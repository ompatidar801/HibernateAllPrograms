package metaDataExamples;

import java.sql.*;

public class DatabaseMetaDataExample1 {

	public static void main(String[] args) throws Exception
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hawa","root","root");
		DatabaseMetaData dmd = cn.getMetaData();
		
		System.out.println("Driver Name: "+dmd.getDriverName());
		System.out.println("Driver Version: "+dmd.getDriverVersion());
		System.out.println("UserName: "+dmd.getUserName());
		System.out.println("Database Product Name: "+dmd.getDatabaseProductName());
		System.out.println("Database Product Version: "+dmd.getDatabaseProductVersion());

		cn.close();
	}

}
