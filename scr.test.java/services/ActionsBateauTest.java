package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import data.bateau.Bateau;
import data.bateau.Croiseur;
import data.composants.Points;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;
import utils.FactoryUtils;


@RunWith(MockitoJUnitRunner.class)
public class ActionsBateauTest {

	@Mock
	private Bateau bateau;
	
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
	public void testPlacerLesBateauxSurLePlateaAvecListeBateauNonNulleEtCoordonneesCorrectes(){
		// Arrange
		Joueur j = new Joueur();
		Plateau plateau = new Plateau(10, 10);
		j.setListeBateaux(this.action.initialiserListeBateaux());
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.PORTE_AVION, new Points('A', 1), new Points('A', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.CROISEUR, new Points('E', 1), new Points('B', 1));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 5), new Points('E', 3));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		this.action.assignerCoordonneesBateaux(j, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		
		// Act
		this.action.placerLesBateauxSurLePlateau(j.getListeBateaux(), plateau);
		
		// Assert
		assertTrue(verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.PORTE_AVION,plateau, 'A', 5));
		assertTrue(verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.CROISEUR,plateau, 'E', 1));
		assertTrue(verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.CONTRE_TORPILLEUR,plateau, 'E', 3));
		assertTrue(verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.SOUS_MARIN,plateau, 'G', 5));
		assertTrue(verifierCasePlateauModifie(j.getListeBateaux(), EnumTypeBateau.TORPILLEUR,plateau, 'J', 8));
	}
	
	@Test
	public void testPlacerLesBateauxSurLePlateauAvecListeBateauVide(){
		// Arrange
		Joueur j = new Joueur();
		Plateau plateau = new Plateau(10, 10);
		List<Bateau> listeVide = Lists.newArrayList();
		j.setListeBateaux(listeVide);
		
		// Act
		this.action.placerLesBateauxSurLePlateau(j.getListeBateaux(), plateau);
		
		// Assert
		assertTrue(toutesLesCasesDuPlateauSontBleues(plateau));
	}

	@Test
	public void testSupprimerBateau(){
		// Arrange
		Joueur j = new Joueur();
		j.setListeBateaux(this.action.initialiserListeBateaux());
		bateau = new Croiseur();
		// Act 
		this.action.supprimerBateau(j, EnumTypeBateau.CONTRE_TORPILLEUR);
		
		// Assert
		assertTrue(verifierBateauSupprime(j));
	}

	//--------------------------------
	//  METHODES UTILITAIRES : PRIVEES
	//--------------------------------

	private boolean verifierCasePlateauModifie(List<Bateau> listeBateau,EnumTypeBateau type,Plateau plateau,char x, int y) {
		
		int xPos = FactoryUtils.convertirCharToInt(x);
		
		if(estUneCaseBateau(plateau, xPos,y-1)){
			return true;
		}
		return false;
	}

	private boolean toutesLesCasesDuPlateauSontBleues(Plateau plateau) {
		for(int i = 0; i < plateau.getLePlateau().length; i++){
			for(int j = 0; i < plateau.getLePlateau().length; i++){
				if(estUneCaseBateau(plateau, i, j)){
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean estUneCaseBateau(Plateau plateau, int i, int j) {
		return plateau.getLePlateau()[i][j].getCouleur() == Color.DARK_GRAY;
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

	@Test
	public void testAssignerCoordonneesBateauxListeVide() throws Exception {
		
		// Arrange
		Joueur j = new Joueur();
		// Act
		action.assignerCoordonneesBateaux(j, EnumTypeBateau.CROISEUR, new Points('A', 1), new Points('A', 4));
		// Assert
		
	}
	
}
