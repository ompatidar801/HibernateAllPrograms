package revisionjdbc;

import java.sql.*;

public class JDBCExample1 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
		Statement str = cn.createStatement();
		ResultSet rs = str.executeQuery("select name from developer where id=102");
		
		System.out.println("Data Successfully inserted");
		rs.close();
		str.close();
		cn.close();
	}
}
