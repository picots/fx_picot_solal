package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

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
		
		statutController.abscisse.textProperty().bindBidirectional(prevX, new NumberStringConverter());
		statutController.ordonnee.textProperty().bindBidirectional(prevY, new NumberStringConverter());
		
		paneController.canvas.heightProperty().bind(paneController.pane.heightProperty());
		paneController.canvas.widthProperty().bind(paneController.pane.widthProperty());
		
		paneController.canvas.widthProperty().addListener(observable -> redessiner());
		paneController.canvas.heightProperty().addListener(observable -> redessiner());
	}
	
	public void redessiner() {
		for(Figure f : dessin.getFigures())
			for(int i = 0; i < f.getPoints().size() - 1; i++)
				paneController.canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(i).getX(), f.getPoints().get(i).getY(), f.getPoints().get(i+1).getX(), f.getPoints().get(i+1).getY());
	}

    
}
