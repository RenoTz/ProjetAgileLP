package data.joueur;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;

import data.bateau.Bateau;

public class Joueur {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------

	private String nom;
	private int score;
	private List<Bateau> listeBateaux;
	private boolean enTrainDeJouer;
	private String nomJoueur;
	private String nomAdversaire;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public Joueur(){
		this.listeBateaux = Lists.newArrayList();
		this.score = 0;
	}
	
	//------------------------------
	// Getters / Setters specifiques
	//------------------------------
	
	public String getNom() {
		return nom;
	}
	
	public String getNomJoueur() {
		return this.nomJoueur;
	}
	
	public void setNomJoueur(String nomJoueur) {
		nomJoueur = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :");
		this.nomJoueur = nomJoueur;		
	}
	
	public String getNomAdversaire() {
		return this.nomAdversaire;
	}
	
	public void setNomAdversaire(String nomAdversaire) {
		nomAdversaire = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :");
		this.nomAdversaire = nomAdversaire;		
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
	
	public int getScore() {
		return 5 - listeBateaux.size() ;
	}
	
	public void setScore(int score){
		this.score = score;
	}
}
