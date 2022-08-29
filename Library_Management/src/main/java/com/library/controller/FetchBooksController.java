package com.library.controller;

import com.library.service.BookService;
import com.library.service.response.BookDetailsRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api( tags="Fetch Books", value = "Books", description = "Get the Details of the Books")
public class FetchBooksController {


    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.library.controller.BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/getAllBooks")
    @ApiOperation(value="Retrieves the list of all the Books along with the Author")
    public ResponseEntity<List<BookDetailsRes>> getAllBookDetail() {
        LOGGER.info("***** Started/End getAllBookDetail in BookController *****");
        return new ResponseEntity<>(bookService.getAllBookDetail(), HttpStatus.OK);
    }

    @GetMapping(value = "/book/{author}")
    @ApiOperation(value="Get the Book details for given Author")
    public ResponseEntity<List<BookDetailsRes>> getBookDetailByAuthor(
            @PathVariable("author") final String author) {
        LOGGER.info("***** Started/End getBookDetailByAuthor in FetchBookController *****");
        return new ResponseEntity<>(bookService.getBook(author),HttpStatus.OK);
    }

}


