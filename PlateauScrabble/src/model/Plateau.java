package model;

public class Plateau {

	static Case t[][] = new Case[15][15];

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

				} else {
					t[x][y] = new Case(Bonus.NORMAL, null);
				}
			}

		}
	}

	/**
	 * 
	 * @param c
	 *            mot entier
	 * @param i
	 *            RowIndex first letter
	 * @param j
	 *            ColumnIndex first letter
	 * @param i2
	 *            RowIndex last letter
	 * @param j2
	 *            ColumIndex last letter
	 * @return
	 */
	public boolean verificationEmplacementMot(Piece c[], int i, int j, int i2, int j2) {
		if (i == i2) {
			return motValideHorizontale(c, i, j, i2, j2);
		} else if (j == j2) {
			return motValideVertical(c, i, j, i2, j2);
		} else
			return false;
	}

	private boolean motValideHorizontale(Piece c[], int i, int j, int i2, int j2) {
		if (t[i][j - 1].getPiece() == null && t[i][j2 + 1].getPiece() == null) {
			for (int x = 0; x < c.length; x++) {
				if (c[x] != null) // Verif si la case du mot récuperer contient
									// une lettre
				{
					if (t[i][j + x].getPiece() != null && t[i - 1][j + x].getPiece() != null
							&& t[i + 1][j + x].getPiece() != null)// verifie la
																	// case,la
																	// case en
																	// haut et
																	// celle du
																	// bas
					{
						return false;
					}
				} else {
					if (t[i][j + x].getPiece() == null) {
						return false;
					}
				}
			}
		} else
			return false;

		return true;
	}

	private boolean motValideVertical(Piece c[], int i, int j, int i2, int j2) {
		if (t[i - 1][j].getPiece() == null && t[i2 + 1][j].getPiece() == null) {

			for (int x = 0; x < c.length; x++) {
				if (c[x] != null) // Verif si la case du mot récuperer contient
									// une lettre
				{
					if (t[i + x][j].getPiece() != null && t[i + x][j - 1].getPiece() != null
							&& t[i + x][j + 1].getPiece() != null)// verifie la
																	// case,la
																	// case en
																	// haut et
																	// celle du
																	// bas
					{
						return false;
					}

				} else {
					if (t[i + x][j].getPiece() == null) {
						return false;
					}
				}
			}
		} else
			return false;

		return true;
	}

	public int score_horizontal(Piece mot[], int i1, int j1, int j2) {

		int iteration_mot_double = 0, iteration_mot_triple = 0, score = 0;
		int c = 0;

		for (int y = j1; y <= j2; y++) {

			switch (t[i1][y].getBonus()) {

			case NORMAL: {
				score += mot[c].getPoint();
				break;
			}

			case MOT_DOUBLE: {
				score += mot[c].getPoint();
				iteration_mot_double += 2;
				break;
			}

			case MOT_TRIPLE: {
				score += mot[c].getPoint();
				iteration_mot_triple += 3;
				break;
			}

			case LETTRE_DOUBLE: {
				score += mot[c].getPoint() * 2;
				break;
			}

			case LETTRE_TRIPLE: {
				score += mot[c].getPoint() * 3;
				break;
			}

			}
			System.out.println("scoreF :"+score);
			c++;
		}
		if (iteration_mot_double != 0)
			score *= iteration_mot_double;
		if (iteration_mot_triple != 0)
			score *= iteration_mot_triple;

		return score;
	}

	public int score_vertical(Piece mot[], int i1, int j1, int i2) {

		int iteration_mot_double = 0, iteration_mot_triple = 0, score = 0;
		int c = 0;
		// calcule score normal

		for (int y = i1; y <= i2; y++) {

			switch (t[y][j1].getBonus()) {

			case NORMAL: {
				score += mot[c].getPoint();
				break;
			}

			case MOT_DOUBLE: {
				score += mot[c].getPoint();
				iteration_mot_double += 2;
				break;
			}

			case MOT_TRIPLE: {
				score += mot[c].getPoint();
				iteration_mot_triple += 3;
				break;
			}

			case LETTRE_DOUBLE: {
				score += mot[c].getPoint() * 2;
				break;
			}

			case LETTRE_TRIPLE: {
				score += mot[c].getPoint() * 3;
				break;
			}

			}
			c++;
		}
		if (iteration_mot_double != 0)
			score *= iteration_mot_double;
		if (iteration_mot_triple != 0)
			score *= iteration_mot_triple;

		return score;
	}

	public int score(Piece mot[], int i1, int j1, int i2, int j2) {
		if (i1 == i2) {
			System.out.println("scoreH");
			return (score_horizontal(mot, i1, j1, j2));
		}
		if (j1 == j2) {
			System.out.println("scoreV");
			return (score_vertical(mot, i1, j1, i2));
		}
		return 0;
	}

}