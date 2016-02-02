package data;

import java.util.HashMap;
import java.util.Map;

public class Points {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------
	private int longueur;
	private String xAvant;
	private Integer yAvant;
	private String xArriere;
	private Integer yArriere;
	private boolean caseTouche;
	private Map<String, Integer> listePoints;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Points(int longueur){
		this.longueur = longueur;
	}
	
	public Points(String xAvant, Integer yAvant, String xArriere, Integer yArriere){
		this.xAvant = xAvant; 
		this.yAvant = yAvant;
		this.xArriere = xArriere; 
		this.yArriere = yArriere;
		listePoints.put(xAvant, yAvant);
	}
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------
	

	public boolean isCaseTouche() {
		return caseTouche;
	}

	public void setCaseTouche(boolean caseTouche) {
		this.caseTouche = caseTouche;
	}

}
