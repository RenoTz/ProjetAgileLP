package tests;

import static org.junit.Assert.*;
import enumeration.EnumTypeBateau;

import java.util.List;

import org.junit.Test;

import data.bateau.Bateau;
import enumeration.EnumTypeBateau;
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
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.CONTRE_TORPILLEUR));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.CROISEUR));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.PORTE_AVION));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.SOUS_MARIN));
		assertEquals(true, verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.TORPILLEUR));
	}

	private boolean verifierPresenceTypeBateau(List<Bateau> listeRetour, EnumTypeBateau type) {
		for (Bateau bateau : listeRetour){
			if (bateau.getTypeBateau().equals(type)){
				return true;
			}
		}
		return false;
	}

}
