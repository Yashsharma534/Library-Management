import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBInfo {
	static 
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		Connection c=null;
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","rat");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
