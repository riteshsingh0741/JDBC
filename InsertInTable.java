import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertInTable {

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
			System.out.println("Enter account details : ");
			int num = sc.nextInt();
			String name = sc.next();
			int balance = sc.nextInt();
			
			String query = "insert into account values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, num);
			ps.setString(2, name);
			ps.setInt(3, balance);
			
			int count = ps.executeUpdate();
			System.out.println("Inserted : " + count);
			
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


