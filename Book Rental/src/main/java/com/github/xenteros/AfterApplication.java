package com.github.xenteros;

import com.github.xenteros.model.Address;
import com.github.xenteros.model.Author;
import com.github.xenteros.model.Book;
import com.github.xenteros.repository.AddressRepository;
import com.github.xenteros.repository.AuthorRepository;
import com.github.xenteros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AfterApplication implements CommandLineRunner {

    private AddressRepository addressRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public AfterApplication(AddressRepository addressRepository,
                            AuthorRepository authorRepository,
                            BookRepository bookRepository) {
        this.addressRepository = addressRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (addressRepository.findAllBy().isEmpty() &&
                authorRepository.findAllBy().isEmpty() &&
                bookRepository.findAllBy().isEmpty()) {
            Address rynek = createAddress("Rynek", "Wrocław", "Poland");
            Address pomorska = createAddress("Pomorska", "Wrocław", "Poland");

            Author rozewicz = createAuthor("Tadeusz", "Różewicz", rynek);
            Author kowalski = createAuthor("Jan", "Kowalski", pomorska);

            Book polapka = createBook("Pułapka", rozewicz);

        }
    }

    private Address createAddress(String street, String city, String state) {
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        return addressRepository.save(address);
    }

    private Author createAuthor(String firstName, String lastName, Address address) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAddress(address);
        return authorRepository.save(author);
    }

    private Book createBook(String title, Author author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        return bookRepository.save(book);
    }
}
