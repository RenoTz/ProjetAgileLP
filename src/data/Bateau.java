package data;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enumeration.EnumTypeBateau;

public class Bateau {

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

}
