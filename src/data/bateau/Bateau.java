package data.bateau;

import data.composants.Points;
import enumeration.EnumTypeBateau;

public abstract class Bateau {

	//-----------------------
	// Attributs de la classe
	//-----------------------
	
	protected EnumTypeBateau typeBateau;
	private boolean coule;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Bateau(EnumTypeBateau typeBateau) {
		this.typeBateau = typeBateau;
	}
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------

	public EnumTypeBateau getTypeBateau() {
		return typeBateau;
	}

	public boolean isCoule() {
		return coule;
	}

	public void setCoule(boolean coule) {
		this.coule = coule;
	}
	
	public abstract Points[] getTabPoints();

}
