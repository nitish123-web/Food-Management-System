package com.dao;

import com.model.Admin;
import com.model.Customer;

public interface LoginDao {
    
	boolean admin_login(Admin ad);
	boolean admin_changepass(Admin ad);
	boolean user_login(Customer cust);
	boolean user_changepass(Customer cust);
}
