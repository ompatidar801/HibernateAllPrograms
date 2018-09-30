package transactionManagement;
 
import java.sql.*;  
import java.io.*;  
public class TransactionManagementExample2
{
	public static void main(String args[])
	{  
		try
		{  
  
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RevisionJDBC","root","root");
			con.setAutoCommit(false);  
  
			PreparedStatement ps=con.prepareStatement("insert into user420 values(?,?,?)");  
  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			while(true)
			{  
  
				System.out.println("enter id");  
				String s1=br.readLine();  
				int id=Integer.parseInt(s1);  
  
				System.out.println("enter name");  
				String name=br.readLine();  
  
				System.out.println("enter address");  
				String address=br.readLine();    
  
				ps.setInt(1,id);  
				ps.setString(2,name);  
				ps.setString(3,address);  
				ps.executeUpdate();  
  
				System.out.println("commit/rollback");  
				String answer=br.readLine();  
				if(answer.equals("commit"))
				{  
					con.commit();  
					System.out.println("record successfully saved");
				}  
				if(answer.equals("rollback"))
				{  
					con.rollback();  
					System.out.println("record not inserted");
				}  
  
  
				System.out.println("Want to add more records y/n");  
				String ans=br.readLine();  
				if(ans.equals("n"))
				{  
					break;  
				}  
  
			}  
			con.commit();  
			System.out.println("record successfully saved");  
  
			con.close();//before closing connection commit() is called  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
  
	}
}  
