package com.Certificate.placement_management.service;

import com.Certificate.placement_management.entity.Certificate;
import com.Certificate.placement_management.repository.CertificateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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

    // Get all certificates for a specific student
    public List<Certificate> getCertificatesByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    // Delete a certificate by ID
    public void deleteCertificate(Long id) {
        repository.deleteById(id);
    }
}
