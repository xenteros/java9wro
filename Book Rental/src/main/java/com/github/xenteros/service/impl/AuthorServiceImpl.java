package com.github.xenteros.service.impl;

import com.github.xenteros.model.Address;
import com.github.xenteros.model.Author;
import com.github.xenteros.repository.AddressRepository;
import com.github.xenteros.repository.AuthorRepository;
import com.github.xenteros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AddressRepository addressRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void create(String firstName, String lastName, Long addressId) {

        Address address = addressRepository.findOne(addressId);

        Author author = new Author();
        author.setAddress(address);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
    }

    @Override
    public Set<Author> findAll() {
        return authorRepository.findAllBy();
    }
}
