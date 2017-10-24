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
	
<<<<<<< HEAD
=======
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

>>>>>>> 5ddfc0485806c0e29d4d67ec2f5a5f5802a7f94c
		
}
