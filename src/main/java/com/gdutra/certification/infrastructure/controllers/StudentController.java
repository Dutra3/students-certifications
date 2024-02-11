package com.gdutra.certification.infrastructure.controllers;

import com.gdutra.certification.domain.usecase.VerifyIfHasCertification;
import com.gdutra.certification.infrastructure.dtos.VerifyHasCertificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertification verifyIfHasCertification;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
        var result = verifyIfHasCertification.execute(verifyHasCertificationDTO);
        if (result) {
            return "Ola mundo";
        } else {
            return "Ola Outra coisa";
        }
    }
}
