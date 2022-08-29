package com.library.repository;

import com.library.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {

    @Query("FROM BookEntity be ")
    public List<BookEntity> findBook();


    @Query("FROM BookEntity where author = :author")
    public List<BookEntity> findBookByAuthor(@Param("author") String author);

    @Query("FROM BookEntity where bookName = :bookName")
    public BookEntity findBookByName(@Param("bookName") String bookName);


}
