package myJDBC;
import java.sql.*;
import java.io.*;
public class SQLiteCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			try
			{
				PreparedStatement pst;
				int id;
				String name,address,email,phone;
				InputStreamReader r = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(r);
				Class.forName("org.sqlite.JDBC");
				Connection conn = DriverManager.getConnection("jdbc:sqlite:H:\\SQLite Databases\\Employee.db");
//				System.out.println("Connected");
				
		System.out.println("Enter 1 to Insert\nEnter 2 to Read\nEnter 3 to Update\nEnter 4 to Delete\nEnter 5 to Exit : ");
		System.out.print("Enter the choice:");
			id = Integer.parseInt(br.readLine());
			switch(id)
			{
			case 1:
				System.out.print("Enter the Name : ");
				name = br.readLine();
				System.out.print("Enter the Address : ");
				address = br.readLine();
				System.out.print("Enter the Phone Number : ");
				phone = br.readLine();
				System.out.print("Enter the Email ID : ");
				email = br.readLine();
				pst = conn.prepareStatement("insert into EmployeeTable(NAME,ADDRESS,PHONE_NUMBER,EMAIL_ID) VALUES (?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, address);
				pst.setString(3, phone);
				pst.setString(4, email);
				pst.executeUpdate();
				System.out.println("Employee Data Inserted");
				break;
			case 2:
				pst=conn.prepareStatement("select * from EmployeeTable");
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					System.out.println("Name : "+rs.getString(1));
					System.out.println("Address : "+rs.getString(2));
					System.out.println("Phone Number : "+rs.getString(3));
					System.out.println("Email ID : "+rs.getString(4));
					System.out.println("======================================================");
				}
				break;
			case 3:
				System.out.print("Enter the Phone Number : ");
				phone = br.readLine();
				System.out.print("Enter the Name : ");
				name = br.readLine();
				System.out.print("Enter the Address : ");
				address = br.readLine();
				System.out.print("Enter the Email ID : ");
				email = br.readLine();
				pst=conn.prepareStatement("UPDATE EmployeeTable SET NAME = ?, ADDRESS = ?,EMAIL_ID = ? WHERE PHONE_NUMBER = ?");
				pst.setString(1, name);
				pst.setString(2, address);
				pst.setString(3, email);
				pst.setString(4, phone);
				pst.executeUpdate();
				pst.close();
				conn.close();
				System.out.println("Data Updated");
				break;
			case 4:
				System.out.print("Enter the Phone Number : ");
				phone = br.readLine();
				pst = conn.prepareStatement("delete from EmployeeTable where PHONE_NUMBER = ?");
				pst.setString(1, phone);
				pst.executeUpdate();
				System.out.println("Data Deleted");
				break;
			case 5:
				System.exit(0);
				break;
				default:
					System.out.println("Plz Enter a valid choice");
			}
		}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
			catch(ClassNotFoundException e2) {
				e2.printStackTrace();
			}
			catch(Exception e3)
			{
				e3.printStackTrace();
			}
		}
	}

}
