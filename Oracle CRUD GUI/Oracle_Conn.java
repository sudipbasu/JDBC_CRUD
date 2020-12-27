import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle_Conn {
public static Connection dbconnect()
{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","SYSTEM");
		return con;
		}
		catch(SQLException e)
		{
			System.err.println(e.getLocalizedMessage());
			return null;
		}
		catch(ClassNotFoundException e1)
		{
			System.err.println(e1.getLocalizedMessage());
			return null;
		}
}
}
