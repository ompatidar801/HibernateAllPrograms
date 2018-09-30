import java.sql.*;
import java.util.Scanner;;
public class CommitRollback 
{
	public static void main(String[] args) throws Exception
	{
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Number Which belong in om1:");
		int n = sc.nextInt();*/
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		con.setAutoCommit(false);  
		Statement s = con.createStatement();
		int res = s.executeUpdate("delete salary from om");
		System.out.println(res);
		con.rollback();
		s.close();
		con.close();
	}
}
