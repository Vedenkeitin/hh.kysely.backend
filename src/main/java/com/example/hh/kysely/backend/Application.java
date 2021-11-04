package com.example.hh.kysely.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;
import com.example.hh.kysely.backend.domain.Quiz;
import com.example.hh.kysely.backend.domain.QuizRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner insertDemoQuestions(QuestionRepository Qrepository, QuizRepository QuizRepo) {
		return (args) -> {
		
			Qrepository.save(new Question("What's your favourite movie?", "Monsters Inc"));
			Qrepository.save(new Question("What is your favourite song?", "Allstar"));

			List<Question> qq = new ArrayList<Question>();			
			qq.add(Qrepository.findByContent("What is your favourite song?").get(0));

			Quiz quiz1 = new Quiz("quiz1");
			quiz1.setQuestions(qq);
			QuizRepo.save(quiz1);
			
			log.info("Fetching demo questions...");
			
			for (Question question : Qrepository.findAll()) {
				log.info(question.toString());
			}
		};
	}
}
