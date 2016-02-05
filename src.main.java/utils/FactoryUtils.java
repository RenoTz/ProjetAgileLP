package utils;

import data.bateau.Bateau;
import data.interfaceJeu.Plateau;

public class FactoryUtils {
	
	public static int convertirCharToInt(char lettre){
		int indice = 0;
		if(lettre == 'A'){
			indice = 0;
		}
		if(lettre == 'B'){
			indice = 1;
		}
		if(lettre == 'C'){
			indice = 2;
		}
		if(lettre == 'D'){
			indice = 3;
		}
		if(lettre == 'E'){
			indice = 4;
		}
		if(lettre == 'F'){
			indice = 5;
		}
		if(lettre == 'G'){
			indice = 6;
		}
		if(lettre == 'H'){
			indice = 7;
		}
		if(lettre == 'I'){
			indice = 8;
		}
		if(lettre == 'J'){
			indice = 9;
		}
		if(lettre == 'K'){
			indice = 10;
		}
		if(lettre == 'L'){
			indice = 11;
		}
		return indice;
	}
	
	public static char convertirIntToChar(int indice){
		char lettre = ' ';
		if(indice == 1){
			lettre = 'A';
		}
		if(indice == 2){
			lettre = 'B';
		}
		if(indice == 3){
			lettre = 'C';
		}
		if(indice == 4){
			lettre = 'D';
		}
		if(indice == 5){
			lettre = 'E';
		}
		if(indice == 6){
			lettre = 'F';
		}
		if(indice == 7){
			lettre = 'G';
		}
		if(indice == 8){
			lettre = 'H';
		}
		if(indice == 9){
			lettre = 'I';
		}
		if(indice == 10){
			lettre = 'J';
		}
		if(indice == 11){
			lettre = 'K';
		}
		if(indice == 12){
			lettre = 'L';
		}
		return lettre;
	}
	
	public static Integer getYPos(Plateau plateau, final int i, final int j) {
		return plateau.getLePlateau()[i][j].getPoint().getyPos();
	}

	public static Integer getXPos(Plateau plateau, final int i, final int j) {
		return FactoryUtils.convertirCharToInt(plateau.getLePlateau()[i][j].getPoint().getxPos());
	}

	public static int positionHorizontale(int yPos, Bateau bateau) {
		return yPos + bateau.getTabPoints().length-1;
	}

	public static int positionVerticale(int xPos, Bateau bateau) {
		return xPos + bateau.getTabPoints().length-1;
	}
}
