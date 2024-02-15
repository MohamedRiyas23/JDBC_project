import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/employee";
		String userName="postgres";
		String password="root";
		try {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			Connection con=DriverManager.getConnection(url,userName,password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
}


