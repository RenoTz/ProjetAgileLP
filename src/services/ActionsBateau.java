package services;

import java.util.ArrayList;
import java.util.List;

import data.Joueur;
import data.Points;
import data.bateau.Bateau;
import data.bateau.ContreTorpilleur;
import data.bateau.Croiseur;
import data.bateau.PorteAvion;
import data.bateau.SousMarin;
import data.bateau.Torpilleur;
import enumeration.EnumTypeBateau;

public class ActionsBateau {
	
	public List<Bateau> initialiserListeBateaux(){
		
		List<Bateau> listeBateaux = new ArrayList<Bateau>();
		
		Bateau porteAvion = new PorteAvion(EnumTypeBateau.PORTE_AVION);
		Bateau contreTorpilleur = new ContreTorpilleur(EnumTypeBateau.CONTRE_TORPILLEUR);
		Bateau croiseur = new Croiseur(EnumTypeBateau.CROISEUR);
		Bateau sousMarin = new SousMarin(EnumTypeBateau.SOUS_MARIN);
		Bateau torpilleur = new Torpilleur(EnumTypeBateau.TORPILLEUR);
		listeBateaux.add(porteAvion);
		listeBateaux.add(contreTorpilleur);
		listeBateaux.add(croiseur);
		listeBateaux.add(sousMarin);
		listeBateaux.add(torpilleur);
		
		return listeBateaux;
	}
	
	public void placerBateau(Joueur j, EnumTypeBateau typeBateau,Points coordonneesAvant, Points coordonneesArriere){
		
		// TODO : check coordonnées A FAIRE!!
			
		for(Bateau bateau : j.getListeBateaux()){
			if(bateau.getTypeBateau().equals(typeBateau)){
				// Placement des coordonnées pour la premiere et la derniere case
				bateau.getTabPoints()[0] = coordonneesAvant;
				bateau.getTabPoints()[bateau.getTabPoints().length-1] = coordonneesArriere;
				remplissageDesCasesIntermediaires(coordonneesAvant,	coordonneesArriere, bateau);
			}
		}
		
	}
	
	public void supprimerBateau(Joueur j, EnumTypeBateau typeBateau){
		for(Bateau bateau : j.getListeBateaux()){
			if(bateau.getTypeBateau().equals(typeBateau)){
				j.getListeBateaux().remove(bateau);
			}
		}
	}
	
	//--------------------------------
	//  METHODES SPECIFIQUES : PRIVEES
	//--------------------------------
	
	private void remplissageDesCasesIntermediaires(Points coordonneesAvant,	Points coordonneesArriere, Bateau bateau) {
		// On remplie les cases intermédiaires
		int indice = 1;
		while(indice < bateau.getTabPoints().length-1){
			if(coordonneesArriere.getxPos() == coordonneesAvant.getxPos()){
				bateau.getTabPoints()[indice] = new Points((char) (coordonneesAvant.getxPos()), coordonneesAvant.getyPos()+indice);
				indice++;
			}else{
				bateau.getTabPoints()[indice] = new Points((char) (coordonneesAvant.getxPos()+indice), coordonneesAvant.getyPos());
				indice++;
			}
		}
	}
}
