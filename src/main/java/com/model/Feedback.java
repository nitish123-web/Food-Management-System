package com.model;

public class Feedback {
	
	private String c_email;
	private String review;
	private int rank;
	private String advice;
	
	public Feedback() {
		super();
	}

	public Feedback(String c_email, String review, int rank, String advice) {
		super();
		this.c_email = c_email;
		this.review = review;
		this.rank = rank;
		this.advice = advice;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	@Override
	public String toString() {
		return "Feedback [c_email=" + c_email + ", review=" + review + ", rank=" + rank + ", advice=" + advice + "]";
	}
	
}
