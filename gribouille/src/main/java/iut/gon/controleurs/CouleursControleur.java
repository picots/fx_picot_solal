package iut.gon.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class CouleursControleur {
	@FXML
    public ColorPicker colorPicker;
    
    @FXML
    public Rectangle blanc;

    @FXML
    public Rectangle bleuClair;

    @FXML
    public Rectangle bleuFonce;
    
    @FXML
    public Rectangle jaune;

    @FXML
    public Rectangle noir;
    
    @FXML
    public Rectangle rose;

    @FXML
    public Rectangle rouge;

    @FXML
    public Rectangle vert;
    
    public Controleur controller;
    
    public void setParam(Controleur c) {
    	controller = c;
    }
}
