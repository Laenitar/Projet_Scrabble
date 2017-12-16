package model;

public class Piece  {

	private String lettre;
	private int point;
	private boolean joker;
	
	public Piece (Piece piece)
	{
		this.lettre=piece.getLettre();
		this.point=piece.getPoint();
		this.joker=piece.getJoker();
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
	
	public boolean getJoker()	{
		return joker;
	}
	
	}
	
