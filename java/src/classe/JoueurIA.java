package classe;

import java.util.ArrayList;
import java.util.List;

public class JoueurIA extends Joueur {

	private String nom;
	private int difficulte;
	private static int nombreIa = 0;
	
	public JoueurIA(Chevalet chevalet, int score, int difficulte) {
		super(chevalet, score);
		nombreIa++;
		nom = "IA" + Integer.toString(nombreIa);
		this.difficulte = difficulte;
	}
	
	public Piece[] rechercheMeilleurCoup (Piece[][] tableau)
	{
		
		List<String> coupPossible = new ArrayList<String>();
		
		for (Piece[] mot : tableau)
		{
		}
		
		return null;
	}
	
	
}
