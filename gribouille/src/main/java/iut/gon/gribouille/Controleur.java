package iut.gon.gribouille;
import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import iut.gon.modele.Trace;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Controleur implements Initializable{

	    @FXML
	    private ColorPicker colorPicker;

	    @FXML
	    private Label abscisse;

	    @FXML
	    private Rectangle blanc;

	    @FXML
	    private Rectangle bleuClair;

	    @FXML
	    private Rectangle bleuFonce;

	    @FXML
	    private Canvas canvas;

	    @FXML
	    private ToggleGroup choixCrayon;

	    @FXML
	    private ToggleGroup choixEpaisseur;

	    @FXML
	    private Label epaisseur;

	    @FXML
	    private Rectangle jaune;

	    @FXML
	    private Rectangle noir;

	    @FXML
	    private Label ordonnee;

	    @FXML
	    private Pane pane;

	    @FXML
	    private Rectangle rose;

	    @FXML
	    private Rectangle rouge;

	    @FXML
	    private Rectangle vert;
	    
	    private Dessin dessin;
	    private double prevX;
	    private double prevY;
	    

	    public Controleur(Dessin d) {
	    	dessin = d;
	    }
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			canvas.heightProperty().bind(pane.heightProperty());
			canvas.widthProperty().bind(pane.widthProperty());
			canvas.widthProperty().addListener(observable -> {
				for(Figure f : dessin.getFigures())
					for(int i = 0; i < f.getPoints().size() - 1; i++)
						canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(i).getX(), f.getPoints().get(i).getY(), f.getPoints().get(i+1).getX(), f.getPoints().get(i+1).getY());
			});
			canvas.heightProperty().addListener(observable -> {
				for(Figure f : dessin.getFigures())
					for(int i = 0; i < f.getPoints().size() - 1; i++)
						canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(i).getX(), f.getPoints().get(i).getY(), f.getPoints().get(i+1).getX(), f.getPoints().get(i+1).getY());
			});
		}
		
		public void onMousePressed(MouseEvent event) {
			prevX = event.getX();
        	prevY = event.getY();
        	dessin.addFigure(new Trace(1, "noir", prevX, prevY));
		}
		
		public void onMouseDragged(MouseEvent event) {
			canvas.getGraphicsContext2D().strokeLine(prevX, prevY, event.getX(), event.getY());
        	prevX = event.getX();
        	prevY = event.getY();
        	dessin.getFigures().getLast().addPoint(prevX, prevY);
		}

}
