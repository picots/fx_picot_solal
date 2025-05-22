package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenusControleur implements Initializable{
	@FXML
	public MenuBar menus;
	
	@FXML
	 public ToggleGroup choixOutil;
	
	@FXML
	public MenuItem toutSup;
	
	@FXML
	public MenuItem figSup;
	
	 @FXML
	 public RadioMenuItem crayon;
	 
	 @FXML
	 public RadioMenuItem etoile;

	 @FXML
	 public ToggleGroup choixEpaisseur;
	 
	 public Controleur controller;
	 
	 public void setParam(Controleur c) {
	    	controller = c;
	 }
	 
	 public void onQuitte() {
		 if(controller.onQuitter())
			 Platform.exit();
	 }
	 
	 public void onCrayon() {
		 controller.onCrayon();
	 }
	 
	 public void onEtoile() {
		 controller.onEtoile();
	 }
	 
	 public void onSauvegarde() {
		 controller.sauvergarder();
	 }
	 
	 public void onCharge() {
		 controller.charger();
	 }
	 
	 public void onExporte() {
		 controller.exporter();
	 }
	 
	 public void onEffaceFigure() {
		 controller.effaceFigure();
	 }
	 
	 public void onEffaceTout() {
		 controller.effaceTout();
	 }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choixEpaisseur.selectedToggleProperty().addListener((obs, ancien, nouveau) ->{
			RadioMenuItem r = (RadioMenuItem)nouveau;
			controller.setEpaisseur(Integer.parseInt(r.getText()));
		});
	}
}
