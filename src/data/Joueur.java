package data;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------

	private String nom;
	
	private List<Bateau> listeBateaux = new ArrayList<Bateau>();
	
	private boolean premier;
	
	private boolean gagne;
	
	//------------------------------
	// Getters / Setters spécifiques
	//------------------------------
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isPremier() {
		return premier;
	}

	public void setPremier(boolean premier) {
		this.premier = premier;
	}

	public boolean isGagne() {
		return gagne;
	}

	public void setaGagne(boolean gagne) {
		this.gagne = gagne;
	}

	public List<Bateau> getListeBateaux() {
		return listeBateaux;
	}

	public void setListeBateaux(List<Bateau> listeBateaux) {
		this.listeBateaux = listeBateaux;
	}
}
