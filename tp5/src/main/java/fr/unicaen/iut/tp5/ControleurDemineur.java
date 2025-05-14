package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class ControleurDemineur implements Initializable{
	
	ModeleDemineur modele;
	@FXML ToggleGroup difficulte;
	@FXML RadioMenuItem facile;
	@FXML RadioMenuItem moyen;
	@FXML RadioMenuItem difficile;
	@FXML GridPane gridPane;
	@FXML TextField nbInconnues;
	@FXML TextField nbMarques;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nbInconnues.textProperty().bind(modele.nbInconnuesProperty().asString());
		nbMarques.textProperty().bind(modele.nbMarquesProperty().asString());
		difficulte.selectedToggleProperty().addListener(obs -> {
			if(facile.isSelected())
				initGrille(facile.getUserData().toString());
			if(moyen.isSelected())
				initGrille(moyen.getUserData().toString());
			if(difficile.isSelected())
				initGrille(difficile.getUserData().toString());
		});
	}
}
