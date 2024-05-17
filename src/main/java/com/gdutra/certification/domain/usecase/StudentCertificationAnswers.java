package com.gdutra.certification.domain.usecase;

import com.gdutra.certification.domain.model.Alternative;
import com.gdutra.certification.domain.model.Question;
import com.gdutra.certification.infrastructure.dtos.StudentCertificationAnswerDTO;
import com.gdutra.certification.infrastructure.repositories.QuestionRepository;
import com.gdutra.certification.infrastructure.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCertificationAnswers {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private QuestionRepository questionRepository;

    public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO studentCertificationAnswer) throws Exception {
        var student = repository.findByEmail(studentCertificationAnswer.getEmail());

        if (student.isEmpty()) {
            throw new Exception("E-mail do estudante incorreto");
        }

        List<Question> questions = questionRepository.findByTechnology(studentCertificationAnswer.getTechnology());

        studentCertificationAnswer.getQuestionAnswers().forEach(questionAnswer -> {
            var questionResult = questions.stream().filter(question -> question.getId().equals(questionAnswer.getQuestionId()))
                    .findFirst().get();

            var findCorrectAlternative = questionResult.getAlternatives().stream().filter(Alternative::getIsCorrect)
                    .findFirst().get();

            questionAnswer.setIsCorrect(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeId()));
        });

        return studentCertificationAnswer;
    }
}
