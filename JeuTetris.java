package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JeuTetris implements KeyListener, Runnable {

	private Grille grille;
	private int score = 0;
	private FenetreDeJeu fenetreDeJeu;
	private long vitesseDeChute = 1000 / 2;

	public JeuTetris(Grille grille, FenetreDeJeu fenetreDeJeu) {
		this.grille = grille;
		this.fenetreDeJeu = fenetreDeJeu;
	}

	@Override
	public void run() {
		Piece pieceTomb = Piece.creerPiece(grille);
		grille.setPieceTombante(pieceTomb);
		grille.actualisationGrille();

		while (!grille.getPieceTombante().perdu()) {
			try {
				grille.repaint();
				if (grille.getPieceTombante().est_tombee()) {
					if (grille.effacer_lignes()) {
						score += 100;
					}
					pieceTomb = Piece.creerPiece(grille);
					grille.setPieceTombante(pieceTomb);
					grille.actualisationGrille();
					grille.repaint();
				}
				
				grille.effacer_piece();
				grille.getPieceTombante().descendre();
				grille.repaint();
				score++;
				if (score % 100 == 0) {
					accelerer();
				}
				fenetreDeJeu.updateScore(score);
				grille.actualisationGrille();
				grille.repaint();
				Thread.sleep(vitesseDeChute);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		fenetreDeJeu.setVisible(false);
		System.out.println("Vous avez perdu !!!");
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();

		grille.effacer_piece();
		switch (keyCode) {
		case KeyEvent.VK_Q:
			System.exit(0);
			break;
		case KeyEvent.VK_DOWN:
			grille.getPieceTombante().descendre();
			break;
		case KeyEvent.VK_LEFT:
			grille.getPieceTombante().deplacement_gauche();
			break;
		case KeyEvent.VK_RIGHT:
			grille.getPieceTombante().deplacement_droite();
			break;
		case KeyEvent.VK_SPACE:
			grille.getPieceTombante().tourner();
			break;
		}

		grille.actualisationGrille();
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}

	@Override
	public void keyTyped(KeyEvent event) {
	}

	public void accelerer() {
		this.vitesseDeChute = vitesseDeChute - (100/(score/100));
	}
}
