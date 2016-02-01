package services;

import data.Bateau;
import data.Joueur;
import enumeration.EnumTypeBateau;

public class ActionsBateau {
	
	public void initialiserListeBateaux(Joueur j){
		Bateau porteAvion = new Bateau(EnumTypeBateau.PORTE_AVION);
		
		j.getListeBateaux().add(porteAvion);
	}
	
	public void placerBateau(Joueur j, Bateau b){
		j.getListeBateaux().add(b);
	}
	
	public void supprimerBateau(Joueur j, Bateau b){
		j.getListeBateaux().remove(b);
	}
}
