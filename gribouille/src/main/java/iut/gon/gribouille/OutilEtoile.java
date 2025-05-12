package iut.gon.gribouille;

import iut.gon.controleurs.Controleur;
import iut.gon.modele.Etoile;
import javafx.scene.input.MouseEvent;

public class OutilEtoile extends Outil {

	public OutilEtoile(Controleur c) {
		super(c);
	}

	@Override
	public void onMousePressed(MouseEvent event) {
		figure = new Etoile(controller.epaisseur.get(), controller.couleur.getName(), controller.prevX.get(), controller.prevY.get());
    	controller.dessin.addFigure(figure);
	}

	@Override
	public void onMouseDragged(MouseEvent event) {
		Etoile etoile = (Etoile)figure;
		controller.paneController.trace(etoile.getCentre().getX(), etoile.getCentre().getY(), event.getX(), event.getY());
	}

}
