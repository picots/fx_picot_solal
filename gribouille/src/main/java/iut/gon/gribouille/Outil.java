package iut.gon.gribouille;

import iut.gon.controleurs.Controleur;
import iut.gon.modele.Figure;
import javafx.scene.input.MouseEvent;

public abstract class Outil {
	protected Controleur controller;
	protected Figure figure;
	
	public Outil(Controleur c) {
		controller = c;
	}
	
	public abstract void onMousePressed(MouseEvent event);
		
	public abstract void onMouseDragged(MouseEvent event);
}
