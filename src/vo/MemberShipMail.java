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
		this.memberShipTitle = name + " 님의 ID/PassWord 입니다.";
		this.memberShipID = id;
		this.memberShipPW = pw;
		
		Properties properties = System.getProperties();
		// 메일 발송 시 서버 측의 환경 정의
		
		properties.put("mail.smtp.host", "smtp.daum.net"); // STMP의 주소
		properties.put("mail.smtp.port", "465"); // SSL 통신을 할 Port
		properties.put("mail.smtp.auth", "true"); // 사용자 인증 사용 여부
		properties.put("mail.smtp.ssl.enable", "true"); // SSL라이는 보안인증 활성화
		properties.put("mail.smtp.ssl.trust", "smtp.daum.net");

		// 새로운 메일 세션(인증)
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("kimguenhwan", "10062116a");
			}
		});
		session.setDebug(true);

		Message mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress("kimguenhwan@daum.net")); // 보내는 사람 메일 주소
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recieveEmailAddress));
			// 받는 사람의 메일 주소
			
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