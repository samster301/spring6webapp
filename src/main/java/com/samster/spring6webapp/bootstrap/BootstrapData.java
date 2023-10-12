package com.samster.spring6webapp.bootstrap;

import com.samster.spring6webapp.domain.Author;
import com.samster.spring6webapp.domain.Book;
import com.samster.spring6webapp.repositories.AuthorRepository;
import com.samster.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author cth = new Author();
        cth.setFirstname("Cormen");
        cth.setLastname("T H");

        Book algo = new Book();
        algo.setTitle("Introduction to Algorithms");
        algo.setIsbn("12345678");

        Author cthSaved = authorRepository.save(cth);
        Book algoSaved = bookRepository.save(algo);

        Author rod = new Author();
        cth.setFirstname("Rod");
        cth.setLastname("Johnson");

        Book noEJB = new Book();
        algo.setTitle("J2EE development without EJB");
        algo.setIsbn("87654321");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        cthSaved.getBooks().add(algoSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(cthSaved);
        authorRepository.save(rodSaved);

        System.out.println("In BootStrap");
        System.out.println("Author count: "+authorRepository.count());
        System.out.println("Book count: "+bookRepository.count());
    }
}
