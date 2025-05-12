package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenusControleur implements Initializable{
	 @FXML
	 public ToggleGroup choixOutil;
	 
	 @FXML
	 public RadioMenuItem crayon;
	 
	 @FXML
	 public RadioMenuItem etoile;

	 @FXML
	 public ToggleGroup choixEpaisseur;
	 
	 public Controleur controller;
	 
	 public void setParam(Controleur c) {
	    	controller = c;
	 }
	 
	 public void onQuitte() {
		 if(controller.onQuitter())
			 Platform.exit();
	 }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choixOutil.selectedToggleProperty().addListener(obs ->{
			if(etoile.isSelected())
				controller.onEtoile();
			if(crayon.isSelected())
				controller.onCrayon();
		});
	}
}
