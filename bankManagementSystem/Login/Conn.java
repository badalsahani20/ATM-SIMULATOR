package bankManagementSystem.Login;

import java.sql.*;

public class Conn {
	
	// A class exists for connection  
	public Connection conn;  
	// Creating Statement
	public Statement stmt;
	 

	

	//	Steps to take
//	1.Create Connection
//	2.Create Statement
	public Conn() {
		// Creating Statement
		try {
			//Step 1
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "NAMEYOUR0544");
			stmt = conn.createStatement();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
