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
import com.example.hh.kysely.backend.domain.Session;
import com.example.hh.kysely.backend.domain.SessionRepository;
import com.example.hh.kysely.backend.domain.User;
import com.example.hh.kysely.backend.domain.UserRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner insertDemoQuestions(QuestionRepository Qrepository, QuizRepository quizrepo, UserRepository urepo, AnswerRepository arepo, SessionRepository srepo) {
		return (args) -> {

			// COMMAND LINE RUNNER FOR CREATING TEST QUESTIONS, ANSWERS AND QUIZ

			// CREATE USERS  - urepo.save RETURNS User object it created
			User cliuser = urepo.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "admin"));
			
			// CREATE NEW QUIZ
			Quiz quiz1 = new Quiz("Esimerkkikysely: Kurssipalaute", cliuser, "Kysely on tarkoitettu opiskelijoille, jolla on voi vastata opettajan luomaan kyselyyn. Kyselyyn voi vastata vain opiskelijat, jotka ovat osallistuneet kurssiin. ");
			quizrepo.save(quiz1);

			// SAVE QUESTIONS TO QUIZ
			Question question1 = Qrepository.save(new Question("Kuinka hyvin saavutit kurssin oppimistavoitteet?", quiz1));
			Question question2 = Qrepository.save(new Question("Kuinka hyvin kurssin ty??m????r?? vastasi opintopisteiden m????r?????", quiz1));
			Question question3 = Qrepository.save(new Question("Mit?? olisit toivonut lis?????", quiz1));
			Question question4 = Qrepository.save(new Question("Mik?? kurssissa oli hyv?????", quiz1));
			Question question5 = Qrepository.save(new Question("Miten kurssia voisi kehitt?????", quiz1));
			Question question6 = Qrepository.save(new Question("Kokonaisarvosana kurssin j??rjest??misest?? (1-5).", quiz1, "radiobutton"));
			Question question7 = Qrepository.save(new Question("Mitk?? n??ist?? olivat erityisen mukavia kurssissa?", quiz1, "checkbox"));
			Question question8 = Qrepository.save(new Question("Vapaa kommentti kurssista.", quiz1));

			// CREATE NEW SESSION
			Session sesh = srepo.save(new Session(quiz1));
			
			// SAVE ANSWERS
			arepo.save(new Answer(question1, "Saavutin tavoitteet tietysti erinomaisesti", sesh));
			arepo.save(new Answer(question1, "En onnistunut :(", sesh));
			arepo.save(new Answer(question2, "Kurssin ty??m????r?? vastasu noppien m????r???? oikein mukavasti", sesh));
			arepo.save(new Answer(question2, "noppien m????r???? oikein mukavasti", sesh));
			arepo.save(new Answer(question2, "Kurssin ty??m????r?? vastasi huonosti", sesh));
			arepo.save(new Answer(question3, "Olisin toivonut ryhm??t??it?? lis????", sesh));
			arepo.save(new Answer(question4, "Kurssissa oli hyv???? ryhm??ty??t", sesh));
			arepo.save(new Answer(question5, "Kurssia voisi kehitt???? vastaamalla t??h??n kyselyyn", sesh));
			arepo.save(new Answer(question6, "Turku", sesh));
			arepo.save(new Answer(question7, "T??m?? on vapaan kommentin paikanpit??j??", sesh));
			
			arepo.save(new Answer(question6, "Turku"));
			arepo.save(new Answer(question6, "Turku"));
			arepo.save(new Answer(question6, "Tampere"));
			arepo.save(new Answer(question6, "Tampere"));
			arepo.save(new Answer(question6, "Helsinki"));
			arepo.save(new Answer(question6, "Helsinki"));
			arepo.save(new Answer(question6, "Helsinki"));
			arepo.save(new Answer(question6, "Lahti"));

			
			
			// CONSOLE INFORMATION
			log.info("Fetching demo questions...");

			// CONSOLE INFORMATION
			for (Question question : Qrepository.findAll()) {
				log.info(question.toString());
			}
		};
	}
}
