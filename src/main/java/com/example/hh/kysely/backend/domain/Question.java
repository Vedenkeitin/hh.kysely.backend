package com.example.hh.kysely.backend.domain;

public class Question {
	private Long questionId;
	private String content;
	private String answer;
	
	

	public Question() {
		
	}
	
	public Question(String content, String answer) {
		this.content = content;
		this.answer = answer;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
		return "Question [questionId=" + questionId + ", content=" + content + ", answer=" + answer + "]";
	}
	
}