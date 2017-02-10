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

import javax.swing.JButton;

public class HistogramPanel extends JPanel implements ActionListener {
	private int histogramHeight = 200;
	private int barWidth = 70;
	private int barGap = 30;

	private JPanel barPanel;
	private JPanel labelPanel;

	private JButton btnNewButton;
	private static JFrame frame;

	private List<Bar> bars = new ArrayList<Bar>();

	public HistogramPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		barPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
		barPanel.setBounds(10, 23, 611, 311);
		Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
		Border inner = new EmptyBorder(10, 10, 0, 10);
		Border compound = new CompoundBorder(outer, inner);
		barPanel.setBorder(compound);
		barPanel.setBackground(Color.WHITE);
		barPanel.setBorder(new TitledBorder(null, "Sex Phycological Histogram", TitledBorder.CENTER, TitledBorder.TOP, null));

		labelPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
		labelPanel.setBounds(10, 321, 508, 5);
		labelPanel.setBorder(new EmptyBorder(5, 10, 0, 10));
		labelPanel.setBackground(Color.BLACK);

		btnNewButton = new JButton("メインスクリ-ン");
		btnNewButton.setBounds(446, 392, 175, 49);
		btnNewButton.addActionListener(this);
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new TitledBorder(null, "Return", TitledBorder.CENTER, TitledBorder.TOP, null));
		setLayout(null);

		add(btnNewButton);
		add(barPanel);
		add(labelPanel);

		JLabel lblNewLabel = new JLabel("Man(男)");
		lblNewLabel.setBounds(220, 392, 100, 49);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(new TitledBorder(null, "<Male>", TitledBorder.CENTER, TitledBorder.TOP, null));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);

		JLabel label = new JLabel("Woman(女)");
		label.setBounds(330, 392, 100, 49);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBorder(new TitledBorder(null, "<Female>", TitledBorder.CENTER, TitledBorder.TOP, null));
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBackground(Color.PINK);
		label.setForeground(Color.WHITE);
		add(label);

		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new TitledBorder(null, "性別についた結果", TitledBorder.CENTER, TitledBorder.TOP, null));

		JLabel lblNewLabel_1 = new JLabel("塩型");
		lblNewLabel_1.setBounds(10, 338, 109, 42);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBorder(new TitledBorder(null, "Type", TitledBorder.CENTER, TitledBorder.TOP, null));
		add(lblNewLabel_1);

		JLabel label_1 = new JLabel("権力型");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		label_1.setBorder(new TitledBorder(null, "Type", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_1.setBounds(133, 338, 109, 42);
		label_1.setForeground(Color.GREEN);
		add(label_1);

		JLabel label_2 = new JLabel("予言字形");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		label_2.setBorder(new TitledBorder(null, "Type", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_2.setBounds(256, 338, 109, 42);
		label_2.setForeground(Color.BLUE);
		add(label_2);

		JLabel label_3 = new JLabel("科学字形");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		label_3.setBorder(new TitledBorder(null, "Type", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_3.setBounds(379, 338, 109, 42);
		label_3.setForeground(Color.ORANGE);
		add(label_3);

		JLabel label_4 = new JLabel("百科事典型");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("굴림", Font.BOLD, 15));
		label_4.setBorder(new TitledBorder(null, "Type", TitledBorder.CENTER, TitledBorder.TOP, null));
		label_4.setBounds(502, 338, 109, 42);
		label_4.setForeground(Color.DARK_GRAY);
		add(label_4);
		
		JLabel lblNewLabel_2 = new JLabel("單位(人)");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBorder(new TitledBorder(null, "check", TitledBorder.CENTER, TitledBorder.TOP, null));
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(20, 392, 99, 49);
        add(lblNewLabel_2);

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

	// 그래프 막대에 각각의 비율 설정
	static void createAndShowGUI() {
		
		ClientManager manager = new ClientManager();
		ArrayList<PersonalityTypeTest> pttList = new ArrayList<>();
		
		// 성별, 나이, type 결과 
		pttList = manager.getAllReCheck();
		
		// 타입 선택
		int type = 0;
		
		// 성별 카운트 배열
		int sex[][] = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };

		for (PersonalityTypeTest personalityTypeTest : pttList) {
			if (ManagerInterface.SALT_TYPE_STRING.equals(personalityTypeTest.getType())) {
				type = 0;
			} else if (ManagerInterface.POWER_TYPE_STRING.equals(personalityTypeTest.getType())) {
				type = 1;
			} else if (ManagerInterface.PROPHET_TYPE_STRING.equals(personalityTypeTest.getType())) {
				type = 2;
			} else if (ManagerInterface.SCIENTIST_TYPE_STRING.equals(personalityTypeTest.getType())) {
				type = 3;
			} else if (ManagerInterface.ENCYCLOPEDIA_TYPE_STRING.equals(personalityTypeTest.getType())) {
				type = 4;
			} else {
				type = 5;
			}
			if (type < 5) {
				if ("남성".equals(personalityTypeTest.getSex())) {
					sex[type][0]++;
				} else if ("여성".equals(personalityTypeTest.getSex())) {
					sex[type][1]++;
				}
			}
		}
		HistogramPanel panel = new HistogramPanel();
		panel.addHistogramColumn("남(男)", sex[0][0], Color.BLUE);
		panel.addHistogramColumn("여(女)", sex[0][1], Color.PINK);
		panel.addHistogramColumn("남(男)", sex[1][0], Color.BLUE);
		panel.addHistogramColumn("여(女)", sex[1][1], Color.PINK);
		panel.addHistogramColumn("남(男)", sex[2][0], Color.BLUE);
		panel.addHistogramColumn("여(女)", sex[2][1], Color.PINK);
		panel.addHistogramColumn("남(男)", sex[3][0], Color.BLUE);
		panel.addHistogramColumn("여(女)", sex[3][1], Color.PINK);
		panel.addHistogramColumn("남(男)", sex[4][0], Color.BLUE);
		panel.addHistogramColumn("여(女)", sex[4][1], Color.PINK);

		panel.layoutHistogram();

		frame = new JFrame("Histogram Panel");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setLocationByPlatform(true);
		frame.setBackground(Color.DARK_GRAY);
		frame.pack();
		frame.setBounds(0, 0, 660, 495);
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