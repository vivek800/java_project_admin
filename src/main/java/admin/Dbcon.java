package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {
	
	public static Connection getcon() throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/bbitbill","root","");
		
		return con;
	}

}
