package services;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import data.bateau.Bateau;
import data.bateau.ContreTorpilleur;
import data.bateau.Croiseur;
import data.bateau.PorteAvion;
import data.bateau.SousMarin;
import data.bateau.Torpilleur;
import data.composants.Points;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
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
	
	public void assignerCoordonneesBateaux(Joueur j, EnumTypeBateau typeBateau,Points coordonneesAvant, Points coordonneesArriere){
		
		// TODO : check coordonn�es A FAIRE!!
		for(Bateau bateau : j.getListeBateaux()){
			if(bateau.getTypeBateau().equals(typeBateau)){
				// Placement des coordonn�es pour la premiere et la derniere case
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
				break;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void placerLesBateauxSurLePlateau(List<Bateau> listeBateaux, Plateau plateau){
		
		boolean caseColoree;
		for(Bateau bateau : listeBateaux){
			for(int caseBateau = 0; caseBateau< bateau.getTabPoints().length;caseBateau++){
				caseColoree = false;
				for( int i = 0; i < plateau.getLePlateau().length; i++ ){
					for( int j = 0; j < plateau.getLePlateau().length; j++ ) {
						 if(caseBateauCorrespondCasePlateau(plateau, bateau, caseBateau, i, j)){
							 plateau.getLePlateau()[i][j].getBouton().setBackground(Color.DARK_GRAY);
							 // TODO : temporaire, affichage test console en attendant l'interface graphique
//							 plateau.getLePlateau()[i][j].getPoint().setxPos('X');
//							 plateau.getLePlateau()[i][j].getPoint().setyPos((int) 'X');
							 caseColoree = true;
							 break;
						 }
					  }
					if(caseColoree){
						break;
					}
				}
			}
		}
		// TODO : � enlever si inutile
		plateau.log();
	}
	
	//--------------------------------
	//  METHODES SPECIFIQUES : PRIVEES
	//--------------------------------
	
	private void remplissageDesCasesIntermediaires(Points coordonneesAvant,	Points coordonneesArriere, Bateau bateau) {
		// On remplie les cases interm�diaires
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
	
	private boolean caseBateauCorrespondCasePlateau(Plateau plateau, Bateau bateau, int caseBateau, int i, int j) {
		return (bateau.getTabPoints()[caseBateau].getxPos() == plateau.getLePlateau()[i][j].getPoint().getxPos()) &&
				 (bateau.getTabPoints()[caseBateau].getyPos() == plateau.getLePlateau()[i][j].getPoint().getyPos());
	}
}
