package ca.saultcollege.csd214.lab3bookstore.domain.service.impl.inmemory;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.MagazineEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.service.MagazineService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Simple in-memory implementation for MagazineService.
 * Enabled only when profile 'inmemory' is active.
 */
@Service
@Profile("inmemory")
public class MagazineServiceInMemory implements MagazineService {

    private final Map<Long, MagazineEntity> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public MagazineServiceInMemory() {
        // Optional seed data
        MagazineEntity sample = new MagazineEntity();
        sample.setName("InMemory Monthly");
        sample.setPrice(new BigDecimal("5.00"));
        sample.setPublisher("Demo Publishers");
        sample.setIssueMonth("January");
        sample.setIssueNumber(1);
        create(sample);
    }

    @Override
    public MagazineEntity create(MagazineEntity entity) {
        long id = seq.incrementAndGet();
        // Simulate generated id
        try {
            var idField = entity.getClass().getSuperclass().getSuperclass().getDeclaredField("id"); // Publication -> Product -> id
            idField.setAccessible(true);
            idField.set(entity, id);
        } catch (Exception ignored) { /* keep it simple for lab */ }
        store.put(id, entity);
        return entity;
    }

    @Override
    public MagazineEntity update(Long id, MagazineEntity entity) {
        if (!store.containsKey(id)) throw new NoSuchElementException("Magazine not found: " + id);
        MagazineEntity current = store.get(id);
        current.setName(entity.getName());
        current.setPrice(entity.getPrice());
        current.setPublisher(entity.getPublisher());
        current.setIssueNumber(entity.getIssueNumber());
        current.setIssueMonth(entity.getIssueMonth());
        return current;
    }

    @Override
    public void delete(Long id) {
        if (store.remove(id) == null) throw new NoSuchElementException("Magazine not found: " + id);
    }

    @Override
    public Optional<MagazineEntity> get(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<MagazineEntity> getAll() {
        return new ArrayList<>(store.values());
    }
}