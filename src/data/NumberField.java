package data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class NumberField extends JTextField implements KeyListener {
	private static final long serialVersionUID = 1;

	public NumberField() {
		addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 입력 숫자 확인
		char c = e.getKeyChar();

		if (!Character.isDigit(c)) {
			e.consume();
			return;
		}
	}
}
