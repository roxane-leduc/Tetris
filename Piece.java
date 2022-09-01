package tetris;

import java.util.Random;

public class Piece {

	// Attributs
	public Forme forme;
	public int rotation; // rotation = une des 4 rotations possibles de la pièce
							// initialisé à la position 0 de base
	public int x;
	public int y;
	// (x,y) : coordonnées du carré en haut à gauche de la sous-grille (4*4)
	// de cette Piece dans la grille du jeu (20*10)

	// Les 4 rotations possibles pour chaque pièces
	// Exemple pour Piece_S
	// 0100
	// 0110
	// 0010
	// 0000
	// Est la 1ère rotation possible pour la pièce de forme S
	// La première ligne de Piece_S, correspond à ses 4 lignes étalées

	public int[][][] cettePiece = new int[4][4][4];
	private Grille grille;

	public static int[][][] Piece_S = { // int ny = y + dy;

			{ { 0, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } }, // rotation 0

			{ { 0, 0, 0, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } }, // rotation 1

			{ { 0, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } }, // rotation 2

			{ { 0, 0, 0, 0 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } } // rotation 3
	};

	public static int[][][] Piece_CARRE = { //
			{ { 0, 2, 2, 0 }, { 0, 2, 2, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 2, 2, 0 }, { 0, 2, 2, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 2, 2, 0 }, { 0, 2, 2, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 2, 2, 0 }, { 0, 2, 2, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } } };

	public static int[][][] Piece_BATON = { //
			{ { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 0, 0 } },
			{ { 3, 3, 3, 3 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 0, 0 } },
			{ { 3, 3, 3, 3 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } } };

	public static int[][][] Piece_S_INV = { //
			{ { 0, 0, 4, 0 }, { 0, 4, 4, 0 }, { 0, 4, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 4, 4, 0 }, { 0, 0, 4, 4 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 4, 0 }, { 0, 4, 4, 0 }, { 0, 4, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 4, 4, 0 }, { 0, 0, 4, 4 }, { 0, 0, 0, 0 } } };

	public static int[][][] Piece_T = { //
			{ { 0, 5, 0, 0 }, { 0, 5, 5, 0 }, { 0, 5, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 0, 5, 0 }, { 0, 5, 5, 5 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 5 }, { 0, 0, 5, 5 }, { 0, 0, 0, 5 }, { 0, 0, 0, 0 } },
			{ { 0, 5, 5, 5 }, { 0, 0, 5, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } } };

	public static int[][][] Piece_L_INV = { //
			{ { 0, 0, 6, 0 }, { 0, 0, 6, 0 }, { 0, 6, 6, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 6, 6, 6 }, { 0, 0, 0, 6 }, { 0, 0, 0, 0 } },
			{ { 0, 6, 6, 0 }, { 0, 6, 0, 0 }, { 0, 6, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 6, 0, 0 }, { 0, 6, 6, 6 }, { 0, 0, 0, 0 } } };

	public static int[][][] Piece_L = { //
			{ { 0, 7, 0, 0 }, { 0, 7, 0, 0 }, { 0, 7, 7, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 0, 0, 7 }, { 0, 7, 7, 7 }, { 0, 0, 0, 0 } },
			{ { 0, 7, 7, 0 }, { 0, 0, 7, 0 }, { 0, 0, 7, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 0, 7, 7, 7 }, { 0, 7, 0, 0 }, { 0, 0, 0, 0 } } };

