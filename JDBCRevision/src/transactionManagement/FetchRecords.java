package transactionManagement;

import java.sql.*;

class FetchRecords
{  
	public static void main(String args[])throws Exception
	{  
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");  
		con.setAutoCommit(false);  
  
		Statement stmt=con.createStatement();  
		stmt.executeUpdate("insert into developer values(190,'abhi',40000)");  
		stmt.executeUpdate("insert into developer values(191,'umesh',50000)");  
		System.out.println("Records Successfullly Inserted");
		con.commit();  
		con.close();  
	}
}  
