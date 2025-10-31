package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * Ticket as a sellable product (e.g., concert, event ticket).
 * Extends ProductEntity to reuse common fields like id, name, and price.
 */
@Entity
@Table(name = "tickets")
public class TicketEntity extends ProductEntity {

    /** Event name printed on the ticket. */
    @Column(name = "event_name")
    private String eventName;

    /** Event date (when it will take place). */
    @Column(name = "event_date")
    private LocalDate eventDate;

    /** Seat or section label. */
    @Column(name = "seat")
    private String seat;

    // Getters and setters
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public String getSeat() { return seat; }
    public void setSeat(String seat) { this.seat = seat; }
}