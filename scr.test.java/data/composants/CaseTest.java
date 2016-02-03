package data.composants;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import data.bateau.Bateau;
import data.bateau.ContreTorpilleur;
import data.interfaceJeu.Interface;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;
import services.ActionsBateau;
import utils.FactoryUtils;

@RunWith(MockitoJUnitRunner.class)
public class CaseTest {
	
		//-------------------------------
		// Classe à tester (@InjectMocks)
		//-------------------------------
		
		@InjectMocks
		private Case casePlateau;
		
		@Mock
		private ActionsBateau actions;
		
		//-------------------------
		// METHODES de test (@Test)
		//-------------------------
		
		@Test
		public void testBateauTouche() {
			
			//Arrange
			Points point = new Points('A', 5);
			casePlateau = new Case(point);
						
			//Act
			boolean retour = casePlateau.isCaseTouche();
			
			// Assert
			assertTrue(retour);
			
		}
		
}
