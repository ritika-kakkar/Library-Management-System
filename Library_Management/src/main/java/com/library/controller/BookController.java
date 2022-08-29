package com.library.controller;

import com.library.controller.model.request.BookData;
import com.library.service.BookService;
import com.library.service.response.BookDetailsRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;

import java.util.List;


@RestController
@Api( tags="Add Book", value = "Adding Book", description = "Add the Book")
public class BookController {
    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/addBook")
    @ApiOperation(value = "Adds the book to the database")
    public ResponseEntity<String> addBook(@RequestBody BookData bookData) {
        LOGGER.info("***** Started addBook Method in BookController *****");
        LOGGER.info("***** End addBook Method in BookController *****");
        return new ResponseEntity<>(bookService.addBook(bookData), HttpStatus.OK);
    }



    }