package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Pencil as a non-publication product.
 * Extends ProductEntity to reuse id, name, and price fields.
 */
@Entity
@Table(name = "pencils")
public class PencilEntity extends ProductEntity {

    /** Hardness grade (e.g., HB, 2B, 4H). */
    @Column(name = "hardness_grade")
    private String hardnessGrade;

    public String getHardnessGrade() { return hardnessGrade; }
    public void setHardnessGrade(String hardnessGrade) { this.hardnessGrade = hardnessGrade; }
}