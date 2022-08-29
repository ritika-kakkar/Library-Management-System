package com.library.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

public class BookDetailsRes {


    @JsonProperty("bookName")
    @ApiModelProperty(example = "2 States")
    private String bookName;

    @JsonProperty("author")
    @ApiModelProperty(example = "Chetan Bhagat")
    private String author;

    @JsonProperty("price")
    @ApiModelProperty(example = "500")
    private String price;

    @JsonProperty("genre")
    @ApiModelProperty(example = "fiction")
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
