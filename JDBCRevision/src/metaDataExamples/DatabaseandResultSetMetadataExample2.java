package metaDataExamples;

import java.sql.*;

public class DatabaseandResultSetMetadataExample2 
{

	public static void main(String[] args) 
		{
			try 
			{
					Class.forName("com.mysql.jdbc.Driver"); 
		            System.out.println("DRIVERS LOADED...");
		            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
		            System.out.println("CONNECTION ESTABLISHED...");
		            Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery("select * from developer");
		            ResultSetMetaData rsmd = rs.getMetaData();
		            System.out.println("==================================================");

		// PRINTING COLUMN NAME
		            for (int i = 1; i <= rsmd.getColumnCount(); i++)
		            {

		                System.out.print(rsmd.getColumnName(i) + "	");
		            }
		            System.out.println("");
		            System.out.println("==================================================");

		// PRINTING THE DATA OF THE TABLE
		            while (rs.next()) 
		            {
		                for (int j = 1; j <= rsmd.getColumnCount(); j++) 
		                {
		                    System.out.print(rs.getString(j) + "	");
		                }
		                System.out.println("");
		            }
		            con.close();
		        } 
				catch (SQLException sqle) 
				{
		            sqle.printStackTrace();

		        } 
				catch (ClassNotFoundException e)
				{
		
					e.printStackTrace();
				}
		    }// main
		};// Table