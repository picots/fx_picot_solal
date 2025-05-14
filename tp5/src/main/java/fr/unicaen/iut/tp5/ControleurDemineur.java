package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ControleurDemineur implements Initializable{
	
	ModeleDemineur modele = new ModeleDemineur(0,0,0);
	@FXML ToggleGroup difficulte;
	@FXML RadioMenuItem facile;
	@FXML RadioMenuItem moyen;
	@FXML RadioMenuItem difficile;
	@FXML GridPane gridPane;
	@FXML TextField nbInconnues;
	@FXML TextField nbMarques;
	
	private final Background inconnu = new Background(new BackgroundFill(Color.AQUA, new CornerRadii(20., true), Insets.EMPTY));
	private final Background libre = new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY));
	private final Background echec = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
	private final Background marquee = new Background(new BackgroundFill(Color.LEMONCHIFFON, CornerRadii.EMPTY, Insets.EMPTY));
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nbInconnues.textProperty().bind(modele.nbInconnuesProperty().asString());
		nbMarques.textProperty().bind(modele.nbMarquesProperty().asString());
		difficulte.selectedToggleProperty().addListener((obs, oldToogle, newToogle) -> initGrille(newToogle.getUserData().toString()));
		
		
	}
	
	public void initGrille(String userData) {
		gridPane.getColumnConstraints().clear();
		gridPane.getRowConstraints().clear();
		
		int[] tab = ModeleDemineur.parseUserData(userData);
		int nbCol = tab[0];
		int nbLig = tab[1];
		int nbMines = tab[2];
		
		modele.setTaille(nbCol, nbLig, nbMines);
		
		for(int c = 0; c < nbCol; c++)
			gridPane.getColumnConstraints().add(new ColumnConstraints(32,32,32));
		
		for(int l = 0; l < nbLig; l++)
			gridPane.getRowConstraints().add(new RowConstraints(32,32,32));
		
		for(int l = 0; l < gridPane.getRowCount(); l++) {
			for(int c = 0; c < gridPane.getColumnCount(); c++) {
				final int lig = l;
				final int col = c;
				Label lab = new Label();
				lab.setBackground(inconnu);
				lab.setPrefSize(31, 31);
				lab.setAlignment(Pos.CENTER);
				lab.textProperty().bind(modele.texteProperty(l, c));
				lab.setOnMouseClicked(event->{
					if(modele.estPerdu())
						return;
					if(event.getButton() == MouseButton.PRIMARY) {
						modele.revele(lig, col);
						if(modele.estPerdu())
							lab.setBackground(echec);
						else
							lab.setBackground(libre);
					}
					if(event.getButton() == MouseButton.SECONDARY && !modele.estRevelee(lig, col)) {
						modele.marque(lig, col);
						if(modele.estPerdu())
							lab.setBackground(echec);
						else
							lab.setBackground(marquee);
					}
					//lab.setText(modele.getText(lig, col));
				});
				gridPane.add(lab, c, l);
			}
		}
		
	}
}
