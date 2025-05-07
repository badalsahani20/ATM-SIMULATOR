package bankManagementSystem.Login;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
public class Withdrawl extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JTextField amount;
	JButton withdraw,back;
	String pin;
	
	Withdrawl(String pin){
		this.pin = pin;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JPanel overlay = new JPanel();
		overlay.setLayout(null);
		overlay.setOpaque(false);
		overlay.setBounds(0,0,900,900);
		image.add(overlay);
		
		
		
		JLabel text = new JLabel("Enter the Withdrawl amount: ₹");
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170,300,400,20);
		overlay.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 16));
		amount.setBounds(170,350,320,25);
		overlay.add(amount);
		
		withdraw = new JButton("WithDraw");
		withdraw.setBounds(355, 485, 150, 30);
		withdraw.addActionListener(this);
		overlay.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		overlay.add(back);
		
		setSize(900, 900);
		setLocation(300,0);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			
			if(ae.getSource() == withdraw) {
				String number = amount.getText();
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String formattedDate = sdf.format(date);
				if(number.equals("")) {
					JOptionPane.showMessageDialog(null,"Please Enter the withdraw Amount");
				}else {
					
					Conn c = new Conn();
					String query = "Insert Into bank(pin, date, type, amount) values(?,?,?,?)";
					PreparedStatement ps1 = c.conn.prepareStatement(query);
					ps1.setString(1, pin);
					ps1.setString(2, formattedDate);
					ps1.setString(3,"withdrawal");
					ps1.setString(4, number);
					ps1.executeUpdate();
					JOptionPane.showMessageDialog(null,"Amount: ₹"+number + " Withdrawal Sucessfull!");
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
			}else if(ae.getSource() == back) {
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Withdrawl("");
	}
}


