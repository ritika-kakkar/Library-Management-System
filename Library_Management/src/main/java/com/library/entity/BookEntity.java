package com.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "Book_details")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Book_name")
    private String bookName;

    @Column(name = "Author")
    private String author;

    @Column(name = "price")
    private String price;

    @Column(name = "genre")
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
