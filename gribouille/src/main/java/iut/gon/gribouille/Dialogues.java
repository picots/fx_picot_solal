package iut.gon.gribouille;

import java.util.Optional;

import iut.gon.controleurs.Controleur;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Dialogues {
	public static boolean confirmation(Controleur c) {
		ButtonType b1 = new ButtonType("Annuler");
		ButtonType b2 = new ButtonType("Quitter sans sauvegarder");
		ButtonType b3 = new ButtonType("Sauvegarder et quitter");
		Alert a = new Alert(AlertType.CONFIRMATION, "Etes vous sûr de vouloir quitter ?");
		a.setTitle("Confirmation de fermeture");
		a.getButtonTypes().setAll(b1, b2, b3);
		Optional<ButtonType> res = a.showAndWait();	
		if(res.get() == b2)
			return true;
		else if(res.get() == b3) {
			try {
				c.sauvergarder();
				return true;
			} catch (NullPointerException e) {
				return false;
			}
		}
		else
			return false;
	}
}
