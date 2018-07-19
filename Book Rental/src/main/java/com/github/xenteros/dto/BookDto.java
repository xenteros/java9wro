package com.github.xenteros.dto;

import com.github.xenteros.model.Book;

public class BookDto {

    private Long id;
    private String title;
    private String authorFirstName;
    private String authorLastName;

    public BookDto(Long id, String title, String authorFirstName, String authorLastName) {
        this.id = id;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorFirstName = book.getAuthor().getFirstName();
        this.authorLastName = book.getAuthor().getLastName();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }
}
