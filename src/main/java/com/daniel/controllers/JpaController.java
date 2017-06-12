package com.daniel.controllers;

import com.daniel.dao.interfaces.AuthorDao;
import com.daniel.dao.interfaces.BookDao;
import com.daniel.domain.Author;
import com.daniel.domain.Book;
import com.daniel.service.MyService;
import com.daniel.service.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by Kapelusznik on 25.05.2017.
 */
@Controller
public class JpaController {

    /*private BookDao bookDao;
    private AuthorDao authorDao;

    @Autowired
    public JpaController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }*/

    private MyService service;

    @Autowired
    public JpaController(MyService service) {
        this.service = service;
    }

    //http://localhost:8080/author/insert?name=Daniel&surname=Grzelak&age=12
    @RequestMapping("/author/insert")
    public String insertAuthor(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam Integer age
    ) {
        Author author = new Author(name, surname, age);
        service.addAuthor(author);
        return "welcome";
    }

    @RequestMapping("/author/update/{name}/{surname}/{age}/{id}")
    public String updateAuthor(
            @PathVariable("name") String name,
            @PathVariable("surname") String surname,
            @PathVariable("age") Integer age,
            @PathVariable("id") Long id
    ) {
        Author author = new Author(name, surname, age);
        author.setId(id);
        service.modifyAuthor(author);

        return "welcome";
    }

    @RequestMapping("/author/select")
    public String selectAuthors(Model model) {
        System.out.println("-------------------------------------------");
        System.out.println(service.getAllAuthors());
        System.out.println("-------------------------------------------");
        model.addAttribute("authors", service.getAllAuthors());
        Comparator<Author> authorComparator = Comparator.comparing(Author::getName);
        model.addAttribute("authorComparator", authorComparator);
        return "authors";
    }

    @RequestMapping("/authors/insertmany")
    public String addManyAuthors() {

        Author a1 = new Author("Jan", "Bomba", 12);
        Author a2 = new Author("Jan", "Bombka", 12);
        Author a3 = new Author("Jan", "Nagasaki", 12);

        service.addManyAuthors(a1, a2, a3);
        return "welcome";
    }

    @RequestMapping("/books/modifybookauthor")
    public String modifyBookAuthor(
            @RequestParam Long authorId,
            @RequestParam Long bookId
    ) {
        service.setAuthorForBook(authorId, bookId);

        return "welcome";

    }


    @RequestMapping("/")
    public String test() {
        return "welcome";
    }
}
