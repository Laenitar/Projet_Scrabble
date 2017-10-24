package classe;
import itf.Piece_Itf;

public class Piece implements Piece_Itf {

	String lettre;
	int point;
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
	

