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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import vo.MemberShipData;
import client.data.ClientManager;
import data.NumberField;
import data.TextFieldLimit;

public class MemberShip extends JFrame implements ActionListener {
	private ClientManager manager = null;
	
	private boolean id_check; // ID 중복 체크
	private boolean email_check; // E-Mail 중복 체크
	
	private JTextField tf_name; // 이름
	private JTextField tf_age;// 나이
	private JTextField tf_id;// id
	private JTextField tf_email;// 이메일
	private String sex; // 성

	private JButton btn_ok;
	private JButton btn_exit;
	private JButton btn_id_check;
	private JButton btn_Email;
	private JPasswordField passwordField;
	private JRadioButton rb_man;
	private JRadioButton rb_women;

	public MemberShip(ClientManager manager) {
		this.manager = manager;
		this.setTitle("MemberShip");
		this.setBounds(100, 100, 618, 487);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./bgimg/BackGround2.GIF")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("名前");
		lblNewLabel.setBounds(12, 29, 146, 45);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(false);
		lblNewLabel.setBorder(new TitledBorder(null, "name", TitledBorder.CENTER, TitledBorder.TOP, null));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.WHITE);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("性別");
		label.setBounds(12, 139, 146, 45);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(false);
		label.setBorder(new TitledBorder(null, "age", TitledBorder.CENTER, TitledBorder.TOP, null));
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setForeground(Color.WHITE);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("年齢");
		label_1.setBounds(12, 84, 146, 45);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setOpaque(false);
		label_1.setBorder(new TitledBorder(null, "sex", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		label_1.setForeground(Color.WHITE);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("ID");
		label_2.setBounds(12, 200, 146, 45);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setOpaque(false);
		label_2.setBorder(new TitledBorder(null, "ID", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		label_2.setForeground(Color.WHITE);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("PassWord");
		label_3.setBounds(12, 257, 146, 45);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setOpaque(false);
		label_3.setBorder(new TitledBorder(null, "Password", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		label_3.setForeground(Color.WHITE);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("E-mail");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(12, 314, 146, 45);
		label_4.setOpaque(false);
		label_4.setBorder(new TitledBorder(null, "E-Mail", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_4.setFont(new Font("굴림", Font.BOLD, 15));
		label_4.setForeground(Color.WHITE);
		getContentPane().add(label_4);

		JLabel lblNewLabel_1 = new JLabel("警告! E-mail 正確に入力しなければアイディーとパスワード探すことができないです!");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 424, 568, 15);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 13));
		getContentPane().add(lblNewLabel_1);

		tf_name = new JTextField();
		tf_name.setToolTipText("이름 입력하세요");
		tf_name.setColumns(10);
		tf_name.setBounds(181, 29, 259, 45);
		tf_name.setOpaque(false);
		tf_name.setForeground(Color.YELLOW);
		tf_name.setBorder(new TitledBorder(null, "-context-", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(tf_name);
		tf_name.setDocument(new TextFieldLimit(5)); // 글자수 제한

		tf_age = new NumberField(); // 숫자 입력 판독
		tf_age.setToolTipText("나이를 숫자로 입력하세요"); // Text 주의창이 나오도록 설정
		tf_age.setColumns(10);
		tf_age.setBounds(181, 84, 259, 45);
		tf_age.setOpaque(false);
		tf_age.setForeground(Color.YELLOW);
		tf_age.setBorder(new TitledBorder(null, "-context-", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(tf_age);
		tf_age.setDocument(new TextFieldLimit(3));

		tf_id = new JTextField(20);
		tf_id.setToolTipText("아이디를 5글자 이상 입력하세요"); // Text 주의창이 나오도록 설정
		tf_id.setColumns(10);
		tf_id.setBounds(181, 200, 259, 45);
		tf_id.setOpaque(false);
		tf_id.setForeground(Color.YELLOW);
		tf_id.setBorder(new TitledBorder(null, "-context-", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(tf_id);
		tf_id.setDocument(new TextFieldLimit(20));

		passwordField = new JPasswordField(15);
		passwordField.setToolTipText("비밀번호를 8자 이상 입력하세요"); // Text 주의창이 나오도록 설정
		passwordField.setBounds(181, 257, 259, 45);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.YELLOW);
		passwordField.setBorder(new TitledBorder(null, "-context-", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(passwordField);
		passwordField.setDocument(new TextFieldLimit(15));

		tf_email = new JTextField(30);
		tf_email.setToolTipText("이메일을 정확하게 입력하세요"); // Text 주의창이 나오도록 설정
		tf_email.setColumns(10);
		tf_email.setBounds(181, 314, 259, 45);
		tf_email.setOpaque(false);
		tf_email.setForeground(Color.YELLOW);
		tf_email.setBorder(new TitledBorder(null, "-context-", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(tf_email);
		tf_email.setDocument(new TextFieldLimit(30));

		btn_ok = new JButton("取得");
		btn_ok.setBounds(323, 369, 128, 45);
		btn_ok.addActionListener(this);
		btn_ok.setForeground(Color.WHITE);
		btn_ok.setBorder(new LineBorder(Color.WHITE));
		btn_ok.setOpaque(false);
		btn_ok.setContentAreaFilled(false);
		btn_ok.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(btn_ok);

		btn_exit = new JButton("アイディ");
		btn_exit.setBounds(181, 369, 128, 45);
		btn_exit.addActionListener(this);
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setBorder(new LineBorder(Color.WHITE));
		btn_exit.setOpaque(false);
		btn_exit.setContentAreaFilled(false);
		btn_exit.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(btn_exit);

		btn_id_check = new JButton("ID 重複検査");
		btn_id_check.setBounds(452, 200, 128, 45);
		btn_id_check.addActionListener(this);
		btn_id_check.setForeground(Color.WHITE);
		btn_id_check.setBorder(new LineBorder(Color.WHITE));
		btn_id_check.setBorder(new TitledBorder(null, "-check-", TitledBorder.CENTER, TitledBorder.TOP, null));
		btn_id_check.setOpaque(false);
		btn_id_check.setContentAreaFilled(false);
		btn_id_check.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(btn_id_check);

		btn_Email = new JButton("E-Mail 重複検査");
		btn_Email.setBounds(452, 314, 128, 45);
		btn_Email.addActionListener(this);
		btn_Email.setForeground(Color.WHITE);
		btn_Email.setBorder(new LineBorder(Color.WHITE));
		btn_Email.setBorder(new TitledBorder(null, "-check-", TitledBorder.CENTER, TitledBorder.TOP, null));
		btn_Email.setOpaque(false);
		btn_Email.setContentAreaFilled(false);
		btn_Email.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(btn_Email);

		rb_man = new JRadioButton("男性");
		rb_man.setFont(new Font("굴림", Font.BOLD, 14));
		rb_man.setHorizontalAlignment(SwingConstants.CENTER);
		rb_man.setOpaque(false);
		rb_man.setContentAreaFilled(false);
		rb_man.setForeground(Color.WHITE);
		rb_man.setBounds(181, 150, 121, 23);
		rb_man.addActionListener(this);
		getContentPane().add(rb_man);

		rb_women = new JRadioButton("女性");
		rb_women.setFont(new Font("굴림", Font.BOLD, 14));
		rb_women.setHorizontalAlignment(SwingConstants.CENTER);
		rb_women.setOpaque(false);
		rb_women.setContentAreaFilled(false);
		rb_women.setForeground(Color.WHITE);
		rb_women.setBounds(323, 150, 121, 23);
		rb_women.addActionListener(this);
		getContentPane().add(rb_women);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_ok) {
			if (id_check == false && email_check == false) {
				JOptionPane.showMessageDialog(null, "ID 와 E-mail 중복 체크해주세요!");
			} 
			else if (id_check == false) {
				JOptionPane.showMessageDialog(null, "ID 중복 체크 해주세요!");
			} 
			else if (email_check == false) {
				JOptionPane.showMessageDialog(null, "E-mail 중복 체크 해주세요!");
			} 
			else if (passwordField.getPassword().length < 8) {
				JOptionPane.showMessageDialog(null, "패스워드 8자 이상 해주세요!");
			} 
			else if (email_check == true && id_check == true) {
				
				boolean check = 
						manager.insertMemberShip(new MemberShipData(tf_name.getText(), Integer.parseInt(tf_age.getText()),
						sex, tf_email.getText(), tf_id.getText(), String.valueOf(passwordField.getPassword())));
				
				if (check == true) {
					id_check = false;
					email_check = false;
					JOptionPane.showMessageDialog(null, "회원가입이 완료되셨습니다. 다시 로그인 해주세요!");
				} 
				else {
					JOptionPane.showMessageDialog(null, "회원가입 실패!");
				}
			}
			
		} else if (e.getSource() == btn_exit) {
			new MainClass().start();
			this.dispose();
			
		} else if (e.getSource() == btn_id_check) {
			if (!tf_id.getText().equals("") && tf_id.getText().length() >= 5) {
				if (manager.memberShipIDCheck(tf_id.getText())) {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
					id_check = true;
				} 
				else {
					JOptionPane.showMessageDialog(null, "중복된 아이디가 존재합니다.");
				}
				
			} else if (tf_id.getText().length() < 5) {
				JOptionPane.showMessageDialog(null, "5글자 이상 입력하세요!");
			}
		} else if (e.getSource() == btn_Email) {
			if (!tf_email.getText().equals("")) {
				if (manager.memberShipEmailCheck(tf_email.getText())) {
					JOptionPane.showMessageDialog(null, "사용 가능한 이메일 입니다.");
					email_check = true;
				} else {
					JOptionPane.showMessageDialog(null, "중복된 이메일가 존재합니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "한글자 이상 입력하세요!");
			}
		} 
		
		else if (e.getSource() == rb_man) {
			sex = rb_man.getText();
			rb_women.setSelected(false);
		} else if (e.getSource() == rb_women) {
			sex = rb_women.getText();
			rb_man.setSelected(false);
		}
	}
}