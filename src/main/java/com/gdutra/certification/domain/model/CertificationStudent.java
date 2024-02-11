package com.gdutra.certification.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationStudent {

    private UUID id;
    private UUID studentId;
    private String technology;
    private Integer grade;
    private List<AnswersCertifications> answersCertifications;
}
