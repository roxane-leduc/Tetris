package tetris;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FenetreDeJeu extends JFrame {

	private static final long serialVersionUID = 1L;
	private FenetreScore tetrisBarreDeStatut;

	public FenetreDeJeu() {
		super("Tetris");

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize((Grille.NCOLONNES - Grille.CVISDEB) * Grille.TCELL,
				(Grille.NLIGNES - Grille.LVISDEB) * Grille.TCELL + 70);
		this.setLocationRelativeTo(null);

		Grille tetrisGrille = new Grille();
		add(tetrisGrille);

		tetrisBarreDeStatut = new FenetreScore();
		add(tetrisBarreDeStatut, BorderLayout.SOUTH);

		JeuTetris jeuTetris = new JeuTetris(tetrisGrille, this);
		addKeyListener(jeuTetris);
		new Thread(jeuTetris).start();
		
	}

	public void updateScore(int score) {
		tetrisBarreDeStatut.printScore(score);
	}
}
