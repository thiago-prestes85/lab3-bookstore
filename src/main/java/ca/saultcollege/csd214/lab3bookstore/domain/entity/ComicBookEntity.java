package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Comic book is a specific type of magazine/publication.
 * Extends MagazineEntity to inherit publication and issue info.
 */
@Entity
@Table(name = "comic_books")
public class ComicBookEntity extends MagazineEntity {

    /** Series title (e.g., "Spider-Man", "Batman"). */
    @Column(name = "series_title")
    private String seriesTitle;

    public String getSeriesTitle() { return seriesTitle; }
    public void setSeriesTitle(String seriesTitle) { this.seriesTitle = seriesTitle; }
}