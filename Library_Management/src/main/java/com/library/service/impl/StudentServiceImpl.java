package com.library.service.impl;

import com.library.common.CommonConstants;
import com.library.controller.model.request.BookData;
import com.library.controller.model.request.StudentData;
import com.library.entity.BookEntity;
import com.library.entity.StudentEntity;
import com.library.repository.BookRepository;
import com.library.repository.StudentRepository;
import com.library.service.BookService;
import com.library.service.StudentService;
import com.library.service.response.BookDetailsRes;
import net.sf.json.JSONException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentServiceImpl implements StudentService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepo;

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public String addStudent(StudentData studentData) {
        logger.info("***** Started StudentBook method in StudentServiceImpl *****");

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(studentData.getStudentName());
        studentEntity.setBookIssued(studentData.getBookIssued());
        studentEntity.setClassEnrolled(studentData.getClassEnrolled());
        studentEntity.setRollNum(studentData.getRollNum());
        studentEntity.setIssuedOn(String.valueOf(studentData.getIssuedOn()));
//        logger.info("StudentRecords before saving in DB  = {} studentName = {} bookIssued = {}", studentData.getStudentName(), studentData.getBookIssued(), studentData.getIssuedOn());
        StudentEntity studentEntity1 = studentRepo.save(studentEntity);

        return  studentEntity1.getBookIssued() + " ISSUED to "+ studentEntity1.getStudentName() + " of class " +studentEntity1.getClassEnrolled() +  " on " + studentEntity1.getIssuedOn() ;
    }

//
//    public BookDetailsRes bookEntityToRes(BookEntity bookEntity){
//        BookDetailsRes bookRes = new BookDetailsRes();
//        bookRes.setBookName(bookEntity.getBookName());
//        bookRes.setAuthor(bookEntity.getAuthor());
//        bookRes.setPrice(bookEntity.getPrice());
//        bookRes.setGenre(bookEntity.getGenre());
//        return bookRes;
//    }





}
