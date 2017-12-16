package model;

public abstract class Joueur {

	protected Chevalet chevalet;
	int score;

	public Joueur(Chevalet chevalet, int score) {
		this.chevalet = chevalet;
		this.score = score;
	}

	public Joueur() {
		this.chevalet = new Chevalet();
		this.score=0;
		
	}
	public void jouerUnMot(Plateau plateau, Piece[] mot, int i, int j, int i2, int j2) {
		if (i == i2) {
			for (int x = 0; x <= mot.length; x++) {
				if (mot[x] != null)
					plateau.t[i][j + x].setPiece(mot[x]);
			}
		} else if (j == j2) {
			for (int x = 0; x <= mot.length; x++) {
				if (mot[x] != null)
					plateau.t[i + x][j].setPiece(mot[x]);
			}
		}
	}

	public void aide(ArbreLexicographique dico) {

	}
	
	public void pioche()
	{
		int i=0;
	
		while(i<7 && !Partie.p.getStackVoid())
		{
				if(this.chevalet.getChevalet()[i] == null)
				{
					{
						this.chevalet.getChevalet()[i] = Partie.p.getStack().firstElement();
						Partie.p.getStack().remove(Partie.p.getStack().firstElement());
						
					}
				}
			
		i++;
		}
	}
	
	
	public Chevalet getChevalet() {
		return this.chevalet;
	}

}