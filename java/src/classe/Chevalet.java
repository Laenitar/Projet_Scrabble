package classe;

import itf.Chevalet_Itf;

public class Chevalet implements Chevalet_Itf {

	private Piece[] chevalet = new Piece[7];

	
	public String[] conversionTab()
	{
		String[] tab = new String[5];
		
		for (int i = 0 ; i < chevalet.length ; i ++)
		{
			tab[i]= this.chevalet[i].getLettre();
		}
		return tab;
	}
	
	public boolean getChevaletVoid() {
		// TODO Auto-generated method stub
		return chevalet.length == 0;
	}

	public Piece[] getChevalet() {
		return chevalet;
	}

	public void setChevalet(Piece[] chevalet) {
		this.chevalet = chevalet;
	}
	
	public int getLenghtChevalet()
	{
		return chevalet.length;
	}
}
