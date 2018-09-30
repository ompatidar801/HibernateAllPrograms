package jdbcDatabaseIndependent;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDBIndependentWithProperties {

	public static void main(String[] args) throws Exception
	{
		
		FileInputStream fis = new FileInputStream("dbconnection.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String DriverName = (String) prop.get("Dname");
		String URL = (String) prop.get("URL");
		String UserName = (String) prop.get("username");
		String Password = (String) prop.get("password");
		
		Class.forName(DriverName);
		Connection con = DriverManager.getConnection(URL,UserName,Password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from person345");
		while(rs.next())
		{
			System.out.println("==========Person Details=========");
			System.out.println("Person ID"+rs.getInt(1));
			System.out.println("Person FirstName"+rs.getString(2));
			System.out.println("Person LastName"+rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();

	}

}
