package com.example.hh.kysely.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;
import com.example.hh.kysely.backend.domain.Quiz;
import com.example.hh.kysely.backend.domain.QuizRepository;

@CrossOrigin
@Controller
public class RestController {

	@Autowired
	private QuestionRepository qrepo;

	@Autowired
	private QuizRepository quizrepo;
	
	

	// REST, FIND QUESTIONS
	@RequestMapping(value = "/questionsRest", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) qrepo.findAll();
	}

	// REST, FIND QUIZZES
	@RequestMapping(value = "/quizRest", method = RequestMethod.GET)
	public @ResponseBody List<Quiz> quizListRest() {
		return (List<Quiz>) quizrepo.findAll();
	}

	// REST, SAVE ANSWER
	/**
	 * @RequestMapping(value = "/answerSave", method = RequestMethod.PUT) public
	 *                       Question newAnswer(@RequestBody Question
	 *                       newAnswer, @PathVariable Long id) { return
	 *                       qrepo.findById(id) .map(question -> {
	 *                       question.setAnswer(newAnswer.getAnswer()); return
	 *                       qrepo.save(question); }) .orElseGet (() -> {
	 *                       newAnswer.setQuestionId(id); return
	 *                       qrepo.save(newAnswer); }); }
	 */

}
