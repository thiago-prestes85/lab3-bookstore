package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import java.math.BigDecimal;

/**
 * Contract for items that can be sold.
 * Implementations must expose a price getter/setter.
 */
public interface SaleableItem {
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}