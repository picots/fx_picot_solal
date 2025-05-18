package iut.gon.gribouille;

import iut.gon.controleurs.Controleur;
import iut.gon.modele.Trace;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class OutilCrayon extends Outil {

	public OutilCrayon(Controleur c) {
		super(c);
	}

	@Override
	public void onMousePressed(MouseEvent event) {
		figure = new Trace(controller.epaisseur.get(), controller.couleur.get().toString(), controller.prevX.get(), controller.prevY.get());
		controller.dessin.addFigure(figure);
    	controller.paneController.setEpaisseur(figure.getEpaisseur());
    	controller.paneController.setCouleur(Color.valueOf(figure.getCouleur()));
	}

	@Override
	public void onMouseDragged(MouseEvent event) {
		controller.paneController.trace(controller.prevX.get(), controller.prevY.get(), event.getX(), event.getY());
		controller.paneController.setEpaisseur(figure.getEpaisseur());
		controller.paneController.setCouleur(Color.valueOf(figure.getCouleur()));
	}
	
}
