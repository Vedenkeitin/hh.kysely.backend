package com.example.hh.kysely.backend.domain;

public class Question {
	private Long QuestionId;
	private String Answer;
	
	public Question() {
		
	}

	public Question(String answer) {
		Answer = answer;
	}

	public Long getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(Long questionId) {
		QuestionId = questionId;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	@Override
	public String toString() {
		return "Question [QuestionId=" + QuestionId + ", Answer=" + Answer + "]";
	}
	
	
}
