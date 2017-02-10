package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import vo.PersonalityTypeTest;
import client.data.ClientManager;
import client.data.LoginStatement;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Recheck extends JFrame implements ActionListener {
	private ClientManager manager = null;
	
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	
	private JButton btnNewButton;
	
	private TimePanel p = new TimePanel();
	private Date today=new Date();

	public Recheck(ClientManager manager) {
		this.manager = manager;
		
		this.setTitle("Research Result");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 699, 518);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 12, 654, 385);
		scrollPane.setBorder(new TitledBorder(null, "Check Result", TitledBorder.CENTER, TitledBorder.TOP, null));
		scrollPane.setOpaque(false);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setOpaque(false);

		String[] columnNames = { "Type", "Advice", "Date" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table.setModel(tableModel);

		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(600);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);

		btnNewButton = new JButton("Back");
		btnNewButton.setBounds(515, 409, 153, 53);
		btnNewButton.addActionListener(this);
		btnNewButton.setBorder(new TitledBorder(null, "check", TitledBorder.CENTER, TitledBorder.TOP, null));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 409, 230, 50);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(Color.LIGHT_GRAY);
		p.setFont(new Font("±º∏≤", Font.BOLD, 15));
		p.setForeground(Color.WHITE);
		p.setBackground(Color.LIGHT_GRAY);
		panel.add(p);
		getContentPane().add(panel);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy“¥ MMÍ≈ ddÏÌ");
		
		JLabel lblNewLabel = new JLabel(dateFormat.format(today).toUpperCase());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(Color.WHITE));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(258, 409, 230, 50);
		getContentPane().add(lblNewLabel);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new MainClass().changeClass("StartScreen");
				dispose();
			}
		});

		ArrayList<PersonalityTypeTest> pttList = manager.getAllResult(LoginStatement.getLoginUserID());
		for (PersonalityTypeTest personalityTypeTest : pttList) {
			String[] list = { personalityTypeTest.getType(), personalityTypeTest.getAnswer(), personalityTypeTest.getDate() };
			tableModel.addRow(list);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			new MainClass().changeClass("StartScreen");
			this.dispose();
		} 
	}
}