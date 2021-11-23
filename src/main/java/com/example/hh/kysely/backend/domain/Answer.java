package com.example.hh.kysely.backend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "question")
	@JsonIgnoreProperties("answers")
	private Question question;
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "session")
	@JsonIgnoreProperties({ "quiz", "answers"})
	private Session session;
	

	public Answer() {}
	
	public Answer(Question question, String content) {
		this.question = question;
		this.content = content;
	}

	public Answer(Question question, String content, Session session) {
		this.question = question;
		this.content = content;
		this.session = session;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
	
}

	
