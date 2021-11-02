package com.example.hh.kysely.backend.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String content;
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "question")
	@JsonManagedReference
	private Quiz quiz;
	
	public Question() {}
	
	public Question(String content, String answer) {
		this.content = content;
		this.answer = answer;
	}

	public Question(String content, String answer, Quiz quiz) {
		this.content = content;
		this.answer = answer;
		this.quiz = quiz;
	}
	
	public Long getQuestionId() {
		return id;
	}

	public void setQuestionId(Long questionId) {
		this.id = questionId;
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
	
	@Override
	public String toString() {
		return "Question [questionId=" + id + ", content=" + content + ", answer=" + answer + "]";
	}
}
