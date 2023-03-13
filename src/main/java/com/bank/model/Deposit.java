package com.bank.model;

public class Deposit {
	
	private int id;
	private double deposit;
	private String depositDate;
	private String description;
	private int userId;

	@Override
	public String toString() {
		return "Deposit [id=" + id + ", deposit=" + deposit + ", depositDate=" + depositDate + ", description="
				+ description + ", userId=" + userId + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
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
