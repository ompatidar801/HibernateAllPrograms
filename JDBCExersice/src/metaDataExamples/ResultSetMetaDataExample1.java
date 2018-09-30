package metaDataExamples;

import java.sql.*;

public class ResultSetMetaDataExample1
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hawa","root","root");
		PreparedStatement pst = cn.prepareStatement("select * from aadam");
		ResultSet rs = pst.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("Total Columns: "+rsmd.getColumnCount());
		System.out.println("Column Name of 1st Column: "+rsmd.getColumnName(1));
		System.out.println("Column Type Name of 1st Column: "+rsmd.getColumnTypeName(1));
		rs.close();
		pst.close();
		cn.close();
	}
}
