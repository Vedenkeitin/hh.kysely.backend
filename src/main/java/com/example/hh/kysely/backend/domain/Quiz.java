package com.example.hh.kysely.backend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String Description;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz")
	@JsonIgnoreProperties("quiz") //  ({ "quiz", "answers" }) vastaukset saa poistettua kyselyn vastauksista 
	public List<Question> questions;
	
	@ManyToOne
	@JoinColumn(name="quiz")
	@JsonIgnoreProperties("quizzes")
	public User owner;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz")
	@JsonIgnoreProperties("quizzes")
	public List<Session> sessions;

	public Quiz() {
	}

	public Quiz(String name) {
		super();
		this.name = name;
	}
	
	public Quiz(String name, User owner) {
		this.name = name;
		this.owner = owner;
	}

	public Quiz(String name, User owner, String description) {
		this.name = name;
		this.owner = owner;
		this.Description = description;
	}

	public Quiz(String name, List<Question> questions) {
		super();
		this.name = name;
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	
}
