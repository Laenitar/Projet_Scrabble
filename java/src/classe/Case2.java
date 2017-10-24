package classe;

import itf.Case_Itf;

public class Case implements Case_Itf{

	Boolean MotDouble;
	Boolean MotTriple;
	Boolean LettreDouble;
	Boolean LettreTriple;
	
	Piece piece = null;
	ArrayList<String> motH = new ArrayList<String>();
	
		public Case(boolean motDouble, boolean motTriple, boolean lettreDouble, boolean lettreTriple, Piece piece) {
		super();
		this.motDouble = motDouble;
		this.motTriple = motTriple;
		this.lettreDouble = lettreDouble;
		this.lettreTriple = lettreTriple;
		this.piece = piece;
	}

		
}
