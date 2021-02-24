import java.sql.*;
import java.io.*;
public class DB_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			try {
				InputStreamReader r = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(r);
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql:JDBC_2021","postgres","root");
				String roll;
				System.out.print("Enter the Roll : ");
				roll = br.readLine();
				PreparedStatement pst = conn.prepareStatement("DELETE FROM public.\"Student\" WHERE \"ROLL\"=?;");
				pst.setString(1, roll);
				pst.executeUpdate();
				System.out.println("Data Deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
