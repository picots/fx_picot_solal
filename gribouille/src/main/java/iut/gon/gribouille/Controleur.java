package iut.gon.gribouille;
import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

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
	    private SimpleDoubleProperty prevX = new SimpleDoubleProperty(0);
	    private SimpleDoubleProperty prevY = new SimpleDoubleProperty(0);
	    

	    public Controleur(Dessin d) {
	    	dessin = d;
	    }
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			abscisse.textProperty().bindBidirectional(prevX, new NumberStringConverter());
			ordonnee.textProperty().bindBidirectional(prevY, new NumberStringConverter());
			
			canvas.heightProperty().bind(pane.heightProperty());
			canvas.widthProperty().bind(pane.widthProperty());
			canvas.widthProperty().addListener(observable -> redessiner());
			canvas.heightProperty().addListener(observable -> redessiner());
		}
		
		public void onMousePressed(MouseEvent event) {
			prevX.set(event.getX());
        	prevY.set(event.getY());
        	dessin.addFigure(new Trace(1, "noir", prevX.get(), prevY.get()));
		}
		
		public void onMouseDragged(MouseEvent event) {
			canvas.getGraphicsContext2D().strokeLine(prevX.get(), prevY.get(), event.getX(), event.getY());
			prevX.set(event.getX());
        	prevY.set(event.getY());
        	dessin.getFigures().getLast().addPoint(prevX.get(), prevY.get());
		}
		
		public void redessiner() {
			for(Figure f : dessin.getFigures())
				for(int i = 0; i < f.getPoints().size() - 1; i++)
					canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(i).getX(), f.getPoints().get(i).getY(), f.getPoints().get(i+1).getX(), f.getPoints().get(i+1).getY());
		}
			
}
