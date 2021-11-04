package com.example.hh.kysely.backend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;


@CrossOrigin
@Controller
public class QuestionController {
	@RequestMapping(value="/")
	public String greeting() {
		return "hello";
	}
	
	@Autowired
	private QuestionRepository qrepo;
	
	// Hakee tietokannasta kysymykset
	@RequestMapping(value="/questions")
	public String QuestionList (Model model) {
		model.addAttribute("questions", qrepo.findAll());
		return "questions";
	}
	
	// REST kysymysten haku
	@RequestMapping(value="/questionsRest", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) qrepo.findAll();
	}
	
	private List<Question> questions = new ArrayList<Question>();


	//TEHDÄÄN ENSIN ENDPOINT LANDING PAGELLE KUN SIVUSTOLLE
	//TULLAAN EKAN KERRAN
	@RequestMapping(value = "/questionlist", method = RequestMethod.GET)
	public String naytaAloitus(@RequestParam(name="question", required=false) String content, Model model) {
		System.out.println("TULTIIN KONTROLLERIIN");
		questions = new ArrayList<Question>();
		Question question = new Question();
		model.addAttribute("question", question);
		return "addquiz";
	}
	@RequestMapping(value= "/save", method = RequestMethod.GET)
	public String kasittelePostaus(@ModelAttribute(name="question") Question question, Model model) {
		System.out.println("OLLAAN KÄSITTELE POSTAUKSESSA");
		questions.add(question);
		model.addAttribute("questions", questions);
		System.out.println(question);
		System.out.println("questions");
		//HALUTAAN TYHJÄTÄ LOMAKE SEURAAVAA VARTEN
		question = new Question();
		model.addAttribute("question", question);
		
		return "addquiz";
		
	}
	@RequestMapping(value="/question")
	public String messages(Model model) {
		Question q1 = new Question();
		q1.setContent("Who?");
		Question q2 = new Question();		
		q2.setContent("What?");
		Question q3 = new Question();
		q3.setContent("Why?");

		List<Question> questions = new ArrayList<Question>();
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);

		model.addAttribute("questions", questions);
		return "questions";
	}
}
