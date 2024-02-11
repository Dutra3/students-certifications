package com.gdutra.certification.infrastructure.repositories;

import com.gdutra.certification.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {

    List<Question> findByTechnology(String technology);
}
