package com.example.hh.kysely.backend.domain;

public class Option {
	
	private String content;
	
	public Option(String content) {
		super();
		this.content = content;
	}
	
	public Option() {}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
