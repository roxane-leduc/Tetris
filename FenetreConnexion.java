package tetris;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreConnexion extends JFrame {

	private static final long serialVersionUID = -6887532275396106292L;

	public FenetreConnexion() {
		super("Tetris");

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(Grille.getNCOLONNES() * Grille.TCELL, Grille.NLIGNES * Grille.TCELL);
		this.setLocationRelativeTo(null);

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		JTextField myLogin = new JTextField("Login");
		myLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField login = (JTextField) event.getSource();
				System.out.println("Tu as écrit : " + login.getText());
				// Joueur joueur = new Joueur(login.getText());
			}
		});

		contentPane.add(myLogin);

		JTextField myMdp = new JTextField("Mdp");
		myMdp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField mdp = (JTextField) event.getSource();
				System.out.println("Tu as écrit : " + mdp.getText());
			}
		});

		contentPane.add(myMdp);

	}

}