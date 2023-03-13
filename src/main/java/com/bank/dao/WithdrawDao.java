package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.User;
import com.bank.model.Withdraw;
import com.bank.util.DBConnect;

public class WithdrawDao {
	
	Connection con=DBConnect.getConnection();
	
	public boolean addWithdraw(Withdraw wd) {
		
		String sql="insert into withdraw (withdraw,description,user_id) values(?,?,?)";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setDouble(1, wd.getWithdraw());
			ps.setString(2, wd.getDescription());
			ps.setInt(3,wd.getUserId());
			
			int i= ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Withdraw> getWithdrawList(int uid){
		
		List<Withdraw> wdList= new ArrayList<Withdraw>();
		
		String sql= "select * from withdraw where user_id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				Withdraw wd= new Withdraw();
				
				wd.setId(rs.getInt("id"));
				wd.setWithdraw(rs.getDouble("withdraw"));
				wd.setWithdrawDate(rs.getDate("withdraw_date").toString());
				wd.setDescription(rs.getString("description"));
				wd.setUserId(rs.getInt("user_id"));
				
				wdList.add(wd);
			}
			
			return wdList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteWithdraw(int id) {
		
		String sql="delete from withdraw where id=?";
		
		try {
			
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Withdraw getWithdraw(int id) {
		
		String sql= "select * from withdraw where id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				Withdraw wd= new Withdraw();
				
				wd.setId(rs.getInt("id"));
				wd.setWithdraw(rs.getDouble("withdraw"));
				wd.setWithdrawDate(rs.getDate("withdraw_date").toString());
				wd.setDescription(rs.getString("description"));
				wd.setUserId(rs.getInt("user_id"));
				
				return wd;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateWithdraw(Withdraw wd) {
		
		String sql="update withdraw set withdraw=?, description=?, user_id=? where id=?";
		
		try {
			
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setDouble(1, wd.getWithdraw());
			ps.setString(2, wd.getDescription());
			ps.setInt(3, wd.getUserId());
			ps.setInt(4, wd.getId());
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	}
	
	public double getTotalWithdraw(User user) {
		
		String sql="select sum(withdraw) as totalwithdraw from withdraw where user_id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getDouble("totalwithdraw");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
}
