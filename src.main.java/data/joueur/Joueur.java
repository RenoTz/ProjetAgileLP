package data.joueur;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;

import data.bateau.Bateau;

public class Joueur {
	
	private static final int NOMBRE_INITIAL_BATEAUX = 5;
	
	//-----------------------
	// Attributs de la classe
	//-----------------------

	private String nom;
	private List<Bateau> listeBateaux;
	private boolean enTrainDeJouer;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public Joueur(){
		this.listeBateaux = Lists.newArrayList();
	}
	
	//------------------------------
	// Getters / Setters specifiques
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
		return CollectionUtils.isEmpty(listeBateaux);
	}

	public List<Bateau> getListeBateaux() {
		return listeBateaux;
	}

	public void setListeBateaux(List<Bateau> listeBateaux) {
		this.listeBateaux = listeBateaux;
	}

	public boolean isTousLesBateauxPlaces() {
		for(Bateau bateau : listeBateaux){
			if(!bateau.isPlace()){
				return false;
			}
		}
		return true;
	}
	
	public int getScore() {
		return NOMBRE_INITIAL_BATEAUX - listeBateaux.size() ;
	}
}
