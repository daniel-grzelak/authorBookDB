package com.daniel.dao.interfaces;

import com.daniel.domain.Book;

import java.util.List;

/**
 * Created by Kapelusznik on 26.05.2017.
 */
public interface BookDao {
    Book add(Book book);
    Book delete(Long id);
    Book modify(Book book);
    List<Book> getAll();
    Book getById(Long id);
    List<Book> findBookByGenre(String genre);
}
