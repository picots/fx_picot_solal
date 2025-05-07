package iut.gon.controleurs;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class Controleur {
	public final Dessin dessin = new Dessin();
    public final SimpleDoubleProperty prevX = new SimpleDoubleProperty(0);
    public final SimpleDoubleProperty prevY = new SimpleDoubleProperty(0);
    public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
    public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
    public Figure figure;
}
