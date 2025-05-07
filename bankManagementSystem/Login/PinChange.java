package bankManagementSystem.Login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;

import javax.swing.*;
public class PinChange extends JFrame implements ActionListener{
	
	JButton back,change;
	JLabel pinText,rePin,text;
	JPasswordField pinChange,pin2;
	String pin;
	PinChange(String pin){
		
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
		
		text = new JLabel("Change Your Pin");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(267,280,450,35);
		overlay.add(text);
		
		pinText = new JLabel("New Pin: ");
		pinText.setForeground(Color.white);
		pinText.setFont(new Font("System", Font.BOLD, 16));
		pinText.setBounds(165, 320, 180, 25);
		overlay.add(pinText);
		
		pinChange = new JPasswordField();
		pinChange.setFont(new Font("Raleway", Font.BOLD,16));
		pinChange.setBounds(330,320,180,25);
		overlay.add(pinChange);
		
		pinChange.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && !Character.isISOControl(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Only Numeric Digits are allowed.");
				}
			}
		});
		
		rePin = new JLabel("Re-enter New Pin: ");
		rePin.setForeground(Color.white);
		rePin.setFont(new Font("System", Font.BOLD, 16));
		rePin.setBounds(165, 360, 180, 25);
		overlay.add(rePin);
		
		pin2 = new JPasswordField();
		pin2.setFont(new Font("Raleway",Font.BOLD, 16));
		pin2.setBounds(330,360,180,25);
		overlay.add(pin2);
		
		pin2.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && !Character.isISOControl(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Only Numeric Digits are allowed.");
				}
			}
		});
		
		change = new JButton("Change");
		change.setBounds(400,510,100,25);
		overlay.add(change);
		change.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(170,510,100,25);
		overlay.add(back);
		back.addActionListener(this);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource() == change) {
				String newPin = new String(pinChange.getPassword());
				String rePin = new String(pin2.getPassword());
				
				if(!newPin.equals(rePin)) {
					JOptionPane.showMessageDialog(null,"Pin Mismatched, Please Enter the same pin");
					return;
					
				}
				
				if(newPin.isEmpty() || rePin.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Pin can't be null");
					return;
				}
				
				if(!newPin.matches("\\d+")) {
					JOptionPane.showMessageDialog(null, "Pin must contain only numbers");	
					return;
				}
				
				if(newPin.length() != 4) {
					JOptionPane.showMessageDialog(null, "Pin must be 4 digit long");
					return;
				}
				
				Conn c = new Conn();
				String query1 = "update bank set pin=? where pin = ?";
				PreparedStatement ps1 = c.conn.prepareStatement(query1);
				ps1.setString(1, newPin);
				ps1.setString(2, pin);
				ps1.executeUpdate();
				
				PreparedStatement ps2 = c.conn.prepareStatement("update login set pinNumber = ? where pinNumber = ?");
				ps2.setString(1, newPin);
				ps2.setString(2, pin);
				ps2.executeUpdate();
				
				PreparedStatement ps3 = c.conn.prepareStatement("update signupthree set pin = ? where pin = ?");
				ps3.setString(1, newPin);
				ps3.setString(2, pin);
				ps3.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Pin Changed Sucessfully");
				setVisible(false);
				new Login().setVisible(true);
			}else {
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}
			
			
		}catch(Exception ex) {
			System.out.println("DataBase Error" + ex.getMessage());
			ex.printStackTrace();
		}
	}
		
	
	

	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}
}
