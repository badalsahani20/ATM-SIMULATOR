package bankManagementSystem.Login;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener {

    JButton login, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        // Image handling with null check
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        if (icon1.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Image not found.");
        } else {
            Image icon2 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            JLabel label = new JLabel(new ImageIcon(icon2));
            label.setBounds(70, 10, 100, 100);
            add(label);
        }

        // Labels
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(180, 50, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(100, 150, 150, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setBounds(100, 200, 150, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 210, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // Buttons
        login = new JButton("Log In");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {        	
            String cardNo = cardTextField.getText().trim();
            String pin = new String(pinTextField.getPassword()).trim();
//            String query = "select * from login where cardNumber = ? and pinNumber = ?";
            


            if (cardNo.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Card No. and Pin cannot be empty.");
                return;
            }

            if (!cardNo.matches("\\d{16}")) {
                JOptionPane.showMessageDialog(this, "Invalid Card Number. Must be 16 digits.");
                return;
            }

            if (!pin.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Invalid Pin. Must be 4 digits.");
                return;
            }
            
            try {
            	Conn conn = new Conn();
                String query = "SELECT pinNumber FROM login WHERE cardNumber = ?";
                PreparedStatement stmt = conn.conn.prepareStatement(query);
                stmt.setString(1, cardNo);
                ResultSet rs = stmt.executeQuery();

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this, "Card Number does not exist.");
                } else {
                    String correctPin = rs.getString("pinNumber");
                    if (correctPin.equals(pin)) {
                        JOptionPane.showMessageDialog(this, "Login Successful!");
                        JOptionPane.showMessageDialog(null, "Redirecting to Transaction menu");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect PIN.");
                    }
                    
                    
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
             
        }
        else if (ae.getSource() == signUp) {
             
            JOptionPane.showMessageDialog(this, "Redirecting to Sign Up.");
            new SignUpOne().setVisible(true);
        }
        else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
//        System.out.println("Hello Users!");
    }
}
