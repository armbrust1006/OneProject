package client;

import java.awt.Color;

public class Circle_Gray extends Circle{
	private Color defaultColor = Color.GRAY;
	private int positionX = 120;
	private int positionY = 0;

	public Circle_Gray() {
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
}
