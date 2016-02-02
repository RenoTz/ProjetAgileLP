package data.interfaceJeu;

import java.awt.Color;

import data.Points;

public class Case {
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points point;
	private Color couleur;
	private boolean caseTouche;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
		
	public Case(Points point){
		this.setPoint(point);
		this.couleur = Color.BLUE;
		this.caseTouche = false;
	}

	//-----------------
	//	GETTERS/SETTERS
	//-----------------
	
	public Points getPoint() {
		return point;
	}

	public void setPoint(Points point) {
		this.point = point;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public boolean isCaseTouche() {
		return caseTouche;
	}

	public void setCaseTouche(boolean caseTouche) {
		this.caseTouche = caseTouche;
	}
	
	


}
