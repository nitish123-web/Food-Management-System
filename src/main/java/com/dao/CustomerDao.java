package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	boolean add_customer(Customer cs);
	boolean update_customerbyemail(Customer cs);
	boolean delete_customerbyemail(String c_email);
	Customer get_customerbyemail(String c_email);
	List<Customer> get_allcustomer();
}
