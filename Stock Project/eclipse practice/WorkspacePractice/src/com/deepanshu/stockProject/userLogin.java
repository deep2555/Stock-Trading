package com.deepanshu.stockProject;

public class userLogin {

	private int id;
	private String userName;
	private String emialId;
	private String password;
	private double balance;
	
	
	/**getter and setter method**/
	
	
	public String getUserName() {
		return userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmialId() {
		return emialId;
	}
	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}

class stockDetail{
	
	private String stockName;
	private int stockPrice;
	private String stockBackground;
	private int stockQuantity;
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getStockBackground() {
		return stockBackground;
	}
	public void setStockBackground(String stockBackground) {
		this.stockBackground = stockBackground;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	
	
}
