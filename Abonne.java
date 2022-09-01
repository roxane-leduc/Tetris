package tetris;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Abonne extends Joueur {

	private String mdp;
	private int record;

	public Abonne(String login, String mdp, int record) {
		super(login);
		this.mdp = mdp;
		this.record = record;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		if (this.record < record) {
			this.record = record;
		}
	}

	public void charger() throws IOException {
		final File inFile = new File(getLogin() + ".txt");
		final FileReader freader = new FileReader(inFile);
		final BufferedReader br = new BufferedReader(freader);
		
		mdp = br.readLine();
		//record = br.readLine().; 
		br.close();

	}

	public void enregistrer(String fichier) throws IOException {
		final File outFile = new File(fichier);
		final Writer writer = new FileWriter(outFile);
		final BufferedWriter bw = new BufferedWriter(writer);
		
		bw.write(getLogin());
		bw.write("\n");
		bw.write(mdp);
		bw.write("\n");
		bw.write(record);
		bw.write("\n");
		bw.close();
	}

}
