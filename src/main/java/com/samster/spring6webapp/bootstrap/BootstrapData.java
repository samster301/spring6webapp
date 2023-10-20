package com.samster.spring6webapp.bootstrap;

import com.samster.spring6webapp.domain.Author;
import com.samster.spring6webapp.domain.Book;
import com.samster.spring6webapp.domain.Publisher;
import com.samster.spring6webapp.repositories.AuthorRepository;
import com.samster.spring6webapp.repositories.BookRepository;
import com.samster.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author cth = new Author();
        cth.setFirstname("Cormen");
        cth.setLastname("T H");

        Book algo = new Book();
        algo.setTitle("Introduction to Algorithms");
        algo.setIsbn("12345678");

        Publisher penguin = new Publisher();
        penguin.setPublisherName("Penguin Publishing");
        penguin.setAddress("2nd Downy street");
        penguin.setCity("London");
        penguin.setState("England");
        penguin.setZip("76578");

        Author cthSaved = authorRepository.save(cth);
        Book algoSaved = bookRepository.save(algo);
        Publisher penguinSaved = publisherRepository.save(penguin);

        Author rod = new Author();
        cth.setFirstname("Rod");
        cth.setLastname("Johnson");

        Book noEJB = new Book();
        algo.setTitle("J2EE development without EJB");
        algo.setIsbn("87654321");

        Publisher jack = new Publisher();
        jack.setPublisherName("Jack Publishing");
        jack.setAddress("123 Mayor st");
        penguin.setCity("Miami");
        penguin.setState("Florida");
        penguin.setZip("76766");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        Publisher jackSaved = publisherRepository.save(jack);

        cthSaved.getBooks().add(algoSaved);
        cthSaved.getPublishers().add(penguinSaved);
        rodSaved.getBooks().add(noEJBSaved);
        rodSaved.getPublishers().add(jackSaved);

        authorRepository.save(cthSaved);
        authorRepository.save(rodSaved);

        System.out.println("In BootStrap");
        System.out.println("Author count: "+authorRepository.count());
        System.out.println("Book count: "+bookRepository.count());
        System.out.println("Publisher count: "+publisherRepository.count());
    }
}
