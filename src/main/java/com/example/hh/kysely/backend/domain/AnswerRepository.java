package com.example.hh.kysely.backend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByContent(String content);
}