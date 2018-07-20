package com.github.xenteros.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany(mappedBy = "books")
    private Set<Rent> rents;

    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
