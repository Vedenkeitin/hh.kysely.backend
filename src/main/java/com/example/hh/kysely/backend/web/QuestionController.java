package com.example.hh.kysely.backend.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hh.kysely.backend.domain.Option;
import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;
import com.example.hh.kysely.backend.domain.Quiz;
import com.example.hh.kysely.backend.domain.QuizRepository;

// JAA USEAMPAAN CONTROLLERIIN
@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository qrepo;

	@Autowired
	private QuizRepository quizrepo;

	

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
		model.addAttribute("option", new Option());
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
		qrepo.save(new Question(question.getContent(), quizrepo.findById(quizId).orElse(null), question.getType()));
		String returnUrl = "redirect:/quiz/" + quizId;
		return returnUrl;
	}
	
	// DELETE QUIZ
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteQuiz(@PathVariable("id") Long quizId, Model model) {
	 quizrepo.deleteById(quizId);
	 return "redirect:../";
	}
	
	// ADD OPTION TO QUESTION
	@RequestMapping(value = "/question/{id}/addoption")
	public String addOption(@PathVariable("id") Long questionId, Option option, HttpServletRequest request) {
		Question q = qrepo.findById(questionId).orElse(null);
		q.getOptions().add(option.getContent()); // Ihmeellistä, että toimii
		qrepo.save(q);
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}
	//DELETE QUESTION FROM QUIZ
	@RequestMapping(value = "/deleteq/{id}", method = RequestMethod.POST)
	public String deleteQuestion(@PathVariable("id") Long questionId, Model model, HttpServletRequest request) {
		qrepo.deleteById(questionId);
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
		
	}
	
	// Car Statistics
    @RequestMapping(value="/answerstatistics", method = RequestMethod.GET)
    public String getStatistics() {
    	return "statistics"; // statistics.html
    }
}
