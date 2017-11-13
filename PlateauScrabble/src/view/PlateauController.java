package view;

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
import main.Main;

public class PlateauController {

	// Label du chevalet
	@FXML
	private Label lettre1, lettre2, lettre3, lettre4, lettre5, lettre6, lettre7;
	// Label du score
	@FXML
	Label score;
	// Label du plateau
	@FXML
	private Label case1, case2, case3, case4, case5, case6, case7, case8, case9, case10, case11, case12, case13, case14,
			case15, case16, case17, case18, case19, case20, case21, case22, case23, case24, case25, case26, case27,
			case28, case29, case30, case31, case32, case33, case34, case35, case36, case37, case38, case39, case40,
			case41, case42, case43, case44, case45, case46, case47, case48, case49, case50, case51, case52, case53,
			case54, case55, case56, case57, case58, case59, case60, case61, case62, case63, case64, case65, case66,
			case67, case68, case69, case70, case71, case72, case73, case74, case75, case76, case77, case78, case79,
			case80, case81, case82, case83, case84, case85, case86, case87, case88, case89, case90, case91, case92,
			case93, case94, case95, case96, case97, case98, case99, case100, case101, case102, case103, case104,
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
	// Tableau du chevalet
	@FXML
	private GridPane chevalet;

	// Reference à l'application principale
	private Main mainApp;

	// Etat de la partie
	static boolean partie = false;
	// Etat du tour du joueur
	static boolean tourJoueur = false;
	// Etat du dragEvent
	static boolean success = false;

	public PlateauController() {

	}