	private Piece(int x, int y, int rotation, Forme forme, int[][][] cettePiece, Grille grille) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.forme = forme;
		myCopyArray(cettePiece);
		this.grille = grille;
	}

	public static Piece creerPiece(Grille grille) {
		// nextInt(7) renvoie un nombre aléatoire >= 0 et < 7
		Random r = new Random();
		int numPiece = r.nextInt(7) + 1;

		int x = r.nextInt(Grille.CVISFIN - 3) + 2;
		int y = 0;
		int rotation = 0;

		switch (numPiece) {
		case 1:
			return new Piece(x, y, rotation, Forme.S, Piece_S, grille);
		case 2:
			return new Piece(x, y, rotation, Forme.CARRE, Piece_CARRE, grille);
		case 3:
			return new Piece(x, y, rotation, Forme.BATON, Piece_BATON, grille);
		case 4:
			return new Piece(x, y, rotation, Forme.S_INV, Piece_S_INV, grille);
		case 5:
			return new Piece(x, y, rotation, Forme.T, Piece_T, grille);
		case 6:
			return new Piece(x, y, rotation, Forme.L_INV, Piece_L_INV, grille);
		case 7:
			return new Piece(x, y, rotation, Forme.L, Piece_L, grille);
		}
		throw new Error("Instruction inategnable!");
	}

	private void myCopyArray(int piece[][][]) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					cettePiece[i][j][k] = piece[i][j][k];
				}
			}
		}
	}

	// Accesseurs
	public int getRotation() {
		return rotation;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int[][][] getCettePiece() {
		return cettePiece;
	}

	public void setX(int x1) {
		x = x1;
	}

	public void setY(int y1) {
		y = y1;
	}

	public boolean bloque_gauche() {

		boolean bloq_gauche = false;

		int[][] sous_grille = cettePiece[rotation];
		int xMoins1 = x - 1;

		switch (xMoins1) {

		// Cas où la sous-grille sort de la grille
		case -1: {
			bloq_gauche = true;
			break;
		}

		// Cas où la sous-grille est à moitié dans la partie cachée de la grille
		case 0: {

			// On vérifie si des cellules de la partie gauche de la sous-grille sont remplis
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][1] != 0) {
					bloq_gauche = true;
				}
			}

			for (int dy = 0; dy < 4; dy++) {
				for (int dx = 2; dx < 4; dx++) {
					if ((sous_grille[dy][dx] != 0) && (grille.grille[y + dy][xMoins1 + dx] != 0)) {
						bloq_gauche = true;
					}
				}
			}

			break;
		}

		// Cas où la colonne de gauche de la sous-grille est dans la partie cachée de la
		// grille
		case 1: {
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][0] != 0) {
					bloq_gauche = true;
				}
			}

			for (int dy = 0; dy < 4; dy++) {
				for (int dx = 1; dx < 4; dx++) {
					if ((sous_grille[dy][dx] != 0) && (grille.grille[y + dy][xMoins1 + dx] != 0)) {
						bloq_gauche = true;
					}
				}
			}

			break;
		}

		// On vérifie que des cellules de la sous-grille et de la grille ne sont pas
		// toutes les deux remplis
		default: {
			for (int dy = 0; dy < 4; dy++) {
				for (int dx = 0; dx < 4; dx++) {
					if ((sous_grille[dy][dx] != 0) && (grille.grille[y + dy][xMoins1 + dx] != 0)) {
						bloq_gauche = true;
					}
				}
			}

			break;
		}
		}

		return bloq_gauche;
		
	}

	public boolean bloque_droite() {

		boolean bloq_droite = false;

		int[][] sous_grille = cettePiece[rotation];
		int xPlus1 = x + 1;

		switch (xPlus1) {

		// Cas où la sous-grille sort de la grille
		case (11): {
			bloq_droite = true;
			break;
		}

		// Cas où la sous-grille est à moitié dans la partie cachée de la grille
		case (10): {

			// On vérifie si des cellules de la partie dorite de la sous-grille sont remplis
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][2] != 0) {
					bloq_droite = true;
				}
			}

			for (int dy = 0; dy < 4; dy++) {
				for (int dx = 0; dx < 2; dx++) {
					if ((sous_grille[dy][dx] != 0) && (grille.grille[y + dy][xPlus1 + dx] != 0)) {
						bloq_droite = true;
					}
				}
			}

			break;
		}

		// Cas où la colonne de droite de la sous-grille est dans la partie cachée de la
		// grille
		case (9): {
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][3] != 0) {
					bloq_droite = true;
				}
			}

			for (int dy = 0; dy < 4; dy++) {
				for (int dx = 0; dx < 3; dx++) {
					if ((sous_grille[dy][dx] != 0) && (grille.grille[y + dy][xPlus1 + dx] != 0)) {
						bloq_droite = true;
					}
				}
			}

			break;
		}

		// On vérifie que des cellules de la sous-grille et de la grille ne sont pas
		// toutes les deux remplis
		default: {
			for (int dy = 0; dy < 4; dy++) {
				for (int dx = 0; dx < 4; dx++) {
					if ((sous_grille[dy][dx] != 0) && (grille.grille[y + dy][xPlus1 + dx] != 0)) {
						bloq_droite = true;
					}
				}
			}

			break;
		}
		}

		return bloq_droite;

	}

	public boolean est_tombee() {

		int[][] sous_grille = cettePiece[rotation];
		int yPlus1 = y + 1;

		// Si la sous_grille est vers le bas de la grille
		if (y >= (Grille.NLIGNES - 4)) {

			// La sous grille touche le bas de la grille
			switch (y) {
			case 20: {
				for (int dx = 0; dx < 4; dx++) {
					if (sous_grille[3][dx] != 0) {
						return true;
					}
				}

				break;
			}

			// 1 ligne de la sous_grille sort de la grille
			case 21: {
				for (int dx = 0; dx < 4; dx++) {
					if (sous_grille[2][dx] != 0) {
						return true;
					}
				}
				break;
			}

			// 2 lignes de la sous_grille sortent de la grille
			case 22: {
				for (int dx = 0; dx < 4; dx++) {
					if (sous_grille[1][dx] != 0) {
						return true;
					}
				}
				break;
			}

			// 3 lignes de la sous_grille sortent de la grille
			case 23: {
				for (int dx = 0; dx < 4; dx++) {
					if (sous_grille[0][dx] != 0) {
						return true;
					}
				}
				break;
			}

			}

		}
		
		for (int dx = 0; dx < 4; dx++) {
			for (int dy = 0; dy < 3; dy++) {
				if ((sous_grille[dy][dx] != 0) && (sous_grille[dy+1][dx] == 0) && (grille.grille[yPlus1 + dy][x + dx] != 0)) {
					return true;
				}
			}
			if ((sous_grille[3][dx] != 0) && (grille.grille[yPlus1 + 3][x + dx] != 0)) {
				return true;
			}
		}

		return false;
	}

	public boolean bloque_tourne() {

		int FutureRotation = rotation + 1;
		if (FutureRotation == 4) {
			FutureRotation = 0;
		}
		int[][] sous_grille = cettePiece[FutureRotation]; // sous-grille = futurePieceTombante dans la bonne rotation

		// On teste d'abord si la pièce ne sort pas de la partie visible à droite
		if (x == Grille.CVISFIN - 1) {
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][2] != 0) {
					return true;
				}
			}
		}

		if (x >= Grille.CVISFIN - 2) {
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][3] != 0) {
					return true;
				}
			}
		}

		// On teste ensuite si la pièce ne sort pas de la partie visible à gauche
		if (x < Grille.CVISDEB) {
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][0] != 0) {
					return true;
				}
			}
		}

		if (x == Grille.CVISDEB - 2) {
			for (int dy = 0; dy < 4; dy++) {
				if (sous_grille[dy][1] != 0) {
					return true;
				}
			}
		}

		for (int dy = 0; dy < 4; dy++) {
			for (int dx = 0; dx < 4; dx++) {
				if ((sous_grille[dy][dx] != 0) && (grille.grille[y + dy][x + dx] != 0)) {
					return true;
					// Ca bloque car une cellule de la grille et une de la sous-grille sont remplis
				}
			}
		}
		return false;
	}

	public void deplacement_gauche() {
		if (!bloque_gauche()) {
			x--;
		}
	}

	public void deplacement_droite() {
		if (!bloque_droite()) {
			x++;
		}
	}

	public void tourner() {
		if (!bloque_tourne()) {
			rotation = (rotation + 1) % 4;
		}
	}

	public void descendre() {
		if (!est_tombee()) {
			y++;
		}
	}

	public boolean perdu() {
		for (int dx = Grille.CVISDEB; dx <= Grille.CVISFIN; dx++) {
			if (est_tombee() && grille.grille[Grille.LVISDEB - 1][dx] != 0) {
				return true;
			}
		}
		return false;
	}

/*
	public void paintComponent(Graphics g) {
		g.setColor(forme.couleur);
		// System.out.println("(" + x + "," + y + ")");
		for (int dy = 0; dy < 4; dy++) {
			int ny = Grille.NLIGNES - (y + dy);
			for (int dx = 0; dx < 4; dx++) {
				int nx = x + dx;
				if (0 != cettePiece[rotation][dy][dx]) {
					g.fillRect(nx * Grille.TCELL, ny * Grille.TCELL, Grille.TCELL, Grille.TCELL);
				}
			}
		}
	}
*/
}