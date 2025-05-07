package bankManagementSystem.Login;

//import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpTwo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;  // SerialVersionUID added for compatibility
    JTextField panTextField, aadharTextField, stateTextField, existingAccTextField;
    JButton next;
    JRadioButton syes, sno, existYes, existNo;
    JComboBox<String> religion, category, income, education, occupation, existing_acc;
    String formno;
//    JDateChooser dateChooser;

    SignUpTwo(String formno) {
    	
    	this.formno = formno;
    	System.out.println("Received form number: " + this.formno);

        
        // Check if it is null
        if (formno == null || formno.isEmpty()) {
            System.out.println("Form number is missing!");
        }

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AdditionalDetails.setBounds(290, 80, 400, 30);
        add(AdditionalDetails);

        // Religion
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        // Category
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String valCategory[] = {"General", "OBC", "SC", "ST", "OTHER"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        // Income
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String valIncome[] = {"Null", "< 1,50,000", "2,50,000", "< 5,00,000", "UPTO 10,00,000"};
        income = new JComboBox<>(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        // Educational Qualification
        JLabel educationLabel = new JLabel("Educational-");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 250, 30);
        add(educationLabel);
        
        JLabel qualificationLabel = new JLabel("Qualification:");
        qualificationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        qualificationLabel.setBounds(100, 310, 250, 30);
        add(qualificationLabel);

        String educationVal[] = {"Non-Graduate", "Graduate", "Post Graduate", "Doctrate", "Others"};
        education = new JComboBox<>(educationVal);
        education.setBounds(300, 310, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        // Occupation
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 360, 200, 30);
        add(occupationLabel);

        String occupationVal[] = {"Salaried", "Self Employed", "Businessman", "Student", "Retired"};
        occupation = new JComboBox<>(occupationVal);
        occupation.setBounds(300, 360, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        // PAN and Aadhar
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 410, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 410, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 460, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 460, 400, 30);
        add(aadharTextField);

        // Senior Citizen
        JLabel sCitizen = new JLabel("Senior Citizen:");
        sCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        sCitizen.setBounds(100, 510, 200, 30);
        add(sCitizen);

        syes = new JRadioButton("Yes");
        sno = new JRadioButton("No");
        syes.setBounds(300, 510, 100, 30);
        syes.setBackground(Color.WHITE);
        sno.setBounds(450, 510, 100, 30);
        sno.setBackground(Color.WHITE);
        add(syes);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel existAcc = new JLabel("Existing Account:");
        existAcc.setFont(new Font("Raleway", Font.BOLD, 20));
        existAcc.setBounds(100, 560, 200, 30);
        add(existAcc);
        
        existYes = new JRadioButton("Yes");
        existNo = new JRadioButton("No");
        existYes.setBounds(300, 560, 100, 30);
        existYes.setBackground(Color.WHITE);
        existNo.setBounds(450, 560, 100, 30);
        existNo.setBackground(Color.WHITE);
        add(existYes);
        add(existNo);
        
        ButtonGroup existGroup = new ButtonGroup();
        existGroup.add(existYes);
        existGroup.add(existNo);
       

        // Next Button
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
        String rel = (String) religion.getSelectedItem();
        String cat = (String) category.getSelectedItem();
        String inc = (String) income.getSelectedItem();
        String edu = (String) education.getSelectedItem();
        String occ = (String) occupation.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        
        String existingAcc = existYes.isSelected() ? "Yes" : "No";

        String senior = syes.isSelected() ? "Yes" : "No";

        // Validate fields
        if (pan.isEmpty() || aadhar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        // SQL insertion
        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan_no, aadhar_no, senior_citizen, existing_account) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.conn.prepareStatement(query);
            
            ps.setString(1, formno);
            ps.setString(2, rel);
            ps.setString(3, cat);
            ps.setString(4, inc);
            ps.setString(5, edu);
            ps.setString(6, occ);
            ps.setString(7, pan);
            ps.setString(8, aadhar);
            ps.setString(9, senior);
            ps.setString(10, existingAcc);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Signup Successful!");
            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
