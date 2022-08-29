package com.library.service;

import com.library.controller.model.request.BookData;
import com.library.service.response.BookDetailsRes;
import com.library.service.response.DeleteBookResponse;
import net.sf.json.JSONException;

import java.util.List;

public interface BookService {

    public String addBook(BookData bookData) throws JSONException;

    public List<BookDetailsRes> getAllBookDetail();

    public List<BookDetailsRes> getBook(final String author);

    public DeleteBookResponse deleteBook(final String bookName);

}
