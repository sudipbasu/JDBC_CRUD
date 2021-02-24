import java.sql.*;
public class DB_Fetch {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql:JDBC_2021","postgres","root");
		PreparedStatement pst = conn.prepareStatement("SELECT * FROM public.\"Student\";");
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
	}

}
