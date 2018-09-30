package callableStatementExamples;

import java.sql.*;

public class CallaStateExample1 {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hawa","root","root");
		CallableStatement cst = cn.prepareCall("{call INSERTER(?,?)}");
		cst.setInt(1,2101);
		cst.setString(2,"Amit");
		cst.execute();
		
		try
		{
			if(cst!=null)
			{
				cst.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Success");
	}

}
