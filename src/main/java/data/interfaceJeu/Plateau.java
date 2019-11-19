package data.interfaceJeu;

import data.composants.Case;
import data.composants.Points;

public class Plateau {
    
    // ------------------------
    // ATTRIBUTS DE LA CLASSE
    // ------------------------
    
    public Case[][] lePlateau;
    
    // ------------------------
    // CONSTRUCTEUR
    // ------------------------
    public Plateau(int largeur, int longueur) {
        this.setLePlateau(new Case[largeur][longueur]);
        this.initPlateau();
    }
    
    // ------------------------
    // METHODES DE LA CLASSE
    // ------------------------
    
    public void initPlateau() {
        for (int i = 0; i < this.lePlateau.length; i++) {
            for (int j = 0; j < this.lePlateau.length; j++) {
                Case casePlateau = new Case(new Points((char) ('A' + i), j + 1));
                this.lePlateau[i][j] = casePlateau;
            }
        }
    }
    
    // -----------------
    // GETTERS/SETTERS
    // -----------------
    
    public Case[][] getLePlateau() {
        return this.lePlateau;
    }
    
    public void setLePlateau(Case[][] lePlateau) {
        this.lePlateau = lePlateau;
    }
    
}