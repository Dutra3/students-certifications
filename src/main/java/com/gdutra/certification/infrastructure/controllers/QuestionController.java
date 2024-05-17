package com.gdutra.certification.infrastructure.controllers;

import com.gdutra.certification.infrastructure.converter.QuestionToDTO;
import com.gdutra.certification.infrastructure.dtos.AlternativeResultDTO;
import com.gdutra.certification.infrastructure.dtos.QuestionResultDTO;
import com.gdutra.certification.infrastructure.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository repository;

    @GetMapping("technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@RequestParam String technology) {
        var result = repository.findByTechnology(technology);

        return result.stream().map(QuestionToDTO::mapQuestionToDTO).toList();
    }
}
