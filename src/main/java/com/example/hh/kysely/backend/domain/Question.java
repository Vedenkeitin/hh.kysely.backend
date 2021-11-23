package com.example.hh.kysely.backend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String content;
	private String answer;
	private String type;
	@ElementCollection  
	private List<String> options;

	@ManyToOne
	@JoinColumn(name = "question")
	@JsonIgnoreProperties({"questions", "sessions"})
	private Quiz quiz;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnoreProperties({"question"})
    private List<Answer> answers;

	
	public Question() {
	}

	public Question(String content, String answer) {
		this.content = content;
		this.answer = answer;
	}
	
	public Question(String content, Quiz quiz) {
		super();
		this.content = content;
		this.quiz = quiz;
	}

	public Question(String content, Quiz quiz, String type) {
		super();
		this.content = content;
		this.quiz = quiz;
		this.type = type;
	}
	
	

	public Question(String content, String answer, Quiz quiz) {
		this.content = content;
		this.answer = answer;
		this.quiz = quiz;
	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
	


}
