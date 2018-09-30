package JDBCBooklet;

import java.sql.*;

public class PreparedStatementEx1 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		//Statement st = con.createStatement();
		//st.execute("create table Rakka(id int(10),name varchar(50))");
		PreparedStatement stmt=con.prepareStatement("insert into Rakka values(?,?)");  
		stmt.setInt(1,101);//1 specifies the first parameter in the query  
		stmt.setString(2,"Ratan");  
		stmt.setInt(3,132);//1 specifies the first parameter in the query  
		stmt.setString(4,"Ratanrt");  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted");  
		  

		con.close();
		
	}
}
