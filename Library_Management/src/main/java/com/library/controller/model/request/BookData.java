package com.library.controller.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({ "bookName", "author", "genre", "price"})

public class BookData {


    @JsonProperty("bookName")
    @ApiModelProperty(notes = "The name of the Book added ", example = "2 States")
    private String bookName;

    @JsonProperty("author")
    @ApiModelProperty(notes = "Author, who wrote the book", example = "Chetan Bhagat")
    private String author;

    @JsonProperty("price")
    @ApiModelProperty(notes = "Amount of the Book in INR", example = "500")
    private String price;

    @JsonProperty("genre")
    @ApiModelProperty(notes = "Type of book like Fiction, Romance etc. ", example = "Fiction")
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


}
