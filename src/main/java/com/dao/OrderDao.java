package com.dao;

import java.util.List;

import com.model.Order;

public interface OrderDao {
    
	boolean update_order(String c_email,float t_price);
	Order place_order(String c_email);
	List<Order> show_order();
}
