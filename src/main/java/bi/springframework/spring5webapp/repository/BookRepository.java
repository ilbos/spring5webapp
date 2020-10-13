package bi.springframework.spring5webapp.repository;

import bi.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    //Spring will implement the interface methods
}
