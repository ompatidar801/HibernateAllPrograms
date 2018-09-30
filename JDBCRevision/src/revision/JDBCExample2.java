package revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample2 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
		Statement str = cn.createStatement();
		ResultSet rs=str.executeQuery("Select * from developer");
		rs.relative(2);  
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)); 
	}
}
