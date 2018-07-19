package com.github.xenteros.service.impl;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.model.Book;
import com.github.xenteros.repository.AuthorRepository;
import com.github.xenteros.repository.BookRepository;
import com.github.xenteros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(String title, Long authorId) {
        Book book = new Book();
        book.setAuthor(authorRepository.findOne(authorId));
        book.setTitle(title);
        bookRepository.save(book);
    }

    @Override
    public Set<BookDto> findAll() {
        return bookRepository.findAllBy().stream()
                .map(BookDto::new)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<BookDto> findAllByAuthorId(Long id) {
        return bookRepository.findAllByAuthorId(id).stream()
                .map(book -> new BookDto(book))
                .collect(Collectors.toSet());
    }
}
