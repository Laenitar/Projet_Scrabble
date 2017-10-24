package classe;
import itf.Piece_Itf;

public class Piece implements Piece_Itf {

	String lettre;
	int point;
<<<<<<< HEAD
	boolean joker;
	
	public Piece (Piece piece)
	{
		this.lettre=piece.getLettre();
		this.point=piece.getPoint();
		this.joker=piece.getJoket();
	}
	public Piece(String lettre, int point, boolean joker) {
		super();
		this.lettre = lettre;
		this.point = point;
		this.joker = joker;
	}
	
	
=======
	boolean b;
	
	public Piece(String lettre, int point, boolean b) {
		super();
		this.lettre = lettre;
		this.point = point;
		this.b = b;
	}
	
>>>>>>> 5ddfc0485806c0e29d4d67ec2f5a5f5802a7f94c
	public String getLettre() {
		return lettre;
	}
	
	public int getPoint() {
		return point;
	}
	
	public boolean getJoket()	{
		return joker;
	}
	
	}
	

