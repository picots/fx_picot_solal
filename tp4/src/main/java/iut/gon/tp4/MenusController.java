package iut.gon.tp4;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;

public class MenusController {
	
	GrilleModel modele;
	Scores scores;
	@FXML MenuBar menus;
	
	public void setParams(GrilleModel modele, Scores scores) {
		this.modele = modele;
		this.scores = scores;
	}
	
	@FXML
	  public void onMenuNouvelle(ActionEvent evt) {
	    modele.nouvellePartie();
	  }
	  @FXML
	  public void onMenuTable(ActionEvent evt) {
	    //TODO appeler la table des scores
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("table.fxml"));
			Parent root = fxmlLoader.load();
			TableController c = fxmlLoader.getController();
			c.setScores(scores);
			menus.getScene().setRoot(root);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	  }

	  @FXML
	  public void onMenuQuitter(ActionEvent evt) {
	    Platform.exit();
	  }
}
