package tetris;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FenetreMenu extends JFrame {

	private static final long serialVersionUID = -43811510894869985L;

	public FenetreMenu() {
		super("Tetris");

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(Grille.NCOLONNES * Grille.TCELL, Grille.NLIGNES * Grille.TCELL);
		this.setLocationRelativeTo(null);
	
		JPanel contentPane = (JPanel) this.getContentPane();
		BoxLayout boxLayout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
		contentPane.setLayout(boxLayout);

		JButton myButton1 = new JButton("Jouer");
		
		myButton1.setForeground(Color.BLUE);
		myButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// Classe anonyme
				FenetreMenu.this.setVisible(false);
				new FenetreDeJeu().setVisible(true);
			}
		});
		contentPane.add(myButton1);

		JButton myButton2 = new JButton("Consulter les règles du jeu");
		myButton2.setForeground(Color.BLUE);
		myButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// Classe anonyme
				FenetreMenu.this.setVisible(false);
				new FenetreRegles().setVisible(true);
			}
		});
		contentPane.add(myButton2);

		JButton myButton3 = new JButton("Se connecter");
		myButton3.setForeground(Color.BLUE);
		myButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// Classe anonyme
				FenetreMenu.this.setVisible(false);
				new FenetreConnexion().setVisible(true);
			}
		});
		contentPane.add(myButton3);

		JButton myButton4 = new JButton("Quitter");
		myButton4.setForeground(Color.RED);
		myButton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// Classe anonyme
				int clickedButton = JOptionPane.showConfirmDialog(FenetreMenu.this, "Etes vous sur de quitter?",
						"Quitter", JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION)
					FenetreMenu.this.dispose();
			}
		});
		contentPane.add(myButton4);

		// S assure de vouloir quitter
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				int clickedButton = JOptionPane.showConfirmDialog(FenetreMenu.this, "Etes vous sur de quitter?",
						"Quitter", JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION)
					FenetreMenu.this.dispose();
			};
		});
	}
}
