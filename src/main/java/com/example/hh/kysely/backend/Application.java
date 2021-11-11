package com.example.hh.kysely.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hh.kysely.backend.domain.Answer;
import com.example.hh.kysely.backend.domain.AnswerRepository;
import com.example.hh.kysely.backend.domain.Question;
import com.example.hh.kysely.backend.domain.QuestionRepository;
import com.example.hh.kysely.backend.domain.Quiz;
import com.example.hh.kysely.backend.domain.QuizRepository;
import com.example.hh.kysely.backend.domain.User;
import com.example.hh.kysely.backend.domain.UserRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner insertDemoQuestions(QuestionRepository Qrepository, QuizRepository quizrepo, UserRepository urepo, AnswerRepository arepo) {
		return (args) -> {

			// COMMAND LINE RUNNER FOR CREATING TEST QUESTIONS, ANSWERS AND QUIZ

			// CREATE USERS  - urepo.save RETURNS User object it created
			User cliuser = urepo.save(new User("moi", "moi"));
			
			// CREATE NEW QUIZ
			Quiz quiz1 = new Quiz("Esimerkkikysely: Kurssipalaute", cliuser);
			quizrepo.save(quiz1);

			// SAVE QUESTIONS TO QUIZ
			Question question1 = Qrepository.save(new Question("Kuinka hyvin saavutit kurssin oppimistavoitteet?", quiz1));
			Question question2 = Qrepository.save(new Question("Kuinka hyvin kurssin työmäärä vastasi opintopisteiden määrää?", quiz1));
			Question question3 = Qrepository.save(new Question("Mitä olisit toivonut lisää?", quiz1));
			Question question4 = Qrepository.save(new Question("Mikä kurssissa oli hyvää?", quiz1));
			Question question5 = Qrepository.save(new Question("Miten kurssia voisi kehittää?", quiz1));
			Question question6 = Qrepository.save(new Question("Kokonaisarvosana kurssin järjestämisestä (1-5).", quiz1));
			Question question7 = Qrepository.save(new Question("Vapaa kommentti kurssista.", quiz1));

			// SAVE ANSWERS
			arepo.save(new Answer(question1, ""));
			arepo.save(new Answer(question1, ""));
			
			// CONSOLE INFORMATION
			log.info("Fetching demo questions...");

			// CONSOLE INFORMATION
			for (Question question : Qrepository.findAll()) {
				log.info(question.toString());
			}
		};
	}
}
