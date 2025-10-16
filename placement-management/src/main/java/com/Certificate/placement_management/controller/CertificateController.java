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

    // Create
    @PostMapping
    public Certificate create(@RequestBody Certificate certificate) {
        return service.addCertificate(certificate);
    }

    // Read all
    @GetMapping
    public List<Certificate> getAllCertificates() {
        return service.getAllCertificates();
    }

    // Read by student
    @GetMapping("/student/{studentId}")
    public List<Certificate> getByStudent(@PathVariable Long studentId) {
        return service.getCertificatesByStudent(studentId);
    }

    // Update
    @PutMapping("/{id}")
    public Certificate update(@PathVariable Long id, @RequestBody Certificate certificate) {
        return service.updateCertificate(id, certificate);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCertificate(id);
    }
}
