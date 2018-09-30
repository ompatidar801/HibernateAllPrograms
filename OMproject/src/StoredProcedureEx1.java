import java.sql.*;
import java.util.Scanner;
public class StoredProcedureEx1 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n1= sc.nextInt();
		Class.forName("com.mysql.jdcbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		Statement st= con.createStatement();
		st.execute("create table tab2(id int,name varchar(30))");
		st.executeUpdate("insert into tab2 values(121,'Rahul')");
		st.executeUpdate("insert into tab2 values(122,'Ravi"+"')");
		//PreparedStatement st1 = con.prepareStatement();
		
		
		
	}
}
