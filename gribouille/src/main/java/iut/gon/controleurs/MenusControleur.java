package iut.gon.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class MenusControleur {
	 @FXML
	 public ToggleGroup choixCrayon;

	 @FXML
	 public ToggleGroup choixEpaisseur;
	 
	 public Controleur controller;
	 
	 public void setParam(Controleur c) {
	    	controller = c;
	 }
}
