package iut.gon.tp3;

public class GrilleModel {
	private String[][] tabString = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
	
	public String getCase(int l, int c) {
		return tabString[l][c];
	}
	
	public void setCase(int l, int c, String txt) {
		tabString[l][c] = txt; 
	}
}
