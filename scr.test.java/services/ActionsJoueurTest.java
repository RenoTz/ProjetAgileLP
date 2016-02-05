package services;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import data.bateau.Bateau;
import data.bateau.SousMarin;
import data.composants.Points;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;

@RunWith(MockitoJUnitRunner.class)
public class ActionsJoueurTest {
	
	//-------------------------------
	// Classe à tester (@InjectMocks)
	//-------------------------------
	
	@InjectMocks
	private ActionsJoueur actionsJoueur;
	
	private ActionsBateau actionsBateau;
	
	//-------------------------
	// METHODES de test (@Test)
	//-------------------------

	@Before
	public void avantLesTests(){
		actionsJoueur = new ActionsJoueur();
		actionsBateau = new ActionsBateau();
	}
	
	@Test
	public void testBateauTouche() {
		
		//Arrange
		Joueur j = new Joueur();
		Plateau plateau = new Plateau(10, 10);
		Bateau sousMarin = new SousMarin();
		j.getListeBateaux().add(sousMarin);
		int xTir = 0, yTir = 4;
		
//		actionsBateau.assignerCoordonneesBateaux(j, EnumTypeBateau.SOUS_MARIN, new Points('A', 1), new Points('A', 5));
//		actionsBateau.placerLesBateauxSurLePlateau(Lists.newArrayList(sousMarin), plateau);
		
		//Act
		actionsJoueur.tirer(j,  plateau, xTir, yTir);
		boolean retour = plateau.getLePlateau()[xTir][yTir].isCaseTouche();
		
		// Assert
//		assertTrue(retour);
		
	}
	
	@Test
	public void testTirer() throws Exception {
		
		// Arrange
		
		// Act
		
		// Assert
	}

	@Test
	public void testCoulerLeBateau() throws Exception {

		// Arrange
		
		// Act
		
		// Assert
	}

}
