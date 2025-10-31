package ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for TicketEntity.
 */
@Repository
public interface TicketJpaRepository extends JpaRepository<TicketEntity, Long> {
}