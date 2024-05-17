package com.gdutra.certification.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO {

    private UUID questionId;
    private UUID alternativeId;
    private Boolean isCorrect;
}
