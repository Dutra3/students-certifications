package com.gdutra.certification.domain.usecase;

import com.gdutra.certification.infrastructure.dtos.VerifyHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertification {

    public boolean execute(VerifyHasCertificationDTO verifyHasCertification) {
        return verifyHasCertification.getEmail().equals("gabrieldutra@gmail.com") && verifyHasCertification.getTechnology().equals("Java");
    }
}
