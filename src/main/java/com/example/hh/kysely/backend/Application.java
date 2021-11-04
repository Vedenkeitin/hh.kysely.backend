package com.example.hh.kysely.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner insertDemoQuestions(QuestionRepository Qrepository, QuizRepository quizrepo) {
		return (args) -> {

			// COMMAND LINE RUNNER FOR CREATING TEST QUESTIONS, ANSWERS AND QUIZ

			// CREATE NEW QUIZ
			Quiz quiz1 = new Quiz("Quiz from clr");
			quizrepo.save(quiz1);

			// SAVE QUESTIONS TO QUIZ
			Qrepository.save(new Question("What's your favourite movie?", "Monsters Inc", quiz1));
			Qrepository.save(new Question("What is your favourite song?", "Allstar", quiz1));

			// CONSOLE INFORMATION
			log.info("Fetching demo questions...");

			// CONSOLE INFORMATION
			for (Question question : Qrepository.findAll()) {
				log.info(question.toString());
			}
		};
	}
}
