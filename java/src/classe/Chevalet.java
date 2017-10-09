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
	
}
