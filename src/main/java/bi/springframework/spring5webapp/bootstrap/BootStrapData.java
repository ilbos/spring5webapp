package bi.springframework.spring5webapp.bootstrap;

import bi.springframework.spring5webapp.domain.Author;
import bi.springframework.spring5webapp.domain.Book;
import bi.springframework.spring5webapp.domain.Publisher;
import bi.springframework.spring5webapp.repository.AuthorRepository;
import bi.springframework.spring5webapp.repository.BookRepository;
import bi.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12344553");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "38123123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher fantasy = new Publisher();
        fantasy.setAddressLine1("Krefeld");
        fantasy.setCity("Krefeld");
        fantasy.setName("fantasy");
        fantasy.setState("NRW");
        fantasy.setZip("47799");
        publisherRepository.save(fantasy);
        ddd.setPublisher(fantasy);
        fantasy.getBooks().add(ddd);
        publisherRepository.save(fantasy);

        noEJB.setPublisher(fantasy);
        fantasy.getBooks().add(noEJB);
        publisherRepository.save(fantasy);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher number of books: " + fantasy.getBooks().size());
        System.out.println("Books to string: " + noEJB.toString());
    }
}
