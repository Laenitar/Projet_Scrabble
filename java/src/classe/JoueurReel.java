package classe;

public class JoueurReel extends Joueur {

	private String nom;

	public JoueurReel(String nom, Chevalet chevalet, int score, String nom2) {
		super(chevalet, score);
		nom = nom2;
	}
	
}
