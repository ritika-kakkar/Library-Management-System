package com.library.controller;


import com.library.service.BookService;
import com.library.service.response.DeleteBookResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api( tags="Delete Books", value = "Books", description = "Delete the Book")
public class DeleteBookController {


    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(com.library.controller.BookController.class);

    @Autowired
    private BookService bookService;


    @DeleteMapping(value = "/book/deleteBook")
    @ApiOperation(value = "Deletes existing Book")
    public ResponseEntity<DeleteBookResponse> deleteBook(@RequestParam(name = "bookName") @Valid String bookName) {
        LOGGER.info("***** Started deleteBook in DeleteBookController*****");
        LOGGER.debug("--Deleted book Name is: {}", bookName);
        LOGGER.info("*****Ended deleteBook in DeleteBookController*****");
        return new ResponseEntity<>(bookService.deleteBook(bookName),
                HttpStatus.OK);
    }



}
