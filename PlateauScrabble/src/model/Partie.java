package model;

import java.util.ArrayList;

public class Partie {

	static Pioche p = new Pioche();

	public Partie() {
		// TODO Auto-generated constructor stub
		p = new Pioche();
	}

	public static void main(String[] args) {
		Anagramme an = new Anagramme();
		ArrayList<String> po = new ArrayList<String>();

		// po.add("p");
		// po.add("a");
		// po.add("t");
		// po.add("e");
		// po.add("s");
		JoueurReel j = new JoueurReel("Mouad");
		j.pioche();
		j.getChevalet().affiche();
		System.out.print("\n");
		po = an.generer1(j.getChevalet());
		

		ArrayList<String> pan = new ArrayList<String>();
		pan = an.analyse(po);
		System.out.println("Mot(s) valide(s): "+po.isEmpty());
		
		for (String s : po) {
			System.out.println("_"+s);
		}

	}
}
