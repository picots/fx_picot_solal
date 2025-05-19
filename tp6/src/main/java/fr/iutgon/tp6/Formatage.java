package fr.iutgon.tp6;

import javafx.scene.paint.Color;

import fr.iutgon.tp6.modele.Ligne;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Paint;

public class Formatage extends TableCell<Ligne, Number> {
	
	public void updateItem(Number prix, boolean empty) {
		super.updateItem(prix, empty);
		setAlignment(Pos.CENTER_RIGHT);
		if(empty && prix == null) {
			setGraphic(null);
			setText(null);
		}
		else {
			setText(String.format("%.2f€", prix));
			if(prix.floatValue() < 0)
				setTextFill(Color.RED);
		}
	}
}
