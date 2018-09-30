package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLInjectionProblemSolution {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = null;

		try {
			// read input from keyboard
			sc = new Scanner(System.in);
			int n = 0;

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDatabase", "root", "root");

			// For Insert values
			System.out.println("Enter username:");
			String username = sc.next();
			System.out.println("Enter Password:");
			String pass = sc.next();

			// STEP 4: create Statement object
			
			ps = con.prepareStatement("select * from User where username = ? and password = ? ");
			// execute the query and solve The Problem of SQL Injection
			ps.setString(1, username);
			ps.setString(2, pass);
			
			// for GET values
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				String username1 = rs.getString(1);
				String pass1 = rs.getString(2);
				System.out.println("UserName: " + username1 + " Password: " + pass1);

			}

		} catch (ClassNotFoundException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end JDBCExample
