package services;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Preconditions;

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
		
		Bateau porteAvion = new PorteAvion();
		Bateau contreTorpilleur = new ContreTorpilleur();
		Bateau croiseur = new Croiseur();
		Bateau sousMarin = new SousMarin();
		Bateau torpilleur = new Torpilleur();
		listeBateaux.add(porteAvion);
		listeBateaux.add(contreTorpilleur);
		listeBateaux.add(croiseur);
		listeBateaux.add(sousMarin);
		listeBateaux.add(torpilleur);
		
		return listeBateaux;
	}
	
	public void assignerCoordonneesBateaux(Joueur j, EnumTypeBateau typeBateau,Points coordonneesAvant, Points coordonneesArriere){
		
		// Check cohérence des coordonnées pour le placement des bateaux
		checkCoherenceDesCoordonnesPourLePlacementDesBateaux(j, typeBateau, coordonneesAvant, coordonneesArriere);
		
		// TODO : check coordonn�es A FAIRE!!
		if(CollectionUtils.isNotEmpty(j.getListeBateaux())){
			for(Bateau bateau : j.getListeBateaux()){
				if(bateau.getTypeBateau().equals(typeBateau)){
					// Placement des coordonn�es pour la premiere et la derniere case
					bateau.getTabPoints()[0] = coordonneesAvant;
					bateau.getTabPoints()[bateau.getTabPoints().length-1] = coordonneesArriere;
					remplissageDesCasesIntermediaires(coordonneesAvant,	coordonneesArriere, bateau);
				}
			}
		}
	}

	public void supprimerBateau(Joueur j, EnumTypeBateau typeBateau){
		if(CollectionUtils.isNotEmpty(j.getListeBateaux())){
			for(Bateau bateau : j.getListeBateaux()){
				if(bateau.getTypeBateau().equals(typeBateau)){
					j.getListeBateaux().remove(bateau);
					break;
				}
			}
		}
	}
	
	public void placerLesBateauxSurLePlateau(List<Bateau> listeBateaux, Plateau plateau){
		
		boolean caseColoree;
		if(CollectionUtils.isNotEmpty(listeBateaux)){
			for(Bateau bateau : listeBateaux){
				if(bateau.getTabPoints()[0] != null){
					for(int caseBateau = 0; caseBateau < bateau.getTabPoints().length; caseBateau++){
						caseColoree = false;
						for( int i = 0; i < plateau.getLePlateau().length; i++ ){
							for( int j = 0; j < plateau.getLePlateau().length; j++ ) {
								 if(caseBateauCorrespondCasePlateau(plateau, bateau, caseBateau, i, j)){
									 plateau.getLePlateau()[i][j].setCouleur(Color.DARK_GRAY);
									 plateau.getLePlateau()[i][j].getBouton().setBackground(Color.DARK_GRAY);
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
			}
		}
		// TODO : � enlever si inutile
		//plateau.log(plateau.getLePlateau());
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
	
	private void checkCoherenceDesCoordonnesPourLePlacementDesBateaux(Joueur j,	EnumTypeBateau typeBateau, Points coordonneesAvant, Points coordonneesArriere) {
		Preconditions.checkArgument(!bateauEnPositionVerticale(coordonneesAvant, coordonneesArriere) 
				|| !bateauEnPositionHorizontale(coordonneesAvant, coordonneesArriere), "Le bateau doit être positionné verticalement ou horizontalement");
		Preconditions.checkArgument(bateauEnPositionVerticale(coordonneesAvant, coordonneesArriere) 
				|| bateauEnPositionHorizontale(coordonneesAvant, coordonneesArriere), "Les coordonnées ne sont pas correctes");
		checkCoherenceCoordonneesEtLongueurBateau(j, typeBateau, coordonneesAvant, coordonneesArriere);
	}
	
	private boolean bateauEnPositionVerticale(Points coordonneesAvant, Points coordonneesArriere) {
		return coordonneesAvant.getxPos()==coordonneesArriere.getxPos() && coordonneesAvant.getyPos()!=coordonneesArriere.getyPos();
	}
	
	private boolean bateauEnPositionHorizontale(Points coordonneesAvant, Points coordonneesArriere) {
		return coordonneesAvant.getxPos()!=coordonneesArriere.getxPos() && coordonneesAvant.getyPos()==coordonneesArriere.getyPos();
	}
	
	private boolean checkCoherenceCoordonneesEtLongueurBateau(Joueur j,EnumTypeBateau typeBateau, Points coordonneesAvant, Points coordonneesArriere ){
		boolean coherent = false;
		if(CollectionUtils.isNotEmpty(j.getListeBateaux())){
			for(Bateau bateau : j.getListeBateaux()){
				if(typeBateau.equals(bateau.getTypeBateau())){
					if(bateauEnPositionVerticale(coordonneesAvant, coordonneesArriere)){
						if(coordonneesArriere.getyPos()-coordonneesAvant.getyPos()> 0 
								&& coordonneesArriere.getyPos()-coordonneesAvant.getyPos() == bateau.getTabPoints().length-1){
							coherent = true;
							break;
						}else if(coordonneesAvant.getyPos()-coordonneesArriere.getyPos()> 0 
								&& coordonneesAvant.getyPos()-coordonneesArriere.getyPos() == bateau.getTabPoints().length-1){
							coherent = true;
							break;
						}
					}
					if(bateauEnPositionHorizontale(coordonneesAvant, coordonneesArriere)){
						if(coordonneesAvant.getxPos()-coordonneesArriere.getyPos()> 0 
								&& coordonneesAvant.getxPos()-coordonneesArriere.getxPos() == bateau.getTabPoints().length-1){
							coherent = true;
							break;
						}else if(coordonneesArriere.getxPos()-coordonneesAvant.getxPos()> 0 
								&& coordonneesArriere.getxPos()-coordonneesAvant.getxPos() == bateau.getTabPoints().length-1){
							coherent = true;
							break;
						}
					}
				}
			}
		}
		return coherent;
	}

}