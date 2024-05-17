package com.gdutra.certification.infrastructure.converter;

import com.gdutra.certification.domain.model.Question;
import com.gdutra.certification.infrastructure.controllers.QuestionController;
import com.gdutra.certification.infrastructure.dtos.AlternativeResultDTO;
import com.gdutra.certification.infrastructure.dtos.QuestionResultDTO;

import java.util.List;

public class QuestionToDTO {
    public static QuestionResultDTO mapQuestionToDTO(Question question) {
        var questionResult = QuestionResultDTO.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription())
                .build();

        List<AlternativeResultDTO> alternativeResults = questionResult.getAlternativeResults()
                .stream()
                .map(QuestionToDTO::mapAlternativeDTO).toList();

        questionResult.setAlternativeResults(alternativeResults);

        return questionResult;
    }

    static AlternativeResultDTO mapAlternativeDTO(AlternativeResultDTO alternativeResult) {
        return AlternativeResultDTO.builder()
                .id(alternativeResult.getId())
                .description(alternativeResult.getDescription())
                .build();
    }
}
