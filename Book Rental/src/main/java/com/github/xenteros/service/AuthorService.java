package com.github.xenteros.service;

import com.github.xenteros.model.Author;

import java.util.Set;

public interface AuthorService {

    void create(String firstName, String lastName, Long addressId);
    Set<Author> findAll();
}
