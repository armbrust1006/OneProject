package client.data;

public class LoginStatement {
	private static String LoginUserID;

	private LoginStatement() {
	}

	public static String getLoginUserID() {
		return LoginUserID;
	}

	public static void setLoginUserID(String loginUserID) {
		LoginUserID = loginUserID;
	}

}
