package services;

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
	
	public void initialiserListeBateaux(Joueur j){
		if(j.getListeBateaux() != null){
			Bateau porteAvion = new PorteAvion(EnumTypeBateau.PORTE_AVION);
			Bateau contreTorpilleur = new ContreTorpilleur(EnumTypeBateau.CONTRE_TORPILLEUR);
			Bateau croiseur = new Croiseur(EnumTypeBateau.CROISEUR);
			Bateau sousMarin = new SousMarin(EnumTypeBateau.SOUS_MARIN);
			Bateau torpilleur = new Torpilleur(EnumTypeBateau.TORPILLEUR);
			j.getListeBateaux().add(porteAvion);
			j.getListeBateaux().add(contreTorpilleur);
			j.getListeBateaux().add(croiseur);
			j.getListeBateaux().add(sousMarin);
			j.getListeBateaux().add(torpilleur);
		}
	}
	
	public void placerBateau(Joueur j, EnumTypeBateau typeBateau,Points coordonneesAvant, Points coordonneesArriere){
		
		// TODO : check coordonnées A FAIRE!!
		for(Bateau bateau : j.getListeBateaux()){
			if(bateau.getTypeBateau().equals(typeBateau)){
				// Placement des coordonnées pour la premiere et la derniere case
				bateau.getTabPoints()[0] = coordonneesAvant;
				bateau.getTabPoints()[bateau.getTabPoints().length-1] = coordonneesArriere;
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
		
	}
	
	public void supprimerBateau(Joueur j, EnumTypeBateau typeBateau){
		for(Bateau bateau : j.getListeBateaux()){
			if(bateau.getTypeBateau().equals(typeBateau)){
				j.getListeBateaux().remove(bateau);
			}
		}
	}
}
