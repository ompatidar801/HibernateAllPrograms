package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertMultipleRecordUsingPS
{
	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		Scanner sc = null;
		
		try 
		{
			// read input from keyboard
			sc = new Scanner(System.in);
			int n = 0;
			if(sc!=null)
			{
				System.out.println("Enter No. of Students");
				n = sc.nextInt();
			}
			
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDatabase", "root", "root");
			
			// STEP 4: create PrepareStatement object
			if(con!=null)
			{
				ps = con.prepareStatement("insert into Student values(?,?,?)");
			}
			
			// read each Student Details from keyboard 
			//set them to query and execute the query
			if(ps!=null && sc!=null)
			{
				for (int i = 1; i<=n ; ++i) 
				{
					System.out.println("Enter "+i+" StudentID:");
					int id = sc.nextInt();
					System.out.println("Enter "+i+" Student Name:");
					String name = sc.next();
					System.out.println("Enter "+i+" Student Marks:");
					int marks = sc.nextInt();
					
					//set these values at placeholders in query
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setInt(3, marks);
					
					//execute the query
					int rs = ps.executeUpdate();
					if (rs==0) 
					{
						System.out.println(i+"Record Is Not Inserted");
					} else 
					{
						System.out.println(i+"Record Is Inserted");
					}
				}
			}
			
		}
		catch (ClassNotFoundException se) 
		{
			// Handle errors for JDBC
			se.printStackTrace();
		}
		catch (SQLException se) 
		{
			// Handle errors for JDBC
			se.printStackTrace();
		}
		catch (Exception e) 
		{
			// Handle errors for Class.forName
			e.printStackTrace();
		} 
		finally 
		{
			// finally block used to close resources
			try 
			{
				if (ps != null)
					ps.close();
			} 
			catch (SQLException se2) 
			{
			} // nothing we can do
			try 
			{
				if (con != null)
					con.close();
			} 
			catch (SQLException se) 
			{
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end JDBCExample