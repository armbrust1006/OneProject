package client.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInsert {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/travel.csv"));
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");) {

			String s = null;
			while ((s = br.readLine()) != null) {
				String sql = "insert into travel values(?, ?, ?, ?, ?, ?)";
				String[] output = s.split(",");
				try (PreparedStatement pstmt = connection.prepareCall(sql);) {
					int i = 1;
					for (String s1 : output) {
						if (!s1.equals("null"))
							pstmt.setString(i, s1);
						else
							pstmt.setString(i, null);
						i++;
					}
					pstmt.executeUpdate();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
