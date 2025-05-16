import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DRLSelect {

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
			
			String query = "select * from account";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
			}
			
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



