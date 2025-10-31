package ca.saultcollege.csd214.lab3bookstore.config;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.BookEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.entity.MagazineEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.entity.TicketEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa.BookJpaRepository;
import ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa.MagazineJpaRepository;
import ca.saultcollege.csd214.lab3bookstore.domain.repository.jpa.TicketJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Demonstrates required CRUD for Books, Magazines, and Tickets on MySQL profile.
 * Run the app with: -Dspring.profiles.active=mysql
 */
@Configuration
public class CrudDemoRunner {

    @Bean
    @Profile("mysql")
    CommandLineRunner demoCrud(BookJpaRepository books,
                               MagazineJpaRepository mags,
                               TicketJpaRepository tickets) {
        return args -> {
            // ---------- BOOKS: ADD ----------
            BookEntity b = new BookEntity();
            b.setName("Clean Code");
            b.setPrice(new BigDecimal("59.90"));
            b.setPublisher("Prentice Hall");
            b.setAuthor("Robert C. Martin");
            b.setIsbn("9780132350884");
            b = books.save(b);

            // ---------- BOOKS: LIST ----------
            System.out.println("[BOOKS] after insert:");
            books.findAll().forEach(it ->
                    System.out.printf("  #%d %s | author=%s | isbn=%s | price=%s%n",
                            it.getId(), it.getName(), it.getAuthor(), it.getIsbn(), it.getPrice())
            );

            // ---------- BOOKS: UPDATE ----------
            b.setPrice(new BigDecimal("54.90"));
            books.save(b);

            // ---------- MAGAZINES: ADD ----------
            MagazineEntity m = new MagazineEntity();
            m.setName("Science Monthly");
            m.setPrice(new BigDecimal("12.00"));
            m.setPublisher("ACME Publishing");
            m.setIssueNumber(123);
            m.setIssueMonth("October");
            m = mags.save(m);

            // ---------- MAGAZINES: LIST ----------
            System.out.println("[MAGAZINES] after insert:");
            mags.findAll().forEach(it ->
                    System.out.printf("  #%d %s | %s %d | price=%s%n",
                            it.getId(), it.getName(), it.getIssueMonth(), it.getIssueNumber(), it.getPrice())
            );

            // ---------- TICKETS: ADD ----------
            TicketEntity t = new TicketEntity();
            t.setName("Concert Ticket");
            t.setPrice(new BigDecimal("99.00"));
            t.setEventName("Rock Fest");
            t.setEventDate(LocalDate.now().plusDays(30));
            t.setSeat("A12");
            t = tickets.save(t);

            // ---------- TICKETS: LIST ----------
            System.out.println("[TICKETS] after insert:");
            tickets.findAll().forEach(it ->
                    System.out.printf("  #%d %s | %s on %s seat %s | price=%s%n",
                            it.getId(), it.getName(), it.getEventName(), it.getEventDate(), it.getSeat(), it.getPrice())
            );

            // ---------- TICKETS: UPDATE ----------
            t.setSeat("A14");
            tickets.save(t);

            // ---------- (OPTIONAL) DELETE EXAMPLES ----------
            // books.deleteById(b.getId());
            // mags.deleteById(m.getId());
            // tickets.deleteById(t.getId());

            System.out.println("CRUD demo completed (MySQL).");
        };
    }
}