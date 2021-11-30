package com.example.hh.kysely.backend.domain;

public class AnswerWrapper {
	
	private String content;
	private String qid;
	
	public AnswerWrapper() {}
	
	public AnswerWrapper(String content, String qid) {
		this.content = content;
		this.qid = qid;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}

	
}
