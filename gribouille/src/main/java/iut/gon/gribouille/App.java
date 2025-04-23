package iut.gon.gribouille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static double prevX, prevY;
    private static Canvas dessin;
    private static Pane pane;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("CadreGribouille"), 600, 400);
        dessin = (Canvas) scene.lookup("Canvas");
        pane = (Pane) dessin.getParent();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        	if(!Dialogues.confirmation())
        		event.consume();
        });
        dessin.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
        	prevX = event.getX();
        	prevY = event.getY();
        });
        dessin.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
        	dessin.getGraphicsContext2D().strokeLine(prevX, prevY, event.getX(), event.getY());
        	prevX = event.getX();
        	prevY = event.getY();
        });
        pane.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
        	if(event.getButton() == MouseButton.SECONDARY) {
        		Circle c = new Circle(event.getX(), event.getY(), 5);
        		pane.getChildren().add(c);
        		event.consume();
        		c.setMouseTransparent(true);
        	}
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