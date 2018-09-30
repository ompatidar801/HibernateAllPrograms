package statementInterface;

//STEP 1. Import required packages
import java.sql.*;

public class StatementInterfaceExample2 
{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/JDBCDatabase";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) 
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "UPDATE Student set smarks=90 WHERE sid=12";
			/*String sql = "create table UserD(userid int, password varchar(30))";*/

			// Let us check if it returns a true Result Set or not.
			Boolean ret = stmt.execute(sql);
			System.out.println("Return value is : " + ret.toString());

			// Let us update age of the record with ID = 12;
			int rows = stmt.executeUpdate(sql);
			System.out.println("Rows impacted : " + rows);

			// Let us select all the records and display them.
			sql = "SELECT * FROM Student";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) 
			{
				// Retrieve by column name
				int id = rs.getInt("sid");
				String name = rs.getString("sname");
				int marks = rs.getInt("smarks");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
				System.out.print(", marks: " + marks);
				System.out.println("");
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
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
				if (stmt != null)
					stmt.close();
			} 
			catch (SQLException se2) 
			{
			} // nothing we can do
			try 
			{
				if (conn != null)
					conn.close();
			} 
			catch (SQLException se) 
			{
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main
}// end JDBCExample