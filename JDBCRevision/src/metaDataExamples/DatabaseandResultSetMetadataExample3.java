package metaDataExamples;

import java.sql.*;

public class DatabaseandResultSetMetadataExample3 {

	public static void main(String[] args)
	{
		try {
				Class.forName("com.mysql.jdbc.Driver"); 
	            System.out.println("DRIVERS LOADED...");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
	            System.out.println("CONNECTION ESTABLISHED...");

	// UNIVERSAL DATABASE DETAILS
	            DatabaseMetaData dmd = con.getMetaData();
	            System.out.println("DATABASE NAME : " + dmd.getDatabaseProductName());
	            System.out.println("DATABASE VERSION : " + dmd.getDatabaseProductVersion());
	            System.out.println("NAME OF THE DRIVER : " + dmd.getDriverName());
	            System.out.println("VERSION OF THE DRIVER : " + dmd.getDriverVersion());
	            System.out.println("MAJOR VERSION OF DRIVER : " + dmd.getDriverMajorVersion());
	            System.out.println("MINOR VERSION OF DRIVER : " + dmd.getDriverMinorVersion());

	// USER DATABASE DETAILS
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("select * from developer");
	            ResultSetMetaData rsmd = rs.getMetaData();
	            System.out.println("NUMBER OF COLUMNS : " + rsmd.getColumnCount());
	            for (int i = 1; i <= rsmd.getColumnCount(); i++) {

	                System.out.println("NAME OF THE COLUMN : " + rsmd.getColumnName(i));
	                System.out.println("TYPE OF THE COLUMN : " + rsmd.getColumnType(i));
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }// main
	};// MetaData