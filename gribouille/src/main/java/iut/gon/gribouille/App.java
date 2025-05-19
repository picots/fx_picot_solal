package iut.gon.gribouille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

import iut.gon.controleurs.Controleur;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	Controleur c = new Controleur();
        scene = new Scene(loadFXML("cadreGribouille", c), 600, 400);
        stage.titleProperty().bind(c.dessin.nomDuFichierProperty());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        		c.menusController.onQuitte();
        		event.consume();
        });
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> c.onKeyPressed(event.getText()));
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