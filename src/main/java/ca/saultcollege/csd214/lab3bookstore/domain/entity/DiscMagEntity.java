package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Magazine that comes with a disc (e.g., CD/DVD editions).
 * Extends MagazineEntity to inherit publication and issue details.
 */
@Entity
@Table(name = "disc_mags")
public class DiscMagEntity extends MagazineEntity {

    /** Whether this magazine includes a physical disc. */
    @Column(name = "has_disc", nullable = false)
    private boolean hasDisc = true;

    public boolean isHasDisc() { return hasDisc; }
    public void setHasDisc(boolean hasDisc) { this.hasDisc = hasDisc; }
}