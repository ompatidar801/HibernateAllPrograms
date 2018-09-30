package revision;

import java.sql.*;

public class JDBCExample1 {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
		Statement str = cn.createStatement();
		str.execute("insert into developer values ('435','temoor','amargadh')");
		
		str.close();
		cn.close();
	}

}

