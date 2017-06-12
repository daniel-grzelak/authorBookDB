package com.daniel.dao.implementations;

import com.daniel.dao.interfaces.BookDao;
import com.daniel.domain.Author;
import com.daniel.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Queue;

/**
 * Created by Kapelusznik on 26.05.2017.
 */
@Repository
public class BookDaoImpl implements BookDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Book add(Book book) {
        entityManager.merge(book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
        return book;
    }

    @Override
    public Book modify(Book book) {
        Book bookFromDb = entityManager.find(Book.class, book.getId());
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setGenre(book.getGenre());
        bookFromDb.setPrice(book.getPrice());
        Author a = entityManager.find(Author.class, book.getAuthor().getId());
        bookFromDb.setAuthor(a);
        return book;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Book> getAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    @Override
    public Book getById(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Book> findBookByGenre(String genre) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.genre = :genre");
        query.setParameter("genre", genre);
        List<Book> books = query.getResultList();
        return books;
    }
}
