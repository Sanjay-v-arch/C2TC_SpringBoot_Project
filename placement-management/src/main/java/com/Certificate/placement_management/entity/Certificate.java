package com.Certificate.placement_management.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificates")

public class Certificate {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String certificateName;
	    private LocalDate issueDate;

	    // Just store studentId directly
	    private Long studentId;

	    // Getters and setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getCertificateName() { return certificateName; }
	    public void setCertificateName(String certificateName) { this.certificateName = certificateName; }

	    public LocalDate getIssueDate() { return issueDate; }
	    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

	    public Long getStudentId() { return studentId; }
	    public void setStudentId(Long studentId) { this.studentId = studentId; }

}
