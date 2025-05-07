package iut.gon.controleurs;

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
	 }
	 
	 public void onMousePressed(MouseEvent event) {
			controller.prevX.set(event.getX());
	    	controller.prevY.set(event.getY());
	    	controller.dessin.addFigure(new Trace(1, "noir", controller.prevX.get(), controller.prevY.get()));
		}
		
		public void onMouseDragged(MouseEvent event) {
			controller.paneController.canvas.getGraphicsContext2D().strokeLine(controller.prevX.get(), controller.prevY.get(), event.getX(), event.getY());
			controller.prevX.set(event.getX());
	    	controller.prevY.set(event.getY());
	    	controller.dessin.getFigures().getLast().addPoint(controller.prevX.get(), controller.prevY.get());
		}
}
