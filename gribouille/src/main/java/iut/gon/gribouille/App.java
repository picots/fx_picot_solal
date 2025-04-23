package iut.gon.gribouille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static double prevX, prevY;
    private static Canvas dessin;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("CadreGribouille"), 600, 400);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        	if(!Dialogues.confirmation())
        		event.consume();
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    
    public static void main(String[] args) {
        launch();
    }

}