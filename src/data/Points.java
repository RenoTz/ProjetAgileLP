package data;

public class Points {
	
	//-----------------------
	// Attributs de la classe
	//-----------------------
	private char xPos;
	private Integer yPos;
	
	//--------------------------
	// Constructeur de la classe
	//--------------------------
	
	public Points(){}
	
	public Points(char xPos, Integer yPos){
		this.setxPos(xPos); 
		this.setyPos(yPos);
	}
	
	//-----------------------------
	// Getters/Setters de la classe
	//-----------------------------

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
