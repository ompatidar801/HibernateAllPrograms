package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLInjectionProblem {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
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
			// STEP 4: create Statement object
			st = con.createStatement();
			// read each Student Details from keyboard
			// set them to query and execute the query

			/*if (sc != null) {
				System.out.println("Enter No. of User");
				n = sc.nextInt();
			}

			for (int i = 1; i <= n; ++i) {
				System.out.println("Enter " + i + " username:");
				String username = sc.next();
				System.out.println("Enter " + i + " Password:");
				String pass = sc.next();

				String query = "insert into User values('" + username + "','"+ pass + "')";

				// execute the query
				int rs = 0;
				if (st != null) {
					rs = st.executeUpdate(query);
				}
				if (rs == 0) {
					System.out.println(i + "Record Is Not Inserted");
				} else {
					System.out.println(i + "Record Is Inserted");
				}
			}*/

			// for GET values and The Problem of SQL Injection
			
			System.out.println("Enter username:");
			String username = sc.next();
			System.out.println("Enter Password:");
			String pass = sc.next();

			String query = "select * from User where username = '" + username + "' and password = '" + pass + "'";
			
			System.out.println("Query : " + query);
	
			// execute the query
			ResultSet rs = st.executeQuery(query);
			
			System.out.println("Results");

			while (rs.next()) {
			String username1 = rs.getString(2);
			String pass1 = rs.getString(3);
			System.out.println("username: "+username1+" Password: "+pass1);
			
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
				if (st != null)
					st.close();
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
