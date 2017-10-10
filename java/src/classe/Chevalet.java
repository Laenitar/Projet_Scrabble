package classe;

import itf.Chevalet_Itf;

public class Chevalet implements Chevalet_Itf {

	private Piece[] chevalet = new Piece[7];

	public Piece[] getChevalet() {
		return chevalet;
	}

	public void setChevalet(Piece[] chevalet) {
		this.chevalet = chevalet;
	}
	
	public void echange(int p1, int p2)
	{
		Piece a = new Piece(chevalet[p2]);
		chevalet[p2] = chevalet[p1];
		chevalet[p1] = a;
	}

	public boolean getChevaletVoid() {
		// TODO Auto-generated method stub
		return chevalet.length == 0;
	}
	
}
