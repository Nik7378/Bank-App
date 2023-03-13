package com.bank.model;

public class Withdraw {
	
	private int id;
	private double withdraw;
	private String withdrawDate;
	private String description;
	private int userId;
	
	@Override
	public String toString() {
		return "Withdraw [id=" + id + ", withdraw=" + withdraw + ", withdrawDate=" + withdrawDate + ", description="
				+ description + ", userId=" + userId + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	public String getWithdrawDate() {
		return withdrawDate;
	}
	public void setWithdrawDate(String withdrawDate) {
		this.withdrawDate = withdrawDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
