
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReadDelete {

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
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter acc num : ");
			int num = sc.nextInt();
			
			String query = "delete from account where num = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, num);
			int count = ps.executeUpdate();
			
			System.out.println("Deleted : " + count);
			
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





