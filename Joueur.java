package tetris;

public class Joueur {

	private String login;

	public Joueur(String login){
		this.login = login;
	}

	public Joueur() {
		this.login = "";
	}

	public String getLogin(){
		return login;
	}

	public void setLogin(String login){
		this.login = login;
	}
	
}