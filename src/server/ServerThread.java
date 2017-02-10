package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import vo.MemberShipData;
import vo.PersonalityTypeTest;

public class ServerThread implements Runnable {
	private Socket client;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ServerDBManager dbManager = new ServerDBManager();

	public ServerThread(Socket client) {
		this.client = client;
		try {
			ois = new ObjectInputStream(client.getInputStream());
			oos = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Object[] data = null;
		while (true) {
			try {
				data = (Object[]) ois.readObject();
				switch ((String) data[0]) {
				case "idCheck":
					oos.writeObject(dbManager.memberShipIDCheck((String) data[1]));
					break;
				case "emailCheck":
					oos.writeObject(dbManager.memberShipEmailCheck((String) data[1]));
					break;
				case "sendEmail":
					oos.writeObject(dbManager.sendEmail((String) data[1]));
					break;
				case "insert":
					oos.writeObject(dbManager.insertMemberShip((MemberShipData) data[1]));
					break;
				case "login":
					oos.writeObject(dbManager.loginMemberShip((MemberShipData) data[1]));
					break;
				case "test":
					oos.writeObject(dbManager.memberTest());
					break;
				case "antype":
					dbManager.typeSaveResult((PersonalityTypeTest) data[1]);
					oos.writeObject(null);
					break;
				case "getresult":
					oos.writeObject(dbManager.getResult((String) data[1]));
					break;
				case "getallresult":
					oos.writeObject(dbManager.getAllResult((String) data[1]));
					break;
				case "getallrecheck":
					oos.writeObject(dbManager.getAllReCheck());
					break;
				case "getimgtext":
					oos.writeObject(dbManager.getImageAndText((String) data[1], (int) data[2]));
					break;
				}
				oos.reset();
			} catch (EOFException e) {
			} catch (SocketException e) {
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
