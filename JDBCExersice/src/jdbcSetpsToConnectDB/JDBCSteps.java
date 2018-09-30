package jdbcSetpsToConnectDB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCSteps 
{

	public static void main(String[] args)
	{
		Connection con=null;
		Statement st=null;
		try {
			FileInputStream fis = new FileInputStream("DBConnect.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String DriverName = (String) prop.get("DriverName");
			String URL = (String) prop.get("URL");
			String UserName1 = (String) prop.get("UserName");
			String Password1 = (String) prop.get("Password");
			
			Class.forName(DriverName);
			con = DriverManager.getConnection(URL,UserName1,Password1);
			st = con.createStatement();
			st.executeUpdate("create table StudentDetails(sID int,sName varchar(36),sMarks int(3))");
			
			System.out.println("Table Successfully Created");
			
			} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
