package com.deepanshu.stockProject;

import java.util.List;

public interface user_interface {

	/** Abstract methods **/

	public void register(userLogin userlogin);
	public boolean validateResource(String name, String getPass);
	public List<stockDetail> showStockList();
	public void addToDb(String stockName, int quantity, double balanceAmount);
}
