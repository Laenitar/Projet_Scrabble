package classe;
import itf.Piece_Itf;

public class Piece implements Piece_Itf {

	char lettre;
	int point;
	
	public Piece(char lettre, int point) {
		super();
		this.lettre = lettre;
		this.point = point;
	}
	
	public char getLettre() {
		return lettre;
	}
	
	public int getPoint() {
		return point;
	}
	
	
	
	
}
