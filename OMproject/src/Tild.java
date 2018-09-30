import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Tild {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","root");
    Statement st=con.createStatement();
    
    st.executeUpdate("insert into p values(6,'SBI_Indore','VigayNagar')");
	System.out.println("Done");






}
}