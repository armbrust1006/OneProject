package client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import vo.PersonalityTypeTest;
import client.data.ClientManager;
import data.ManagerInterface;

public class HistogramPanel_2 extends JPanel implements ActionListener {
	private int histogramHeight = 200;
	private int barWidth = 50;
	private int barGap = 10;

	private JPanel barPanel;
	private JPanel labelPanel;

	private JButton btnNewButton;
	private static JFrame frame;

	private List<Bar> bars = new ArrayList<Bar>();

	public HistogramPanel_2() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		barPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
		barPanel.setBounds(38, 25, 1053, 311);
		Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
		Border inner = new EmptyBorder(10, 10, 0, 10);
		Border compound = new CompoundBorder(outer, inner);
		barPanel.setBorder(compound);
		barPanel.setBackground(Color.WHITE);
		barPanel.setBorder(new TitledBorder(null, "Age Phycological Histogram", TitledBorder.CENTER, TitledBorder.TOP, null));

		labelPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
		labelPanel.setBounds(10, 321, 508, 5);
		labelPanel.setBorder(new EmptyBorder(5, 10, 0, 10));
		labelPanel.setBackground(Color.BLACK);

		btnNewButton = new JButton("メインスクリ-ン");
        btnNewButton.setBounds(918, 382, 175, 55);
        btnNewButton.addActionListener(this);
        btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
        btnNewButton.setOpaque(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorder(new TitledBorder(null, "Return", TitledBorder.CENTER, TitledBorder.TOP, null));
        btnNewButton.setForeground(Color.yellow);
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		setLayout(null);

		add(btnNewButton);
		add(barPanel);
		add(labelPanel);

		JLabel lblNewLabel = new JLabel("10代(10~19)");
		lblNewLabel.setBounds(38, 339, 260, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(new TitledBorder(null, "<teenage>", TitledBorder.CENTER, TitledBorder.TOP, null));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		add(lblNewLabel);

		JLabel label = new JLabel("20代(20~29)");
		label.setBounds(303, 339, 252, 31);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBorder(new TitledBorder(null, "<twenty>", TitledBorder.CENTER, TitledBorder.TOP, null));
		label.setFont(new Font("굴림", Font.BOLD, 15));
		add(label);

		JLabel label_1 = new JLabel("30代(30~39)");
		label_1.setBounds(560, 339, 260, 31);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setOpaque(true);
		label_1.setBorder(new TitledBorder(null, "<thirty>", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		add(label_1);

		JLabel label_2 = new JLabel("40代(40~49)");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		label_2.setBorder(new TitledBorder(null, "<forty>", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_2.setBounds(824, 339, 267, 31);
		add(label_2);

		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new TitledBorder(null, "年齢についた結果", TitledBorder.CENTER, TitledBorder.TOP, null));

		JPanel panel = new JPanel();
		panel.setBounds(38, 382, 866, 55);
		panel.setLayout(new GridLayout(0, 10));
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Phychological Articles", TitledBorder.CENTER, TitledBorder.TOP, null));
		add(panel);

		JLabel label_red = new JLabel("塩型");
		label_red.setFont(new Font("굴림", Font.BOLD, 15));
		label_red.setHorizontalAlignment(SwingConstants.CENTER);
		label_red.setForeground(Color.RED);
		panel.add(label_red);

		Circle r = new Circle_Red();
		panel.add(r);

		JLabel label_green = new JLabel("権力型");
		label_green.setFont(new Font("굴림", Font.BOLD, 15));
		label_green.setHorizontalAlignment(SwingConstants.CENTER);
		label_green.setForeground(Color.GREEN);
		panel.add(label_green);

		Circle r1 = new Circle_Green();
		panel.add(r1);

		JLabel label_blue = new JLabel("予言字形");
		label_blue.setFont(new Font("굴림", Font.BOLD, 15));
		label_blue.setHorizontalAlignment(SwingConstants.CENTER);
		label_blue.setForeground(Color.BLUE);
		panel.add(label_blue);

		Circle r2 = new Circle_Blue();
		panel.add(r2);

		JLabel label_orange = new JLabel("科学字形");
		label_orange.setFont(new Font("굴림", Font.BOLD, 15));
		label_orange.setHorizontalAlignment(SwingConstants.CENTER);
		label_orange.setForeground(Color.ORANGE);
		panel.add(label_orange);

		Circle r3 = new Circle_Orange();
		panel.add(r3);

		JLabel label_gary = new JLabel("百科事典型");
		label_gary.setFont(new Font("굴림", Font.BOLD, 15));
		label_gary.setHorizontalAlignment(SwingConstants.CENTER);
		label_gary.setForeground(Color.GRAY);
		panel.add(label_gary);

		Circle r4 = new Circle_Gray();
		panel.add(r4);
	}

	public void addHistogramColumn(String label, int value, Color color) {
		Bar bar = new Bar(label, value, color);
		bars.add(bar);
	}

	public void layoutHistogram() {
		barPanel.removeAll();
		labelPanel.removeAll();

		int maxValue = 0;

		for (Bar bar : bars)
			maxValue = Math.max(maxValue, bar.getValue());

		for (Bar bar : bars) {
			JLabel label = new JLabel(bar.getValue() + "");
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.TOP);
			label.setVerticalAlignment(JLabel.BOTTOM);
			int barHeight = (bar.getValue() * histogramHeight) / maxValue;
			Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
			label.setIcon(icon);
			barPanel.add(label);

			JLabel barLabel = new JLabel(bar.getLabel());
			barLabel.setHorizontalAlignment(JLabel.CENTER);
			labelPanel.add(barLabel);
		}
	}

	private class Bar {
		private String label;
		private int value;
		private Color color;

		public Bar(String label, int value, Color color) {
			this.label = label;
			this.value = value;
			this.color = color;
		}

		public String getLabel() {
			return label;
		}

		public int getValue() {
			return value;
		}

		public Color getColor() {
			return color;
		}
	}

	private class ColorIcon implements Icon {
		private int shadow = 3;

		private Color color;
		private int width;
		private int height;

		public ColorIcon(Color color, int width, int height) {
			this.color = color;
			this.width = width;
			this.height = height;
		}

		public int getIconWidth() {
			return width;
		}

		public int getIconHeight() {
			return height;
		}

		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(color);
			g.fillRect(x, y, width - shadow, height);
			g.setColor(Color.GRAY);
			g.fillRect(x + width - shadow, y + shadow, shadow, height - shadow);
		}
	}

	static void createAndShowGUI() {
		ClientManager manager = new ClientManager();
		
		ArrayList<PersonalityTypeTest> pttList = new ArrayList<>();
		pttList = manager.getAllReCheck();
		
		// 나이 선택
		int age = 0;
		
		// 나이 대별 카운트 배열
		int ages[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

		for (PersonalityTypeTest personalityTypeTest : pttList) {
			
			if (personalityTypeTest.getAge() >= 10 && personalityTypeTest.getAge() < 20) {
				age = 0;
			} else if (personalityTypeTest.getAge() >= 20 && personalityTypeTest.getAge() < 30) {
				age = 1;
			} else if (personalityTypeTest.getAge() >= 30 && personalityTypeTest.getAge() < 40) {
				age = 2;
			} else if (personalityTypeTest.getAge() >= 40 && personalityTypeTest.getAge() < 50) {
				age = 3;
			} else {
				age = 4;
			}
			
			if (age < 4) {
				if (ManagerInterface.SALT_TYPE_STRING.equals(personalityTypeTest.getType())) {
					ages[age][0]++; // 해당 나이대 內 소금형 수
				} else if (ManagerInterface.POWER_TYPE_STRING.equals(personalityTypeTest.getType())) {
					ages[age][1]++; // 해당 나이대 內 임금 뒷편 권력형 수
				} else if (ManagerInterface.PROPHET_TYPE_STRING.equals(personalityTypeTest.getType())) {
					ages[age][2]++; // 해당 나이대 內 예언자형 수
				} else if (ManagerInterface.SCIENTIST_TYPE_STRING.equals(personalityTypeTest.getType())) {
					ages[age][3]++; // 해당 나이대 內 과학자형 수
				} else if (ManagerInterface.ENCYCLOPEDIA_TYPE_STRING.equals(personalityTypeTest.getType())) {
					ages[age][4]++; // 해당 나이대 內 백과사전형 수
				}
			}
		}

		HistogramPanel_2 panel = new HistogramPanel_2();
		panel.addHistogramColumn("1", ages[0][0], Color.RED);
		panel.addHistogramColumn("2", ages[0][1], Color.GREEN);
		panel.addHistogramColumn("3", ages[0][2], Color.BLUE);
		panel.addHistogramColumn("4", ages[0][3], Color.ORANGE);
		panel.addHistogramColumn("5", ages[0][4], Color.GRAY);
		panel.addHistogramColumn("1", ages[1][0], Color.RED);
		panel.addHistogramColumn("2", ages[1][1], Color.GREEN);
		panel.addHistogramColumn("3", ages[1][2], Color.BLUE);
		panel.addHistogramColumn("4", ages[1][3], Color.ORANGE);
		panel.addHistogramColumn("5", ages[1][4], Color.GRAY);
		panel.addHistogramColumn("1", ages[2][0], Color.RED);
		panel.addHistogramColumn("2", ages[2][1], Color.GREEN);
		panel.addHistogramColumn("3", ages[2][2], Color.BLUE);
		panel.addHistogramColumn("4", ages[2][3], Color.ORANGE);
		panel.addHistogramColumn("5", ages[2][4], Color.GRAY);
		panel.addHistogramColumn("1", ages[3][0], Color.RED);
		panel.addHistogramColumn("2", ages[3][1], Color.GREEN);
		panel.addHistogramColumn("3", ages[3][2], Color.BLUE);
		panel.addHistogramColumn("4", ages[3][3], Color.ORANGE);
		panel.addHistogramColumn("5", ages[3][4], Color.GRAY);
		panel.layoutHistogram();

		frame = new JFrame("Histogram Panel");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setLocationByPlatform(true);
		frame.setBackground(Color.DARK_GRAY);
		frame.pack();
		frame.setBounds(0, 0, 1140, 495);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new MainClass().changeClass("StartScreen");
				frame.dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			new MainClass().changeClass("StartScreen");
			frame.dispose();
		}
	}
}