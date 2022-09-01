package tetris;

import java.awt.Color;

public enum Forme {
	CARRE(new Color(204, 102, 204)),
	BATON(new Color(102, 102, 204)),
	L(new Color(218, 170, 0)),
	L_INV(new Color(102, 204, 204)),
	S(new Color(95, 195, 95)),
	S_INV(new Color(204, 102, 102)),
	T(new Color(204, 204, 102));

	public Color couleur;

	private Forme(Color couleur) {
		this.couleur = couleur;
	}
}