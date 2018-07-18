package com.github.xenteros.controller;

import com.github.xenteros.model.Author;
import com.github.xenteros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/authors")
class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping
    public void create(@RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam Long addressId) {

        authorService.create(firstName, lastName, addressId);
    }

    @GetMapping
    public Set<Author> findAll() {
        return authorService.findAll();
    }

}
