package data.src.data;

public class Joueur {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------

	private String nom;
	
	// TODO RT : à décommenter quand la classe Bateau sera prête
	//	private List<Bateau> listeBateaux = new ArrayList<>();
	
	private boolean premier;
	
	private boolean gagne;
	
	//------------------------------
	// Getters / Setters spécifiques
	//------------------------------
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean isPremier() {
		return premier;
	}

	public void setPremier(boolean premier) {
		this.premier = premier;
	}

	public boolean isGagne() {
		return gagne;
	}

	public void setaGagne(boolean gagne) {
		this.gagne = gagne;
	}
}
