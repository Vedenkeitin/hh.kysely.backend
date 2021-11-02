package com.example.hh.kysely.backend.domain;

import javax.persistence.Entity;
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
	
	

	public Question() {
		
	}
	
	public Question(String content, String answer) {
		this.content = content;
		this.answer = answer;
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

	@Override
	public String toString() {
		return "Question [questionId=" + id + ", content=" + content + ", answer=" + answer + "]";
	}
}
