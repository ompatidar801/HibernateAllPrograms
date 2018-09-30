package preparedStatementExa;

import java.sql.*;

import java.util.*;
class PreparedSExample2
{
	Connection con;
	void openConnection()throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver is loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
	}
	void insertTest()throws Exception
	{
		PreparedStatement pstmt=con.prepareStatement("insert into developer values(?,?,?) ");
		Scanner s=new Scanner(System.in);
		String Choice="yes";
		while(Choice.equals("yes"))
		{
			System.out.println("enter Developer d_id");
			int d_id=s.nextInt();
			System.out.println("enter Developer d_name");
			String d_name=s.next();
			System.out.println("enter Developer address");
			String address=s.next();
			
			//setting the values
			pstmt.setInt(1,d_id);
			pstmt.setString(2,d_name);
			pstmt.setString(3,address);
			int i=pstmt.executeUpdate();
			System.out.println(i+"Row inserted");
			System.out.println("do you want to inset another row(Yes/no)");
			Choice=s.next();
		}//end while
		pstmt.close();
	}
	void closeConnection()throws Exception
	{
		con.close();
		System.out.println("connection is closed");
	}
	public static void main(String[] args) throws Exception
	{ 
		PreparedSExample2 pt=new PreparedSExample2();
		pt.openConnection();
		pt.insertTest();
		pt.closeConnection();
	}
}
