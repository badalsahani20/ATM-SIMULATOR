package bankManagementSystem.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BalanceEnquiry extends JFrame implements ActionListener{
	JButton back;
	JTextField fill;
	String pin;
	BalanceEnquiry(String pin){
		this.pin = pin;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("icons/atm.jpg");
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JPanel overlay = new JPanel();
		overlay.setLayout(null);
		overlay.setOpaque(false);
		overlay.setBounds(0,0,900,900);
		image.add(overlay);
		
		back = new JButton("Back");
		back.setBounds(355,510,150,30);
		back.addActionListener(this);
		overlay.add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try {
			String query = "SELECT * FROM bank WHERE pin = ?";
			PreparedStatement ps = c.conn.prepareStatement(query);
			ps.setString(1, pin);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				String type = rs.getString("type").trim().toLowerCase();
				int amt = Integer.parseInt(rs.getString("amount"));
				if(type.equals("deposit")) {
					balance += amt;
				}else {
					balance -= amt;
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel text = new JLabel("Your current A/C Balance is: ₹" + balance);
		text.setForeground(Color.white);
		text.setBounds(170,350,400,50);
		overlay.add(text);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pin).setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}
