package com.deepanshu.stockProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class userImplementation implements user_interface {

	public void register(userLogin userlogin) {
		/** here detail implementation of register method **/
		try {
			Connection conn = userDB.getconnection();
			String query = "Insert into userLogin(name, emailId, password) values(?,?,?)";
			System.out.println("query: " + query);
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, userlogin.getUserName());
			ps.setString(2, userlogin.getEmialId());
			ps.setString(3, userlogin.getPassword());
			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Registration successful");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in connecting or insert the query");
			e.printStackTrace();
		}

	}

	public boolean validateResource(String name, String getPass) {

		boolean result = false;
		try {
			Connection conn = userDB.getconnection();
			String query = ("select * from userLogin where name = ?");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Login Successfully");
				result = true;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid User");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public List<stockDetail> showStockList() {

		List<stockDetail> result = new ArrayList<stockDetail>();
		try {
			Connection conn = userDB.getconnection();
			String query = ("select * from stockDetails");
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet set = ps.executeQuery();

			while (set.next()) {
				stockDetail stkD = new stockDetail();
				stkD.setStockName(set.getString("stockName"));
				stkD.setStockPrice(set.getInt("stockPrice"));
				stkD.setStockBackground(set.getString("backgroundHistory"));
				stkD.setStockQuantity(set.getInt("stockQuantity"));

				result.add(stkD);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public void addToDb(String stockName, int quantity, double balanceAmount) {
		// TODO Auto-generated method stub

		/** get the detail from the getter method **/
		stockDetail stk = new stockDetail();
		userLogin user = new userLogin();

		try {

			Connection conn = userDB.getconnection();
			String query = "insert into userStockDetails values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

			System.out.println("Stock Name: " + stockName);
			System.out.println("Stock Quantity: " + quantity);
			System.out.println("Final Balance Amount:" + balanceAmount);

			ps.setDouble(1, balanceAmount);
			ps.setString(2, stockName);
			ps.setInt(3, quantity);

			ps.executeUpdate();

			/**
			 * another quantity String Query2 = "insert into userStockDetails
			 * values(?,?,?)"; PreparedStatement pst = conn.prepareStatement(Query2);
			 * 
			 * pst.setDouble(1, getBalances); pst.setString(2, stk.getStockName());
			 * pst.setInt(3, stk.getStockQuantity()); pst.executeUpdate();
			 **/

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public double validationUser(String stockName, double balanceAmount) {
		// TODO Auto-generated method stub
		try {

			stockDetail stk = new stockDetail();
			Connection conn = userDB.getconnection();
			String query = "select stockPrice  from stockDetails where stockName = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, stockName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				stk.setStockPrice(rs.getInt("stockPrice"));
			}
			int getThePrice = stk.getStockPrice();
			if (balanceAmount < getThePrice) {
				JOptionPane.showMessageDialog(null, "You don't Have Enough Balance in your Account");
			} else {
				balanceAmount = balanceAmount - getThePrice;
				System.out.println("balance amount: " + balanceAmount);
				JOptionPane.showMessageDialog(null, "You have bought the" +" "+stockName+" "+ "stock and you have the "
						+" "+balanceAmount+" "+ "balance in your account");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balanceAmount;

	}

}
