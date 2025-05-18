package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DessinControleur implements Initializable{
	 @FXML
	 public Canvas canvas;
	 
	 @FXML
	 public Pane pane;
	 
	 public Controleur controller;
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 canvas.heightProperty().bind(pane.heightProperty());
		 canvas.widthProperty().bind(pane.widthProperty());
		 canvas.widthProperty().addListener((obs, ancien, nouveau) -> redessiner());
		 canvas.heightProperty().addListener((obs, ancien, nouveau) -> redessiner());
	 }
	 
	 public void setParam(Controleur c) {
	    	controller = c;
	}
	
	public void efface() {
		canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());	
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}
	 
	public void redessiner() {
		controller.redessiner();
	}
	
	public void onMouseMoved(MouseEvent event) {
		controller.onMouseMoved(event);
	}
	
	public void onMousePressed(MouseEvent event) {
		controller.onMousePressed(event);
	}
	
	public void onMouseDragged(MouseEvent event) {
		controller.onMouseDragged(event);
	}
	
	public void setEpaisseur(int epaisseur) {
		canvas.getGraphicsContext2D().setLineWidth(epaisseur);
	}
	
	public void setCouleur(Color couleur) {
		canvas.getGraphicsContext2D().setStroke(couleur);
	}
}
