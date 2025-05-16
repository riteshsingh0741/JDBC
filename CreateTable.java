import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

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
			System.out.println("Connected..");
			
			String query = "create table account (num int, name varchar(20), balance int)";
			Statement st = con.createStatement();
			st.execute(query);
			System.out.println("Table is created..");
			
			
			// logic
			con.close();
			System.out.println("Connection closed...");
		}
	
		
		catch(Exception e)
		{
			System.out.println("Exception : " + e.getMessage());
		}

	}
}
