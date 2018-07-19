package com.github.xenteros.repository;

import com.github.xenteros.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Set<Book> findAllBy();
    Set<Book> findAllByAuthorId(Long authorId);
}
