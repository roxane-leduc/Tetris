package tetris;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FenetreRegles extends JFrame {

	private static final long serialVersionUID = -2376588611370170244L;

	public FenetreRegles() {
		super("Tetris");

		// String dir = System.getProperty("user.dir");
		// System.out.println(dir);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(Grille.getNCOLONNES() * Grille.TCELL, Grille.NLIGNES * Grille.TCELL);
		this.setLocationRelativeTo(null);

		JTextArea texte = new JTextArea(readFile("src/tetris/regles.txt"));
		this.add(texte); //
	}

	private String readFile(String file) {
		String lines = "";
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();

			while ((line = reader.readLine()) != null)
				lines += line + "\n";

			reader.close();
		} catch (Exception e) {
			lines = "Une erreur s'est produite : " + e.getMessage();
		}

		return lines;
	}
}
