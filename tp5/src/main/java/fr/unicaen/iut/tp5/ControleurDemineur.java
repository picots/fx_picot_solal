package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ControleurDemineur implements Initializable{
	
	ModeleDemineur modele = new ModeleDemineur(0,0,0);
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
		difficulte.selectedToggleProperty().addListener((obs, oldToogle, newToogle) -> initGrille(newToogle.getUserData().toString()));
	}
	
	public void initGrille(String userData) {
		gridPane.getColumnConstraints().clear();
		gridPane.getRowConstraints().clear();
		
		int[] tab = ModeleDemineur.parseUserData(userData);
		int nbCol = tab[0];
		int nbLig = tab[1];
		int nbMines = tab[2];
		
		modele = new ModeleDemineur(nbCol, nbLig, nbMines);
		
		for(int c = 0; c < nbCol; c++)
			gridPane.getColumnConstraints().add(new ColumnConstraints(32,32,32));
		
		for(int l = 0; l < nbLig; l++)
			gridPane.getRowConstraints().add(new RowConstraints(32,32,32));
		
	}
}
