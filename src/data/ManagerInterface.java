package data;

import java.util.ArrayList;

import vo.ImageAndDataObject;
import vo.MemberShipData;
import vo.PersonalityTypeTest;

public interface ManagerInterface {
	static final int SALT_TYPE = 0;
	static final int POWER_TYPE = 1;
	static final int PROPHET_TYPE = 2;
	static final int SCIENTIST_TYPE = 3;
	static final int ENCYCLOPEDIA_TYPE = 4;
	
	static final int NOT_ID = 5;
	static final int NOT_MISSING_PASSWORD = 6;
	static final int LOGIN_SUCCESS = 7;

	static final int GET_AGE_RESULT = 8;
	static final int GET_SEX_RESULT = 9;

	static final int GET_TRAVEL = 10;
	static final int GET_COOK = 11;

	static final String SALT_TYPE_STRING = "소금형";
	static final String POWER_TYPE_STRING = "임금 뒷편 권력형";
	static final String PROPHET_TYPE_STRING = "예언자";
	static final String SCIENTIST_TYPE_STRING = "과학자";
	static final String ENCYCLOPEDIA_TYPE_STRING = "백과사전형";

	public boolean memberShipIDCheck(String id);

	public boolean memberShipEmailCheck(String email);

	public boolean sendEmail(String email);

	public boolean insertMemberShip(MemberShipData insertData);

	public int loginMemberShip(MemberShipData loginData);

	public ArrayList<PersonalityTypeTest> memberTest();

	public void typeSaveResult(PersonalityTypeTest memberType);

	public PersonalityTypeTest getResult(String user);

	public ArrayList<PersonalityTypeTest> getAllResult(String user);

	public ArrayList<PersonalityTypeTest> getAllReCheck();

	public ArrayList<ImageAndDataObject> getImageAndText(String user, int check);
}
