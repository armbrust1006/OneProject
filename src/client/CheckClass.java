package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import vo.PersonalityTypeTest;
import client.data.ClientManager;
import client.data.ClientTypeTest;

public class CheckClass extends JFrame implements ActionListener {

	private PersonalityTypeTest ptt = null;
	private ClientManager manager = null;

	private ClientTypeTest testmanager = null; // 문제_생성
	private ArrayList<String> question = null;// 문제 생성 및 추가
	private ArrayList<String> answer = new ArrayList<>(); // 문제응답
	private int state = 0; // 문제 푼 횟수

	private String[] ans = new String[2];

	private JPanel panel;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;

	private JLabel qu1;
	private JLabel qu2;
	private JLabel qu3;
	private JLabel qu4;
	private JLabel qu5;

	private ArrayList<JLabel> qu = new ArrayList<>(); // 문제 리스트

	private static JRadioButton btn_q1_y;
	private static JRadioButton btn_q2_y;
	private static JRadioButton btn_q3_y;
	private static JRadioButton btn_q4_y;
	private static JRadioButton btn_q5_y;

	private static JRadioButton btn_q1_n;
	private static JRadioButton btn_q2_n;
	private static JRadioButton btn_q3_n;
	private static JRadioButton btn_q4_n;
	private static JRadioButton btn_q5_n;

	private boolean checkSet = false; // 모두 체크 확인
	private boolean[] answerCheck = { false, false, false, false, false };

	private ArrayList<String> qus = new ArrayList<>(); // y or n
	private String qus1 = null;
	private String qus2 = null;
	private String qus3 = null;
	private String qus4 = null;
	private String qus5 = null;

	private JButton btn_next;

	/*-------------------------------*/
	private JLabel label_2;
	static int seconds = 0;

	private Timer timer;
	private JPanel panel_2;

	List<JPanel> panels = new ArrayList<JPanel>();

	private JPanel panel_1;

	private int num = 0;
	private int percentage = 0;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	private TimePanel p = new TimePanel();
	private Date today = new Date();

	public CheckClass(ClientManager manager) {

		// ===============================================================
		this.manager = manager;
		this.testmanager = new ClientTypeTest(manager);
		question = testmanager.getQuestion(); // 문제 받아오기
		// ===============================================================

		this.setTitle("CharacterTest");
		getContentPane().setLayout(null);
		this.setSize(977, 676);

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./bgimg/BackGround4.GIF")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		lblNewLabel = new JLabel(" TestLevel >");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(14, 73, 150, 47);
		lblNewLabel.setOpaque(true);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(842, 67, 103, 53);
		lblNewLabel_1.setOpaque(false);
		lblNewLabel_1.setBorder(new TitledBorder(null, "Percentage", TitledBorder.CENTER, TitledBorder.TOP, null));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1);

