package com.library.service.impl;

import com.library.common.CommonConstants;
import com.library.controller.model.request.BookData;
import com.library.entity.BookEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import com.library.service.response.BookDetailsRes;
import com.library.service.response.DeleteBookResponse;
import org.dozer.DozerBeanMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.library.common.CommonConstants.BOOK_ADDED;

@Service
public class BookServiceImpl implements BookService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepo;

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public String addBook(BookData bookData) {
        logger.info("***** Started addBook method in BookServiceImpl *****");

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookData.getBookName());
        bookEntity.setAuthor(bookData.getAuthor());
        bookEntity.setPrice(bookData.getPrice());
        bookEntity.setGenre(bookData.getGenre());
        logger.info("BookRecords before saving in DB  = {} author = {} price = {}", bookData.getBookName(), bookData.getAuthor(), bookData.getPrice());
        BookEntity bookEntity1 = bookRepo.save(bookEntity);
        logger.info("BookRecords after saving in DB  = {} author = {} price = {}", bookData.getBookName(), bookData.getAuthor(), bookData.getPrice());

        return CommonConstants.BOOK_ADDED;
    }


    public BookDetailsRes bookEntityToRes(BookEntity bookEntity){
        BookDetailsRes bookRes = new BookDetailsRes();
        bookRes.setBookName(bookEntity.getBookName());
        bookRes.setAuthor(bookEntity.getAuthor());
        bookRes.setPrice(bookEntity.getPrice());
        bookRes.setGenre(bookEntity.getGenre());
        return bookRes;
    }


    @Override
    public List<BookDetailsRes> getAllBookDetail() {
        logger.info("***** Start getAllBookDetail in BookServiceImpl *****");

        BookDetailsRes res = null;
        List<BookDetailsRes> listRes = new ArrayList<>();

        List<BookEntity> listBookEntity = bookRepo.findBook();

        if (null != listBookEntity) {
            for (BookEntity bookEntity : listBookEntity) {
                res =bookEntityToRes(bookEntity);
                listRes.add(res);
            }
        }

        logger.info("***** End getAllBookDetails in BookServiceImpl *****");
        return listRes;
    }

    @Override
    public List<BookDetailsRes> getBook(String author) {
        logger.info("***** Started getBook in BookServiceImpl *****");
        logger.debug("Input Author is: {}",author);

        List<BookDetailsRes> listBookDetailRes = new ArrayList<>();
        BookDetailsRes bookDetailRes = null;
        List<BookEntity> bookEntity = null;

        bookEntity = bookRepo.findBookByAuthor(author);

        if(null == bookEntity) {
            logger.error("Exception--DB Record Not Found in BookEntity --");
            logger.info("EXCEPTION");
            throw new ResourceNotFoundException(CommonConstants.DB_RECORD_NOT_EXIST);
        }

        for(BookEntity bookEntity1 : bookEntity) {
            bookDetailRes = bookEntityToRes(bookEntity1);
            listBookDetailRes.add(bookDetailRes);
        }

        logger.debug("Author is: {}",listBookDetailRes);
        logger.info("***** End getBookByAuthor in BookServiceImpl *****");
        return listBookDetailRes;
    }



//        BookEntity bookEntity = null;
//
//
//        bookEntity = bookRepo.findBookByAuthor(author);
//        if(null == bookEntity) {
//            logger.error("Exception--DB Record Not Found in BookEntity --");
//            throw new ResourceNotFoundException(CommonConstants.DB_RECORD_NOT_EXIST);
//        }
//
//        BookDetailsRes bookDetailRes = bookEntityToRes(bookEntity);
//        logger.debug("Book Detail Response is: {}",bookDetailRes);
//        logger.info("***** End getBook in BookServiceImpl *****");
//        return bookDetailRes;
//    }


    @Override
    public DeleteBookResponse deleteBook(String bookName) {
        logger.info("***** Start deleteBook in BookServiceImpl *****");

        BookEntity bookEntity = bookRepo.findBookByName(bookName);
        DeleteBookResponse deleteBookResponse = new DeleteBookResponse();

        if (Objects.isNull(bookEntity)) {
            logger.info("***** Book Not Found in DB*****");
            throw new ResourceNotFoundException(CommonConstants.DB_RECORD_NOT_EXIST);
        }

        deleteBookResponse.setBookName(bookEntity.getBookName());
        deleteBookResponse.setAuthor(bookEntity.getAuthor());
        deleteBookResponse.setPrice(bookEntity.getPrice());
        deleteBookResponse.setGenre(bookEntity.getGenre());

        bookRepo.delete(bookEntity);
        deleteBookResponse.setStatus(CommonConstants.BOOK_DELETED);
        logger.info("***** End deleteBook in BookServiceImpl *****");
        logger.debug("--deleted Book Response is: {}",deleteBookResponse);
        return deleteBookResponse;
    }


}


