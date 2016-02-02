package tests;

import static org.junit.Assert.*;
import enumeration.EnumTypeBateau;

import java.util.List;

import org.junit.Test;

import data.bateau.Bateau;
import data.bateau.ContreTorpilleur;
import data.bateau.Croiseur;
import data.bateau.PorteAvion;
import data.bateau.SousMarin;
import data.bateau.Torpilleur;
import services.ActionsBateau;

public class Tests {

	private ActionsBateau action = new ActionsBateau();
	private Croiseur croiseur;
	private Torpilleur torpilleur;
	private ContreTorpilleur contreTorpilleur;
	private PorteAvion porteAvion;
	private SousMarin sousMarin;

	
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

	private boolean verifierPresenceTypeBateau(List<Bateau> listeRetour, EnumTypeBateau type) {
		for (Bateau bateau : listeRetour){
			if (bateau.getTypeBateau().equals(type)){
				return true;
			}
		}
		return false;
	}
	
	//VE
	@Test
	public void testIsCoule(){
		List<Bateau> listeRetour = action.initialiserListeBateaux();
		
		for(Bateau bateau : listeRetour){
			assertEquals(false, bateau.isCoule());
		}
	}
	
	@Test
	public void testCroiseurIsTouche(){
		croiseur = new Croiseur(EnumTypeBateau.CROISEUR);
		assertEquals(false, croiseur.isTouche());
	}
	
	@Test
	public void testTorpilleurIsTouche(){
		torpilleur = new Torpilleur(EnumTypeBateau.TORPILLEUR);
		assertEquals(false, torpilleur.isTouche());
	}
	
	@Test
	public void testContreTorpilleurIsTouche(){
		contreTorpilleur = new ContreTorpilleur(EnumTypeBateau.CONTRE_TORPILLEUR);
		assertEquals(false, contreTorpilleur.isTouche());
	}
	
	@Test
	public void testPorteAvionIsTouche(){
		porteAvion = new PorteAvion(EnumTypeBateau.PORTE_AVION);
		assertEquals(false, porteAvion.isTouche());
	}
	
	@Test
	public void testSousMarinIsTouche(){
		sousMarin = new SousMarin(EnumTypeBateau.SOUS_MARIN);
		assertEquals(false, sousMarin.isTouche());
	}

}
