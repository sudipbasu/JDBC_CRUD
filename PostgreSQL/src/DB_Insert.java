import java.sql.*;

import java.io.*;
public class DB_Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				String roll,name,college;
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql:JDBC_2021","postgres","root");
//				System.out.println("Connected");
				InputStreamReader r = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(r);
				System.out.print("Enter Roll : ");
				roll = br.readLine();
				System.out.print("Enter Name : ");
				name = br.readLine();
				System.out.print("Enter College : ");
				college = br.readLine();
				String sql = "INSERT INTO public.\"Student\"(\"ROLL\", \"NAME\", \"COLLEGE\") VALUES (?, ?, ?);";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, roll);
				pst.setString(2, name);
				pst.setString(3, college);
				pst.executeUpdate();
				System.out.println("Data Inserted");
			}
			
			catch(Exception e)
			{
				System.out.println(e.getLocalizedMessage());
				e.printStackTrace();
			}
	}

}
