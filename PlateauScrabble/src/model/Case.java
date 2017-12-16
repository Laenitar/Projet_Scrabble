package model;

public class Case {

	private Bonus bonus;
	private Piece piece;

	public Case(Bonus bonus, Piece piece) {
		super();
		this.bonus = bonus;
		this.setPiece(null);
	}

	public Bonus getBonus() {
		return bonus;
	}

	public Piece getPiece() {
		return this.piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}

