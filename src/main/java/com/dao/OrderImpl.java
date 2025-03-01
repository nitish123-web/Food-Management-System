package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.db.DbConnect;
import com.model.Order;

public class OrderImpl implements OrderDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	boolean b;
	
	@Override
	public Order place_order(String c_email) {
	 String date=new Date().toString();
	 float t_price=0;
	 Order o=new Order();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select sum(t_price) as total from cart where c_email=?");
            ps.setString(1, c_email);
            rs=ps.executeQuery();
            if(rs.next()) {
            	t_price=rs.getFloat("total");
            }
            if(t_price>0) {
            	ps=con.prepareStatement("insert into orders(C_EMAIL,T_PRICE,O_DATE) values(?,?,?)");
                ps.setString(1,c_email);
                ps.setFloat(2,t_price);
                ps.setString(3,date);
                row=ps.executeUpdate();
                if(row>0) {
                	ps=con.prepareStatement("select * from orders where c_email=? and date=?");
                	ps.setString(1, c_email);
                	ps.setString(2, date);
                	rs=ps.executeQuery();
                	if(rs.next()) {
                	 o.setO_id(rs.getInt("o_id"));
                	 o.setC_email(rs.getString("c_email"));
                	 o.setT_price(rs.getFloat("t_price"));
                	 o.setO_date(rs.getString("date"));
                    }
                }
            }
		}catch (Exception s) {
			s.printStackTrace();
		}
	       return o;
	}

	@Override
	public List<Order> show_order() {
		List<Order> list=new ArrayList<Order>();
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("select * form orders");
           	rs=ps.executeQuery();
           	 while(rs.next()) {
           		Order o=new Order(); 
           		o.setO_id(rs.getInt("o_id"));
           	    o.setC_email(rs.getString("c_email"));
           	    o.setT_price(rs.getFloat("t_price"));
           	    o.setO_date(rs.getString("date"));
           	    list.add(o);
           	 }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update_order(String c_email,float t_price) {
		try {
			con=DbConnect.get_connect();
			ps=con.prepareStatement("update orders set t_price=? where c_email=?");
			ps.setFloat(1, t_price);
			ps.setString(2, c_email);
           	row=ps.executeUpdate();
           	b=(row>0)?true:false;
           	System.out.println(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

}
