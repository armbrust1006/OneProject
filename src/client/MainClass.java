package client;

import vo.PersonalityTypeTest;
import client.data.ClientManager;
import client.data.LoginStatement;

public class MainClass {
	private ClientManager manager = new ClientManager();

	public void start() {
		LoginClass login = new LoginClass(manager);
		login.getContentPane().setLayout(null);
		login.setVisible(true);
	}

	public void changeClass(String answer) {
		if (answer == "StartScreen") {
			StartScreen start = new StartScreen();
			start.setVisible(true);
		} else if (answer == "CheckClass") {
			CheckClass check = new CheckClass(manager);
			check.setVisible(true);
		} else if (answer == "MemberShip") {
			MemberShip member = new MemberShip(manager);
			member.setVisible(true);
		} else if (answer == "Recheck") {
			Recheck recheck = new Recheck(manager);
			recheck.setVisible(true);
		} else if (answer == "RecommendDishes") {
			RecommendDishes dishes = new RecommendDishes(manager);
			dishes.setVisible(true);
		} else if (answer == "RecommendTravel") {
			RecommendTravel travel = new RecommendTravel(manager);
			travel.setVisible(true);
		} else if (answer == "ResultClass") {
			ResultClass result = new ResultClass(manager);
			result.setVisible(true);
		}
	}

	public void sendType(String[] ans) {
		manager.typeSaveResult(new PersonalityTypeTest(LoginStatement.getLoginUserID(), ans[0], ans[1]));
	}

	public static void main(String[] args) {
		new MainClass().start();
	}
}