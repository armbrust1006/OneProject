package client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartScreen extends JFrame implements ActionListener {

	private JButton btnNewButton;
	private JButton button;
	private JButton btnNewButton_1;
	
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;

	public StartScreen() {
		this.setTitle("Main");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 462, 302);
		getContentPane().setLayout(null);

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./bgimg/BackGround3.GIF")))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		btnNewButton = new JButton("性格検査");
		btnNewButton.setBounds(14, 12, 412, 55);
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBorder(new TitledBorder(null, "Testing", TitledBorder.CENTER, TitledBorder.TOP, null));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("새굴림", Font.BOLD, 30));
		getContentPane().add(btnNewButton);

		button = new JButton("以前検査履歴");
		button.setBounds(14, 79, 412, 55);
		button.addActionListener(this);
		button.setForeground(Color.LIGHT_GRAY);
		button.setBorder(new TitledBorder(null, "Past Checking", TitledBorder.CENTER, TitledBorder.TOP, null));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setFont(new Font("새굴림", Font.BOLD, 30));
		getContentPane().add(button);

		btnNewButton_1 = new JButton("性別についた性格");
		btnNewButton_1.setBounds(14, 146, 199, 44);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(new TitledBorder(null, "Phichological Type", TitledBorder.CENTER, TitledBorder.TOP, null));
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("새굴림", Font.BOLD, 14));
		getContentPane().add(btnNewButton_1);

		button_1 = new JButton("年齢についた性格");
		button_1.setBounds(14, 202, 199, 44);
		button_1.addActionListener(this);
		button_1.setForeground(Color.BLACK);
		button_1.setBorder(new TitledBorder(null, "Phichological Type", TitledBorder.CENTER, TitledBorder.TOP, null));
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setFont(new Font("새굴림", Font.BOLD, 14));
		getContentPane().add(button_1);

		button_2 = new JButton("ログアウト");
		button_2.setOpaque(false);
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBorder(new TitledBorder(null, "Logout", TitledBorder.CENTER, TitledBorder.TOP, null));
		button_2.setContentAreaFilled(false);
		button_2.setOpaque(false);
		button_2.addActionListener(this);
		button_2.setBounds(227, 146, 199, 44);
		getContentPane().add(button_2);

		button_3 = new JButton("終了");
		button_3.setOpaque(false);
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBorder(new TitledBorder(null, "Exit", TitledBorder.CENTER, TitledBorder.TOP, null));
		button_3.setContentAreaFilled(false);
		button_3.setOpaque(false);
		button_3.setBounds(227, 202, 199, 44);
		getContentPane().add(button_3);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNewButton) {
			new MainClass().changeClass("CheckClass");
			this.dispose();
		}

		else if (e.getSource() == btnNewButton_1) {

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					new HistogramPanel().createAndShowGUI();
				}
			});
			this.dispose();
		}

		else if (e.getSource() == button_1) {

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					new HistogramPanel_2().createAndShowGUI();
				}
			});
			this.dispose();
		}

		else if (e.getSource() == button) {
			new MainClass().changeClass("Recheck");
			this.dispose();
		}

		else if (e.getSource() == button_2) {
			new MainClass().start();
			this.dispose();
		}

		else if (e.getSource() == button_3) {
			System.exit(0);
		}
	}
}