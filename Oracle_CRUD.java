import java.sql.*;
import java.io.*;
import java.util.Scanner;
public class Oracle_CRUD {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		try
		{
			int roll;
			String name,college;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","SYSTEM");
			Scanner sc = new Scanner(System.in);
			InputStreamReader r = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(r);
			int id;
			System.out.println("Enter 1 for Insert Data\nEnter 2 for Fetch Data\nEnter 3 for Delete Data\nEnter 4 for Update Data");
			id=sc.nextInt();
			switch(id)
			{
			case 1:
				System.out.print("Enter Name : ");
				name = br.readLine();
				System.out.print("Enter Roll : ");
				roll = sc.nextInt();
				System.out.print("Enter College :");
				college = br.readLine();
				PreparedStatement pst = con.prepareStatement("insert into student(NAME,ROLL,COLLEGE) VALUES (?,?,?)");
				pst.setString(1, name);
				pst.setInt(2, roll);
				pst.setString(3, college);
				pst.executeUpdate();
				System.out.println("Data Inserted");
				break;
			case 2:
				PreparedStatement pst1 = con.prepareStatement("select * from student");
				ResultSet rs = pst1.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
				}
				break;
			case 3:
				System.out.print("Enter the Roll : ");
				roll = sc.nextInt();
				PreparedStatement pst2 = con.prepareStatement("delete from student where ROLL = ?");
				pst2.setInt(1, roll);
				pst2.executeUpdate();
				System.out.println("Data Deleted");
				break;
			case 4:
				System.out.print("Enter Roll : ");
				roll = sc.nextInt();
				System.out.print("Enter Name : ");
				name = br.readLine();
				
				System.out.print("Enter College :");
				college = br.readLine();
				PreparedStatement pst3 = con.prepareStatement("update student set NAME = ? , COLLEGE = ? WHERE ROLL = ?");
				pst3.setString(1, name);
				pst3.setString(2, college);
				pst3.setInt(3, roll);
				pst3.executeUpdate();
				System.out.println("Data Updated");
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
	}

}
