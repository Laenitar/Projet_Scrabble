package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
import javafx.scene.text.Text;
import main.Main;

public class PlateauController {

	static String s;

	@FXML
	private Label lettre1,lettre2,lettre3,lettre4,lettre5,lettre6,lettre7;
	
	private Label testGetLabel;
	@FXML
	private Label case1,case2,case3,case4,case5,case6,case7,case8,case9,case10,case11,case12,case13,case14,case15,case16,case17,case18,case19,case20,case21,case22,case23,case24,case25,case26,case27,case28,case29,case30,case31,case32,case33,case34,case35,case36,case37,case38,case39,case40,case41,case42,case43,case44,case45,case46,case47,case48,case49,case50,case51,case52,case53,case54,case55,case56,case57,case58,case59,case60,case61,case62,case63,case64,case65,case66,case67,case68,case69,case70,case71,case72,case73,case74,case75,case76,case77,case78,case79,case80,case81,case82,case83,case84,case85,case86,case87,case88,case89,case90,case91,case92,case93,case94,case95,case96,case97,case98,case99,case100,case101,case102,case103,case104,case105,case106,case107,case108,case109,case110,case111,case112,case113,case114,case115,case116,case117,case118,case119,case120,case121,case122,case123,case124,case125,case126,case127,case128,case129,case130,case131,case132,case133,case134,case135,case136,case137,case138,case139,case140,case141,case142,case143,case144,case145,case146,case147,case148,case149,case150,case151,case152,case153,case154,case155,case156,case157,case158,case159,case160,case161,case162,case163,case164,case165,case166,case167,case168,case169,case170,case171,case172,case173,case174,case175,case176,case177,case178,case179,case180,case181,case182,case183,case184,case185,case186,case187,case188,case189,case190,case191,case192,case193,case194,case195,case196,case197,case198,case199,case200,case201,case202,case203,case204,case205,case206,case207,case208,case209,case210,case211,case212,case213,case214,case215,case216,case217,case218,case219,case220,case221,case222,case223,case224,case225;
	@FXML
	private GridPane plateau;
	@FXML
	private GridPane chevalet;

	// Reference to the main application.
	private Main mainApp;

	public PlateauController() {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
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
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		// Affiche le Chevalet
		showChevalet(mainApp.getChevalet());

	}

	private void showChevalet(String[] ch) {
		if (ch != null) {
			lettre1.setText(mainApp.getChevalet()[0]);
			lettre2.setText(mainApp.getChevalet()[1]);
			lettre3.setText(mainApp.getChevalet()[2]);
			lettre4.setText(mainApp.getChevalet()[3]);
			lettre5.setText(mainApp.getChevalet()[4]);
			lettre6.setText(mainApp.getChevalet()[5]);
			lettre7.setText(mainApp.getChevalet()[6]);
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
	 * Appeler quand le joueur appuie sur Nouvelle Partie Initialise la grille
	 * vide et le chevalet avec 7 lettres
	 */
	@FXML
	private void handleNewGame() {

		if (mainApp.getChevalet() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Chevalet Vide");
			alert.setHeaderText("Vous n'avez plus de piÃ¨ces Ã  jouer");
			alert.setContentText("Veuillez piocher des lettres");

			alert.showAndWait();
		} else
			showChevalet(mainApp.getChevalet());

	}

	@FXML
	private void dragGetLabel() {

		Node l = chevalet.getChildren().get(0);
		String[] ts = l.toString().split("'");
		s = ts[1];
		System.out.println("1 : " + s);

	}

	@FXML
	private void dragSetLabel() {
		System.out.println(s);
		testGetLabel.setText(s);
	}

	// TODO

	@FXML
	public void onDrag(MouseEvent event) {
		/* drag was detected, start drag-and-drop gesture */
		System.out.println("onDragDetected");
		Label source = (Label) event.getSource();

		/*
		 * Integer colIndex = GridPane.getColumnIndex(source); Integer x =
		 * (Integer) source.getProperties().get("gridpane-column");
		 */

		/* allow any transfer mode */
		Dragboard db = source.startDragAndDrop(TransferMode.ANY);

		/* put a string on dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(source.getText());
		db.setContent(content);

		event.consume();
	}

	public void onDragOver(DragEvent event) {
		// data is dragged over the target
		System.out.println("onDragOver");
		try {
			Label target = (Label) event.getGestureTarget();

			// accept it only if it is not dragged from the same node and if it
			// has
			// a string data
			//
			if (event.getGestureSource() != target && event.getDragboard().hasString()) {

				// allow for both copying and moving, whatever user chooses

				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		event.consume();
	}

	//TODO Changer le fond à l'entrée du curseur
	public void onDragEntered(DragEvent event) {
		/* the drag-and-drop gesture entered the target */
		System.out.println("onDragEntered");
		try {
			Label target = (Label) event.getGestureTarget();
			/* show to the user that it is an actual gesture target */
			if (event.getGestureSource() != target && event.getDragboard().hasString()) {
				// System.out.println(event.getDragboard().getString()+
				// target.getText());
				BackgroundFill bf = new BackgroundFill(Color.rgb(17, 119, 255), CornerRadii.EMPTY, Insets.EMPTY);
				Background bg = new Background(bf);
				target.setBackground(bg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		event.consume();
	}

	//TODO Changer le fond à la sortie du curseur
	public void onDragExited(DragEvent event) {
		try {
			// Label target = (Label) event.getGestureTarget();
			/* mouse moved away, remove the graphical cues */
			BackgroundFill bf = new BackgroundFill(null, CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(bf);
			// target.setBackground(bg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		event.consume();
	}

	public void onDragDropped(DragEvent event) {
		/* data dropped */
		System.out.println("onDragDropped");
		try {
			Label target = (Label) event.getGestureTarget();
			/* if there is a string data on dragboard, read it and use it */
			Dragboard db = event.getDragboard();
			boolean success = false;
			if (db.hasString()) {
				target.setText(db.getString());

				success = true;
			}
			/*
			 * let the source know whether the string was successfully
			 * transferred and used
			 */
			event.setDropCompleted(success);
		} catch (Exception e) {
			e.printStackTrace();
		}

		event.consume();
	}

	public void onDragDone(DragEvent event) {
		/* the drag-and-drop gesture ended */
		Label source = (Label) event.getSource();

		System.out.println("onDragDone");
		/* if the data was successfully moved, clear it */
		if (event.getTransferMode() == TransferMode.MOVE) {
			source.setText("");
		}

		event.consume();
	}

}
