
package classe;

import itf.Plateau_Itf;
import java.util.Scanner;

public class Plateau implements Plateau_Itf {
	
	private Case t[][] = new Case[15][15];

	public Plateau() {

		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				// MOT TRIPLE
				if (x == 0 && y == 0 || x == 7 && y == 0 || x == 0 && y == 7 || x == 0 && y == 14 || x == 14 && y == 0
						|| x == 14 && y == 7 || x == 14 && y == 14 || x == 7 && y == 14) {

					t[x][y] = new Case(Bonus.MOT_TRIPLE, null);
				}
				// MOT DOUBLE
				else if (x == 1 && y == 1 || x == 2 && y == 2 || x == 3 && y == 3 || x == 4 && y == 4
						|| x == 13 && y == 1 || x == 12 && y == 2 || x == 11 && y == 3 || x == 10 && y == 4
						|| x == 1 && y == 13 || x == 2 && y == 12 || x == 3 && y == 11 || x == 4 && y == 10
						|| x == 13 && y == 13 || x == 12 && y == 12 || x == 11 && y == 11 || x == 10 && y == 10) {

					t[x][y] = new Case(Bonus.MOT_DOUBLE, null);
				}
				// LETTRE TRIPLE
				else if (x == 5 && y == 1 || x == 9 && y == 1 || x == 5 && y == 5 || x == 9 && y == 5
						|| x == 1 && y == 5 || x == 13 && y == 5 || x == 1 && y == 9 || x == 5 && y == 9
						|| x == 9 && y == 9 || x == 13 && y == 9 || x == 5 && y == 13 || x == 9 && y == 13) {

					t[x][y] = new Case(Bonus.LETTRE_TRIPLE, null);
				}
				// LETTRE DOUBLE
				else if ((x == 0 && (y == 33 || y == 11)) || (x == 2 && (y == 7 || y == 9))
						|| (x == 3 && (y == 0 || y == 7 || y == 14))
						|| (x == 6 && (y == 2 || y == 6 || y == 8 || y == 12)) || (x == 7 && (y == 3 || y == 11))
						|| (x == 8 && (y == 2 || y == 6 || y == 8 || y == 12))
						|| (x == 11 && (y == 0 || y == 7 || y == 14)) || (x == 12 && (y == 6 || y == 8))
						|| (x == 14 && (14 == 3 || y == 11))) {

					t[x][y] = new Case(Bonus.LETTRE_DOUBLE, null);

				}
			}

		}
	}

	
	@Override
	public boolean verificationEmplacementMot(Piece c[], int i, int j, int i2, int j2) {
		// TODO Auto-generated method stub
		if (i == i2)
		{
			return motValideHorizontale (c, i, j, i2, j2);
		}
		else if (j == j2)
		{
			return motValideVertical (c, i, j, i2, j2);
		}
		else	
			return false;
	}
	
	private boolean motValideHorizontale(Piece c[], int i, int j, int i2, int j2) 
	{
		if (t[i][j-1] != null && t[i][j2+1] != null)
		{
			for (int x = 0; x < c.length; x++) 
			{	
				if (c[x] != null) //Verif si la case du mot récuperer contient une lettre
				{
					if(t[i+x][j] == null && t[i+x][j-1] == null && t[i+x][j+1] == null)// verifie la case,la case en haut et celle du bas
					{
						return true;
					}
					else
					{
						return false;
					}
					
				}
				else
				{
					if (t[i+x][j] == null)
					{
						return false;
					}
				}
			}  
		}
		return false;
	}
	
	private boolean motValideVertical(Piece c[], int i, int j, int i2, int j2) 
	{
		if (t[i-1][j] != null && t[i2+1][j] != null)
		{
			for (int x = 0; x < c.length; x++) 
			{	
				if (c[x] != null) //Verif si la case du mot récuperer contient une lettre
				{
					if(t[i][j+x] == null && t[i-1][j+x] == null && t[i+1][j+x] == null)// verifie la case,la case en haut et celle du bas
					{
						return true;
					}
					else
					{
						return false;
					}
					
				}
				else
				{
					if (t[i][j+x] == null)
					{
						return false;
					}
				}
			}  
		}
		return false;
	}


}
