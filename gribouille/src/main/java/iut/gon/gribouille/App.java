package iut.gon.gribouille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import iut.gon.modele.Dessin;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	Dessin dessin = new Dessin();
    	Controleur c = new Controleur(dessin);
        scene = new Scene(loadFXML("CadreGribouille", c), 600, 400);
        stage.titleProperty().bind(dessin.nomDuFichierProperty());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        	if(!Dialogues.confirmation())
        		event.consume();
        });
    }

    static void setRoot(String fxml, Controleur c) throws IOException {
        scene.setRoot(loadFXML(fxml, c));
    }

    private static Parent loadFXML(String fxml, Controleur c) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    	fxmlLoader.setController(c);
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }

}