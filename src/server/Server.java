package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		try {
			ServerSocket server = new ServerSocket(6868);
			System.out.println("���� ����");
			while (true) {
				Socket client = server.accept();
				ServerThread clientThread = new ServerThread(client);
				new Thread(clientThread).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}
