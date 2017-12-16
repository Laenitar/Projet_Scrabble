package view;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import main.Label2;
import main.Main;
import model.ArbreLexicographique;
import model.JoueurReel;
import model.Piece;
import model.Plateau;

public class PlateauController {

	// Dictionnaire et recherche
	ArbreLexicographique a = new ArbreLexicographique();
	// Label du chevalet
	@FXML
	private Label lettre1, lettre2, lettre3, lettre4, lettre5, lettre6, lettre7, lettre11, lettre12, lettre13, lettre14,
			lettre15, lettre16, lettre17;
	// Label du score
	@FXML
	Label score1, score2, lscore1, lscore2, tour;
	private int scoreJ1, scoreJ2;
	// Label du plateau
	@FXML
	private Label2 case1, case2, case3, case4, case5, case6, case7, case8, case9, case10, case11, case12, case13,
			case14, case15, case16, case17, case18, case19, case20, case21, case22, case23, case24, case25, case26,
			case27, case28, case29, case30, case31, case32, case33, case34, case35, case36, case37, case38, case39,
			case40, case41, case42, case43, case44, case45, case46, case47, case48, case49, case50, case51, case52,
			case53, case54, case55, case56, case57, case58, case59, case60, case61, case62, case63, case64, case65,
			case66, case67, case68, case69, case70, case71, case72, case73, case74, case75, case76, case77, case78,
			case79, case80, case81, case82, case83, case84, case85, case86, case87, case88, case89, case90, case91,
			case92, case93, case94, case95, case96, case97, case98, case99, case100, case101, case102, case103, case104,
			case105, case106, case107, case108, case109, case110, case111, case112, case113, case114, case115, case116,
			case117, case118, case119, case120, case121, case122, case123, case124, case125, case126, case127, case128,
			case129, case130, case131, case132, case133, case134, case135, case136, case137, case138, case139, case140,
			case141, case142, case143, case144, case145, case146, case147, case148, case149, case150, case151, case152,
			case153, case154, case155, case156, case157, case158, case159, case160, case161, case162, case163, case164,
			case165, case166, case167, case168, case169, case170, case171, case172, case173, case174, case175, case176,
			case177, case178, case179, case180, case181, case182, case183, case184, case185, case186, case187, case188,
			case189, case190, case191, case192, case193, case194, case195, case196, case197, case198, case199, case200,
			case201, case202, case203, case204, case205, case206, case207, case208, case209, case210, case211, case212,
			case213, case214, case215, case216, case217, case218, case219, case220, case221, case222, case223, case224,
			case225;
	// Tableau du plateau
	@FXML
	private GridPane plateau;
	// Reference de la grille de jeu
	private Plateau p = new Plateau();
	// Tableau du chevalet
	@FXML
	private GridPane chevalet1, chevalet2;

	// Reference à l'application principale
	private Main mainApp;

	// Etat de la partie
	static boolean partie = false;
	// Etat du tour du joueur
	static public boolean tourJoueur1 = false;
	static public boolean tourJoueur2 = false;
	// Etat du dragEvent
	static boolean success = false;

	public PlateauController() {

	}

