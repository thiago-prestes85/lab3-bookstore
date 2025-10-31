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
 * Same CRUD demo, but for the H2 profile (in-memory DB).
 */
@Configuration
@Profile("h2")
public class H2CrudDemoRunner {

    @Bean
    CommandLineRunner demoCrudH2(BookJpaRepository books,
                                 MagazineJpaRepository mags,
                                 TicketJpaRepository tickets) {
        return args -> {
            // BOOK
            BookEntity b = new BookEntity();
            b.setName("Clean Architecture");
            b.setPrice(new BigDecimal("49.90"));
            b.setPublisher("Pearson");
            b.setAuthor("Robert C. Martin");
            b.setIsbn("9780134494166");
            books.save(b);

            System.out.println("[H2][BOOKS] after insert:");
            books.findAll().forEach(it ->
                    System.out.printf("  #%d %s | %s | %s%n", it.getId(), it.getName(), it.getAuthor(), it.getIsbn())
            );

            // MAG
            MagazineEntity m = new MagazineEntity();
            m.setName("H2 Science");
            m.setPrice(new BigDecimal("7.50"));
            m.setPublisher("ACME");
            m.setIssueNumber(1);
            m.setIssueMonth("January");
            mags.save(m);

            System.out.println("[H2][MAGAZINES] after insert:");
            mags.findAll().forEach(it ->
                    System.out.printf("  #%d %s | %s %d%n", it.getId(), it.getName(), it.getIssueMonth(), it.getIssueNumber())
            );

            // TICKET
            TicketEntity t = new TicketEntity();
            t.setName("H2 Live Show");
            t.setPrice(new BigDecimal("80.00"));
            t.setEventName("H2 Fest");
            t.setEventDate(LocalDate.now().plusDays(10));
            t.setSeat("B10");
            tickets.save(t);

            System.out.println("[H2][TICKETS] after insert:");
            tickets.findAll().forEach(it ->
                    System.out.printf("  #%d %s | %s on %s seat %s%n",
                            it.getId(), it.getName(), it.getEventName(), it.getEventDate(), it.getSeat())
            );
        };
    }
}