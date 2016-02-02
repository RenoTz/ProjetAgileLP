package tests;

import static org.junit.Assert.*;
import enumeration.EnumTypeBateau;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import data.Joueur;
import data.Plateau;
import data.Points;
import data.bateau.Bateau;
import services.ActionsBateau;

public class Tests {

	private ActionsBateau action = new ActionsBateau();
	
	@Test
	public void testActionsBateauInitialiserListe() {
		//Arrange
		
		//Act
		List<Bateau> listeRetour = action.initialiserListeBateaux();
		//Assert
		assertNotNull(listeRetour);
		assertEquals(listeRetour.size(), 5);
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.CONTRE_TORPILLEUR));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.CROISEUR));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.PORTE_AVION));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.SOUS_MARIN));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.TORPILLEUR));
	}
	
	@Test
	public void testPlacerLesBateauxSurLePlateau(){
		// Arrange
		Joueur j = new Joueur();
		Plateau plateau = new Plateau(10, 10);
		j.setListeBateaux(action.initialiserListeBateaux());
		action.assignerCoordonneesBateaux(j, EnumTypeBateau.PORTE_AVION, new Points('A', 1), new Points('A', 5));
		action.assignerCoordonneesBateaux(j, EnumTypeBateau.CROISEUR, new Points('B', 1), new Points('E', 1));
		action.assignerCoordonneesBateaux(j, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		action.assignerCoordonneesBateaux(j, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		action.assignerCoordonneesBateaux(j, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		// Act
		action.placerLesBateauxSurLePlateau(j.getListeBateaux(), plateau);
		
		// Assert
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.PORTE_AVION,plateau, 'A', 5);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.CROISEUR,plateau, 'E', 1);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.CONTRE_TORPILLEUR,plateau, 'E', 3);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.SOUS_MARIN,plateau, 'G', 5);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.TORPILLEUR,plateau, 'J', 8);
	}

	@Test
	public void testSupprimerBateau(){
		// Arrange
		Joueur j = new Joueur();
		j.setListeBateaux(action.initialiserListeBateaux());
		// Act 
		action.supprimerBateau(j, EnumTypeBateau.CONTRE_TORPILLEUR);
		// Assert
		assertTrue(verifierBateauSupprime(j));
	}

	
	private boolean verifierCasePlateauModifie(List<Bateau> listeBateau,EnumTypeBateau type,Plateau plateau,char x, int y) {
		
		for(Bateau bateau : listeBateau){
			if(type.equals(bateau.getTypeBateau())){
				for( int i = 0; i < plateau.getLePlateau().length; i++ ){
					for( int j = 0; j < plateau.getLePlateau().length; j++ ) {
						if((plateau.getLePlateau()[i][j].getPoint().getxPos() == x) && 
								(plateau.getLePlateau()[i][j].getPoint().getyPos() == i)){
							return true;
						}
					}	
				}
			}
		}
		
		return false;
		
	}

	private boolean verifierPresenceTypeBateau(List<Bateau> listeRetour, EnumTypeBateau type) {
		for (Bateau bateau : listeRetour){
			if (bateau.getTypeBateau().equals(type)){
				return true;
			}
		}
		return false;
	}
	
	private boolean verifierBateauSupprime(Joueur j) {
		for(Bateau bateau : j.getListeBateaux()){
			if(bateau.getTypeBateau().equals(EnumTypeBateau.CONTRE_TORPILLEUR)){
				return false;
			}
		}
		return true;
	}

}
