package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import vo.PersonalityTypeTest;
import client.data.ClientManager;
import client.data.LoginStatement;

public class ResultClass extends JFrame implements ActionListener {
	private ClientManager manager = null;
	private PersonalityTypeTest ptt = null;
	
	private JTextArea textArea;
	private JPanel panel;
	private JButton c1;
	private JButton c2;
	private JButton c3;

	public ResultClass(ClientManager manager) {
		this.manager = manager;
		this.setTitle("Result");
		this.setBounds(100, 100, 892, 312);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./bgimg/BackGround5.GIF")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(620, 20, 240, 234);
		panel.setLayout(new GridLayout(3, 0));
		panel.setBorder(new TitledBorder(null, "Recommend List", TitledBorder.CENTER, TitledBorder.TOP, null));
		panel.setOpaque(false);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("検査結果該当者は");
		lblNewLabel.setBounds(20, 26, 200, 44);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(Color.YELLOW));
		lblNewLabel.setForeground(Color.YELLOW);
		getContentPane().add(lblNewLabel);

		JLabel label_1 = new JLabel();
		label_1.setBounds(225, 26, 240, 44);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBorder(new TitledBorder(null, "Result", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		getContentPane().add(label_1);
		label_1.setEnabled(false);

		JLabel label = new JLabel("タイプです。");
		label.setBounds(470, 26, 140, 44);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new LineBorder(Color.YELLOW));
		label.setForeground(Color.YELLOW);
		getContentPane().add(label);

		textArea = new JTextArea();
		textArea.setBounds(14, 71, 600, 182);
		textArea.setBorder(new TitledBorder(null, "助言", TitledBorder.CENTER, TitledBorder.TOP,null));
		textArea.setOpaque(false);
		textArea.setFont(new Font("굴림", Font.BOLD, 14));
		textArea.setForeground(Color.YELLOW);
		textArea.setEditable(false);
		getContentPane().add(textArea);

		c1 = new JButton("メインスクリ-ン");
		c1.setBounds(425, 422, 136, 34);
		c1.setHorizontalAlignment(SwingConstants.CENTER);
		c1.setFont(new Font("굴림", Font.BOLD, 25));
		c1.setBorder(new LineBorder(Color.YELLOW));
		c1.setForeground(Color.WHITE);
		c1.setOpaque(false);
		c1.setContentAreaFilled(false);
		c1.addActionListener(this);
		panel.add(c1);
		
		c2 = new JButton("おすすめ料理");
		c2.setBounds(425, 422, 136, 34);
		c2.setHorizontalAlignment(SwingConstants.CENTER);
		c2.setFont(new Font("굴림", Font.BOLD, 25));
		c2.setBorder(new LineBorder(Color.YELLOW));
		c2.setForeground(Color.WHITE);
		c2.setOpaque(false);
		c2.setContentAreaFilled(false);
		c2.addActionListener(this);
		panel.add(c2);
		
		c3 = new JButton("おすすめ旅行先");
		c3.setBounds(425, 422, 136, 34);
		c3.setHorizontalAlignment(SwingConstants.CENTER);
		c3.setFont(new Font("굴림", Font.BOLD, 25));
		c3.setBorder(new LineBorder(Color.YELLOW));
		c3.setForeground(Color.WHITE);
		c3.setOpaque(false);
		c3.setContentAreaFilled(false);
		c3.addActionListener(this);
		panel.add(c3);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new MainClass().changeClass("StartScreen");
				dispose();
			}
		});

		ptt = manager.getResult(LoginStatement.getLoginUserID());
		label_1.setText(ptt.getType());
		textArea.append(ptt.getAnswer());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == c1) {
			new MainClass().changeClass("StartScreen");
			this.dispose();
		}

		else if (e.getSource() == c2) {
			new MainClass().changeClass("RecommendDishes");
			this.setVisible(false);
		}

		else if (e.getSource() == c3) {
			new MainClass().changeClass("RecommendTravel");
			this.setVisible(false);
		}
	}
}
