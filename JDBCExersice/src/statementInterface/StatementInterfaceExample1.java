package statementInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StatementInterfaceExample1 
{
	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		Scanner sc = null;

		// STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		// STEP 3: Open a connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDatabase", "root", "root");

		// STEP 4: create statement object
		stmt = con.createStatement();

		String answer = "";
		do {
			// 1.insert Operation

			// read input from keyboard
			sc = new Scanner(System.in);
			System.out.println("For INSERT Operation press 1:");
			System.out.println("For UPDATE Operation press 2:");
			System.out.println("For GET Operation press 3:");
			System.out.println("For DELETE Operation press 4:");
			int insert = sc.nextInt();
			switch (insert) {
			case 1:
				System.out.println("Enter StudentID:");
				int id = sc.nextInt();
				System.out.println("Enter Student Name:");
				String name = sc.next();
				System.out.println("Enter Student Marks:");
				int marks = sc.nextInt();

				// STEP 5: Execute a query
				stmt.executeUpdate("insert into Student values(" + id + "," + "'" + name + "'," + marks + ")");
				System.out.println("records inserted");
				break;

			// update Operation

			case 2:
				System.out.println("Enter StudentID which is Stored in Student Table :");
				int sid = sc.nextInt();
				System.out.println("Enter Student Name for Update:");
				String sname = sc.next();
				System.out.println("Enter Student Marks for Update:");
				int smarks = sc.nextInt();

				int updatedRecord = stmt.executeUpdate(
						"update Student set sname='" + sname + "',smarks=" + smarks + " where sid=" + sid);
				System.out.println("Updated Record: " + updatedRecord);
				break;

			case 3:
				System.out.println("Student Details:");
				ResultSet getRecord = stmt.executeQuery("select * from Student");
				while (getRecord.next()) {
					// Retrieve by column name
					int stid = getRecord.getInt(1);
					String stname = getRecord.getString(2);
					int stmarks = getRecord.getInt(3);

					// Display values
					System.out.print("ID: " + stid);
					System.out.print(", Name: " + stname);
					System.out.print(", marks: " + stmarks);
					System.out.println("");
				}

				break;

			// delete Operation
			case 4:
				System.out.println("Enter StudentID which want you to Delete:");
				int stid = sc.nextInt();
				int deletedRecord = stmt.executeUpdate("delete from Student where sid=" + stid);
				System.out.println("Deleted Record: " + deletedRecord);
				
				break;

			default:
				System.out.println("Invalid Choice:");
				break;

			}
			System.out.println("Do u Want continue");
			answer = sc.next();

		} while(answer.equalsIgnoreCase("y"));
		con.close();
		System.out.println("Goodbye!");
	}
}
