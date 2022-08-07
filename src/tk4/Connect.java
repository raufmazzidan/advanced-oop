package tk4;

import java.sql.*;

public class Connect {
	private Statement st;
	private Connection con;

	public Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/tk4", "root", "");
			st = con.createStatement(1004, 1008);
			System.out.println("Connection Successful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Error");
		}
	}

	public ResultSet executeQuery(String query) {
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Error");
		}
		return rs;
	}

	public void executeUpdate(String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Error");
		}
	}
}