package classe;

import itf.Case_Itf;

public class Case implements Case_Itf{

	private Bonus bonus;
	private Piece piece;

	public Case(Bonus bonus, Piece piece) {
		super();
		this.bonus = bonus;
		this.piece = null;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public Piece getPiece() {
		return piece;
	}
	
}
