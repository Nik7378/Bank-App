package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Deposit;
import com.bank.model.User;
import com.bank.util.DBConnect;

public class DepositDao {
	
	Connection con=DBConnect.getConnection();
	
	public boolean addDeposit(Deposit dep) {
		
		String sql="insert into deposit (deposit,description,user_id) values(?,?,?)";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setDouble(1, dep.getDeposit());
			ps.setString(2, dep.getDescription());
			ps.setInt(3,dep.getUserId());
			
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
	
	public List<Deposit> getDepositList(int uid){
		
		List<Deposit> depList= new ArrayList<Deposit>();
		
		String sql= "select * from deposit where user_id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				Deposit dep= new Deposit();
				
				dep.setId(rs.getInt("id"));
				dep.setDeposit(rs.getDouble("deposit"));
				dep.setDepositDate(rs.getDate("deposit_date").toString());
				dep.setDescription(rs.getString("description"));
				dep.setUserId(rs.getInt("user_id"));
				
				depList.add(dep);
			}
			
			return depList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteDeposit(int id) {
		
		String sql="delete from deposit where id=?";
		
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
	
	public Deposit getDeposit(int id) {
		
		String sql= "select * from deposit where id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				Deposit dep= new Deposit();
				
				dep.setId(rs.getInt("id"));
				dep.setDeposit(rs.getDouble("deposit"));
				dep.setDepositDate(rs.getDate("deposit_date").toString());
				dep.setDescription(rs.getString("description"));
				dep.setUserId(rs.getInt("user_id"));
				
				return dep;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateDeposit(Deposit dep) {
		
		String sql="update deposit set deposit=?, description=?, user_id=? where id=?";
		
		try {
			
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setDouble(1, dep.getDeposit());
			ps.setString(2, dep.getDescription());
			ps.setInt(3, dep.getUserId());
			ps.setInt(4, dep.getId());
			
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
	
	public double getTotalDeposit(User user) {
		
		String sql="select sum(deposit) as totaldeposit from deposit where user_id=?";
		
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getDouble("totaldeposit");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
}
