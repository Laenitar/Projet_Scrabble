package itf;

import classe.Piece;
import classe.TableauLettreDisponible;

public interface Pioche_Itf {

	public Piece_Itf[] tirage(Joueur_Itf j);
	
	public Piece[] start(TableauLettreDisponible t);
	
}
