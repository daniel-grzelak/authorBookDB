package com.daniel.dao.implementations;

import com.daniel.dao.interfaces.AuthorDao;
import com.daniel.domain.Author;
import com.daniel.domain.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kapelusznik on 26.05.2017.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Author add(Author author) {
        entityManager.merge(author);
        return author;
    }

    @Override
    public Author delete(Long id) {
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
        return author;
    }

    @Override
    public Author modify(Author author) {
        Author authorFromDb = entityManager.find(Author.class, author.getId());
        authorFromDb.setAge(author.getAge());
        authorFromDb.setSurname(author.getSurname());
        authorFromDb.setName(author.getName());
        return author;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Author> getAll() {
        Query query = entityManager.createQuery("Select a from Author a");
        List<Author> authors = query.getResultList();
        authors.forEach(a -> a.getBooks().size());
        return authors;
    }

    @Override
    public Author getById(Long id) {
        Author author = entityManager.find(Author.class, id);
        return author;
    }

    @Override
    public List<Book> getAllBooksForAuthorById(Long id) {
        Author author = entityManager.find(Author.class, id);
        return author.getBooks();
    }
}
