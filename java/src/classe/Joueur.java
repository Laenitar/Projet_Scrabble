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
	
	
	
	public void jouerUnMot (Plateau plateau , Piece[] mot , int i , int j , int i2 , int j2)
	{
		if (i == i2)
		{
			for (int x = 0 ; x <= mot.length ; x++)
			{
				if (mot[x] != null)
				plateau.tableau[i][j + x].piece = mot[x];
			}
		}
		else if (j == j2)
		{
			for (int x = 0 ; x <= mot.length ; x++)
			{
				if (mot[x] != null)
				plateau.tableau[i + x][j].piece = mot[x];
			}
		}
	}
	
	public void aide (ArbreLexicographique dico)
	{
		
	}

}
