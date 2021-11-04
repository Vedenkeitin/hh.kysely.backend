package com.example.hh.kysely.backend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// SEARCH FOR QUESTIONS
	@RequestMapping(value="/questions")
	public String QuestionList (Model model) {
		model.addAttribute("questions", qrepo.findAll());
		return "questions";
	}
	
	// REST, FIND QUIZZES
	@RequestMapping(value="/questionsRest", method = RequestMethod.GET)
	public @ResponseBody List<Quiz> questionListRest() {
		return (List<Quiz>) quizrepo.findAll();
	}
	private List<Question> questions = new ArrayList<Question>();


	//TEHDÄÄN ENSIN ENDPOINT LANDING PAGELLE KUN SIVUSTOLLE
	//TULLAAN EKAN KERRAN
	@RequestMapping(value = "/questionlist", method = RequestMethod.GET)
	public String naytaAloitus(@RequestParam(name="question", required=false) String content, Model model) {
		questions = new ArrayList<Question>();
		Question question = new Question();
		model.addAttribute("question", question);
		return "addquiz";
	}
	@RequestMapping(value= "/save", method = RequestMethod.GET)
	public String kasittelePostaus(@ModelAttribute(name="question") Question question, Model model) {
		questions.add(question);
		model.addAttribute("questions", questions);
		
		// EMPTYING FORM FOR NEXT ONE
		question = new Question();
		model.addAttribute("question", question);
		
		return "addquiz";
	}
	// QUIZ PAGE
	@RequestMapping(value="/")
	public String index(Model model) {
		model.addAttribute("quizzes", quizrepo.findAll());
		model.addAttribute("quiz", new Quiz());
		return "index";
	}
	
	// FIND QUIZ BY ID
	@RequestMapping(value="/quiz/{id}")
	public String quizPage(@PathVariable("id") Long quizId, Model model) {
		model.addAttribute("quiz", quizrepo.findById(quizId));
		model.addAttribute("question", new Question());
	return "quizpage";
	}
	
	// SAVE QUIZ
	@RequestMapping(value="/quiz/save")
	public String quizSave(Quiz quiz) {
		quizrepo.save(quiz);
		return "redirect:../";
	}
	
	// ADD QUESTION TO QUIZ
	@RequestMapping(value="/quiz/{id}/addquestion")
	public String saveQuestionToQuiz(@PathVariable("id") Long quizId, Question question) {
		qrepo.save(new Question(question.getContent(), quizrepo.findById(quizId).orElse(null)));
		String returnUrl = "redirect:/quiz/" + quizId; 
		return returnUrl;
	}
}
