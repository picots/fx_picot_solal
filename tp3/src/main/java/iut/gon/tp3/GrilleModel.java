package iut.gon.tp3;

import javafx.beans.property.SimpleStringProperty;

public class GrilleModel {
	private SimpleStringProperty[][] tabString = {{new SimpleStringProperty("7"),new SimpleStringProperty("8"),new SimpleStringProperty("9")},
												  {new SimpleStringProperty("4"),new SimpleStringProperty("5"),new SimpleStringProperty("6")},
												  {new SimpleStringProperty("1"),new SimpleStringProperty("2"),new SimpleStringProperty("3")}}; 
	
	public SimpleStringProperty getCase(int l, int c) {
		return tabString[l][c];
	}
	
	public void setCase(int l, int c, String txt) {
		tabString[l][c].setValue(txt); 
	}
}
