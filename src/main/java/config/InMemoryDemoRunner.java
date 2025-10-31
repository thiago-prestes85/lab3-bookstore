package ca.saultcollege.csd214.lab3bookstore.config;

import ca.saultcollege.csd214.lab3bookstore.domain.entity.MagazineEntity;
import ca.saultcollege.csd214.lab3bookstore.domain.service.MagazineService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

/**
 * Simple demo for the in-memory profile to show IoC in action.
 */
@Configuration
@Profile("inmemory")
public class InMemoryDemoRunner {

    @Bean
    CommandLineRunner runInMemory(MagazineService magazines) {
        return args -> {
            System.out.println("------ INMEMORY PROFILE ACTIVE ------");
            System.out.println("Initial list:");
            magazines.getAll().forEach(m -> System.out.println("  " + m.getName()));

            MagazineEntity m = new MagazineEntity();
            m.setName("IoC Weekly");
            m.setPublisher("NoSQL Press");
            m.setIssueNumber(2);
            m.setIssueMonth("February");
            m.setPrice(new BigDecimal("6.50"));
            magazines.create(m);

            System.out.println("After insert:");
            magazines.getAll().forEach(x ->
                    System.out.println("  " + x.getName() + " #" + x.getIssueNumber()));
        };
    }
}