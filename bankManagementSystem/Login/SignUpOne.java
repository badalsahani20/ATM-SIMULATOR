package bankManagementSystem.Login;
import bankManagementSystem.Login.Conn; 

import java.awt.*;

import java.awt.event.*;
import java.sql.PreparedStatement;

import com.toedter.calendar.JDateChooser;
import java.util.*;
import javax.swing.*;
import java.sql.*;  // To cover Connection, PreparedStatement, and other SQL classes


public class SignUpOne extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;  // SerialVersionUID added for compatibility
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unMarried;
    JDateChooser dateChooser;
    JLabel formno, personalDetails, name, fname, dob, gender, email, marital, address, city, state, pinCode;
    long random;
    
    SignUpOne() {
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.BLUE);
        add(dateChooser);
        
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        female.setBounds(450, 290, 70, 30);
        female.setBackground(Color.WHITE);
        add(male);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        unMarried = new JRadioButton("Unmarried");
        married.setBounds(300, 390, 80, 30);
        married.setBackground(Color.WHITE);
        unMarried.setBounds(450, 390, 100, 30);
        unMarried.setBackground(Color.WHITE);
        add(married);
        add(unMarried);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unMarried);
        
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 100, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 100, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100, 590, 100, 30);
        add(pinCode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        // Generating form number (assuming random is a long variable)
        String formno = "" + random;  // Ensure `random` is properly defined

        // Collecting input data
        String name = nameTextField.getText();
        String father_name = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        // Gender selection
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } 

        // Email, address, city, pin-code, and state
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pinTextField.getText();
        String state = stateTextField.getText();

        // Validation: Checking for empty fields
        if ( father_name.isEmpty() || 
                dob.isEmpty() || 
                gender == null ||     // Fix: Check for `null` instead of `.isEmpty()` for gender
                email.isEmpty() || 
                address.isEmpty() || 
                city.isEmpty() || 
                pincode.isEmpty() || 
                state.isEmpty()) {
            
            
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        // Marital status validation
        String marital_status = null;
        if (unMarried.isSelected()) {
            marital_status = "UnMarried";
        } else if (married.isSelected()) {
            marital_status = "Married";
        } else {
            JOptionPane.showMessageDialog(null, "Please select the marital status.");
            return;
        }

        // Proceed with SQL insertion or further processing
    

    	
    	try {
    		
    		if(name.equals("")) {
    			JOptionPane.showMessageDialog(null,"Name is required");
    		}else {
    			// Database connection
    			Conn c = new Conn();

    			// Use PreparedStatement directly from the Connection object
    			String sql = "INSERT INTO signup (formno, name, father_name, dob, gender, email, marital_status, address, city, pincode, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    			PreparedStatement ps = c.conn.prepareStatement(sql);  // ✅ Use Connection, not Statement
    			ps.setString(1, formno);
    			ps.setString(2, name);
    			ps.setString(3, father_name);
    			ps.setString(4, dob);
    			ps.setString(5, gender);
    			ps.setString(6, email);
    			ps.setString(7, marital_status);
    			ps.setString(8, address);
    			ps.setString(9, city);
    			ps.setString(10, pincode);
    			ps.setString(11, state);

    			ps.executeUpdate();

    			JOptionPane.showMessageDialog(null, "Signup Successful!");
    			setVisible(false);
    			System.out.println("Sending: " + random);
    			new SignUpTwo(String.valueOf(random)).setVisible(true);

    		}
    		
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public static void main(String args[]) {
        new SignUpOne();
    }
}
