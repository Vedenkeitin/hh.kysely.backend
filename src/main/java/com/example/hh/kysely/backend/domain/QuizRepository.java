package com.example.hh.kysely.backend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
	List<Quiz> findByName(String name);
	List<Quiz> findByVisibility(Boolean visibility);
}