package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 * Cash till (store register) kept simple to satisfy the lab requirement.
 * Extends ProductEntity to reuse id, name and price (price can represent unit price or fee).
 */
@Entity
@Table(name = "cash_tills")
public class CashTillEntity extends ProductEntity {

    /** Current balance held by this till. */
    @Column(name = "balance", precision = 12, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}