	/**
	 * Initialise la class PlateauController, est chargée automatiquement après que
	 * le FXML soit chargé
	 */
	@FXML
	private void initialize() {
		// Affiche l'image plateau
		Image img = new Image("/imgView/plateau.png");
		BackgroundSize bs = new BackgroundSize(plateau.getWidth(), plateau.getHeight(), false, false, true, true);
		BackgroundImage myBI = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, bs);
		plateau.setBackground(new Background(myBI));

	}

	/**
	 * Est appelé par l'application principale pour lui donner une reference à elle
	 * meme
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Affiche le Chevalet au lancement de l'application
		//
		// L'initialise a null
		showChevalet(null);

	}

	/**
	 * Rempli le chevalet Null au lancement de l'application
	 * 
	 * @param ch
	 */
	private void showChevalet(String[] ch) {
		BackgroundFill bf = new BackgroundFill(Color.rgb(255, 255, 100), CornerRadii.EMPTY, Insets.EMPTY);
		Background bg = new Background(bf);
		if (ch != null) {
			lettre1.setText(mainApp.getChevalet()[0]);
			lettre2.setText(mainApp.getChevalet()[1]);
			lettre3.setText(mainApp.getChevalet()[2]);
			lettre4.setText(mainApp.getChevalet()[3]);
			lettre5.setText(mainApp.getChevalet()[4]);
			lettre6.setText(mainApp.getChevalet()[5]);
			lettre7.setText(mainApp.getChevalet()[6]);

			lettre1.setBackground(bg);
			lettre2.setBackground(bg);
			lettre3.setBackground(bg);
			lettre4.setBackground(bg);
			lettre5.setBackground(bg);
			lettre6.setBackground(bg);
			lettre7.setBackground(bg);
		} else {
			lettre1.setText(null);
			lettre2.setText(null);
			lettre3.setText(null);
			lettre4.setText(null);
			lettre5.setText(null);
			lettre6.setText(null);
			lettre7.setText(null);
		}
	}

	/**
	 * Appeler quand le joueur appuie sur Nouvelle Partie Initialise la grille vide
	 * et le chevalet avec 7 lettres
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
		} else
			showChevalet(mainApp.getChevalet());
		partie = true;
		tourJoueur = true;
	}

	/**
	 * Drag est detecte, commence la gestion du drag & drop
	 * 
	 * @param event
	 */
	@FXML
	public void onDrag(MouseEvent event) {

		// System.out.println("onDragDetected");
		Label source = (Label) event.getSource();

		/* Autorise n'importe quel mode de transfert */
		Dragboard db = source.startDragAndDrop(TransferMode.ANY);

		/* Recupere le text de la source du drag & drop */
		ClipboardContent content = new ClipboardContent();
		System.out.print(source.getText());
		content.putString(source.getText());
		db.setContent(content);

		event.consume();
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
			// accepte le drag seulement si :
			// la source contient un string
			// et que le tour actuel est celui du joueur
			// event.getGestureSource() != target &&
			if (event.getDragboard().hasString() && tourJoueur) {

				// Autorise le deplacement
				event.acceptTransferModes(TransferMode.MOVE);
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
		System.out.println("onDragEntered");
		try {
			// Label target = (Label) event.getGestureTarget();
			Label t = (Label) event.getTarget();
			/* show to the user that it is an actual gesture target */
			if (event.getDragboard().hasString() && t.getText() == "") {
				BackgroundFill bf = new BackgroundFill(Color.rgb(17, 119, 255), CornerRadii.EMPTY, Insets.EMPTY);
				Background bg = new Background(bf);
				t.setBackground(bg);
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
			System.out.println("onDragExited");
			Label t = (Label) event.getTarget();

			// Enleve le fond si le coup n'a pas ete joue
			// et si la case est vide
			if (!success && t.getText() == "") {
				BackgroundFill bf = new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY);
				Background bg = new Background(bf);
				t.setBackground(bg);
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
		System.out.println("onDragDropped");
		try {
			Label t = (Label) event.getTarget();
			Label target = (Label) event.getGestureTarget();

			Dragboard db = event.getDragboard();

			if (db.hasString() && target.getText() == "") {
				target.setText(db.getString());

				// Change le fond d'une case avec une lettre
				System.out.println("Fond");
				BackgroundFill bf = new BackgroundFill(Color.rgb(255, 255, 100), CornerRadii.EMPTY, Insets.EMPTY);
				Background bg = new Background(bf);
				t.setBackground(bg);
				target.setBackground(bg);

				success = true;
			}

			// Specifie a la source que le drop a ete complete
			event.setDropCompleted(success);
		} catch (Exception e) {
			e.printStackTrace();
		}

		event.consume();
	}

	/**
	 * A la fin du drag&drop Si le drop a ete complete enlever la lettre du chevalet
	 * 
	 * @param event
	 */
	@FXML
	public void onDragDone(DragEvent event) {
		/* the drag-and-drop gesture ended */
		Label source = (Label) event.getGestureSource();

		System.out.println("onDragDone");
		/* si le string a ete utilise, l'effacer */
		if (event.getTransferMode() == TransferMode.MOVE && success) {
			source.setText("");
			BackgroundFill bf = new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(bf);
			source.setBackground(bg);
			success = false;
		}

		event.consume();
	}

	/**
	 * Specifie la fin du tour Joueur Affiche un warning si le chevalet est plein
	 * (le joueur doit jouer un mot)
	 */
	public void handleFinTour() {
		boolean vide = false;
		// Verifie si le chevalet est plein
		for (int i = 0; i < 7; i++) {
			Label l = (Label) chevalet.getChildren().get(i);
			if (l.getText() == "") {
				vide = true;
			}
		}
		// Si au moins une case du chevalet est vide
		// Afficher un warning
		if (!vide) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Partie en cours");
			alert.setHeaderText("Votre chevalet est plein");
			alert.setContentText(
					"Pour finir votre tour, vous devez jouer un mot.\nPour echanger des lettres, veuillez cliquez sur le \nbouton \"Echanger des lettres\"");

			alert.showAndWait();
			// Sinon fin du tour
		} else
			tourJoueur = false;
	}
}
