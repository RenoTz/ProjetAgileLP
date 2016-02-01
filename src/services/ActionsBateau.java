package services;

import data.Bateau;
import data.Joueur;
import enumeration.EnumTypeBateau;

public class ActionsBateau {
	
	public void initialiserListeBateaux(Joueur j){
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
	
	public void placerBateau(Joueur j, Bateau b){
		j.getListeBateaux().add(b);
	}
	
	public void supprimerBateau(Joueur j, Bateau b){
		j.getListeBateaux().remove(b);
	}
}
