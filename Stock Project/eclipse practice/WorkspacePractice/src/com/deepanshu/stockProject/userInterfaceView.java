package com.deepanshu.stockProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class userInterfaceView extends JFrame {

	private JPanel contentPane;

	private JTextField textName;
	private JTextField emailIdText;
	private JTextField passwordText;
	private JTable table_1;
	JPanel panel_2;
	JButton buy;
	JButton sell;

	String userInputForStockName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterfaceView frame = new userInterfaceView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public userInterfaceView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 978, 842);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 132, 132));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(200, 50));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel.setBackground(Color.cyan);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("User Details ");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setPreferredSize(new Dimension(700, 400));
		panel_1.setLayout(new GridLayout(4, 2));
		panel_1.setBackground(Color.YELLOW);
		contentPane.add(panel_1);

		JLabel name = new JLabel("User Name");
		name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(name);
		/** for user **/
		textName = new JTextField();
		textName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_1.add(textName);
		textName.setColumns(10);

		JLabel emailId = new JLabel("Emial Id");
		emailId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(emailId);

		emailIdText = new JTextField();
		panel_1.add(emailIdText);
		emailIdText.setColumns(10);

		JLabel password = new JLabel("Password");
		password.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(password);

		passwordText = new JTextField();
		panel_1.add(passwordText);
		passwordText.setColumns(10);

		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerDetails();
			}
		});
		register.setForeground(Color.GREEN);
		register.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel_1.add(register);

		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateLoginInfo();
			}
		});
		login.setForeground(Color.GREEN);
		login.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel_1.add(login);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setPreferredSize(new Dimension(500, 300));
		panel_2.setBackground(Color.YELLOW);
		panel_2.setVisible(false);
		contentPane.add(panel_2);

		String col[] = { "Stock Name", "Stock Price", "Background Growth", "Stock Quantity" };
		Object row[][] = {};

		DefaultTableModel dft = new DefaultTableModel(row, col);

		table_1 = new JTable(dft) {

		};

		JScrollPane scrolPane = new JScrollPane(table_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel_2.add(scrolPane).setBounds(5, 40, 485, 325);

		buy = new JButton("Buy stock");
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/* action performed by here for buy the **/
				stockCheck();

			}
		});
		buy.setForeground(Color.GREEN);
		buy.setFont(new Font("Times New Roman", Font.BOLD, 17));
		buy.setVisible(false);
		contentPane.add(buy);

		sell = new JButton("Sell Stock");
		sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/** Action performed here to sell the stock **/
				
			}
		});
		sell.setForeground(Color.GREEN);
		sell.setFont(new Font("Times New Roman", Font.BOLD, 17));
		sell.setVisible(false);
		contentPane.add(sell);

	}
	public void stockCheck() {
		String stockName = JOptionPane.showInputDialog("Which Stock you want to buy ? ");
		int quantity = Integer.parseInt(JOptionPane.showInputDialog("How much quantity of Stock you want to buy ?"));
		double amount = Double.parseDouble(JOptionPane.showInputDialog("How much balance is in your account?"));
		
		
		System.out.println("quantity: "+ quantity);
		System.out.println("stockName: "+ stockName);
		System.out.println("amount: "+ amount);

		/**userInterface object**/
		userImplementation userImp = new userImplementation();
		/**Method for validating the user values**/
		double finalAmount = userImp.validationUser(stockName, amount);
		userImp.addToDb(stockName, quantity,finalAmount);
		
		
		
		
	}

	public void registerDetails() {
		/** Register the details in database **/
		/** validate the information **/

		if (textName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill the Name");
		}
		if (emailIdText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill the Email");
		}
		if (passwordText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill the Password");
		} else {
			// write pending

			String name;
			String emailId;
			String password;

			name = textName.getText();
			emailId = emailIdText.getText();
			password = passwordText.getText();

			System.out.println("name: " + name);
			System.out.println("email Id: " + emailId);
			System.out.println("password: " + password);

			/** make object of user */

			userLogin user = new userLogin();
			userImplementation userIm = new userImplementation();

			user.setUserName(name);
			user.setEmialId(emailId);
			user.setPassword(password);

			userIm.register(user);
			textName.setText("");
			emailIdText.setText("");
			passwordText.setText("");
		}

	}

	public void validateLoginInfo() {

		/** validate the information **/

		if (textName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill the Name");
		}
		if (emailIdText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill the Email");
		}
		if (passwordText.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill the Password");
		} else {
			// write pending
			String name = textName.getText();
			String getEmai = emailIdText.getText();
			String getPass = passwordText.getText();

			userImplementation userIM = new userImplementation();
			boolean res = userIM.validateResource(name, getPass);
			if (res == true) {
				panel_2.setVisible(true);
				buy.setVisible(true);
				sell.setVisible(true);
				stockDetail();

			}

		}
	}

	private void stockDetail() {
		userImplementation userIM = new userImplementation();
		List<stockDetail> resu = userIM.showStockList();

		DefaultTableModel dftt = (DefaultTableModel) table_1.getModel();
		dftt.setRowCount(0);

		for (stockDetail stkDetails : resu) {
			String stockName = stkDetails.getStockName();
			int stockPrice = stkDetails.getStockPrice();
			String backgroundHistory = stkDetails.getStockBackground();
			int stockQuan = stkDetails.getStockQuantity();
			System.out.println("stockName: " + stockName);
			System.out.println("stockPrice: " + stockPrice);
			System.out.println("backgroundHistory: " + backgroundHistory);
			System.out.println("stockQuan: " + stockQuan);

			dftt.addRow(new Object[] { stockName, stockPrice, backgroundHistory, stockQuan });
		}

	}

}
