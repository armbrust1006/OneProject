package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import vo.ImageAndDataObject;
import client.data.ClientManager;
import client.data.LoginStatement;
import data.ManagerInterface;

public class RecommendTravel extends JFrame implements ActionListener {
	private ClientManager manager = null;
	private JLabel pic_1 = new JLabel();
	private JLabel pic_2 = new JLabel();

	private int x = 0;
	private int y = 0;

	private ArrayList<ImageIcon> list_1 = new ArrayList<>();
	private ArrayList<ImageIcon> list_2 = new ArrayList<>();
	
	private ArrayList<String> data1 = new ArrayList<>();
	private ArrayList<String> data2 = new ArrayList<>();
	private ArrayList<String> data3 = new ArrayList<>();

	private JLabel lblNewLabel_2;
	private JLabel label_1;
	private JLabel label_2;

	private JButton btnNewButton;

	public RecommendTravel(ClientManager manager) {
		super("RecommendTravel");
		this.manager = manager;
		
		ArrayList<ImageAndDataObject> list = new ArrayList<>();
		
		list = manager.getImageAndText(LoginStatement.getLoginUserID(), ManagerInterface.GET_TRAVEL);
		
		if (list != null) {
			for (ImageAndDataObject datas : list) {
				list_1.add(datas.getImg2());
				list_2.add(datas.getImg1());
				data1.add(datas.getData1());
				data2.add(datas.getData2());
				data3.add(datas.getData3());
			}
		}

		JLabel lblNewLabel = new JLabel("City");
		lblNewLabel.setBounds(14, 206, 146, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBorder(new TitledBorder(null, "City", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("Country");
		label.setBounds(14, 258, 146, 40);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBorder(new TitledBorder(null, "Country", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(label);

		JLabel lblNewLabel_1 = new JLabel("Places");
		lblNewLabel_1.setBounds(14, 310, 146, 40);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBorder(new TitledBorder(null, "Context", TitledBorder.CENTER, TitledBorder.TOP, null));
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(174, 206, 401, 40);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new TitledBorder(null, "context", TitledBorder.CENTER, TitledBorder.TOP));
		lblNewLabel_2.setForeground(Color.YELLOW);
		getContentPane().add(lblNewLabel_2);
		
		label_1 = new JLabel();
		label_1.setBorder(new TitledBorder(null, "context", TitledBorder.CENTER, TitledBorder.TOP));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(174, 258, 401, 40);
		label_1.setForeground(Color.YELLOW);
		getContentPane().add(label_1);
		
		label_2 = new JLabel();
		label_2.setBorder(new TitledBorder(null, "context", TitledBorder.CENTER, TitledBorder.TOP));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(174, 310, 401, 40);
		label_2.setForeground(Color.YELLOW);
		getContentPane().add(label_2);

		btnNewButton = new JButton("Back");
		btnNewButton.setBounds(435, 157, 146, 40);
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new TitledBorder(null, "Return", TitledBorder.CENTER, TitledBorder.TOP, null));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);

		Timer tm;
		Timer tm2;
		pic_1.setBounds(14, 12, 389, 185);
		pic_1.setBorder(new TitledBorder(null, "Recommend City", TitledBorder.CENTER, TitledBorder.TOP, null));

		pic_2.setBounds(417, 12, 164, 109);
		pic_2.setBorder(new TitledBorder(null, "Country", TitledBorder.CENTER, TitledBorder.TOP, null));

		tm = new Timer(4000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				lblNewLabel_2.setText(data1.get(x));
				label_1.setText(data2.get(x));
				label_2.setText(data3.get(x));
				x += 1;
				if (x >= list_1.size()) {
					x = 0;
				}
			}
		});

		tm2 = new Timer(4000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize2(y);
				y += 1;
				if (y >= list_2.size()) {
					y = 0;
				}
			}
		});

		getContentPane().add(pic_1);
		getContentPane().add(pic_2);
		tm.start();
		tm2.start();
		getContentPane().setLayout(null);
		setSize(621, 423);
		getContentPane().setBackground(Color.LIGHT_GRAY);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new MainClass().changeClass("ResultClass");
				dispose();
			}
		});

	}

	public void SetImageSize(int i) {
		ImageIcon icon = list_1.get(i);

		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(pic_1.getWidth(), pic_1.getHeight(), Image.SCALE_SMOOTH);

		ImageIcon newImc = new ImageIcon(newImg);
		pic_1.setIcon(newImc);
	}

	public void SetImageSize2(int i) {
		ImageIcon icon2 = list_2.get(i);

		Image img2 = icon2.getImage();
		Image newImg2 = img2.getScaledInstance(pic_2.getWidth(), pic_2.getHeight(), Image.SCALE_SMOOTH);

		ImageIcon newImc2 = new ImageIcon(newImg2);
		pic_2.setIcon(newImc2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			new MainClass().changeClass("ResultClass");
			this.dispose();
		}
	}
}