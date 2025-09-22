package com.Certificate.placement_management.repository;
import com.Certificate.placement_management.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
	List<Certificate> findByStudentId(Long studentId);

}
