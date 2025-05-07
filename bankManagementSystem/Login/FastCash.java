package bankManagementSystem.Login;
//import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;  // SerialVersionUID added for compatibility
		JButton amount1, amount2, amount3, amount4, amount5, amount6, back;
		String pin;
		
	
		FastCash(String pin){
			this.pin = pin;
			
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
			Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(0,0,900,900);
			add(image);
			
			JLabel text = new JLabel("Select Withdrawl Amount");
			text.setBounds(219,300,700,35);
			text.setForeground(Color.white);
			text.setFont(new Font("System",Font.BOLD,16));
			image.add(text);
			
			amount1 = new JButton("₹100");
			amount1.setBounds(170,415,150,30);
			amount1.addActionListener(this);
			image.add(amount1);
			
			amount2 = new JButton("₹500");
			amount2.setBounds(350,415,150,30);
			amount2.addActionListener(this);
			image.add(amount2);
			
			amount3 = new JButton("₹1000");
			amount3.setBounds(170,450,150,30);
			amount3.addActionListener(this);
			image.add(amount3);
			
			amount4 = new JButton("₹2000");
			amount4.setBounds(350,450,150,30);
			amount4.addActionListener(this);
			image.add(amount4);
			
			amount5 = new JButton("₹5000");
			amount5.setBounds(170,485,150,30);
			amount5.addActionListener(this);
			image.add(amount5);
			
			amount6 = new JButton("₹10000");
			amount6.setBounds(350,485,150,30);
			amount6.addActionListener(this);
			image.add(amount6);
			
			back = new JButton("Exit");
			back.setBounds(350,520,150,30);
			back.addActionListener(this);
			image.add(back);
			
			setLayout(null);
			setSize(900,900);
			setLocation(300,0);
			setUndecorated(true);
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == back) {
				setVisible(false);
				new Transactions(pin).setVisible(true);
			
			}else {
				String amount = ((JButton) ae.getSource()).getText().substring(1);
				Conn c = new Conn();

				try {
				    String query = "SELECT * FROM bank WHERE pin = ?";
				    int balance = 0;
				    PreparedStatement ps = c.conn.prepareStatement(query);
				    ps.setString(1, pin);
				    ResultSet rs = ps.executeQuery();

				    while (rs.next()) {
				        String type = rs.getString("type").trim().toLowerCase();
				        int amt = Integer.parseInt(rs.getString("amount"));

				        if (type.equals("deposit")) {
				            balance += amt;
				        } else if (type.equals("withdrawal")) {
				            balance -= amt;
				        }
				    }

				    if (balance < Integer.parseInt(amount)) {
				        JOptionPane.showMessageDialog(null, "Insufficient Balance");
				        return;
				    }

				    // Correct date and insert
				    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				    String query2 = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
				    PreparedStatement ps2 = c.conn.prepareStatement(query2);
				    ps2.setString(1, pin);
				    ps2.setString(2, formattedDate);
				    ps2.setString(3, "withdrawal");
				    ps2.setString(4, amount);
				    ps2.executeUpdate();

				    JOptionPane.showMessageDialog(null, "Amount ₹" + amount + " Debited Successfully!");
				    setVisible(false);
				    new Transactions(pin).setVisible(true);

				} catch (SQLException ex) {
				    ex.printStackTrace(); // Log the error!
				}

			}
		}
		
		
		public static void main(String[] args) {
			new FastCash("");
		}
}

