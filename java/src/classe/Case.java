package classe;

import itf.Case_Itf;

public class Case implements Case_Itf{

	private Bonus bonus;
	private Piece piece;
	private boolean	fixer;

	public Case(Bonus bonus, Piece piece) {
		super();
		this.bonus = bonus;
		this.piece = null;
		fixer = false;
	}

	public boolean getFixer() {
		return fixer;
	}

	public void setFixer(boolean fixer) {
		this.fixer = fixer;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece p)
	{
		this.piece = p;
	}
	
}
