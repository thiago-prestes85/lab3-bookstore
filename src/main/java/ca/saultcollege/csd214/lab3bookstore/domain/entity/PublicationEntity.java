package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Publication-level entity (books, magazines, comics, etc.).
 * Now extends ProductEntity as required by the lab.
 */
@Entity
@Table(name = "publications")
public class PublicationEntity extends ProductEntity {

    /** Publisher/label responsible for the publication. */
    @Column(name = "publisher")
    private String publisher;

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
}