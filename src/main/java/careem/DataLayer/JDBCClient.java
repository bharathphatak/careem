package careem.DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCClient {

	public Connection getConnection() {
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://10.52.100.193:3306/hacareem", "root", "password");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
