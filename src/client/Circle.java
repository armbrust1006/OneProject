package client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Circle extends JPanel {

	private double iconRadius = 23;
	private Color defaultColor = new Color(89, 104, 99);
	private int positionX = 0;
	private int positionY = 0;

	private Ellipse2D iconBody = new Ellipse2D.Double(getPositionX(), getPositionY(), iconRadius, iconRadius);

	public Circle() {
	}

	public Color getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(Color defaultColor) {
		this.defaultColor = defaultColor;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		this.setBackground(new Color(255, 255, 255));

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setPaint(getDefaultColor());
		g2d.draw(iconBody);
		g2d.fill(iconBody);
	}
}