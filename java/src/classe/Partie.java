package classe;

import itf.Partie_Itf;

public class Partie implements Partie_Itf{

	Joueur[] tab_Joueur;
	Plateau plateau;
	Pioche pioche;
	ArbreLexicographique dictionnaire;
	
	public Partie(Joueur[] tab_Joueur) {
		super();
		this.tab_Joueur = tab_Joueur;
		this.plateau = new Plateau();
		this.pioche = new Pioche();
		this.dictionnaire = new ArbreLexicographique();
	}
	
	public void tourUnJoueur(Joueur j)
	{
		//TODO
		//Place un mot ou demande d'aide
		//Vérification sur le plateau
		//Placement du mot sur le plateau
		//Calcule du score et modification
		//Pioche
		//Fin de tour
	}
	
	public void tourDeJeu()
	{
		for (Joueur j : tab_Joueur)
		{
			tourUnJoueur(j);
			if (finPartie(j)) break;
		}
	}
	
	public boolean finPartie(Joueur j)
	{
		if (j.getChevalet() == null && pioche.getStackVoid())
			return false;
		else
			return true;
	}
	
}
