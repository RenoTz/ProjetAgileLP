package services;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import utils.FactoryUtils;
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
	
	//------------------------
	// METHODES DE LA CLASSE
	//------------------------
	
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
	
	public void saisieDesCoordonneesDesBateaux(final Joueur joueur,final Plateau plateau, final int xPos, final int yPos) {
		
		for(final Bateau bateau : joueur.getListeBateaux()){
			if(!bateau.isPlace()){
				plateau.getLePlateau()[xPos][yPos].getBouton().setBackground(Color.CYAN);
				if(positionVerticaleBas(xPos, bateau) < plateau.getLePlateau().length && plateau.getLePlateau()[positionVerticaleBas(xPos, bateau)][yPos].isWater()){
					plateau.getLePlateau()[positionVerticaleBas(xPos, bateau)][yPos].getBouton().setBackground(Color.ORANGE);
					plateau.getLePlateau()[positionVerticaleBas(xPos, bateau)][yPos].getBouton().setEnabled(true); 
				}
				if(positionVerticaleHaut(xPos, bateau) >= 0 && plateau.getLePlateau()[positionVerticaleHaut(xPos, bateau)][yPos].isWater()){
					plateau.getLePlateau()[positionVerticaleHaut(xPos, bateau)][yPos].getBouton().setBackground(Color.ORANGE);
					plateau.getLePlateau()[positionVerticaleHaut(xPos, bateau)][yPos].getBouton().setEnabled(true); 
				}
				if(positionHorizontaleDroite(yPos, bateau) < plateau.getLePlateau().length && plateau.getLePlateau()[xPos][positionHorizontaleDroite(yPos, bateau)].isWater()){
					plateau.getLePlateau()[xPos][positionHorizontaleDroite(yPos, bateau)].getBouton().setBackground(Color.ORANGE);
					plateau.getLePlateau()[xPos][positionHorizontaleDroite(yPos, bateau)].getBouton().setEnabled(true);
				}
				if(positionHorizontaleGauche(yPos, bateau) >= 0 && plateau.getLePlateau()[xPos][positionHorizontaleGauche(yPos, bateau)].isWater()){
					plateau.getLePlateau()[xPos][positionHorizontaleGauche(yPos, bateau)].getBouton().setBackground(Color.ORANGE);
					plateau.getLePlateau()[xPos][positionHorizontaleGauche(yPos, bateau)].getBouton().setEnabled(true);
				}
					bateau.getTabPoints()[0] = new Points(FactoryUtils.convertirIntToChar(xPos + 1), yPos + 1);
					break;
				}
			}
		}
		
	private int positionHorizontaleDroite(int yPos, Bateau bateau) {
		return yPos + bateau.getTabPoints().length-1;
	}

	private int positionVerticaleBas(int xPos, Bateau bateau) {
		return xPos + bateau.getTabPoints().length-1;
	}
	
	private int positionHorizontaleGauche(int yPos, Bateau bateau) {
		return yPos - (bateau.getTabPoints().length-1);
	}

	private int positionVerticaleHaut(int xPos, Bateau bateau) {
		return xPos - (bateau.getTabPoints().length-1);
	}
	
	public void assignerCoordonneesBateaux(Joueur j, EnumTypeBateau typeBateau, Points coordonneesArriere){
		
		if(CollectionUtils.isNotEmpty(j.getListeBateaux())){
			for(Bateau bateau : j.getListeBateaux()){
				if(bateau.getTypeBateau().equals(typeBateau)){
					// Placement des coordonn�es pour la premiere et la derniere case
					Points coordonneesAvant = bateau.getTabPoints()[0];
					bateau.getTabPoints()[bateau.getTabPoints().length-1] = coordonneesArriere;
					remplissageDesCasesIntermediaires(coordonneesAvant,	coordonneesArriere, bateau);
					break;
				}
			}
		}
	}

	public void supprimerBateau(Joueur j, Bateau bateauCoule){
		if(CollectionUtils.isNotEmpty(j.getListeBateaux())){
			for(Bateau bateau : j.getListeBateaux()){
				if(bateau.getTypeBateau().equals(bateauCoule.getTypeBateau())){
					j.getListeBateaux().remove(bateau);
					break;
				}
			}
		}
	}
	
	public void placerLesBateauxSurLePlateau(Bateau bateau, Plateau plateau){
		
		boolean caseColoree;
		if(bateau.getTabPoints()[0] != null){
			for(int caseBateau = 0; caseBateau < bateau.getTabPoints().length; caseBateau++){
				caseColoree = false;
				for( int i = 0; i < plateau.getLePlateau().length; i++ ){
					for( int j = 0; j < plateau.getLePlateau().length; j++ ) {
						 if(caseBateauCorrespondCasePlateau(plateau, bateau, caseBateau, i, j)){
							 plateau.getLePlateau()[i][j].setWater(false);
							 plateau.getLePlateau()[i][j].getBouton().setBackground(Color.DARK_GRAY);
							 caseColoree = true;
							 break;
						 }
						 bateau.setPlace(true);
					}					
					if(caseColoree){
						break;
					}
				}
			}
		}
	}
	
	//--------------------------------
	//  METHODES UTILITAIRES : PRIVEES
	//--------------------------------
	
	public void remplissageDesCasesIntermediaires(Points coordonneesAvant,	Points coordonneesArriere, Bateau bateau) {
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