package bankManagementSystem.Login;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;  // SerialVersionUID added for compatibility
		JButton deposit, withdraw, fastCash, miniStatement, pinChange, balEnquiry, exit;
		String pin;
	
		Transactions(String pin){
			this.pin = pin;
			
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
			Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(0,0,900,900);
			add(image);
			
			JLabel text = new JLabel("Please Select Your Transaction");
			text.setBounds(219,300,700,35);
			text.setForeground(Color.white);
			text.setFont(new Font("System",Font.BOLD,16));
			image.add(text);
			
			deposit = new JButton("Deposit");
			deposit.setBounds(170,415,150,30);
			deposit.addActionListener(this);
			image.add(deposit);
			
			withdraw = new JButton("Cash Withdraw");
			withdraw.setBounds(350,415,150,30);
			withdraw.addActionListener(this);
			image.add(withdraw);
			
			fastCash = new JButton("Fast Cash");
			fastCash.setBounds(170,450,150,30);
			fastCash.addActionListener(this);
			image.add(fastCash);
			
			miniStatement = new JButton("Mini Statement");
			miniStatement.setBounds(350,450,150,30);
			miniStatement.addActionListener(this);
			image.add(miniStatement);
			
			pinChange = new JButton("Change Pin");
			pinChange.setBounds(170,485,150,30);
			pinChange.addActionListener(this);
			image.add(pinChange);
			
			balEnquiry = new JButton("Balance Enquiry");
			balEnquiry.setBounds(350,485,150,30);
			balEnquiry.addActionListener(this);
			image.add(balEnquiry);
			
			exit = new JButton("Exit");
			exit.setBounds(350,520,150,30);
			exit.addActionListener(this);
			image.add(exit);
			
			setLayout(null);
			setSize(900,900);
			setLocation(300,0);
			setUndecorated(true);
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == exit) {
				System.exit(0);
			}else if(ae.getSource() == deposit) {
				setVisible(false);
				new Deposit(pin).setVisible(true);
			}else if(ae.getSource() == withdraw) {
				setVisible(false);
				new Withdrawl(pin).setVisible(true); 
			}else if(ae.getSource() == fastCash) {
				setVisible(false);
				new FastCash(pin).setVisible(true);
			}else if(ae.getSource() == pinChange) {
				setVisible(false);
				new PinChange(pin).setVisible(true);
			}else if(ae.getSource() == balEnquiry) {
				setVisible(false);
				new BalanceEnquiry(pin).setVisible(true);
			}else {
				new MiniStatement(pin).setVisible(true);
			}
		}
		
		
		public static void main(String[] args) {
			new Transactions("");
		}
}
