package model;

public class JoueurReel extends Joueur {

	private String nom;

	public JoueurReel(String nom, Chevalet chevalet, int score) {
		super(chevalet, score);
		this.nom = nom;
	}
	
	public JoueurReel(String nom) {
		this.nom = nom;
	}
	
}