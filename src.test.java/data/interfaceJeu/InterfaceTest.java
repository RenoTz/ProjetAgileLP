package data.interfaceJeu;

import javax.swing.JButton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class InterfaceTest {
	
	//-------------------------------
	// Classe à tester (@InjectMocks)
	//-------------------------------

	
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
//		List<JButton> listeRetour = interfaceJeu.creerCasesGraphiques(plateau);
		// Assert
//		assertTrue(CollectionUtils.isNotEmpty(listeRetour));
	}
	
}
