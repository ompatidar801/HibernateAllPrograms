package JDBCBooklet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCEx2
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		Statement st = con.createStatement();
		ResultSet rt = st.executeQuery("select * from tab1");
		while(rt.next())
		{
			System.out.print(rt.getString(2)+" : ");
			System.out.print(rt.getInt(1)+" ");
			System.out.println("");
		}
		System.out.println("Done");
	}
}
