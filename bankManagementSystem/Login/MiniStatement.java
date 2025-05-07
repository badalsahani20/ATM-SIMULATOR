package bankManagementSystem.Login;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
public class MiniStatement extends JFrame{
	String pin;
	MiniStatement(String pin){
		this.pin = pin;
		setLayout(null);
		setTitle("Mini Statement");
		
		JLabel mini = new JLabel();
		add(mini);
		
		JLabel bank = new JLabel("State Bank Of India");
		bank.setBounds(133,20,150,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		Conn c = new Conn();
		try {
			
			PreparedStatement ps1 = c.conn.prepareStatement("select * from login where pinNumber = ?");
			ps1.setString(1, pin);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4) + "xxxxxxxx" + rs.getString("cardNumber").substring(12));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			String query = "select * from bank where pin = ? ORDER BY date DESC LIMIT 5";
			PreparedStatement ps1 = c.conn.prepareStatement(query);
			ps1.setString(1, pin);
			ResultSet rs = ps1.executeQuery();
			
			StringBuilder statement = new StringBuilder();
			statement.append("<html>");
			while(rs.next()) {
				statement.append(rs.getString("date"))
				.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
				.append(rs.getString("type"))
				.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
				.append(rs.getString("amount"))
				.append("<br><br>");
			}
			
			statement.append("</html>");
			mini.setText(statement.toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		mini.setBounds(20,140,400,400);
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MiniStatement("").setVisible(true);
	}
}
