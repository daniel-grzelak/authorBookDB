package com.daniel.controllers;

import com.daniel.dao.interfaces.AuthorDao;
import com.daniel.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





/**
 * Created by Kapelusznik on 01.06.2017.
 */
@Controller
public class AuthorController {
    private AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public String formGet(Model m) {
        Author author = new Author();

        m.addAttribute("author", author);


        return "author";
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public String formPost( @ModelAttribute Author author1, BindingResult result, Model m) {
        if (result.hasErrors())
        {


            for (Object object : result.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    System.out.println(fieldError.getField() + " -> " + fieldError.getCode());
                }
            }
            Author author = new Author();
            m.addAttribute("author", author);


            return "author";
        }


        authorDao.add(author1);

        return "redirect:/";
    }
}
