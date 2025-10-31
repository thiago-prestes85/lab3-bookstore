package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;

/**
 * Base type that contributes audit/edit columns to subclasses.
 * Not a standalone table.
 */
@MappedSuperclass
public abstract class Editable {

    @Column(name = "created_at", nullable = false, updatable = false)
    protected Instant createdAt = Instant.now();

    @Column(name = "updated_at", nullable = false)
    protected Instant updatedAt = Instant.now();

    @Column(name = "is_editable", nullable = false)
    protected boolean editable = true;

    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public boolean isEditable() { return editable; }

    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
    public void setEditable(boolean editable) { this.editable = editable; }
}