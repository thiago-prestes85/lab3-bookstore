package ca.saultcollege.csd214.lab3bookstore.domain.service.impl.jpa;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.TicketEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa.TicketJpaRepository;
import ca.saultcollege.csd214.lab3bookstore.domain.service.TicketService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * JPA-backed service for tickets.
 * Enabled when profile 'mysql' or 'h2' is active.
 */
@Service
@Profile({ "mysql", "h2" })
@Transactional
public class TicketServiceJpa implements TicketService {

    private final TicketJpaRepository repo;

    public TicketServiceJpa(TicketJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public TicketEntity create(TicketEntity entity) {
        return repo.save(entity);
    }

    @Override
    public TicketEntity update(Long id, TicketEntity entity) {
        TicketEntity current = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ticket not found: " + id));

        current.setName(entity.getName());
        current.setPrice(entity.getPrice());
        current.setEventName(entity.getEventName());
        current.setEventDate(entity.getEventDate());
        current.setSeat(entity.getSeat());
        return repo.save(current);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NoSuchElementException("Ticket not found: " + id);
        repo.deleteById(id);
    }

    @Override @Transactional(readOnly = true)
    public Optional<TicketEntity> get(Long id) {
        return repo.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<TicketEntity> getAll() {
        return repo.findAll();
    }
}