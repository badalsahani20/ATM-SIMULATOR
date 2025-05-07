package bankManagementSystem.Login;

//import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;  // SerialVersionUID added for compatibility
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit,cancel;
	String formno;
	
	SignUpThree(String formno){
		
		this.formno = formno;
		
		setLayout(null);
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD, 22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type = new JLabel("Account Type: ");
		type.setFont(new Font("Raleway",Font.BOLD, 22));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD,16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100,180,150,20);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font.BOLD,16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350,180,250,20);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD,16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100,220,250,20);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway", Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350,220,250,20);
		add(r4);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		
		JLabel card = new JLabel("Card Number: ");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100, 300, 200, 30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-0544");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330,300,300,30);
		add(number);
		
		JLabel cardDetails = new JLabel("16 Digit Card Number");
		cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
		cardDetails.setBounds(100,330,300,20);
		add(cardDetails);
		
		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(330,370,300,30);
		add(pnumber);
		
		JLabel pinDetails = new JLabel("Four Digit Password");
		pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
		pinDetails.setBounds(100,400,300,20);
		add(pinDetails);
		
		JLabel services = new JLabel("Services Required: ");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,450,300,30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setBounds(100, 500, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setBounds(350, 500, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setBounds(560, 500, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("Email & Alerts");
		c4.setBackground(Color.white);
		c4.setBounds(100, 550, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setBounds(560, 550, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Statements");
		c6.setBackground(Color.white);
		c6.setBounds(350, 550, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("Accept All The Policies");
		c7.setBackground(Color.white);
		c7.setBounds(100, 680, 200, 30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBounds(250,720,100,30);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		add(cancel);
		
		submit.addActionListener(this);
		cancel.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,820);
		setLocation(350, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String accountType = null;
			
			if(r1.isSelected()) {
				accountType = "Saving Account";
			}else if(r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType = "Current Account";
			}else if(r4.isSelected()){
				accountType = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			// Generate a 16-digit card number
			String cardNumber = String.format("%04d%04d%04d%04d",
			    random.nextInt(10000), random.nextInt(10000), random.nextInt(10000), random.nextInt(10000));

			// Generate a 4-digit PIN
			String pinNumber = String.format("%04d", random.nextInt(10000));

			
			String facility = "";
			
			if(c1.isSelected()) facility += "ATM Card, ";
			if(c2.isSelected()) facility += "Internet Banking, ";
			if(c3.isSelected()) facility += "Mobile Banking, ";
			if(c4.isSelected()) facility += "Email & Alerts, ";
			if(c5.isSelected()) facility += "Cheque Book, ";
			if(c6.isSelected()) facility += "E-Statements, ";

			// Remove trailing comma
			if (!facility.isEmpty()) {
			    facility = facility.substring(0, facility.length() - 2);
			}
			
			if (!c7.isSelected()) {
			    JOptionPane.showMessageDialog(null, "You must accept the policies!");
			    return; // Stop submission
			}

			
			try {
				if(accountType.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Account Typee is Required");
				}else {
					Conn c = new Conn();
					String query = "INSERT INTO signupthree (formno, accountType, cardNumber, pin, facility) VALUES (?, ?, ?, ?, ?)";
					
		            PreparedStatement ps1 = c.conn.prepareStatement(query);
		            ps1.setString(1, formno);
		            ps1.setString(2, accountType);
		            ps1.setString(3, cardNumber);
		            ps1.setString(4, pinNumber);
		            ps1.setString(5, facility);
		            ps1.executeUpdate();
		            ps1.close();
		            
		            
		            String query2 = "INSERT INTO login (formno, cardNumber, pinNumber) Values (?,?,?)";
		            PreparedStatement ps2 = c.conn.prepareStatement(query2);
		            ps2.setString(1, formno);
		            ps2.setString(2, cardNumber);
		            ps2.setString(3, pinNumber);
		            
		            ps2.executeUpdate();
		            ps2.close();
		            c.conn.close();
		            
		            JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber + "\n Pin: " + pinNumber);
		            setVisible(false);
		            new Deposit(pinNumber).setVisible(false);
				}
			}catch (SQLException e) {
			    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
			    e.printStackTrace();
			}
			
		}else if(ae.getSource() == cancel) {
			setVisible(false);  // Close the current frame
		    new Login().setVisible(true);  // Navigate back to login or another page
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new SignUpThree("");
	}
}
