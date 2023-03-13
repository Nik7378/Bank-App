package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.bank.model.User;
import com.bank.util.DBConnect;
import com.bank.dao.DepositDao;
import com.bank.dao.WithdrawDao;

public class UserDao {

	Connection con= DBConnect.getConnection();
	
	public boolean adduser(String name,String age,String mobile,String aadhar,String password) {
		
		String sql="insert into user (name,age,mobile,aadhar,password) values(?,?,?,?,?)";
		
		try {
	
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, mobile);
			ps.setString(4, aadhar);
			ps.setString(5, password);

			int i=ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public User userLogin(String mobile,String password) {
		
		String sql="select * from user where mobile=? and password=?";
		
		User user = new User();
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mobile);
			ps.setString(2, password);

			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setMobile(rs.getString("mobile"));
				user.setAadhar(rs.getString("aadhar"));
				user.setPassword(rs.getString("password"));
			}
			
			return user;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean updateUser(User u) {
		
		String sql="update user set name=?, age=?, mobile=?, aadhar=?, password=? where id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getAge());
			ps.setString(3, u.getMobile());
			ps.setString(4, u.getAadhar());
			ps.setString(5, u.getPassword());
			ps.setInt(6, u.getId());

			int i=ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
