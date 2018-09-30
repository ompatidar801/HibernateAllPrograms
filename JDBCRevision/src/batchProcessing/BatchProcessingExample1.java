package batchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessingExample1 {

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");  
		con.setAutoCommit(false);  
  
		Statement stmt=con.createStatement();
		stmt.addBatch("insert into user420 values(4564,'rajesh','dewas')");  
		stmt.addBatch("insert into user420 values(877,'umesh','goa')");  
		  
		stmt.executeBatch();//executing the batch  
		  
		con.commit();  
		con.close();  
	}

}
