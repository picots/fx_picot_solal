package iut.gon.gribouille;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Dialogues {
	public static boolean confirmation() {
		Alert a = new Alert(AlertType.CONFIRMATION, "Etes vous sûr de vouloir quitter ?", ButtonType.YES, ButtonType.NO);
		a.setTitle("Confirmation de fermeture");
		return a.showAndWait().get() == ButtonType.YES;
	}
}
