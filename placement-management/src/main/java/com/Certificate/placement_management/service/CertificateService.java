package com.Certificate.placement_management.service;

import com.Certificate.placement_management.entity.Certificate;
import com.Certificate.placement_management.repository.CertificateRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    private final CertificateRepository repository;

    public CertificateService(CertificateRepository repository) {
        this.repository = repository;
    }

    // Add a new certificate
    public Certificate addCertificate(Certificate certificate) {
        return repository.save(certificate);
    }

    // Get all certificates
    public List<Certificate> getAllCertificates() {
        return repository.findAll();
    }

    // Get certificates by student
    public List<Certificate> getCertificatesByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    // Update a certificate
    public Certificate updateCertificate(Long id, Certificate updatedCertificate) {
        return repository.findById(id).map(certificate -> {
            certificate.setCertificateName(updatedCertificate.getCertificateName());
            certificate.setIssueDate(updatedCertificate.getIssueDate());
            certificate.setStudentId(updatedCertificate.getStudentId());
            certificate.setIssuedBy(updatedCertificate.getIssuedBy());
            certificate.setExpiryDate(updatedCertificate.getExpiryDate());
            certificate.setGrade(updatedCertificate.getGrade());
            certificate.setCertificateType(updatedCertificate.getCertificateType());
            certificate.setRemarks(updatedCertificate.getRemarks());
            return repository.save(certificate);
        }).orElseThrow(() -> new RuntimeException("Certificate not found with id " + id));
    }

    // Delete a certificate
    public void deleteCertificate(Long id) {
        repository.deleteById(id);
    }
}
