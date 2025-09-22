package com.Certificate.placement_management.controller;

import com.Certificate.placement_management.entity.Certificate;
import com.Certificate.placement_management.service.CertificateService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    // Create a new certificate
    @PostMapping
    public Certificate create(@RequestBody Certificate certificate) {
        return service.addCertificate(certificate);
    }

    // Get all certificates
    @GetMapping
    public List<Certificate> getAllCertificates() {
        return service.getAllCertificates();
    }

    // Get all certificates for a specific student
    @GetMapping("/student/{studentId}")
    public List<Certificate> getByStudent(@PathVariable Long studentId) {
        return service.getCertificatesByStudent(studentId);
    }

    // Delete a certificate by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCertificate(id);
    }
}
