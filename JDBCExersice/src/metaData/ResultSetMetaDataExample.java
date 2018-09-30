package metaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataExample {

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDatabase", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from User");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			/*System.out.println("Total columns: " + rsmd.getColumnCount());
			System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
			System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));*/
			
			int colCnt = rsmd.getColumnCount();
			for (int i = 1; i <=colCnt; i++) {
				System.out.print(rsmd.getColumnLabel(i)+"\t\t\t");
			}
			System.out.println("\n");
			
			for (int i = 1; i <=colCnt; i++) {
				System.out.print(rsmd.getColumnTypeName(i)+"\t\t\t");
			}
			System.out.println("\n");
			while (rs.next()) {
				
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));

			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}