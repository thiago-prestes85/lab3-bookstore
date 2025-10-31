package ca.saultcollege.csd214.lab3bookstore.domain.service;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.MagazineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for MagazineService using the H2 profile.
 * This proves CRUD behavior via JPA with an in-memory database.
 */
@SpringBootTest
@ActiveProfiles("h2")
class MagazineServiceTest {

    @Autowired
    private MagazineService magazineService;

    @Test
    void shouldCreateAndListMagazine() {
        MagazineEntity m = new MagazineEntity();
        m.setName("Test Monthly");
        m.setPublisher("Test House");
        m.setIssueMonth("March");
        m.setIssueNumber(42);
        m.setPrice(new BigDecimal("9.99"));

        MagazineEntity saved = magazineService.create(m);
        assertNotNull(saved);
        assertNotNull(saved.getId());

        List<MagazineEntity> all = magazineService.getAll();
        assertFalse(all.isEmpty());
        assertTrue(all.stream().anyMatch(x -> "Test Monthly".equals(x.getName())));
    }

    @Test
    void shouldUpdateMagazine() {
        MagazineEntity m = new MagazineEntity();
        m.setName("To Update");
        m.setPublisher("ACME");
        m.setIssueMonth("April");
        m.setIssueNumber(1);
        m.setPrice(new BigDecimal("5.00"));
        MagazineEntity saved = magazineService.create(m);

        MagazineEntity patch = new MagazineEntity();
        patch.setName("Updated Name");
        patch.setPublisher("ACME 2");
        patch.setIssueMonth("May");
        patch.setIssueNumber(2);
        patch.setPrice(new BigDecimal("6.50"));

        MagazineEntity updated = magazineService.update(saved.getId(), patch);
        assertEquals("Updated Name", updated.getName());
        assertEquals("ACME 2", updated.getPublisher());
        assertEquals("May", updated.getIssueMonth());
        assertEquals(2, updated.getIssueNumber());
        assertEquals(new BigDecimal("6.50"), updated.getPrice());
    }

    @Test
    void shouldDeleteMagazine() {
        MagazineEntity m = new MagazineEntity();
        m.setName("To Delete");
        m.setPublisher("Del Pub");
        m.setIssueMonth("June");
        m.setIssueNumber(7);
        m.setPrice(new BigDecimal("3.00"));
        MagazineEntity saved = magazineService.create(m);

        magazineService.delete(saved.getId());

        assertTrue(magazineService.get(saved.getId()).isEmpty());
    }
}