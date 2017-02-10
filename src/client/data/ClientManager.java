package client.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import vo.ImageAndDataObject;
import vo.MemberShipData;
import vo.MemberShipMail;
import vo.PersonalityTypeTest;
import data.ManagerInterface;

public class ClientManager implements ManagerInterface {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public ClientManager() {
		try {
			Socket client = new Socket("localhost", 6868);
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean memberShipIDCheck(String id) {
		Object[] data = { "idCheck", id };
		return (boolean) sendRequest(data);
	}

	@Override
	public boolean memberShipEmailCheck(String email) {
		Object[] data = { "emailCheck", email };
		return (boolean) sendRequest(data);
	}

	@Override
	public boolean sendEmail(String email) {
		Object[] data = { "sendEmail", email };
		return (boolean) sendRequest(data);
	}

	@Override
	public boolean insertMemberShip(MemberShipData insertData) {
		Object[] data = { "insert", insertData };
		return (boolean) sendRequest(data);
	}

	@Override
	public int loginMemberShip(MemberShipData loginData) {
		Object[] data = { "login", loginData };
		return (int) sendRequest(data);
	}

	@Override
	public ArrayList<PersonalityTypeTest> memberTest() {
		Object[] data = { "test" };
		return (ArrayList<PersonalityTypeTest>) sendRequest(data);
	}

	@Override
	public void typeSaveResult(PersonalityTypeTest membertp) {
		Object[] data = { "antype", membertp };
		sendRequest(data);
	}

	@Override
	public PersonalityTypeTest getResult(String user) {
		Object[] data = { "getresult", user };
		return (PersonalityTypeTest) sendRequest(data);
	}

	@Override
	public ArrayList<PersonalityTypeTest> getAllResult(String user) {
		Object[] data = { "getallresult", user };
		return (ArrayList<PersonalityTypeTest>) sendRequest(data);
	}

	@Override
	public ArrayList<PersonalityTypeTest> getAllReCheck() {
		Object[] data = { "getallrecheck" };
		return (ArrayList<PersonalityTypeTest>) sendRequest(data);
	}

	@Override
	public ArrayList<ImageAndDataObject> getImageAndText(String user, int check) {
		Object[] data = { "getimgtext", user, check };
		return (ArrayList<ImageAndDataObject>) sendRequest(data);
	}

	public Object sendRequest(Object[] data) {
		try {
			oos.writeObject(data);
			return ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
