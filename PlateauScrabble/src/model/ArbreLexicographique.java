package model;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ArbreLexicographique {

	private Noeud courant;
	private Noeud tete;
	private char lettre;

	public ArbreLexicographique() {
		Noeud[] fils = new Noeud[30];
		this.tete = new Noeud('\u0000', false, 1, fils);
		this.courant = tete;
		// this.remplirArbre("../dico");
		this.remplirArbre("./src/dico/dico.txt");
	}

	private void toutLesMotsPossibles(Chevalet chevalet) {
		for (int i = 1; i <= chevalet.lenght(); i++)
			generer(i, "", chevalet.lenght());
	}

	private void generer(int loop, String sb, int taille) {
		if (sb.length() >= loop) {
			System.out.println(sb);
			return;
		}
		for (int i = 0; i < taille; i++) {
			// TODO
			// a revoir pour afficher tout les mots et initialiser "tab"
			// generer(loop, sb + tab.charAt(i));
		}
	}

	private void ajouterMot(String mot) {
		int i, nbFils;
		// System.out.println(mot);

		if (mot.equals("")) {
			courant.setMot(true);
			this.courant = tete;
		} else {
			lettre = mot.charAt(0);
		}

		if (possedeFils(this.courant.getFils(), this.lettre)) {
			i = chercherIndiceFils(this.courant.getFils(), this.lettre);
			this.courant = this.courant.getFils()[i];
			// System.out.println(mot);

			if (mot.equals("")) {
				courant.setMot(true);
				this.courant = tete;
			} else {
				mot = mot.substring(1, mot.length());
				ajouterMot(mot);
			}
		} else {
			nbFils = nbFils(this.courant.getFils());
			Noeud[] fils = new Noeud[30];
			this.courant.getFils()[nbFils] = new Noeud(lettre, false, this.courant.getNiveau() + 1, fils);
			i = chercherIndiceFils(this.courant.getFils(), lettre);
			this.courant = this.courant.getFils()[i];

			if (mot.equals("")) {
				courant.setMot(true);
				this.courant = tete;
			} else {
				mot = mot.substring(1, mot.length());
				ajouterMot(mot);
			}
		}
	}

	public boolean existe(String mot) {
		if (mot.equals("") || mot.isEmpty()) {
			System.out.println("Le mot de base est vide");
			return false;
		} else
			return this.existe2(mot.toUpperCase(), this.tete);
	}

	protected boolean existe2(String mot, Noeud courant) {

		if (mot.equals("") && courant.isMot()) {
		
			return true;
		} else {

			if (courant.getFils() != null) {
				for (int i = 0; i < courant.getFils().length; i++) {
					if (courant.getFils()[i] == null)
						continue;

					if (!mot.isEmpty())
						if (courant.getFils()[i].getLettre() == mot.charAt(0)) {
							// courant = courant.getFils()[i];
							return this.existe2(mot.substring(1, mot.length()), courant.getFils()[i]);

						}
				}
			}
		}
		//System.out.println("On a pas trouv� : false");
		return false;
	}

	private boolean possedeFils(Noeud[] fils, char c) {
		int i;
		boolean bool = false;

		for (i = 0; i < fils.length; i++) {
			if (fils[i] == null) {
				continue;
			} else if (fils[i].getLettre() == c) {
				bool = true;

			}
		}
		return bool;
	}

	private int chercherIndiceFils(Noeud[] fils, char c) {
		int i, j;
		j = 0;

		for (i = 0; i < fils.length; i++) {
			if (fils[i] == null) {
				continue;
			} else if (fils[i].getLettre() == c) {
				j = i;
			}
		}
		return j;
	}

	private int nbFils(Noeud[] fils) {
		int i, cpt;
		cpt = 0;

		for (i = 0; i < fils.length; i++) {
			if (fils[i] != null) {
				cpt++;
			}
		}
		return cpt;
	}

	private void remplirArbre(String fichier) {

		try {

			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;

			while ((ligne = br.readLine()) != null) {
				this.ajouterMot(ligne);

			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Noeud getCourant() {
		return courant;
	}

	public void setCourant(Noeud courant) {
		this.courant = courant;
	}

	public Noeud getTete() {
		return tete;
	}

	public void setTete(Noeud tete) {
		this.tete = tete;
	}

	public char getLettre() {
		return lettre;
	}

	public void setLettre(char lettre) {
		this.lettre = lettre;
	}

}