package storeImagesInDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertImagesTest {

	public static void main(String[] args) throws SQLException {
		InsertImagesTest imageTest = new InsertImagesTest();
		//imageTest.insertImage();
		imageTest.retriveImage(); 
	}

	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDatabase", "root", "root");
		} catch (Exception e) {
			System.out.println("Error Occured While Getting the Connection: - " + e);
		}
		return connection;
	}

	public void insertImage() {
		Connection connection = null;
		PreparedStatement statement = null;
		FileInputStream inputStream = null;

		try {
			File image = new File("C:\\Users\\Om\\Desktop\\IOC and DI.png");
			inputStream = new FileInputStream(image);

			connection = getConnection();
			statement = connection.prepareStatement("insert into Images(img_title, img_data) " + "values(?,?)");
			statement.setString(1, "IOC and DI");
			statement.setBinaryStream(2, (InputStream) inputStream, (int) (image.length()));

			statement.executeUpdate();
			System.out.println("Images Saved Successfully");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: - " + e);
		} catch (SQLException e) {
			System.out.println("SQLException: - " + e);
		} finally {

			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("SQLException Finally: - " + e);
			}

		}

	}

	public void retriveImage() 
	{
		Connection connection = null;
		PreparedStatement statement = null;
		try {
				connection = getConnection();
				PreparedStatement ps=connection.prepareStatement("select * from Images");  
				ResultSet rs=ps.executeQuery();  
				if(rs.next()){//now on 1st row  
				              
				Blob b=rs.getBlob(2);//2 means 2nd column data  
				byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
				              
				FileOutputStream fout=new FileOutputStream("d:\\sonoo.png");  
				fout.write(barr);  
				              
				fout.close();  
				}//end of if  
				System.out.println("ok");  
				              
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: - " + e);
		} catch (SQLException e) {
			System.out.println("SQLException: - " + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("SQLException Finally: - " + e);
			}

		}
	}

}
