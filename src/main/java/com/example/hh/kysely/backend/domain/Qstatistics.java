package com.example.hh.kysely.backend.domain;

public class Qstatistics {
	// not entity class
	
		private String model;
		private long count;
		
		public Qstatistics() {
			super();
			this.model = null;
			this.count = 0;
		}
		
		
		public Qstatistics(String model, long count) {
			super();
			this.model = model;
			this.count = count;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public void setCount(long count) {
			this.count = count;
		}
		public String getModel() {
			return model;
		}
		public long getCount() {
			return count;
		}
		@Override
		public String toString() {
			return "QuestionModelCount [model=" + model + ", count=" + count + "]";
		}
}
