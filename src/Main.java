import data.Plateau;

import data.Plateau;
import data.bateau.Bateau;
import data.bateau.SousMarin;
import enumeration.EnumTypeBateau;

public class Main {

	public static void main(String[] args) {
		
		Bateau sousMarin = new SousMarin(EnumTypeBateau.SOUS_MARIN);
		
		Plateau P = new Plateau(10,10);
		
		P.initPlateau();
		
	}

}
