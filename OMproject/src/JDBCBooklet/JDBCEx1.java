package JDBCBooklet;
import java.sql.*;
public class JDBCEx1 
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		Statement ar = con.createStatement();
		ar.execute("create table tab2(id int,name varchar(30))");
		ar.executeUpdate("insert into tab2 values(121,'Rahul')");
		ar.executeUpdate("insert into tab2 values(122,'Ravi"+"')");
		System.out.println("done!!!!....");
	}

}
