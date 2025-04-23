package iut.gon.tp3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GrilleController implements Initializable{
	private @FXML GridPane grille;
	private Label[][] labels = new Label[3][3];
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		grille.setStyle("-fx-background-color: seashell");
		for(int l = 0; l < 3; l++) {
			for(int c = 0; c < 3; c++) {
				Label lab = new Label(String.format("L%dC%d", l, c));
				labels[l][c] = lab;
				lab.setOnMouseClicked(event -> lab.setText("bonjour"));
				lab.setMaxSize(1000, 1000);
				lab.setAlignment(Pos.CENTER);
				grille.add(lab, c, l);
			}
		}
	}
}
