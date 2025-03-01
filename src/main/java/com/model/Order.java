package com.model;

public class Order {
	
	
	private int o_id;
	private String c_email;
	private float t_price;
	private String o_date;
	
	public Order() {
		super();
	}

	public Order(String c_email, float t_price, String o_date) {
		super();
		this.c_email = c_email;
		this.t_price = t_price;
		this.o_date = o_date;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public float getT_price() {
		return t_price;
	}

	public void setT_price(float t_price) {
		this.t_price = t_price;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", c_email=" + c_email + ", t_price=" + t_price + ", o_date=" + o_date + "]";
	}
	
}
