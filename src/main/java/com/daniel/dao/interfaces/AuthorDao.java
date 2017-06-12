package com.daniel.dao.interfaces;

import com.daniel.domain.Author;
import com.daniel.domain.Book;

import java.util.List;

/**
 * Created by Kapelusznik on 26.05.2017.
 */
public interface AuthorDao {
    Author add(Author author);
    Author delete(Long id);
    Author modify(Author author);
    List<Author> getAll();
    Author getById(Long id);
    List<Book> getAllBooksForAuthorById(Long id);
}
