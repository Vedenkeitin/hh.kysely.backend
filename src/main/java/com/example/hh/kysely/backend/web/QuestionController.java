package com.example.hh.kysely.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QuestionController {
	@RequestMapping(value="/")
	public String greeting() {
		return "hello";
	}
}
