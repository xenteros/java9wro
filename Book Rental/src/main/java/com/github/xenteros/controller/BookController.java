package com.github.xenteros.controller;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/books")
class BookController {

    private BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void create(@RequestParam Long authorId, @RequestParam String title) {
        bookService.create(title, authorId);
    }

    @GetMapping
    public Set<BookDto> findAll(){

        return bookService.findAll();
    }
}
