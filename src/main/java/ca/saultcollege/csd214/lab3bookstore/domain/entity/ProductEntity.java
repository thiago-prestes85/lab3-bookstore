package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Root product entity (books, magazines, tickets, pencils, etc.).
 * Extends Editable and implements SaleableItem as required by the lab.
 */
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductEntity extends Editable implements SaleableItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Human-friendly product name. */
    @Column(nullable = false)
    private String name;

    /** Current unit price. */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price = BigDecimal.ZERO;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override public BigDecimal getPrice() { return price; }
    @Override public void setPrice(BigDecimal price) { this.price = price; }
}