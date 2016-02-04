package data.interfaceJeu;

import java.util.List;

import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import services.ActionsBateau;
import utils.FactoryUtils;
import data.composants.Points;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class InterfaceTest {
	
	//-------------------------------
	// Classe à tester (@InjectMocks)
	//-------------------------------

	@InjectMocks 
	private Interface interfaceJeu;
	
	private ActionsBateau action;
	
	//-------------------------
	// METHODES de test (@Test)
	//-------------------------
	
	@Test
	public void creerCasesGraphiquesTest(){
		
		// Arrange
		Plateau plateau = new Plateau(1,1);
		JButton bouton = new JButton();
		plateau.getLePlateau()[0][0].setBouton(bouton);
		// Act
		List<JButton> listeRetour = interfaceJeu.creerCasesGraphiques(plateau);
		// Assert
		assertTrue(CollectionUtils.isNotEmpty(listeRetour));
	}
	
	@Test
	public void testTirer() {
		
		//Arrange
		action = new ActionsBateau();
		char xPos = 'A';
		int yPos = 3;
		Interface interfaceJeu = new Interface();
		Joueur j = new Joueur();
		j.setListeBateaux(action.initialiserListeBateaux());
		action.assignerCoordonneesBateaux(j, EnumTypeBateau.PORTE_AVION, new Points(xPos, 1), new Points(xPos, 5));
		action.placerLesBateauxSurLePlateau(j.getListeBateaux(),interfaceJeu.getPlateauJoueur());
		
		//Act
//		interfaceJeu.tirer(j,interfaceJeu.getPlateauJoueur(), FactoryUtils.convertirCharToInt(xPos), yPos);
		
		// Assert
//		assertTrue(interfaceJeu.getPlateauJoueur().getLePlateau()[FactoryUtils.convertirCharToInt(xPos)][yPos].isCaseTouche());
		
	}

}
