package com.example.hh.kysely.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;
import com.example.hh.kysely.backend.domain.Quiz;
import com.example.hh.kysely.backend.domain.QuizRepository;

@CrossOrigin
@Controller
public class QuestionController {

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
	@RequestMapping(value = "/answerSave", method = RequestMethod.PUT)
	public Question newAnswer(@RequestBody Question newAnswer, @PathVariable Long id) {
		return qrepo.findById(id)
				.map(question -> {
					question.setAnswer(newAnswer.getAnswer());
					return qrepo.save(question);
				})
				.orElseGet (() -> {
					newAnswer.setQuestionId(id);
					return qrepo.save(newAnswer);
				});
	}
	*/

	// QUIZ PAGE, LANDING PAGE, SHOWS ALL QUIZZES
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("quizzes", quizrepo.findAll());
		model.addAttribute("quiz", new Quiz());
		return "index";
	}

	// FIND QUIZ BY ID
	@RequestMapping(value = "/quiz/{id}")
	public String quizPage(@PathVariable("id") Long quizId, Model model) {
		model.addAttribute("quiz", quizrepo.findById(quizId));
		model.addAttribute("question", new Question());
		return "quizpage";
	}

	// SAVE QUIZ
	@RequestMapping(value = "/quiz/save")
	public String quizSave(Quiz quiz) {
		quizrepo.save(quiz);
		return "redirect:../";
	}

	// ADD QUESTION TO QUIZ
	@RequestMapping(value = "/quiz/{id}/addquestion")
	public String saveQuestionToQuiz(@PathVariable("id") Long quizId, Question question) {
		qrepo.save(new Question(question.getContent(), quizrepo.findById(quizId).orElse(null)));
		String returnUrl = "redirect:/quiz/" + quizId;
		return returnUrl;
	}
}
