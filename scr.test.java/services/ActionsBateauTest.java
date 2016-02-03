package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import data.bateau.Bateau;
import data.composants.Points;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;


@RunWith(MockitoJUnitRunner.class)
public class ActionsBateauTest {

	//-------------------------------
	// Classe à tester (@InjectMocks)
	//-------------------------------
	
	@InjectMocks
	private ActionsBateau action;
	
	//-------------------------
	// METHODES de test (@Test)
	//-------------------------
		
	@Test
	public void testActionsBateauInitialiserListe() {
		//Arrange
		
		//Act
		List<Bateau> listeRetour = this.action.initialiserListeBateaux();
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
	public void testPlacerLesBateauxSurLePlateaListeNonNull(){
		// Arrange
		Joueur j = new Joueur();
		Plateau plateau = new Plateau(10, 10);
		j.setListeBateaux(this.action.initialiserListeBateaux());
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.PORTE_AVION, new Points('A', 1), new Points('A', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.CROISEUR, new Points('B', 1), new Points('E', 1));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		// Act
		this.action.placerLesBateauxSurLePlateau(j.getListeBateaux(), plateau);
		
		// Assert
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.PORTE_AVION,plateau, 'A', 5);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.CROISEUR,plateau, 'E', 1);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.CONTRE_TORPILLEUR,plateau, 'E', 3);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.SOUS_MARIN,plateau, 'G', 5);
		verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.TORPILLEUR,plateau, 'J', 8);
	}
	
	@Test
	public void testPlacerLesBateauxSurLePlateau(){
		// Arrange
		Joueur j = new Joueur();
		Plateau plateau = new Plateau(10, 10);
		j.setListeBateaux(this.action.initialiserListeBateaux());
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.PORTE_AVION, new Points('A', 1), new Points('A', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.CROISEUR, new Points('B', 1), new Points('E', 1));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		// Act
		this.action.placerLesBateauxSurLePlateau(j.getListeBateaux(), plateau);
		
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
		j.setListeBateaux(this.action.initialiserListeBateaux());
		// Act 
		this.action.supprimerBateau(j, EnumTypeBateau.CONTRE_TORPILLEUR);
		// Assert
		assertTrue(verifierBateauSupprime(j));
	}

	//--------------------------------
	//  METHODES UTILITAIRES : PRIVEES
	//--------------------------------

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
