package JDBCBooklet;
import java.sql.*;
public class PreparedStatementEx2
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
		String qre = "insert into tab2 values(?,?)";
		/*PreparedStatement ps = con.prepareStatement(qre);
		ps.setInt(1, 46);
		ps.setString(2,"mumbai");
		ps.executeUpdate();
		ps.setInt(1, 48);
		ps.setString(2,"indore");
		ps.executeUpdate();
		ps.setInt(1, 47);
		ps.setString(2,"Goa");
		ps.executeUpdate();*/
		PreparedStatement ps1 = con.prepareStatement("select * from tab1 where id >? and id<?");
		ps1.setInt(1,45);
		//ps1.setString(2,"id");
		ps1.setInt(2, 122);
		ps1.executeQuery();
		System.out.println("Record inserted");
		System.out.println(ps1);
		con.close();
	}
}
                                                                                                                                         