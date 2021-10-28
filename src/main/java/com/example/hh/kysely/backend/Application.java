package com.example.hh.kysely.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner insertDemoQuestions(QuestionRepository Qrepository) {
		return (args) -> {
			Qrepository.save(new Question("What's your favourite movie?", "Monsters Inc"));
			Qrepository.save(new Question("What is your favourite song?", "Allstar"));
			
			log.info("Fetching demo questions...");
			
			for (Question question : Qrepository.findAll()) {
				log.info(question.toString());
			}
		};
	}
}
