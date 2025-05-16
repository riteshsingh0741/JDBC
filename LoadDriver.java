import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriver {

	public static void main(String[] args) 
	{
		String driver = "com.mysql.cj.jdbc.Driver";  // JDBC package name.... it is always started with capital - Driver
		String url = "jdbc:mysql://localhost:3307/cgu";  // connecting to database
		String user = "root";
		String pwd = "ritesh";  // mysql password - ritesh 
		
		try {
			Class.forName(driver);
			System.out.println("Driver is ready...");
			
			Connection con = DriverManager.getConnection(url , user , pwd);
			System.out.println("Connection is ready...");
			
			// logic
			con.close();
			System.out.println("Connection closed...");
		}
	
//		catch(ClassNotFoundException e)
//		{
//			System.out.println("Error : Driver mot found.");
//		}
//		
//		catch(SQLException e1)
//		{
//			System.out.println("Connection error.");
//		}
		
		// for those 2 catch block we can use only 1 catch block - exception
		
		catch(Exception e)
		{
			System.out.println("Exception : " + e.getMessage());
		}

	}
}
