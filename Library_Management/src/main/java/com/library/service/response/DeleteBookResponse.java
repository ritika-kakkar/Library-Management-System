package com.library.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "bookName", "author", "price", "genre", "status"})
public class DeleteBookResponse {

    @JsonProperty("bookName")
    private String bookName;

    @JsonProperty("author")
    private String author;

    @JsonProperty("price")
    private String price;

    @JsonProperty("status")
    private String status;

    @JsonProperty("genre")
    private String genre;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
