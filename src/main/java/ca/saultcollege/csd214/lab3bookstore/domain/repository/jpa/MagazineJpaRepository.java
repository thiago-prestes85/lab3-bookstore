package ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.MagazineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for MagazineEntity.
 */
@Repository
public interface MagazineJpaRepository extends JpaRepository<MagazineEntity, Long> {
}