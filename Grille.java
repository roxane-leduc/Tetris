package tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grille extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int TCELL = 30; // Taille d'un cellule

	public static int NCOLONNES = 14; // Nombre de colonnes dans la grille cachée
	public static int NLIGNES = 24; // Nombre de lignes dans la grille cachée

	public static int CVISDEB = 2; // Colonne VISible DEBut
	public static int CVISFIN = NCOLONNES - 3; // Colonne VISible FIN
	public static int LVISDEB = 4; // Ligne VISible DEBut

	public int[][] grille;
	private Piece pieceTombante;

	public Grille() {
		grille = new int[NLIGNES][NCOLONNES];
		for (int ligne = 0; ligne < NLIGNES; ligne++) {
			for (int colonne = 0; colonne < NCOLONNES; colonne++) {
				grille[ligne][colonne] = 0;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// pieceTombante.paintComponent(g);
		for (int ligne = LVISDEB; ligne < NLIGNES; ligne++) {
			for (int colonne = CVISDEB; colonne <= CVISFIN; colonne++) {
				switch (grille[ligne][colonne]) {
				case 0: {
					g.setColor(Color.gray);
					break;
				}

				case 1: {
					g.setColor(Color.green);
					break;
				}

				case 2: {
					g.setColor(Color.yellow);
					break;
				}

				case 3: {
					g.setColor(Color.cyan);
					break;
				}

				case 4: {
					g.setColor(Color.red);
					break;
				}

				case 5: {
					g.setColor(Color.magenta);
					break;
				}

				case 6: {
					g.setColor(Color.blue);
					break;
				}

				case 7: {
					g.setColor(Color.orange);
					break;
				}
				}

				int x = (colonne - CVISDEB) * TCELL;
				int y = (ligne - LVISDEB) * TCELL;

				g.fillRect(x, y, TCELL, TCELL);
				if (0 == grille[ligne][colonne]) {
					g.setColor(Color.lightGray);
					g.drawRect(x, y, TCELL, TCELL);
				}
			}
		}

	}

	public void effacer_piece() {
		int x, y, rotation;
		int[][][] p;

		p = pieceTombante.getCettePiece();
		rotation = pieceTombante.getRotation();
		x = pieceTombante.getX();
		y = pieceTombante.getY();
		for (int i = x; i < x + 4; i++) {
			for (int j = y; j < y + 4; j++) {
				if (p[rotation][j - y][i - x] != 0) {
					grille[j][i] = 0;
				}
			}
		}
	}

	public void actualisationGrille() {
		int x, y, rotation;
		int[][][] p;

		p = pieceTombante.getCettePiece();
		rotation = pieceTombante.getRotation();
		x = pieceTombante.getX();
		y = pieceTombante.getY();
		for (int i = x; i < x + 4; i++) {
			for (int j = y; j < y + 4; j++) {
				int cellule = p[rotation][j - y][i - x];
				if ((j < NLIGNES) && (cellule != 0)) {
					grille[j][i] = cellule;
				}
			}
		}
	}

	public void effacer_ligne(int ligne) {
		for (int dx = CVISDEB; dx <= CVISFIN; dx++) {
			grille[ligne][dx] = 0;
		}
	}

	public void decaler_grille(int ligne_effacee) {
		for (int dy = ligne_effacee; dy > 0; dy--) {
			for (int dx = CVISDEB; dx <= CVISFIN; dx++) {
				grille[dy][dx] = grille[dy - 1][dx];
			}
		}
	}

	public boolean ligne_complete(int ligne) {

		for (int dx = CVISDEB; dx <= CVISFIN; dx++) {
			if (grille[ligne][dx] == 0) {
				return false;
			}
		}
		return true;
	}

	public boolean effacer_lignes() {
		boolean resultat = false;
		int y = pieceTombante.getY();
		for (int dy = y; dy < y + 4; dy++) {
			if ((dy < NLIGNES) && (ligne_complete(dy))) {
				effacer_ligne(dy);
				decaler_grille(dy);
				resultat = true;
			}
		}
		return resultat;
	}

	public int getCellule(int i, int j) {
		return grille[i][j];
	}

	public void setCellule(int i, int j, int nb) {
		this.grille[i][j] = nb;
	}

	public static int getNCOLONNES() {
		return NCOLONNES;
	}

	public static int getNLIGNES() {
		return NLIGNES;
	}

	public static int getCVISDEB() {
		return CVISDEB;
	}

	public static int getCVISFIN() {
		return CVISFIN;
	}

	public static int getLVISDEB() {
		return LVISDEB;
	}

	public void setPieceTombante(Piece pieceTombante) {
		this.pieceTombante = pieceTombante;
	}

	public Piece getPieceTombante() {
		return pieceTombante;
	}

	public int[][] getGrille() {
		return grille;
	}
}