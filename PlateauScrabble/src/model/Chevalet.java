package model;

public class Chevalet  {

	private Piece[] chevalet = new Piece[7];

	public Piece[] getChevalet() {
		return chevalet;
	}

	public void setChevalet(Piece[] chevalet) {
		this.chevalet = chevalet;
	}
	
	public String[] conversionTab()
	{
		String[] tab = new String[5];
		
		for (int i = 0 ; i < chevalet.length ; i ++)
		{
			tab[i]= this.chevalet[i].getLettre();
		}
		return tab;
	}
	
	public int lenght()
	{
		return chevalet.length;
	}
	
	public void echange(int p1, int p2)
	{
		Piece a = new Piece(chevalet[p2]);
		chevalet[p2] = chevalet[p1];
		chevalet[p1] = a;
	}
	
	public boolean getChevaletVoid() {
		// TODO Auto-generated method stub
		return chevalet.length == 0;
	}
	
	public void affiche() {
		for(int i=0; i<7;i++)
			if (chevalet[i]!=null)
				System.out.print(chevalet[i].getLettre());
		
		
		
	}
	
}