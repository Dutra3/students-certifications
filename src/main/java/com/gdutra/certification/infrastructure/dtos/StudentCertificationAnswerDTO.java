package com.gdutra.certification.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCertificationAnswerDTO {

    private String email;
    private String technology;
    private List<QuestionAnswerDTO> questionAnswers;
}
