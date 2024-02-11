package com.gdutra.certification.domain.usecase;

import com.gdutra.certification.infrastructure.dtos.VerifyHasCertificationDTO;
import com.gdutra.certification.infrastructure.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertification {

    @Autowired
    private CertificationStudentRepository repository;

    public boolean execute(VerifyHasCertificationDTO verifyHasCertification) {
        var result = repository.findByStudentEmailAndTechnology(verifyHasCertification.getEmail(), verifyHasCertification.getTechnology());

        return !result.isEmpty();
    }
}
