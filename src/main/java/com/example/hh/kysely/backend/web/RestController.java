package com.example.hh.kysely.backend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.hh.kysely.backend.domain.Answer;
import com.example.hh.kysely.backend.domain.AnswerRepository;
import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;
import com.example.hh.kysely.backend.domain.Quiz;
import com.example.hh.kysely.backend.domain.QuizRepository;

@CrossOrigin
@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private QuestionRepository qrepo;

	@Autowired
	private QuizRepository quizrepo;
	
	@Autowired
	private AnswerRepository arepo;

	// REST, FIND QUESTIONS
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) qrepo.findAll();
	}

	// REST, FIND QUIZZES
	@RequestMapping(value = "/quizzes", method = RequestMethod.GET)
	public @ResponseBody List<Quiz> quizListRest() {
		return (List<Quiz>) quizrepo.findAll();
	}

	
	// REST, UUSI KYSYMYS
	@RequestMapping(value="/questions/{id}/save", method= RequestMethod.POST)
	public @ResponseBody Question saveQuestionRest(@RequestBody Question question, @PathVariable ("id") Long quizId) {
		Quiz q = quizrepo.findById(quizId).orElse(null);
		question.setQuiz(q);
		return qrepo.save(question);
		
	}
	
	// REST, UUSI VASTAUS
	@RequestMapping(value="/answers/{id}/save", method= RequestMethod.POST)
	public @ResponseBody Answer saveAnswerRest(@RequestBody Answer answer, @PathVariable ("id") Long questionId) {
		Question q = qrepo.findById(questionId).orElse(null);
		answer.setQuestion(q);
		return arepo.save(answer);
		
	}
	
	// REST, KATSO KYSELYN SISÄLTÖ
	@RequestMapping(value = "/quizzes/{id}", method = RequestMethod.GET)
	public @ResponseBody Quiz quizListRest(@PathVariable ("id") Long quizId) {
		Quiz q = quizrepo.findById(quizId).orElse(null);
		return q;
		
	}
	// REST, HAE KYSELYN KYSYMYKSET
	@RequestMapping(value = "/quizzes/{id}/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest(@PathVariable ("id") Long quizId) {
		Quiz q = quizrepo.findById(quizId).orElse(null);
		return q.questions;
		
	}
	//REST, HAE KYSELYN KAIKKI VASTAUKSET
	@RequestMapping(value = "/quizzes/{id}/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> answerListRest(@PathVariable ("id") Long quizId) {
		Quiz q = quizrepo.findById(quizId).orElse(null);
		List<Answer> alist = new ArrayList<>();
		for (Question qu : q.questions) {
			alist.addAll(qu.getAnswers());
		}
		return alist;
	}
	
	//REST SESSION GET ALL
	
	// GET QUIZ ANSWERS
	// POHJA 
	/* 
	@RequestMapping(value="/answers/quiz/{id}/save", method= RequestMethod.POST)
	public @ResponseBody Answer saveQuizAnswerRest(@RequestBody String data, @PathVariable ("id") Long quizId) {
		Question q = qrepo.findById(questionId).orElse(null);
		Session sesh = srepo.save(new Session(quizrepo.findById(quizId).orElse()));
		for ( q : quesions ) {
			
			for( answer : answers ){
				answer.setQuestion(q, answer.content, sesh);
			}
		}
		return http.Ok!;
		
	}
	*/

}
