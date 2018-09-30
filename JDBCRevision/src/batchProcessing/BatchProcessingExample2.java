package batchProcessing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchProcessingExample2 {

	public static void main(String[] args) 
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
		con.setAutoCommit(false);  

		PreparedStatement ps=con.prepareStatement("insert into user420 values(?,?,?)");  

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		while(true)
		{  

			System.out.println("enter id");  
			String s1=br.readLine();  
			int id=Integer.parseInt(s1);  

			System.out.println("enter name");  
			String name=br.readLine();  

			System.out.println("enter address");  
			String address=br.readLine();    

			ps.setInt(1,id);  
			ps.setString(2,name);  
			ps.setString(3,address);  
			
		    ps.addBatch();  
		    System.out.println("Want to add more records y/n");  
		    String ans=br.readLine();  
		    if(ans.equals("n"))
		    {  
		    	break;  
		    }  
		      
		    }  
		    ps.executeBatch();  
		      
		    System.out.println("record successfully saved");  
		    con.commit();
		    con.close();  
		    }
		    catch(Exception e){System.out.println(e);}  
		      
		    }
}  

