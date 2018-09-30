import java.sql.*;
public class OurJavaCode {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from x where name like 'n%'");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		System.out.println(con.getClass().getName());
		System.out.println(st.getClass().getName());
		System.out.println(rs.getClass().getName());
		rs.close();
		st.close();
		con.close();
	}

}
