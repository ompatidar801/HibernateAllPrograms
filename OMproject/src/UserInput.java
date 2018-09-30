import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any numer:");
		int no = sc.nextInt();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from table1 where sno >"+no);
		while(rs.next() != false)
		{
			System.out.println(rs.getInt("sno")+" "+rs.getString("name")+" "+rs.getString("lname"));

		}
	}

}
