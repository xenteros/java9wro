package com.github.xenteros.service;

import com.github.xenteros.dto.BookDto;

import java.util.Set;

public interface BookService {

    void create(String title, Long authorId);
    Set<BookDto> findAll();
    Set<BookDto> findAllByAuthorId(Long id);

}
