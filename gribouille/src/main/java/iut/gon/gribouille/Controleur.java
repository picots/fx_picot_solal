package iut.gon.gribouille;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
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

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			canvas.heightProperty().bind(pane.heightProperty());
			canvas.widthProperty().bind(pane.widthProperty());
		}

}
