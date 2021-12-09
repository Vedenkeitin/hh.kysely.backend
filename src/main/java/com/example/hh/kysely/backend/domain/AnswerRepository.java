package com.example.hh.kysely.backend.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByContent(String content);
	
	
	@Query("SELECT " + " new com.example.hh.kysely.backend.domain.Qstatistics(a.content, COUNT(a.content)) "
			+ " FROM Answer a " + " WHERE a.question = :question " + " GROUP BY a.content")
	public List<Qstatistics> findByQuestionNamedParams(//findByQstatistics(
			@Param("question") Question question);
	//findByQuestionNamedParams();
	

}

/**
@Query("SELECT " + " new hh.palvelinohjelmointi.carcrudproject.domain.CarModelStatistics(c.model, COUNT(c)) "
		+ " FROM Car c GROUP BY c.model")
public List<CarModelStatistics> findByCarModelStatistics();
**/

/*
 * SELECT CONTENT, COUNT(CONTENT)
 * FROM ANSWER
 * WHERE QUESTION = 7
 * GROUP BY CONTENT
 */

//@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
//User findUserByStatusAndNameNamedParams(
  //@Param("status") Integer status, 
  //@Param("name") String name);

