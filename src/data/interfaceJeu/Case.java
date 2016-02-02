package data.interfaceJeu;

import java.awt.Color;

import data.Points;

public class Case {
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points point;
	private Color couleur;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
		
	public Case(Points point){
		this.setPoint(point);
		this.couleur = Color.BLUE;
	}

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
	
	//-----------------
	//	GETTERS/SETTERS
	//-----------------


}
