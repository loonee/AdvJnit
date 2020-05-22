package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Choices {
	private static Scanner sc;

	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/sys";
		String username="root";
		String password="test";
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement ps=null;
		if(con != null)
			System.out.println("Connected");
		
		
		String value;
		
		do {
			sc = new Scanner(System.in);
			System.out.println("Enter the choice(1.Insert 2.Display 3.Delete 4.Update)");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the choice 1.all columns 2. particular column(id, salary)");
				int choice1 = sc.nextInt();
				switch (choice1) {
				
				case 1:
					ps = con.prepareStatement("insert into employee values(?,?,?)");
					System.out.println("Enter id: ");
			    	int id = sc.nextInt();
			    	ps.setInt(1, id);
			    	System.out.println("Enter name: ");
			    	String name = sc.next();
			    	ps.setString(2, name);
			    	System.out.println("Enter salary: ");
			    	int salary=sc.nextInt();
			    	ps.setInt(3, salary);
					int x = ps.executeUpdate();
					if (x != 0) {
						System.out.println("Record Successfully Inserted");
					}
					break;
					
				case 2:
					ps = con.prepareStatement("insert into employee (id, salary) values (?,?)");
					System.out.println("Enter id: ");
			    	int e_id = sc.nextInt();
			    	ps.setInt(1, e_id);
			    	System.out.println("Enter salary: ");
			    	int e_salary=sc.nextInt();
			    	ps.setInt(2, e_salary);
					int executeUpdate = ps.executeUpdate();
					if (executeUpdate != 0) {
						System.out.println("Record Successfully Inserted");
					}
					break;
				}
				break;
				
			case 2:
				System.out.println("Enter the choice (1. All rows and all columns 2. Particular row(id search))");
				int choice2 = sc.nextInt();
				switch (choice2) {
				case 1:
					ps = con.prepareStatement("select * from employee");
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
					}
					break;
					
				case 2:
					ps = con.prepareStatement("select * from employee where id=?");
					System.out.println("Enter id: ");
					int value1 = sc.nextInt();
					ps.setInt(1, value1);
					ResultSet rs1 = ps.executeQuery();
					while (rs1.next()) {
						System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getInt(3));
					}
					break;
				}
				break;
				
			case 3:
				System.out.println("Enter the choice (1. All rows 2. Particular row(id))");
				int choice3 = sc.nextInt();
				switch (choice3) {
				case 1:
					ps = con.prepareStatement("delete from employee");
					ps.executeUpdate();
					break;
				case 2:
					ps = con.prepareStatement("delete from employee where id=?");
					System.out.println("Enter id");
					int value2 = sc.nextInt();
					ps.setInt(1, value2);
					ps.executeUpdate();
					break;
				}
				break;
				
			case 4:
				System.out.println("Enter the choice (1. Name 2. Salary)");
				int choice4 = sc.nextInt();
				switch (choice4) {
				case 1:
					ps = con.prepareStatement("update employee set name=? where id=?");
					System.out.println("Enter name: ");
			    	String name = sc.next();
			    	ps.setString(1, name);
			    	System.out.println("Enter id: ");
			    	int id=sc.nextInt();
			    	ps.setInt(2, id);
					ps.executeUpdate();
					break;
				case 2:
					ps = con.prepareStatement("update employee set salary=? where id=?");
					System.out.println("Enter id: ");
			    	int e_id=sc.nextInt();
			    	ps.setInt(2, e_id);
			    	System.out.println("Enter salary: ");
			    	int e_salary=sc.nextInt();
			    	ps.setInt(1, e_salary);
					ps.executeUpdate();
					break;
				}
				break;

			}
			System.out.println("Do you want to continue (y/n) ");
			value = sc.next();

		} while (value.equals("y"));

	}

}