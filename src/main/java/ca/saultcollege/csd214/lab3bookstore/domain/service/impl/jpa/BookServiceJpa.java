package ca.saultcollege.csd214.lab3bookstore.domain.service.impl.jpa;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.BookEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa.BookJpaRepository;
import ca.saultcollege.csd214.lab3bookstore.domain.service.BookService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * JPA-backed service for books.
 * Enabled when profile 'mysql' or 'h2' is active.
 */
@Service
@Profile({ "mysql", "h2" })
@Transactional
public class BookServiceJpa implements BookService {

    private final BookJpaRepository repo;

    public BookServiceJpa(BookJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public BookEntity create(BookEntity entity) {
        return repo.save(entity);
    }

    @Override
    public BookEntity update(Long id, BookEntity entity) {
        BookEntity current = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found: " + id));

        current.setName(entity.getName());
        current.setPrice(entity.getPrice());
        current.setPublisher(entity.getPublisher());
        current.setAuthor(entity.getAuthor());
        current.setIsbn(entity.getIsbn());
        return repo.save(current);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NoSuchElementException("Book not found: " + id);
        repo.deleteById(id);
    }

    @Override @Transactional(readOnly = true)
    public Optional<BookEntity> get(Long id) {
        return repo.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<BookEntity> getAll() {
        return repo.findAll();
    }
}