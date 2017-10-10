package classe;

import itf.Joueur_Itf;

public abstract class Joueur implements Joueur_Itf {
	
	Chevalet chevalet;
	int score;
	
	public Joueur(Chevalet chevalet, int score) {
		super();
		this.chevalet = chevalet;
		this.score = score;
	}

}
