package classe;

public class Noeud {

	private char lettre;
	private boolean mot;
	private int niveau;
	private Noeud[] fils;
	
	public Noeud(char l, boolean m, int n, Noeud[] f) {
		lettre =l;
		mot=m;
		niveau=n;
		fils=f;
	}
	
	public Noeud[] getFils() {
		return fils;
	}
	
	public void setFils(Noeud[] fils) {
		this.fils = fils;
	}
	
	public char getLettre() {
		return lettre;
	}
	
	public void setLettre(char l) {
		lettre=l;
	}
	
	public boolean isMot() {
		return mot;
	}
	
	public void setMot(boolean m) {
		mot = m;
	}
	
	public int getNiveau() {
		return niveau;
	}
	
	public void setNiveau(int n) {
		niveau=n;
	}
}
