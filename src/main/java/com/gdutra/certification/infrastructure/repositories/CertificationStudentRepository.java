package com.gdutra.certification.infrastructure.repositories;

import com.gdutra.certification.domain.model.CertificationStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CertificationStudentRepository extends JpaRepository<CertificationStudent, UUID> {

    @Query("SELECT ct FROM certifications ct "
            + "INNER JOIN ct.student std "
            + "WHERE std.email = :email "
            + "AND ct.technology = :technology")
    List<CertificationStudent> findByStudentEmailAndTechnology(String email, String technology);
}
