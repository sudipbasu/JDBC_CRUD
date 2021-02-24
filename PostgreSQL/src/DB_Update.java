import java.io.*;
import java.sql.*;
public class DB_Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String roll,name,college;
			InputStreamReader r = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(r);
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql:JDBC_2021","postgres","root");
			System.out.print("Enter the Roll : ");
			roll = br.readLine();
			System.out.print("Enter the Name : ");
			name = br.readLine();
			System.out.print("Enter the College : ");
			college = br.readLine();
			PreparedStatement pst = conn.prepareStatement("UPDATE public.\"Student\" SET  \"NAME\"=?, \"COLLEGE\"=? WHERE \"ROLL\"=?;");
			pst.setString(1, name);
			pst.setString(2, college);
			pst.setString(3, roll);
			pst.executeUpdate();
			System.out.println("Data Updated");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
