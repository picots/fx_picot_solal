package iut.gon.tp4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Morpion extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("grille.fxml"));
    Scores table = new Scores();
    GrilleController controller = new GrilleController(table);
    fxmlLoader.setController(controller);
    Scene scene = new Scene(fxmlLoader.load(), 800, 600);
    
    stage.setTitle("Morpion!");
    stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> controller.jouerAvecTouches(event));
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
