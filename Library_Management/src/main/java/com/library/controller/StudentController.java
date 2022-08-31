package com.library.controller;

import com.library.controller.model.request.BookData;
import com.library.controller.model.request.StudentData;
import com.library.service.BookService;
import com.library.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api( tags="Students Data", value = "Adding Student Data and Issuing Book", description = "Adding Student Data and Issuing Book")
public class StudentController {

    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/addStudent")
    @ApiOperation(value = "Adds the Student Data to the database")
    public ResponseEntity<String> addStudent(@RequestBody StudentData studentData) {
        LOGGER.info("***** Started addStudent Method in StudentController *****");
        LOGGER.info("***** End addStudent Method in StudentController *****");
        return new ResponseEntity<>(studentService.addStudent(studentData), HttpStatus.OK);
    }


}
