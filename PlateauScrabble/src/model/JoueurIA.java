package model;

import java.util.ArrayList;

public class JoueurIA extends Joueur{

	String tabMot[];
	int difficulté;
	
	//-----------------------Getter-Setter------------------
	public String[] getTabMot() {
		return tabMot;
	}
	public void setTabMot(String[] tabMot) {
		this.tabMot = tabMot;
	}
	public int getDifficulté() {
		return difficulté;
	}
	public void setDifficulté(int difficulté) {
		this.difficulté = difficulté;
	}

	
//---------------------------Constructeur--------------------
	
	public JoueurIA(String nom, ArrayList<String> chevalet, int score, String[] tabMot, int difficulté) {
		super();
		this.tabMot = tabMot;
		this.difficulté = difficulté;
	}
	
//----------------------------Méthodes----------------------
	
	public void rechercheMot() {
		
	}
	
	public void gestionNiveau (int difficulté) {
		
	}
	
}