	/**
	 * Initialise la class PlateauController, est chargée automatiquement
	 * après que le FXML soit chargé
	 */
	@FXML
	private void initialize() {
		// Affiche l'image plateau
		Image img = new Image("/imgView/plateau.png");
		BackgroundSize bs = new BackgroundSize(plateau.getWidth(), plateau.getHeight(), false, false, true, true);
		BackgroundImage myBI = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, bs);
		plateau.setBackground(new Background(myBI));
		score1.setVisible(false);
		score2.setVisible(false);
		lscore1.setVisible(false);
		lscore2.setVisible(false);

	}

	/**
	 * Est appelé par l'application principale pour lui donner une reference à
	 * elle meme
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Affiche le Chevalet au lancement de l'application
		//
		// L'initialise a null
		showChevalet(chevalet1);
		showChevalet(chevalet2);

	}

	/**
	 * Rempli le chevalet Null au lancement de l'application
	 * 
	 * @param ch
	 */
	private void showChevalet(GridPane c) {
		BackgroundFill bf = new BackgroundFill(Color.rgb(255, 255, 100), CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);

		JoueurReel j = mainApp.getJoueurReel();
		if (j != null) {
			for (int i = 0; i < 7; i++) {
				Label2 l = (Label2) c.getChildren().get(i);
				l.setText(j.getChevalet().getChevalet()[i].getLettre());
				l.setBackground(bg);

			}
		} else {
			for (int i = 0; i < 7; i++) {
				Label2 l = (Label2) c.getChildren().get(i);
				l.setText("");
			}
		}

	}

	/**
	 * Appeler quand le joueur appuie sur Nouvelle Partie Initialise la grille
	 * vide et le chevalet avec 7 lettres
	 */
	@FXML
	private void handleNewGame() {

		// Si la partie est deja lancee
		if (partie) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Partie en cours");
			alert.setHeaderText("Partie deja en cours");
			alert.setContentText(
					"Vous avez deja une partie en cours. Veuillez finir votre partie avant d'en lancer une nouvelle");

			alert.showAndWait();
		} else {
			partie = true;
			tourJoueur2 = true;
			showChevalet(chevalet2);
			tourJoueur2 = false;
			tourJoueur1 = true;
			tourJoueur();
			showChevalet(chevalet1);
			showScore();
		}

	}

	/**
	 * Drag est detecte, commence la gestion du drag & drop
	 * 
	 * @param event
	 */
	@FXML
	public void onDrag(MouseEvent event) {

		// System.out.println("onDragDetected");
		Label2 source = (Label2) event.getSource();
		// System.out.println(source.getFixe());
		if (!source.getFixe()) {
			/* Autorise n'importe quel mode de transfert */
			Dragboard db = source.startDragAndDrop(TransferMode.ANY);

			/* Recupere le text de la source du drag & drop */
			ClipboardContent content = new ClipboardContent();
			// System.out.print(source.getText());
			content.putString(source.getText());
			db.setContent(content);

			event.consume();
		}
	}

	/**
	 * Drag & drop passe au dessus d'une cible Autorise le mode transfert
	 * deplacement
	 * 
	 * @param event
	 */
	@FXML
	public void onDragOver(DragEvent event) {
		// Donnee drag sur la cible
		// System.out.println("onDragOver");
		try {
			if (tourJoueur1 || tourJoueur2) {
				// accepte le drag seulement si :
				// la source contient un string
				// et que le tour actuel est celui du joueur
				// event.getGestureSource() != target &&
				if (event.getDragboard().hasString() && (tourJoueur1 || tourJoueur2)) {

					// Autorise le deplacement
					event.acceptTransferModes(TransferMode.MOVE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		event.consume();
	}

	/**
	 * Change le fond pour specifier une case jouable
	 * 
	 * @param event
	 */
	@FXML
	public void onDragEntered(DragEvent event) {
		/* the drag-and-drop gesture entered the target */
		// System.out.println("onDragEntered");
		try {
			if (tourJoueur1 || tourJoueur2) {
				// Label target = (Label) event.getGestureTarget();
				Label t = (Label) event.getTarget();
				/* show to the user that it is an actual gesture target */
				if (event.getDragboard().hasString() && t.getText() == "") {
					BackgroundFill bf = new BackgroundFill(Color.rgb(17, 119, 255), CornerRadii.EMPTY, Insets.EMPTY);
					Background bg = new Background(bf);
					t.setBackground(bg);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		event.consume();
	}

	/**
	 * Change le fond a la sortie du curseur
	 * 
	 * @param event
	 */
	public void onDragExited(DragEvent event) {
		try {
			if (tourJoueur1 || tourJoueur2) {
				// System.out.println("onDragExited");
				Label t = (Label) event.getTarget();

				// Enleve le fond si le coup n'a pas ete joue
				// et si la case est vide
				if (!success && t.getText() == "") {
					BackgroundFill bf = new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY);
					Background bg = new Background(bf);
					t.setBackground(bg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		event.consume();
	}

	/**
	 * Au drop, si il y a un string dans le dragboard, le lire et l'utiliser
	 * 
	 * @param event
	 */
	@FXML
	public void onDragDropped(DragEvent event) {
		/* data dropped */
		// System.out.println("onDragDropped");
		try {
			if (tourJoueur1 || tourJoueur2) {
				Label t = (Label) event.getTarget();
				Label target = (Label) event.getGestureTarget();

				Dragboard db = event.getDragboard();

				if (db.hasString() && target.getText() == "") {
					target.setText(db.getString());

					// Change le fond d'une case avec une lettre
					BackgroundFill bf = new BackgroundFill(Color.rgb(255, 255, 100), CornerRadii.EMPTY, Insets.EMPTY);
					Background bg = new Background(bf);
					t.setBackground(bg);
					target.setBackground(bg);

					success = true;
				}
			}
			// Specifie a la source que le drop a ete complete
			event.setDropCompleted(success);
		} catch (Exception e) {
			e.printStackTrace();
		}

		event.consume();
	}

	/**
	 * A la fin du drag&drop Si le drop a ete complete enlever la lettre du
	 * chevalet
	 * 
	 * @param event
	 */
	@FXML
	public void onDragDone(DragEvent event) {
		/* the drag-and-drop gesture ended */
		if (tourJoueur1 || tourJoueur2) {
			Label source = (Label) event.getGestureSource();

			// System.out.println("onDragDone");
			/* si le string a ete utilise, l'effacer */
			if (event.getTransferMode() == TransferMode.MOVE && success) {
				source.setText("");
				BackgroundFill bf = new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY);
				Background bg = new Background(bf);
				source.setBackground(bg);
				success = false;
			}
		}
		event.consume();
	}

	/**
	 * Specifie la fin du tour Joueur Affiche un warning si le chevalet est
	 * plein (le joueur doit jouer un mot)
	 */
	public void handleFinTour() {
		// Si aucune case du chevalet n'est vide
		// Afficher un warning
		if (!verifChevalet()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Partie en cours");
			alert.setHeaderText("Votre chevalet est plein");
			alert.setContentText(
					"Pour finir votre tour, vous devez jouer un mot.\nPour echanger des lettres, veuillez cliquez sur le \nbouton \"Echanger des lettres\"");

			alert.showAndWait();
		} else {
			// Si le mot est valide et dans le dictionnaire
			if (verifMotFinTour()) {
				// Pioche pour le prochain tour
				pioche();
				// Changement de tour
				tourJoueur1 = !tourJoueur1;
				tourJoueur2 = !tourJoueur2;
				fixeLettre();
				tourJoueur();

			} else { // Afficher un warning
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(mainApp.getPrimaryStage());
				alert.setTitle("Partie en cours");
				alert.setHeaderText("Le mot n'est pas correct");
				alert.setContentText("Pour finir votre tour, vous devez entrer un mot correct.\"");

				alert.showAndWait();
			}
		}
	}

	public boolean verifChevalet() {
		boolean vide = false;
		// Verifie si le chevalet est plein
		if (tourJoueur1)
			for (int i = 0; i < 7; i++) {
				Label l = (Label) chevalet1.getChildren().get(i);
				if (l.getText() == "") {
					vide = true;
				}
			}
		else if (tourJoueur2)
			for (int i = 0; i < 7; i++) {
				Label l = (Label) chevalet2.getChildren().get(i);
				if (l.getText() == "") {
					vide = true;
				}
			}

		return vide;
	}

	public boolean verifMotFinTour() {
		ArrayList<Label2> mot = new ArrayList<Label2>();
		for (int i = 0; i < 225; i++) {
			Label2 l = (Label2) plateau.getChildren().get(i);

			if (l.getText() != "" && !l.getFixe()) {
				mot.add(l);
			}

		}
		// si le mot ne contient pas de lettre ou une seule, return false;
		if (mot.size() < 2)
			return false;

		System.out.println("Mot: " + mot.toString());
		Piece tp[];

		if (isHorizontal(mot)) {
			int taille = (GridPane.getColumnIndex(mot.get(mot.size() - 1)) - GridPane.getColumnIndex(mot.get(0))) + 1;
			tp = new Piece[taille];
			int index = getIndex(GridPane.getRowIndex(mot.get(0)), GridPane.getColumnIndex(mot.get(0)));

			System.out.println("HORIZONTAL");
			for (int j = 0; j < taille; j++) {
				Label2 l1 = (Label2) plateau.getChildren().get(index + j);

				if (l1.getText() == "*")
					tp[j] = new Piece(l1.getText(), Main.getP().findScore(l1.getText()), true);
				else if (l1.getText() == "")
					return false;
				else{
					tp[j] = new Piece(l1.getText(), Main.getP().findScore(l1.getText()), false);
				}
			}
		} else if (isVertical(mot)) {
			int taille = (GridPane.getRowIndex(mot.get(mot.size() - 1)) - GridPane.getRowIndex(mot.get(0))) + 1;
			tp = new Piece[taille];
			int index = getIndex(GridPane.getRowIndex(mot.get(0)), GridPane.getColumnIndex(mot.get(0)));

			System.out.println("VERTICAL");
			for (int j = 0; j < taille; j++) {
				Label2 l1 = (Label2) plateau.getChildren().get(index + j * 15);

				if (l1.getText() == "*")
					tp[j] = new Piece(l1.getText(), Main.getP().findScore(l1.getText()), true);
				else if (l1.getText() == "")
					return false;
				else
					tp[j] = new Piece(l1.getText(), Main.getP().findScore(l1.getText()), false);

			}
		} else
			return false;

		// System.out.println("RETURN VERIF");
		if (p.verificationEmplacementMot(tp, GridPane.getRowIndex(mot.get(0)), GridPane.getColumnIndex(mot.get(0)),
				GridPane.getRowIndex(mot.get(mot.size() - 1)), GridPane.getColumnIndex(mot.get(mot.size() - 1)))) {
			if(a.existe(tabToString(tp)))
				calculScore(tp, GridPane.getRowIndex(mot.get(0)), GridPane.getColumnIndex(mot.get(0)),
						GridPane.getRowIndex(mot.get(mot.size() - 1)), GridPane.getColumnIndex(mot.get(mot.size() - 1)));
				return true;
		}

		return false;
	}

	/**
	 * 
	 * @param i
	 *            axe vertical (ligne)
	 * @param j
	 *            axe horizontal (colonne)
	 * @return
	 */
	public int getIndex(int i, int j) {
		int index = -1;
		for (int x = 0; x < 15; x++)
			for (int y = 0; y < 15; y++) {
				index++;
				if (x == i && y == j)
					return index;
			}

		return index;
	}

	public void pioche() {
		JoueurReel j = mainApp.getJoueurReel();
		j.pioche();
		showChevalet(chevalet1);
	}

	public void fixeLettre() {
		for (int i = 0; i < 225; i++) {
			Label2 l = (Label2) plateau.getChildren().get(i);
			if (l.getText() != "" && !l.getFixe()) {
				l.setFixe(true);
			}
		}
	}

	public String tabToString(Piece[] mot) {
		String s = new String();
		for (int i = 0; i < mot.length; i++)
			if (i == 0)
				s = mot[i].getLettre();
			else
				s = s + mot[i].getLettre();
		return s;
	}

	public boolean isVertical(ArrayList<Label2> mot) {
		Label2 l1 = mot.get(0);
		for (Label2 l : mot) {
			if (GridPane.getColumnIndex(l) == GridPane.getColumnIndex(l1))
				continue;
			else
				return false;
		}
		return true;
	}

	public boolean isHorizontal(ArrayList<Label2> mot) {
		Label2 l1 = mot.get(0);
		for (Label2 l : mot) {
			if (GridPane.getRowIndex(l) == GridPane.getRowIndex(l1))
				continue;
			else
				return false;
		}
		return true;
	}

	public void tourJoueur() {
		if (tourJoueur1) {
			tour.setText("Au tour du Joueur 1");
			for (int i = 0; i < 7; i++) {
				chevalet1.getChildren().get(i).setVisible(true);
				chevalet2.getChildren().get(i).setVisible(false);
			}
		} else if (tourJoueur2) {
			tour.setText("Au tour du Joueur 2");
			for (int i = 0; i < 7; i++) {
				chevalet1.getChildren().get(i).setVisible(false);
				chevalet2.getChildren().get(i).setVisible(true);
			}
		} else {
			tour.setText("En attente de partie");
		}
	}
	
	public void calculScore(Piece[] mot,int i, int j, int i2, int j2){
		int score = p.score(mot,i,j,i2,j2);
		System.out.println(score);
		if(tourJoueur1){
			scoreJ1 += score;
			score1.setText(String.valueOf(scoreJ1));
		}else if(tourJoueur2){
			scoreJ2 += score;
			score2.setText(String.valueOf(scoreJ2));
		}
	}

	public void showScore() {
		score1.setVisible(true);
		score2.setVisible(true);
		lscore1.setVisible(true);
		lscore2.setVisible(true);
	}
}
