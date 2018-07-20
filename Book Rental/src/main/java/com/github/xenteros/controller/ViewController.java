package com.github.xenteros.controller;

import com.github.xenteros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    private AuthorService authorService;

    @Autowired
    public ViewController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/logged-user")
    public String loggedUser(Model model) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("name", username);

        return "login_success_page";
    }

    @GetMapping("/authors")
    public String allAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }



}
