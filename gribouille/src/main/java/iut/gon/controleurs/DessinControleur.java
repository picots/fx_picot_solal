package iut.gon.controleurs;

import iut.gon.modele.Figure;
import iut.gon.modele.Trace;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DessinControleur {
	 @FXML
	 public Canvas canvas;
	 
	 @FXML
	 public Pane pane;
	 
	 public Controleur controller;
	 
	 public void setParam(Controleur c) {
	    	controller = c;
	    	canvas.heightProperty().bind(pane.heightProperty());
			canvas.widthProperty().bind(pane.widthProperty());
			canvas.widthProperty().addListener(observable -> redessiner());
			canvas.heightProperty().addListener(observable -> redessiner());
	}
	
	public void efface() {
		canvas.getGraphicsContext2D().clearRect(0,0,0,0);	
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}
	 
	public void redessiner() {
			for(Figure f : controller.dessin.getFigures())
				for(int i = 0; i < f.getPoints().size() - 1; i++)
					trace(f.getPoints().get(i).getX(), f.getPoints().get(i).getY(), f.getPoints().get(i+1).getX(), f.getPoints().get(i+1).getY());
	}
	
	public void onMousePressed(MouseEvent event) {
		controller.onMousePressed(event);
	}
	
	public void onMouseDragged(MouseEvent event) {
		controller.onMouseDragged(event);
	}
	
}
