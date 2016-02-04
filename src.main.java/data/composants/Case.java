package data.composants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class Case {
	
	//------------------------
	//  ATTRIBUTS DE LA CLASSE
	//------------------------
	
	private Points point;
	private Color couleur;
	private boolean caseTouche;
	private boolean caseUtilisee;
	private JButton bouton;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
		
	public Case(Points point){
		this.setPoint(point);
		this.couleur = Color.BLUE;
		this.caseTouche = false;
		this.caseUtilisee = false;
		this.bouton = creerBouton();
	}

	//-----------------
	//	GETTERS/SETTERS
	//-----------------
	
	private JButton creerBouton() {
		JButton bouton = new JButton();
		bouton.setBackground(couleur);
		bouton.setPreferredSize(new Dimension(40, 40));
		bouton.setText(String.valueOf(this.point.getxPos())+String.valueOf(this.point.getyPos()));
		bouton.setForeground(Color.WHITE);
		return bouton;
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

	public boolean isCaseTouche() {
		if(getCouleur().equals(Color.RED)){ 
			caseTouche = true;
		}
		return caseTouche;
	}

	public void setCaseTouche(boolean caseTouche) {
		this.caseTouche = caseTouche;
	}
	
	public boolean getCaseUtilisee(){
		return this.caseUtilisee;
	}
	
	public void setCaseUtilisee(boolean caseUtilisee){
		this.caseUtilisee = caseUtilisee;
	}

	public JButton getBouton() {
		return bouton;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}
}
