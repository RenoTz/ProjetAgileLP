package data;

public class Points {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------
	private char xPos;
	private Integer yPos;
	private boolean caseTouche;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Points(char xPos, Integer yPos){
		this.setxPos(xPos); 
		this.setyPos(yPos);
		this.caseTouche = false;
	}
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------
	

	public boolean isCaseTouche() {
		return caseTouche;
	}

	public void setCaseTouche(boolean caseTouche) {
		this.caseTouche = caseTouche;
	}

	public char getxPos() {
		return xPos;
	}

	public void setxPos(char xPos) {
		this.xPos = xPos;
	}

	public Integer getyPos() {
		return yPos;
	}

	public void setyPos(Integer yPos) {
		this.yPos = yPos;
	}

}
