package model;

import java.util.ArrayList;

public class JoueurIA extends Joueur{

	String tabMot[];
	int difficult�;
	
	//-----------------------Getter-Setter------------------
	public String[] getTabMot() {
		return tabMot;
	}
	public void setTabMot(String[] tabMot) {
		this.tabMot = tabMot;
	}
	public int getDifficult�() {
		return difficult�;
	}
	public void setDifficult�(int difficult�) {
		this.difficult� = difficult�;
	}

	
//---------------------------Constructeur--------------------
	
	public JoueurIA(String nom, ArrayList<String> chevalet, int score, String[] tabMot, int difficult�) {
		super();
		this.tabMot = tabMot;
		this.difficult� = difficult�;
	}
	
//----------------------------M�thodes----------------------
	
	public void rechercheMot() {
		
	}
	
	public void gestionNiveau (int difficult�) {
		
	}
	
}
