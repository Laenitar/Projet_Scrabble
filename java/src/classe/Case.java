package classe;

import itf.Case_Itf;

public class Case implements Case_Itf{

	Boolean motDouble;
	Boolean motTriple;
	Boolean lettreDouble;
	Boolean lettreTriple;
	Piece piece;

	public Case(Boolean motDouble, Boolean motTriple, Boolean lettreDouble, Boolean lettreTriple, Piece piece) {
		super();
		this.motDouble = motDouble;
		this.motTriple = motTriple;
		this.lettreDouble = lettreDouble;
		this.lettreTriple = lettreTriple;
		this.piece = null;
	}
	
		
}
