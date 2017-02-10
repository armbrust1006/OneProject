package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import vo.MemberShipData;
import client.data.ClientManager;
import client.data.LoginStatement;
import data.ManagerInterface;

public class LoginClass extends JFrame implements ActionListener {
	private ClientManager manager = null;
	
	private JTextField tf_id;
	private JPasswordField passwordField;
	
	private JButton btn_login;
	private JButton btn_membership;
	private JButton btn_cencel;
	private JButton btn_IDAndPwSearch;

	public LoginClass(ClientManager manager) {
		this.manager = manager;
		
		this.setTitle("Login");
		this.setBounds(100, 100, 509, 301);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./bgimg/BackGround2.GIF")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(41, 31, 136, 42);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(false);
		lblNewLabel.setBorder(new TitledBorder(null, "아이디 입력", TitledBorder.CENTER, TitledBorder.TOP, null));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("Password");
		label.setBounds(41, 85, 136, 42);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(false);
		label.setBorder(new TitledBorder(null, "비밀번호 입력", TitledBorder.CENTER, TitledBorder.TOP, null));
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label);

		tf_id = new JTextField();
		tf_id.setBounds(191, 31, 282, 42);
		tf_id.setOpaque(false);
		tf_id.setBorder(new LineBorder(Color.YELLOW));
		tf_id.setForeground(Color.YELLOW);
		tf_id.setFont(new Font("굴림", Font.BOLD, 14));
		tf_id.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(tf_id);
		tf_id.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setForeground(Color.YELLOW);
		passwordField.setFont(new Font("굴림", Font.BOLD, 14));
		passwordField.setOpaque(false);
		passwordField.setBorder(new LineBorder(Color.YELLOW));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(191, 85, 282, 42);
		getContentPane().add(passwordField);

		btn_login = new JButton("ログイン");
		btn_login.setForeground(Color.cyan);
		btn_login.setBorder(new TitledBorder(null, "login", TitledBorder.CENTER, TitledBorder.TOP, null));
		btn_login.setFont(new Font("굴림", Font.BOLD, 15));
		btn_login.setBounds(41, 139, 125, 42);
		btn_login.setOpaque(false);
		btn_login.setContentAreaFilled(false);
		btn_login.addActionListener(this);
		getContentPane().add(btn_login);

		btn_membership = new JButton("新規取得");
		btn_membership.setBounds(334, 139, 140, 42);
		btn_membership.setForeground(Color.ORANGE);
		btn_membership.setBorder(new TitledBorder(null, "Membership", TitledBorder.CENTER, TitledBorder.TOP, null));
		btn_membership.setFont(new Font("굴림", Font.BOLD, 15));
		btn_membership.setOpaque(false);
		btn_membership.setContentAreaFilled(false);
		btn_membership.addActionListener(this);
		getContentPane().add(btn_membership);

		btn_cencel = new JButton("取り消し");
		btn_cencel.setBounds(41, 193, 125, 42);
		btn_cencel.setForeground(Color.cyan);
		btn_cencel.setBorder(new TitledBorder(null, "Cancel", TitledBorder.CENTER, TitledBorder.TOP, null));
		btn_cencel.setFont(new Font("굴림", Font.BOLD, 15));
		btn_cencel.setOpaque(false);
		btn_cencel.setContentAreaFilled(false);
		btn_cencel.addActionListener(this);
		getContentPane().add(btn_cencel);

		btn_IDAndPwSearch = new JButton("ログインできない");
		btn_IDAndPwSearch.setBounds(334, 193, 140, 42);
		btn_IDAndPwSearch.setForeground(Color.ORANGE);
		btn_IDAndPwSearch.setBorder(new TitledBorder(null, "Searching", TitledBorder.CENTER, TitledBorder.TOP, null));
		btn_IDAndPwSearch.setFont(new Font("굴림", Font.BOLD, 15));
		btn_IDAndPwSearch.setContentAreaFilled(false);
		btn_IDAndPwSearch.addActionListener(this);
		btn_IDAndPwSearch.putClientProperty("styleClass", "italic");
		getContentPane().add(btn_IDAndPwSearch);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_login) {
			int logincheck = manager
					.loginMemberShip(new MemberShipData(tf_id.getText(), String.valueOf(passwordField.getPassword())));
			if (logincheck == ManagerInterface.LOGIN_SUCCESS) {
				LoginStatement.setLoginUserID(tf_id.getText());
				new MainClass().changeClass("StartScreen");
				this.dispose();
			} 
			
			else if (logincheck == ManagerInterface.NOT_ID) {
				JOptionPane.showMessageDialog(null, "등록된 정보를 다시 확인해주세요.");
			}
			
			else if (logincheck == ManagerInterface.NOT_MISSING_PASSWORD) {
				JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 다시 확인해주세요.");
			}
		} 
		
		else if (e.getSource() == btn_IDAndPwSearch) {
			String email = JOptionPane.showInputDialog(null, "가입 하실때 입력하신 이메일 주소를 정확하게 입력하세요!");

			if (manager.sendEmail(email)) {
				JOptionPane.showMessageDialog(null, "정상적으로 메일을 발송했습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "메일 주소를 다시 확인 바랍니다.");
			}
		} 
		
		else if (e.getSource() == btn_membership) {
			new MainClass().changeClass("MemberShip");
			this.dispose();
		} 
		
		else if (e.getSource() == btn_cencel) {
			tf_id.setText("");
			passwordField.setText("");
		}
	}
}