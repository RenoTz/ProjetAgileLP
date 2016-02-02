package tests;

import static org.junit.Assert.*;
import enumeration.EnumTypeBateau;

import org.junit.Test;

public class Tests {

	@Test
	public void testInitialiserListeBateaux() {
		int nbBateaux = 0;
		for (int cpt = 1; cpt <= 5; cpt++)
		{
			nbBateaux++;
		}
		System.out.println(EnumTypeBateau.values().length);
		if (EnumTypeBateau.values().length != 5){
			assertEquals("Nombre de bateaux ok", nbBateaux);
		}
			
	}

}
