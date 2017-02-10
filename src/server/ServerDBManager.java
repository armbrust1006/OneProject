package server;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import vo.ImageAndDataObject;
import vo.MemberShipData;
import vo.MemberShipMail;
import vo.PersonalityTypeTest;
import data.ManagerInterface;

public class ServerDBManager implements ManagerInterface {

	@Override
	public boolean memberShipIDCheck(String id) {
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT user_id FROM membership WHERE user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return false;
	}

	@Override
	public boolean memberShipEmailCheck(String email) {
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT email FROM membership WHERE email = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			
			if (!resultSet.next()) { 
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return false;
	}

	@Override
	public boolean sendEmail(String email) {
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT user_name, email, user_id, user_pw FROM membership WHERE email = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			resultSet = statement.executeQuery();
			if (resultSet != null) {
				if (resultSet.next()) {
					new MemberShipMail(resultSet.getString(2), resultSet.getString(1), resultSet.getString(3),
							resultSet.getString(4));
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return false;
	}

	@Override
	public boolean insertMemberShip(MemberShipData insertData) {
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		String sql = "INSERT INTO membership VALUES(?,?,?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, insertData.getName());
			statement.setInt(2, insertData.getAge());
			statement.setString(3, insertData.getSex());
			statement.setString(4, insertData.getEmail());
			statement.setString(5, insertData.getId());
			statement.setString(6, insertData.getPassword());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return false;
	}

	@Override
	public int loginMemberShip(MemberShipData loginData) {
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		int login = 5;
		
		String sql = "SELECT user_id, user_pw FROM membership WHERE user_id = ?";
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, loginData.getId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				login = NOT_ID;
				if (loginData.getId().equals(resultSet.getString(1))) {
					login = NOT_MISSING_PASSWORD;
					if (loginData.getPassword().equals(resultSet.getString(2))) {
						login = LOGIN_SUCCESS;
					}
				}
			}
			return login;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return login;
	}

	@Override
	public ArrayList<PersonalityTypeTest> memberTest() {
		Connection connection = ConnectionDB.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<PersonalityTypeTest> testList = new ArrayList<>();
		String sql = "SELECT * FROM typetest t join typetestqu q USING(typenum)";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				PersonalityTypeTest test = new PersonalityTypeTest(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4));
				testList.add(test);
			}
			return testList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return null;
	}

	@Override
	public void typeSaveResult(PersonalityTypeTest memberType) {
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		String sql = "INSERT INTO membertype VALUES(?, sysdate, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, memberType.getId());
			statement.setString(2, memberType.getAnswer());
			statement.setString(3, memberType.getType());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
	}

	@Override
	public PersonalityTypeTest getResult(String user) {
		ArrayList<PersonalityTypeTest> pttList = new ArrayList<>();
		PersonalityTypeTest ptt = null;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT user_id, set_date, type_aw_data, type_select FROM membertype WHERE user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				pttList.add(new PersonalityTypeTest(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4)));
			}
			Collections.sort(pttList, new AscResult()); //정렬
			
			
			int lastIndex = (pttList.size() - 1);
			ptt = pttList.get(lastIndex);
			return ptt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return null;
	}

	@Override
	public ArrayList<PersonalityTypeTest> getAllResult(String user) {
		ArrayList<PersonalityTypeTest> pttList = new ArrayList<>();
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT user_id, set_date, type_aw_data, type_select FROM membertype WHERE user_id = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				pttList.add(new PersonalityTypeTest(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4)));
			}
			Collections.sort(pttList, new AscResult());
			return pttList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return null;
	}

	@Override
	public ArrayList<PersonalityTypeTest> getAllReCheck() {
		ArrayList<PersonalityTypeTest> pttList = new ArrayList<>();
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT ship.age, ship.sex, type.type_select "
				+ "FROM membership ship JOIN membertype type ON ship.user_id = type.user_id";
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				pttList.add(new PersonalityTypeTest(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
			}
			return pttList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return null;
	}

	@Override
	public ArrayList<ImageAndDataObject> getImageAndText(String user, int check) {
		ArrayList<ImageAndDataObject> itList = new ArrayList<>();
		PersonalityTypeTest getimg = getResult(user);
		
		BufferedImage bi1, bi2;
		
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = null;
		String sql1 = "SELECT image_cafeteria, image_cooks, cafeteria, cooks, address FROM cook WHERE type_select = ?";
		String sql2 = "SELECT image_country, image_city, country, city, address FROM travel WHERE type_select = ?";
		
		if (ManagerInterface.GET_COOK == check) {
			sql = sql1;
		} else if (ManagerInterface.GET_TRAVEL == check) {
			sql = sql2;
		}
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, getimg.getType());
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				bi1 = ImageIO.read(new File(resultSet.getString(1)));
				ImageIcon ii1 = new ImageIcon(bi1);
				
				bi2 = ImageIO.read(new File(resultSet.getString(2)));
				ImageIcon ii2 = new ImageIcon(bi2);
				
				itList.add(
						new ImageAndDataObject(ii1, ii2, resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
			}
			return itList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionDB.setClose(connection);
		}
		return null;
	}

	// 정렬
	class AscResult implements Comparator<PersonalityTypeTest> {
		@Override
		public int compare(PersonalityTypeTest o1, PersonalityTypeTest o2) {
			return o1.getDate().compareTo(o2.getDate());
		}
	}
}
