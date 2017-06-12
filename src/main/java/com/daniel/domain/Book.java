package com.daniel.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Kapelusznik on 25.05.2017.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    private BigDecimal price;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Author author;

    public Book(){}
    public Book(String title, String genre, BigDecimal price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", author=" + author.getName() + " " + author.getSurname() +
                '}';
    }
}
