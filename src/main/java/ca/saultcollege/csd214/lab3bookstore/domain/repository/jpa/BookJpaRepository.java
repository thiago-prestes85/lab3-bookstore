package ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for BookEntity.
 */
@Repository
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
}