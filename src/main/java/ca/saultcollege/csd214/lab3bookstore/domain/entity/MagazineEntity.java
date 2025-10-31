package ca.saultcollege.csd214.lab3bookstore.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Concrete publication representing a magazine.
 * Inherits product and publication fields (name, price, publisher).
 */
@Entity
@Table(name = "magazines")
public class MagazineEntity extends PublicationEntity {

    /** Sequential issue number of the magazine. */
    @Column(name = "issue_number")
    private Integer issueNumber;

    /** Month label for the issue (e.g., "October"). */
    @Column(name = "issue_month")
    private String issueMonth;

    public Integer getIssueNumber() { return issueNumber; }
    public void setIssueNumber(Integer issueNumber) { this.issueNumber = issueNumber; }

    public String getIssueMonth() { return issueMonth; }
    public void setIssueMonth(String issueMonth) { this.issueMonth = issueMonth; }
}
