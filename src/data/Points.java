package data;

import java.awt.Point;

public class Points {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	private Point coordonneesAvant;
	private Point coordonneesArriere;
	private boolean caseTouche;
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------
	
	public Point getCoordonneesAvant() {
		return coordonneesAvant;
	}

	public void setCoordonneesAvant(Point coordonneesAvant) {
		this.coordonneesAvant = coordonneesAvant;
	}

	public Point getCoordonneesArriere() {
		return coordonneesArriere;
	}

	public void setCoordonneesArriere(Point coordonneesArriere) {
		this.coordonneesArriere = coordonneesArriere;
	}

	public boolean isCaseTouche() {
		return caseTouche;
	}

	public void setCaseTouche(boolean caseTouche) {
		this.caseTouche = caseTouche;
	}

}
