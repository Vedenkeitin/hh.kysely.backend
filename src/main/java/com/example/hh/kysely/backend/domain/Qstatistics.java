package com.example.hh.kysely.backend.domain;

public class Qstatistics {
	// not entity class
	
		private String content; // vastausvaihtoehdon teksti
		private long count; // vastattujen vaihtoehtojen lkm
		
		public Qstatistics() {
			super();
			this.content = null;
			this.count = 0;
		}
		
		
		public Qstatistics(String content, long count) {
			super();
			this.content = content;
			this.count = count;
		}
		public void setModel(String content) {
			this.content = content;
		}
		public void setCount(long count) {
			this.count = count;
		}
		public String getContent() {
			return content;
		}
		public long getCount() {
			return count;
		}
		@Override
		public String toString() {
			return "QuestionModelCount [content=" + content + ", count=" + count + "]";
		}
}
