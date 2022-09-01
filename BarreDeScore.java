package tetris;

import java.awt.Font;

import javax.swing.JLabel;

public class BarreDeScore extends JLabel {
	private static final long serialVersionUID = 1L;

	public BarreDeScore() {
		super(toScore(0));
		setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	}

	private static String toScore(int score) {
		return String.format("Score: %4d", score);
	}

	public void printScore(int score) {
		setText(toScore(score));
	}
}
