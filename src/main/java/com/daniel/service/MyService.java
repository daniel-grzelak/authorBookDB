package com.daniel.service;

import com.daniel.domain.Author;
import com.daniel.domain.Book;

import java.util.List;

/**
 * Created by Kapelusznik on 08.06.2017.
 */
public interface MyService {
    Author addAuthor(Author author);
    Author deleteAuthor(Long id);
    Author modifyAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    List<Book> getAllBooksForAuthorById(Long id);
    Book addBook(Book book);
    Book deleteBook(Long id);
    Book modifyBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    List<Book> findBookByGenre(String genre);
    void addManyAuthors(Author ... authors);
    void setAuthorForBook(Long authorId, Long bookId);
}
