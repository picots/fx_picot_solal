package fr.iutgon.tp6;

import fr.iutgon.tp6.modele.FabriqueProduits;
import fr.iutgon.tp6.modele.Ligne;
import fr.iutgon.tp6.modele.Produit;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberExpression;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class FactureController implements Initializable {
	public TableView<Ligne> table;
	public TableColumn<Ligne, Integer> qte;
	public TableColumn<Ligne, Produit> produit;
	public TableColumn<Ligne, Number> prixUnitaire;
	public TableColumn<Ligne, Number> totalHT;
	public TableColumn<Ligne, Number> totalTTC;
	public TextField sommeFacture;
	public NumberExpression exp = new SimpleFloatProperty(0);

	/**
   Called to initialize a controller after its root element has been completely processed.

   @param location  The location used to resolve relative paths for the root object, or
   {@code null} if the location is not known.
   @param resources The resources used to localize the root object, or {@code null} if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//TODO préparer la table
		qte.setCellValueFactory(new PropertyValueFactory<>("qte"));
		Callback<TableColumn.CellDataFeatures<Ligne, Produit>, ObservableValue<Produit>> call = 
				new Callback<TableColumn.CellDataFeatures<Ligne,Produit>, ObservableValue<Produit>>(){

			@Override
			public ObservableValue<Produit> call(CellDataFeatures<Ligne, Produit> param) {
				// TODO Auto-generated method stub
				return param.getValue().produitProperty();
			}

		};
		produit.setCellValueFactory(call);
		prixUnitaire.setCellValueFactory(param -> {
			return Bindings.selectFloat(param.getValue().produitProperty(), "prix");
		});
		totalHT.setCellValueFactory(param ->{
			return param.getValue().totalHTProperty();
		});
		totalTTC.setCellValueFactory(param ->{
			return param.getValue().totalTTCProperty();
		});
		
		qte.setCellFactory(cell -> new TextFieldTableCell<>(new IntegerStringConverter()));
		produit.setCellFactory(cell -> new ChoiceBoxTableCell<Ligne, Produit>(new StringConverter<Produit>(){
			@Override
			public String toString(Produit object) {
				// TODO Auto-generated method stub
				return object.getNom();
			}

			@Override
			public Produit fromString(String string) {
				// TODO Auto-generated method stub
				return FabriqueProduits.getProduits().get(FabriqueProduits.getProduits().indexOf(string));
			}
			
		},FXCollections.observableList(FabriqueProduits.getProduits())));
		prixUnitaire.setCellFactory(cell -> new Formatage());
		totalHT.setCellFactory(cell -> new Formatage());
		totalTTC.setCellFactory(cell -> new Formatage());
	}

	public void onAjouter(ActionEvent actionEvent) {
		//TODO ajouter un produit aléatoire à la table
		Random r = new Random();
		Ligne ligne = new Ligne(r.nextInt(15)+1, new Produit("Burger", 2.75f, 1.15f));
		table.getItems().add(ligne);
		exp = Bindings.add(exp, ligne.totalTTCProperty());
		sommeFacture.textProperty().bind(exp.asString());
	}
}
