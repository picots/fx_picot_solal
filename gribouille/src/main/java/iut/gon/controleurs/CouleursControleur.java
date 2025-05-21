package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class CouleursControleur implements Initializable{
	@FXML 
	public VBox couleurs;
	
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
    
    public SimpleObjectProperty<Rectangle> prevRec = new SimpleObjectProperty<Rectangle>();
    
    public Controleur controller;
    
    public void setParam(Controleur c) {
    	controller = c;
    }
    
    public void getCouleurDuColorPicker() {
    	controller.setCouleur(colorPicker.getValue());
    	controller.paneController.setCouleur(colorPicker.getValue());
    	changerEtat(prevRec.get(), 5, 1);
    }
    
    public void changerEtat(Rectangle r, double arc, double stroke) {
    	r.setArcHeight(arc);
    	r.setArcWidth(arc);
    	r.setStrokeWidth(stroke);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prevRec.set(noir);
		couleurs.setOnMouseClicked(event ->{
			if(!(event.getTarget() instanceof Rectangle))
				return;
			Rectangle rectangle = (Rectangle)event.getTarget();
			controller.selectionnerCouleur(rectangle);
		});
	}
}
