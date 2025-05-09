package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille.Dialogues;
import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Controleur implements Initializable{
	public final Dessin dessin = new Dessin();
    public final SimpleDoubleProperty prevX = new SimpleDoubleProperty(0);
    public final SimpleDoubleProperty prevY = new SimpleDoubleProperty(0);
    public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
    public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
    public Figure figure;
    
    @FXML public CouleursControleur couleursController;
    @FXML public MenusControleur menusController;
    @FXML public StatutControleur statutController;
    @FXML public DessinControleur paneController;
	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
		couleursController.setParam(this);
		menusController.setParam(this);
		statutController.setParam(this);
		paneController.setParam(this);
		
		statutController.abscisse.textProperty().bind(prevX.asString());
		statutController.ordonnee.textProperty().bind(prevY.asString());
		statutController.epaisseur.textProperty().bind(epaisseur.asString());
		statutController.couleur.textProperty().bind(couleur.asString());
		
	}
	
	public void onMousePressed(MouseEvent event) {
		prevX.set(event.getX());
    	prevY.set(event.getY());
    	dessin.addFigure(new Trace(epaisseur.get(), couleur.get().toString(), prevX.get(), prevY.get()));
	}
	
	public void onMouseDragged(MouseEvent event) {
		paneController.canvas.getGraphicsContext2D().strokeLine(prevX.get(), prevY.get(), event.getX(), event.getY());
		prevX.set(event.getX());
    	prevY.set(event.getY());
    	dessin.getFigures().getLast().addPoint(prevX.get(), prevY.get());
	}
	
	public boolean onQuitter() {
		return Dialogues.confirmation();
	}

    
}
