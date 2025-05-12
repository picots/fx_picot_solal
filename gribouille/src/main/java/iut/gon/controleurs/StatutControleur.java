package iut.gon.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

public class StatutControleur{
	@FXML
    public Label abscisse;

    @FXML
    public Label epaisseur;
    
    @FXML
    public Label couleur;

    @FXML
    public Label ordonnee;
    
    @FXML
    public Label outil;
    
    public Controleur controller;
    
    public void setParam(Controleur c) {
    	controller = c;
    }
}
