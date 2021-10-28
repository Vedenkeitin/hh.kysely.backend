package com.example.hh.kysely.backend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findByContent(String Content);
}