package bi.springframework.spring5webapp.repository;

import bi.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    //Spring will implement the interface methods
}
