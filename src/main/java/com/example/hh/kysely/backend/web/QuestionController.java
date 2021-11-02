package com.example.hh.kysely.backend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.hh.kysely.backend.domain.Question;


@Controller
public class QuestionController {
	@RequestMapping(value="/")
	public String greeting() {
		return "hello";
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
