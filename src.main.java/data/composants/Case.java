package data.composants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class Case {
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points point;
	private boolean caseTouche;
	private boolean water;
	private JButton bouton;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
		
	public Case(Points point){
		this.setPoint(point);
		this.caseTouche = false;
		this.setWater(true);
		this.bouton = creerBouton();
	}
	
	//--------------------------------
	//  METHODES SPECIFIQUES : PRIVEES
	//--------------------------------
	
	private JButton creerBouton() {
		JButton bouton = new JButton();
		bouton.setBackground(Color.BLUE);
		bouton.setPreferredSize(new Dimension(40, 40));
		bouton.setForeground(Color.WHITE);
		return bouton;
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

	public boolean isCaseTouche() {
		if(getBouton().getBackground().equals(Color.RED)){ 
			caseTouche = true;
		}
		return caseTouche;
	}

	public void setCaseTouche(boolean caseTouche) {
		this.caseTouche = caseTouche;
	}
	
	public JButton getBouton() {
		return bouton;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}
}
