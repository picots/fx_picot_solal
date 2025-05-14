package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille.Dialogues;
import iut.gon.gribouille.Outil;
import iut.gon.gribouille.OutilCrayon;
import iut.gon.gribouille.OutilEtoile;
import iut.gon.modele.Dessin;
import iut.gon.modele.Etoile;
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


public class Controleur implements Initializable{
	public final Dessin dessin = new Dessin();
    public final SimpleDoubleProperty prevX = new SimpleDoubleProperty(0);
    public final SimpleDoubleProperty prevY = new SimpleDoubleProperty(0);
    public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
    public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
    
    @FXML public CouleursControleur couleursController;
    @FXML public MenusControleur menusController;
    @FXML public StatutControleur statutController;
    @FXML public DessinControleur paneController;
    
    public Outil outil = new OutilCrayon(this);
	
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
    
    public void onMouseMoved(MouseEvent event) {
    	prevX.set(event.getX());
    	prevY.set(event.getY());
    }
	
	public void onMousePressed(MouseEvent event) {
		prevX.set(event.getX());
    	prevY.set(event.getY());
    	outil.onMousePressed(event);
	}
	
	public void onMouseDragged(MouseEvent event) {
		outil.onMouseDragged(event);
		prevX.set(event.getX());
    	prevY.set(event.getY());
    	dessin.getFigures().getLast().addPoint(prevX.get(), prevY.get());
	}
	
	public void redessiner() {
		paneController.efface();
		for(Figure f : dessin.getFigures()) {
			if(f instanceof Trace) {
				for(int i = 0; i < f.getPoints().size() - 1; i++) {
					paneController.setEpaisseur(epaisseur.get());
					paneController.trace(f.getPoints().get(i).getX(), f.getPoints().get(i).getY(), f.getPoints().get(i+1).getX(), f.getPoints().get(i+1).getY());
				}
			}
			if(f instanceof Etoile) {
				Etoile e = (Etoile)f;
				paneController.setEpaisseur(epaisseur.get());
				for(int i = 0; i < e.getPoints().size(); i++)
					paneController.trace(e.getCentre().getX(), e.getCentre().getY(), e.getPoints().get(i).getX(), e.getPoints().get(i).getY());
			}
		}	
	}
	
	public boolean onQuitter() {
		return Dialogues.confirmation();
	}
	
	public void onCrayon() {
		outil = new OutilCrayon(this);
		statutController.outil.setText("Crayon");
		menusController.etoile.setSelected(false);
		menusController.crayon.setSelected(true);
	}
	
	public void onEtoile() {
		outil = new OutilEtoile(this);
		statutController.outil.setText("Etoile");
		menusController.etoile.setSelected(true);
		menusController.crayon.setSelected(false);
	}

	public void setEpaisseur(int epaisseur) {
		this.epaisseur.set(epaisseur);
	}
    
}
