package services;

import java.awt.Point;
import data.Bateau;
import data.Joueur;
import enumeration.EnumTypeBateau;

public class ActionsBateau {
	
	public void initialiserListeBateaux(Joueur j){
		if(j.getListeBateaux() != null){
			Bateau porteAvion = new Bateau(EnumTypeBateau.PORTE_AVION);
			Bateau contreTorpilleur = new Bateau(EnumTypeBateau.CONTRE_TORPILLEUR);
			Bateau croiseur = new Bateau(EnumTypeBateau.CROISEUR);
			Bateau sousMarin = new Bateau(EnumTypeBateau.SOUS_MARIN);
			Bateau torpilleur = new Bateau(EnumTypeBateau.TORPILLEUR);
			j.getListeBateaux().add(porteAvion);
			j.getListeBateaux().add(contreTorpilleur);
			j.getListeBateaux().add(croiseur);
			j.getListeBateaux().add(sousMarin);
			j.getListeBateaux().add(torpilleur);
		}
	}
	
	public void placerBateau(Joueur j, EnumTypeBateau typeBateau,Point coordonneesArriere, Point coordonneesAvant){
		
		// TODO : check coordonnées A FAIRE!!
		for(Bateau bateau : j.getListeBateaux()){
			if(bateau.getTypeBateau().equals(typeBateau)){
//				bateau.getListePoints().add(new Points(coordonneesArriere, coordonneesAvant));
			}
		}
		
	}
	
	public void supprimerBateau(Joueur j, Bateau b){
		j.getListeBateaux().remove(b);
	}
}
