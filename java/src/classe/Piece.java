package classe;
import itf.Piece_Itf;

public class Piece implements Piece_Itf {

	private String lettre;
	private int point;
	private boolean joker;
	//vientDetrePose
	
	public Piece(String lettre, int point, boolean joker) {
	
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
	

