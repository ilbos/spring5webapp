package bi.springframework.spring5webapp.repository;

import bi.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    //Spring will implement the interface methods
}