		panel_2 = new JPanel();
		panel_2.setBounds(184, 43, 605, 47);
		panel_2.setBorder(new TitledBorder(null, "TimeCounting", TitledBorder.CENTER, TitledBorder.TOP, null));
		panel_2.setOpaque(false);
		getContentPane().add(panel_2);
		label_2 = new JLabel();
		label_2.setOpaque(false);
		panel_2.add(label_2);

		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds++;
				int day = (int) TimeUnit.SECONDS.toDays(seconds);
				long hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24);
				long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
				long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);
				label_2.setText(hours + " Hour(s), " + minute + " Minute(s) and " + second + " Second(s)");
				label_2.setFont(new Font("굴림", Font.BOLD, 13));
			}
		});
		timer.start();

		panel = new JPanel();
		panel.setBounds(14, 126, 931, 491);
		panel.setLayout(new GridLayout(5, 0));
		panel.setBorder(new TitledBorder(null, "Question", TitledBorder.CENTER, TitledBorder.TOP, null));
		panel.setOpaque(false);
		getContentPane().add(panel);

		p1 = new JPanel();
		p1.setBorder(new TitledBorder(null, "check", TitledBorder.CENTER, TitledBorder.TOP, null));
		p1.setOpaque(false);
		p2 = new JPanel();
		p2.setBorder(new TitledBorder(null, "check", TitledBorder.CENTER, TitledBorder.TOP, null));
		p2.setOpaque(false);
		p3 = new JPanel();
		p3.setBorder(new TitledBorder(null, "check", TitledBorder.CENTER, TitledBorder.TOP, null));
		p3.setOpaque(false);
		p4 = new JPanel();
		p4.setBorder(new TitledBorder(null, "check", TitledBorder.CENTER, TitledBorder.TOP, null));
		p4.setOpaque(false);
		p5 = new JPanel();
		p5.setBorder(new TitledBorder(null, "check", TitledBorder.CENTER, TitledBorder.TOP, null));
		p5.setOpaque(false);

		panel.add(p1);
		panel.add(p2);
		panel.add(p3);
		panel.add(p4);
		panel.add(p5);

		qu1 = new JLabel();
		qu1.setBorder(new LineBorder(Color.YELLOW));
		qu1.setOpaque(false);
		qu2 = new JLabel();
		qu2.setBorder(new LineBorder(Color.YELLOW));
		qu2.setOpaque(false);
		qu3 = new JLabel();
		qu3.setBorder(new LineBorder(Color.YELLOW));
		qu3.setOpaque(false);
		qu4 = new JLabel();
		qu4.setBorder(new LineBorder(Color.YELLOW));
		qu4.setOpaque(false);
		qu5 = new JLabel();
		qu5.setBorder(new LineBorder(Color.YELLOW));
		qu5.setOpaque(false);

		btn_q1_y = new JRadioButton("Y");
		btn_q1_y.setPreferredSize(new Dimension(50, 50));
		btn_q1_y.setOpaque(false);
		btn_q1_y.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q1_y.setForeground(Color.WHITE);
		btn_q1_y.addActionListener(this);

		btn_q2_y = new JRadioButton("Y");
		btn_q2_y.setPreferredSize(new Dimension(50, 50));
		btn_q2_y.setOpaque(false);
		btn_q2_y.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q2_y.setForeground(Color.WHITE);
		btn_q2_y.addActionListener(this);

		btn_q3_y = new JRadioButton("Y");
		btn_q3_y.setPreferredSize(new Dimension(50, 50));
		btn_q3_y.setOpaque(false);
		btn_q3_y.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q3_y.setForeground(Color.WHITE);
		btn_q3_y.addActionListener(this);

		btn_q4_y = new JRadioButton("Y");
		btn_q4_y.setPreferredSize(new Dimension(50, 50));
		btn_q4_y.setOpaque(false);
		btn_q4_y.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q4_y.setForeground(Color.WHITE);
		btn_q4_y.addActionListener(this);

		btn_q5_y = new JRadioButton("Y");
		btn_q5_y.setPreferredSize(new Dimension(50, 50));
		btn_q5_y.setOpaque(false);
		btn_q5_y.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q5_y.setForeground(Color.WHITE);
		btn_q5_y.addActionListener(this);

		btn_q1_n = new JRadioButton("N");
		btn_q1_n.setPreferredSize(new Dimension(50, 50));
		btn_q1_n.setOpaque(false);
		btn_q1_n.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q1_n.setForeground(Color.DARK_GRAY);
		btn_q1_n.addActionListener(this);

		btn_q2_n = new JRadioButton("N");
		btn_q2_n.setPreferredSize(new Dimension(50, 50));
		btn_q2_n.setOpaque(false);
		btn_q2_n.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q2_n.setForeground(Color.DARK_GRAY);
		btn_q2_n.addActionListener(this);

		btn_q3_n = new JRadioButton("N");
		btn_q3_n.setPreferredSize(new Dimension(50, 50));
		btn_q3_n.setOpaque(false);
		btn_q3_n.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q3_n.setForeground(Color.DARK_GRAY);
		btn_q3_n.addActionListener(this);

		btn_q4_n = new JRadioButton("N");
		btn_q4_n.setPreferredSize(new Dimension(50, 50));
		btn_q4_n.setOpaque(false);
		btn_q4_n.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q4_n.setForeground(Color.DARK_GRAY);
		btn_q4_n.addActionListener(this);

		btn_q5_n = new JRadioButton("N");
		btn_q5_n.setPreferredSize(new Dimension(50, 50));
		btn_q5_n.setOpaque(false);
		btn_q5_n.setFont(new Font("굴림", Font.BOLD, 20));
		btn_q5_n.setForeground(Color.DARK_GRAY);
		btn_q5_n.addActionListener(this);

		p1.add(qu1);
		qu1.setPreferredSize(new Dimension(780, 67));
		p1.add(btn_q1_y);
		p1.add(btn_q1_n);

		p2.add(qu2);
		qu2.setPreferredSize(new Dimension(780, 67));
		p2.add(btn_q2_y);
		p2.add(btn_q2_n);

		p3.add(qu3);
		qu3.setPreferredSize(new Dimension(780, 67));
		p3.add(btn_q3_y);
		p3.add(btn_q3_n);

		p4.add(qu4);
		qu4.setPreferredSize(new Dimension(780, 67));
		p4.add(btn_q4_y);
		p4.add(btn_q4_n);

		p5.add(qu5);
		qu5.setPreferredSize(new Dimension(780, 67));
		p5.add(btn_q5_y);
		p5.add(btn_q5_n);

		btn_next = new JButton("NEXT");
		btn_next.setFont(new Font("굴림", Font.BOLD, 20));
		btn_next.setBorder(new TitledBorder(null, "Next", TitledBorder.CENTER, TitledBorder.TOP, null));
		btn_next.setOpaque(false);
		btn_next.setContentAreaFilled(false);
		btn_next.setBounds(803, 22, 142, 46);
		btn_next.addActionListener(this);
		getContentPane().add(btn_next);

		panel_1 = new JPanel();
		panel_1.setBounds(96, 94, 732, 26);
		panel_1.setLayout(new GridLayout(0, 190));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setOpaque(true);
		getContentPane().add(panel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(203, 0, 563, 61);
		panel_3.setOpaque(false);
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		p.setFont(new Font("굴림", Font.BOLD, 13));
		p.setForeground(Color.DARK_GRAY);
		p.setBackground(Color.LIGHT_GRAY);
		panel_3.add(p);
		getContentPane().add(panel_3);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		JLabel lblNewLabel_2 = new JLabel(dateFormat.format(today).toUpperCase());
		lblNewLabel_2.setBounds(14, 14, 186, 53);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_2.setBorder(new TitledBorder(null, "Today's Date", TitledBorder.CENTER, TitledBorder.TOP, null));
		lblNewLabel_2.setOpaque(false);
		getContentPane().add(lblNewLabel_2);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new MainClass().changeClass("StartScreen");
				dispose();
			}
		});
		qu.add(qu1);
		qu.add(qu2);
		qu.add(qu3);
		qu.add(qu4);
		qu.add(qu5);

		makeQuestion();
	}

	// 문제 제출
	public void makeQuestion() {
		int munje = 0;

		// private ArrayList<String> question = null; 문제 생성 및 추가

		for (int i = (state * 5); i < ((state + 1) * 5); i++) {
			qu.get(munje).setText(question.get(i));
			munje++;
		}
		state++;
	}

	// 문제 선택 타입 저장
	public void checkFind(ActionEvent e) {
		if (e.getSource() == btn_q1_y || e.getSource() == btn_q1_n) {
			if (e.getSource() == btn_q1_y) {
				qus1 = btn_q1_y.getText();
			} else {
				qus1 = btn_q1_n.getText();
			}
		} else if (e.getSource() == btn_q2_y || e.getSource() == btn_q2_n) {
			if (e.getSource() == btn_q2_y) {
				qus2 = btn_q2_y.getText();
			} else {
				qus2 = btn_q2_n.getText();
			}
		} else if (e.getSource() == btn_q3_y || e.getSource() == btn_q3_n) {
			if (e.getSource() == btn_q3_y) {
				qus3 = btn_q3_y.getText();
			} else {
				qus3 = btn_q3_n.getText();
			}
		} else if (e.getSource() == btn_q4_y || e.getSource() == btn_q4_n) {
			if (e.getSource() == btn_q4_y) {
				qus4 = btn_q4_y.getText();
			} else {
				qus4 = btn_q4_n.getText();
			}
		} else if (e.getSource() == btn_q5_y || e.getSource() == btn_q5_n) {
			if (e.getSource() == btn_q5_y) {
				qus5 = btn_q5_y.getText();
			} else {
				qus5 = btn_q5_n.getText();
			}
		}
		// 정상적인 체크 확인
		if (btn_q1_y.isSelected() != btn_q1_n.isSelected()) {
			answerCheck[0] = true;
		} else if (btn_q1_y.isSelected() == btn_q1_n.isSelected()) {
			answerCheck[0] = false;
		}
		if (btn_q2_y.isSelected() != btn_q2_n.isSelected()) {
			answerCheck[1] = true;
		} else if (btn_q2_y.isSelected() == btn_q2_n.isSelected()) {
			answerCheck[1] = false;
		}
		if (btn_q3_y.isSelected() != btn_q3_n.isSelected()) {
			answerCheck[2] = true;
		} else if (btn_q3_y.isSelected() == btn_q3_n.isSelected()) {
			answerCheck[2] = false;
		}
		if (btn_q4_y.isSelected() != btn_q4_n.isSelected()) {
			answerCheck[3] = true;
		} else if (btn_q4_y.isSelected() == btn_q4_n.isSelected()) {
			answerCheck[3] = false;
		}
		if (btn_q5_y.isSelected() != btn_q5_n.isSelected()) {
			answerCheck[4] = true;
		} else if (btn_q5_y.isSelected() == btn_q5_n.isSelected()) {
			answerCheck[4] = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_q1_y) {
			btn_q1_n.setSelected(false);
		} else if (e.getSource() == btn_q2_y) {
			btn_q2_n.setSelected(false);
		} else if (e.getSource() == btn_q3_y) {
			btn_q3_n.setSelected(false);
		} else if (e.getSource() == btn_q4_y) {
			btn_q4_n.setSelected(false);
		} else if (e.getSource() == btn_q5_y) {
			btn_q5_n.setSelected(false);
		} else if (e.getSource() == btn_q1_n) {
			btn_q1_y.setSelected(false);
		} else if (e.getSource() == btn_q2_n) {
			btn_q2_y.setSelected(false);
		} else if (e.getSource() == btn_q3_n) {
			btn_q3_y.setSelected(false);
		} else if (e.getSource() == btn_q4_n) {
			btn_q4_y.setSelected(false);
		} else if (e.getSource() == btn_q5_n) {
			btn_q5_y.setSelected(false);
		} else if (e.getSource() == btn_next) {

			// 문제 체크 확인
			int cnt = 0;

			for (boolean che : answerCheck) {
				if (che) {
					cnt++;
				}

				if (cnt == 5) {
					checkSet = true;// 문제 전부 체크 확인 완료
				}
			}

			if (checkSet) {
				checkSet = false; // 문제 전부 체크 확인 리셋

				// 검사 결과 반환
				// 기본 각 5개씩 15번 기본 검사 실시 후 검사 결과 정확한 판단이 안될 경우 다시 검사 실시
				answer.add(qus1);
				answer.add(qus2);
				answer.add(qus3);
				answer.add(qus4);
				answer.add(qus5);

				boolean more = false;

				if (state >= 1 && state < 20) {
					more = testmanager.answerCount(answer, state);
				}

				else if (state == 20) {
					answer.clear();
					question = testmanager.getQuestion();
					state = 0;
					percentage = 0;
					num = 0;
					panels.clear();
					panel_1.removeAll();
				}

				if (more) {
					// 프로그래스바
					panel_1.setBackground(Color.BLACK);
					percentage = 100;
					// 결과 DB 전송
					ans = testmanager.requestType();
					// 검사 종료

					JOptionPane.showMessageDialog(null, "검사가 완료 되었습니다. 결과확인바랍니다!");
					panel.setVisible(false);
					btn_next.setText("결과 보기");
					new MainClass().changeClass("ResultClass");
					new MainClass().sendType(ans);
					this.dispose();

				} else if (state != 0) {

					// 프로그래스바
					num++;
					percentage = percentage + 5;

					for (int i = 0; i < num; i++) {
						JPanel p = new JPanel();
						panels.add(p);
						panel_1.add(p);

						for (JPanel p2 : panels) {
							p2.setBackground(Color.BLACK);
						}
					}

					qus.clear();
					makeQuestion();
				}

				lblNewLabel_1.setText(String.valueOf(percentage) + "%");
				lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
				lblNewLabel_1.setForeground(Color.yellow);

				qus1 = null;
				qus2 = null;
				qus3 = null;
				qus4 = null;
				qus5 = null;

				btn_q1_y.setSelected(false);
				btn_q2_y.setSelected(false);
				btn_q3_y.setSelected(false);
				btn_q4_y.setSelected(false);
				btn_q5_y.setSelected(false);

				btn_q1_n.setSelected(false);
				btn_q2_n.setSelected(false);
				btn_q3_n.setSelected(false);
				btn_q4_n.setSelected(false);
				btn_q5_n.setSelected(false);

				invalidate(); // 초기화
				repaint(); // 다시 생성

			} else {
				JOptionPane.showMessageDialog(null, "모두 체크해주세요!");
			}
		}
		checkFind(e); // 체크 확인
	}
}