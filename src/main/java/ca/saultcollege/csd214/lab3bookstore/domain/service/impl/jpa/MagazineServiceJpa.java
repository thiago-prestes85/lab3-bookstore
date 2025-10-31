package ca.saultcollege.csd214.lab3bookstore.domain.service.impl.jpa;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.MagazineEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa.MagazineJpaRepository;
import ca.saultcollege.csd214.lab3bookstore.domain.service.MagazineService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * JPA-backed service for magazines.
 * Enabled when profile 'mysql' or 'h2' is active.
 */
@Service
@Profile({ "mysql", "h2" })
@Transactional
public class MagazineServiceJpa implements MagazineService {

    private final MagazineJpaRepository repo;

    public MagazineServiceJpa(MagazineJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public MagazineEntity create(MagazineEntity entity) {
        // Defensive defaults can be added here if needed
        return repo.save(entity);
    }

    @Override
    public MagazineEntity update(Long id, MagazineEntity entity) {
        MagazineEntity current = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Magazine not found: " + id));

        // Copy only updatable fields
        current.setName(entity.getName());
        current.setPrice(entity.getPrice());
        current.setPublisher(entity.getPublisher());
        current.setIssueNumber(entity.getIssueNumber());
        current.setIssueMonth(entity.getIssueMonth());

        return repo.save(current);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Magazine not found: " + id);
        }
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MagazineEntity> get(Long id) {
        return repo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MagazineEntity> getAll() {
        return repo.findAll();
    }
}