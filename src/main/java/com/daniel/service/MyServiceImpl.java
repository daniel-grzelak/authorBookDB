package com.daniel.service;

import com.daniel.dao.interfaces.AuthorDao;
import com.daniel.dao.interfaces.BookDao;
import com.daniel.domain.Author;
import com.daniel.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kapelusznik on 08.06.2017.
 */
@Service
public class MyServiceImpl implements MyService {
    private AuthorDao authorDao;
    private BookDao bookDao;

    @Autowired
    public MyServiceImpl(AuthorDao authorDao, BookDao bookDao) {
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @Transactional
    @Override
    public Author addAuthor(Author author) {
        return authorDao.add(author);
    }

    @Transactional
    @Override
    public Author deleteAuthor(Long id) {
        return authorDao.delete(id);
    }

    @Transactional
    @Override
    public Author modifyAuthor(Author author) {
        return authorDao.modify(author);
    }

    @Transactional
    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAll();
    }

    @Transactional
    @Override
    public Author getAuthorById(Long id) {
        return authorDao.getById(id);
    }

    @Transactional
    @Override
    public List<Book> getAllBooksForAuthorById(Long id) {
        return authorDao.getAllBooksForAuthorById(id);
    }

    @Transactional
    @Override
    public Book addBook(Book book) {
        return bookDao.add(book);
    }

    @Transactional
    @Override
    public Book deleteBook(Long id) {
        return bookDao.delete(id);
    }

    @Transactional
    @Override
    public Book modifyBook(Book book) {
        return bookDao.modify(book);
    }

    @Transactional
    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Transactional
    @Override
    public Book getBookById(Long id) {
        return bookDao.getById(id);
    }

    @Transactional
    @Override
    public List<Book> findBookByGenre(String genre) {
        return bookDao.findBookByGenre(genre);
    }

    @Transactional
    @Override
    public void addManyAuthors(Author... authors) {
        for (Author a : authors)
        {
            authorDao.add(a);
        }
    }



    @Transactional
    @Override
    public void setAuthorForBook(Long authorId, Long bookId) {
        Author author = authorDao.getById(authorId);
        Book book = bookDao.getById(bookId);
        book.setAuthor(author);
    }


}
