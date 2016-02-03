package data.joueur;

import java.util.List;
import data.bateau.Bateau;

public class Joueur {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------

	private String nom;
	private List<Bateau> listeBateaux;
	private boolean enTrainDeJouer;
	private boolean gagne;
	
	//------------------------------
	// Getters / Setters sp�cifiques
	//------------------------------
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isEnTrainDeJouer() {
		return enTrainDeJouer;
	}

	public void setEnTrainDeJouer(boolean enTrainDeJouer) {
		this.enTrainDeJouer = enTrainDeJouer;
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
