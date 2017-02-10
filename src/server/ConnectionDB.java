package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	static void setClose(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
