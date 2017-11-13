package classe;

import itf.Joueur_Itf;

public abstract class Joueur implements Joueur_Itf {
	
	protected Chevalet chevalet;
	protected int score;
	
	public Joueur(Chevalet chevalet, int score) {
		super();
		this.chevalet = chevalet;
		this.score = score;
	}
	

/*	private void jouerUnMot (Plateau plateau , Piece[] mot , int i , int j , int i2 , int j2)
	{
		if (i == i2)
		{
			for (int x = 0 ; x <= mot.length ; x++)
			{
				if (mot[x] != null)
				plateau.t[i][j + x].piece = mot[x];
			}
		}
		else if (j == j2)
		{
			for (int x = 0 ; x <= mot.length ; x++)
			{
				if (mot[x] != null)
				plateau.t[i + x][j].piece = mot[x];
			}
		}
	}*/
	
	public void aide (ArbreLexicographique dico)
	{
		
	}


	public Chevalet getChevalet() {
		return chevalet;
	}
	
	public void setChevalet(Chevalet chevalet) {
		this.chevalet = chevalet;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	

}
