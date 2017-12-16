package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Anagramme {

	protected ArbreLexicographique abr;

	Anagramme() {
		this.abr = new ArbreLexicographique();
	}

	public static ArrayList<String> generer(ArrayList<String> t) {
 
		
		String racine;
		ArrayList<String> ch = new ArrayList<String>();
		ArrayList<String> h = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		LinkedList<String> ret = new LinkedList<String>();
		int i, a;
		if (t.size() == 1) {

			return t;
		} else {

			for (i = 0; i < t.size(); i++) {
				racine = t.get(i);
				if (ret.indexOf(racine) >= 0) {

				} else {
					ret.add(racine);
					h.clear();
					h.addAll(t);

					try {
						h.remove(i);
					} catch (Exception e) {
						System.out.println(e.getMessage() + t.size());
					}
					a = result.size();
					ch = generer(h);
					result.addAll(ch);

					for (int j = a; j < result.size(); j++) {

						result.set(j, racine + result.get(j));

					}
				}
			}
			return result;
		}
	}

	public ArrayList<String> generer1(Chevalet c) {
		ArrayList<String> t = new ArrayList<String>();
		for(int i=0; i<7;i++ ) 
		{
			System.out.print(i);
			if(c.getChevalet()[i] != null)
				t.add(c.getChevalet()[i].getLettre());
		}
		System.out.print("salut");
		for(int j=0; j<7; j++)
			System.out.print(t.get(j));
		
		return analyse(t);
	}
	public ArrayList<String> analyse(ArrayList<String> mot) {

		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> mot_valide = new ArrayList<String>();
		
		result = generer(mot);

		if (!result.isEmpty()) {
			System.out.println(result.size());

			for (int i = 0; i < result.size(); i++) {
				
				System.out.println(result.get(i));
				String s = result.get(i);
				if(abr.existe(s))
					
					mot_valide.add(s);
				
				

			}
		}
		return (mot_valide);
	}
	
	

	
}