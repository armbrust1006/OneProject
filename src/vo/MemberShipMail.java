package vo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MemberShipMail {
	private String recieveEmailAddress;
	private String memberShipTitle;
	private String memberShipID;
	private String memberShipPW;

	public MemberShipMail(String EmailAddress, String name, String id, String pw) {
		this.recieveEmailAddress = EmailAddress;
		this.memberShipTitle = name + " ���� ID/PassWord �Դϴ�.";
		this.memberShipID = id;
		this.memberShipPW = pw;
		
		Properties properties = System.getProperties();
		// ���� �߼� �� ���� ���� ȯ�� ����
		
		properties.put("mail.smtp.host", "smtp.daum.net"); // STMP�� �ּ�
		properties.put("mail.smtp.port", "465"); // SSL ����� �� Port
		properties.put("mail.smtp.auth", "true"); // ����� ���� ��� ����
		properties.put("mail.smtp.ssl.enable", "true"); // SSL���̴� �������� Ȱ��ȭ
		properties.put("mail.smtp.ssl.trust", "smtp.daum.net");

		// ���ο� ���� ����(����)
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kimguenhwan", "10062116a");
			}
		});
		session.setDebug(true);

		Message mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress("kimguenhwan@daum.net")); // ������ ��� ���� �ּ�
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recieveEmailAddress));
			// �޴� ����� ���� �ּ�
			
			mimeMessage.setSubject(memberShipTitle);
			mimeMessage.setText(memberShipID + "\n" + memberShipPW);
			
			Transport.send(mimeMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}