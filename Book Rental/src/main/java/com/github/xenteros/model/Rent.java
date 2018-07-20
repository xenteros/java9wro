package com.github.xenteros.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "rent_book",
            joinColumns = { @JoinColumn(name = "rent_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private Set<Book> books;
    private LocalDateTime timeOfRent;

    public Long getId() {
        return id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public LocalDateTime getTimeOfRent() {
        return timeOfRent;
    }

    public void setTimeOfRent(LocalDateTime timeOfRent) {
        this.timeOfRent = timeOfRent;
    }
}
