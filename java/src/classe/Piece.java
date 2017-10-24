package classe;
import itf.Piece_Itf;

public class Piece implements Piece_Itf {

	String lettre;
	int point;
	boolean b;
	
	public Piece(String lettre, int point, boolean b) {
		super();
		this.lettre = lettre;
		this.point = point;
		this.b = b;
	}
	
	public String getLettre() {
		return lettre;
	}
	
	public int getPoint() {
		return point;
	}
	
	
	
	
}
