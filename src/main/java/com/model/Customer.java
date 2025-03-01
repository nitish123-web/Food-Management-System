package com.model;

public class Customer {
	
	private String c_name;
	private String c_email;
	private String c_pass;
	private String c_address;
	private long c_contact;
	
	public Customer() {
		super();
	}
	
	public Customer(String c_email, String c_pass) {
		super();
		this.c_email = c_email;
		this.c_pass = c_pass;
	}

	public Customer(String c_name, String c_email, String c_pass, String c_address, long c_contact) {
		super();
		this.c_name = c_name;
		this.c_email = c_email;
		this.c_pass = c_pass;
		this.c_address = c_address;
		this.c_contact = c_contact;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getC_pass() {
		return c_pass;
	}

	public void setC_pass(String c_pass) {
		this.c_pass = c_pass;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public long getC_contact() {
		return c_contact;
	}

	public void setC_contact(long c_contact) {
		this.c_contact = c_contact;
	}

	@Override
	public String toString() {
		return "Customer [c_name=" + c_name + ", c_email=" + c_email + ", c_pass=" + c_pass + ", c_address=" + c_address
				+ ", c_contact=" + c_contact + "]";
	}
	
}
