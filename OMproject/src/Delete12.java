import java.util.Scanner;
import java.sql.*;
public class Delete12
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter RollNo Which you Want to Delete");
		int n = sc.nextInt();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		
		Statement st = con.createStatement();
		int rs = st.executeUpdate("delete from table1 where sno=" +n);
		//System.out.println(rs);
		if(rs==0)
		{
			System.out.println("Record Not Found & Not delete"+rs);
		}
		else
		{
			System.out.println("No of Record are Deleted: "+rs);
		}

		st.close();
		con.close();
	}
}
