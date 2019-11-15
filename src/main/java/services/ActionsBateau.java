package services;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import utils.FactoryUtils;

import com.google.common.base.Preconditions;

import data.bateau.Bateau;
import data.bateau.ContreTorpilleur;
import data.bateau.Croiseur;
import data.bateau.PorteAvion;
import data.bateau.SousMarin;
import data.bateau.Torpilleur;
import data.composants.Points;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;

public class ActionsBateau {
    
    // ------------------------
    // METHODES DE LA CLASSE
    // ------------------------
    
    public List<Bateau> initialiserListeBateaux() {
        
        List<Bateau> listeBateaux = new ArrayList<Bateau>();
        
        Bateau porteAvion = new PorteAvion();
        Bateau contreTorpilleur = new ContreTorpilleur();
        Bateau croiseur = new Croiseur();
        Bateau sousMarin = new SousMarin();
        Bateau torpilleur = new Torpilleur();
        listeBateaux.add(porteAvion);
        listeBateaux.add(contreTorpilleur);
        listeBateaux.add(croiseur);
        listeBateaux.add(sousMarin);
        listeBateaux.add(torpilleur);
        
        return listeBateaux;
    }
    
    public void saisieDesCoordonneesDesBateaux(final Joueur joueur, final Plateau plateau, final int xPos, final int yPos) {
        
        for (final Bateau bateau : joueur.getListeBateaux()) {
            if (!bateau.isPlace()) {
                plateau.getLePlateau()[xPos][yPos].getBouton().setBackground(Color.CYAN);
                if ((this.positionVerticaleBas(xPos, bateau) < plateau.getLePlateau().length)
                                && this.isWaterVersLeBas(plateau, xPos, yPos, bateau)) {
                    plateau.getLePlateau()[this.positionVerticaleBas(xPos, bateau)][yPos].getBouton().setBackground(Color.ORANGE);
                    plateau.getLePlateau()[this.positionVerticaleBas(xPos, bateau)][yPos].getBouton().setEnabled(true);
                }
                if ((this.positionVerticaleHaut(xPos, bateau) >= 0) && this.isWaterVersLeHaut(plateau, xPos, yPos, bateau)) {
                    plateau.getLePlateau()[this.positionVerticaleHaut(xPos, bateau)][yPos].getBouton().setBackground(Color.ORANGE);
                    plateau.getLePlateau()[this.positionVerticaleHaut(xPos, bateau)][yPos].getBouton().setEnabled(true);
                }
                if ((this.positionHorizontaleDroite(yPos, bateau) < plateau.getLePlateau().length)
                                && this.isWaterVersLaDroite(plateau, xPos, yPos, bateau)) {
                    plateau.getLePlateau()[xPos][this.positionHorizontaleDroite(yPos, bateau)].getBouton().setBackground(Color.ORANGE);
                    plateau.getLePlateau()[xPos][this.positionHorizontaleDroite(yPos, bateau)].getBouton().setEnabled(true);
                }
                if ((this.positionHorizontaleGauche(yPos, bateau) >= 0) && this.isWaterVersLaGauche(plateau, xPos, yPos, bateau)) {
                    plateau.getLePlateau()[xPos][this.positionHorizontaleGauche(yPos, bateau)].getBouton().setBackground(Color.ORANGE);
                    plateau.getLePlateau()[xPos][this.positionHorizontaleGauche(yPos, bateau)].getBouton().setEnabled(true);
                }
                bateau.getTabPoints()[0] = new Points(FactoryUtils.convertirIntToChar(xPos + 1), yPos + 1);
                break;
            }
        }
    }
    
    public void assignerCoordonneesBateaux(Joueur j, EnumTypeBateau typeBateau, Points coordonneesArriere) {
        if (CollectionUtils.isNotEmpty(j.getListeBateaux())) {
            for (Bateau bateau : j.getListeBateaux()) {
                if (bateau.getTypeBateau().equals(typeBateau)) {
                    // Placement des coordonn�es pour la premiere et la derniere case
                    Points coordonneesAvant = bateau.getTabPoints()[0];
                    bateau.getTabPoints()[bateau.getTabPoints().length - 1] = coordonneesArriere;
                    this.remplissageDesCasesIntermediaires(coordonneesAvant, coordonneesArriere, bateau);
                    break;
                }
            }
        }
    }
    
    public void supprimerBateau(Joueur j, Bateau bateauCoule) {
        if (CollectionUtils.isNotEmpty(j.getListeBateaux())) {
            for (Bateau bateau : j.getListeBateaux()) {
                if (bateau.getTypeBateau().equals(bateauCoule.getTypeBateau())) {
                    j.getListeBateaux().remove(bateau);
                    break;
                }
            }
        }
    }
    
    public void placerLesBateauxSurLePlateau(Bateau bateau, Plateau plateau) {
        
        int x = 0, y = 0;
        if (bateau.getTabPoints()[0] != null) {
            for (int caseBateau = 0; caseBateau < bateau.getTabPoints().length; caseBateau++) {
                x = FactoryUtils.convertirCharToInt(bateau.getTabPoints()[caseBateau].getxPos());
                y = bateau.getTabPoints()[caseBateau].getyPos() - 1;
                plateau.getLePlateau()[x][y].setWater(false);
                plateau.getLePlateau()[x][y].getBouton().setBackground(Color.DARK_GRAY);
            }
            bateau.setPlace(true);
        }
    }
    
    // --------------------------------
    // METHODES UTILITAIRES : PRIVEES
    // --------------------------------
    
    private boolean isWaterVersLeBas(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau) {
        for (int x = xPos; x <= this.positionVerticaleBas(xPos, bateau); x++) {
            if (!plateau.getLePlateau()[x][yPos].isWater()) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isWaterVersLeHaut(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau) {
        for (int x = this.positionVerticaleHaut(xPos, bateau); x <= xPos; x++) {
            if (!plateau.getLePlateau()[x][yPos].isWater()) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isWaterVersLaDroite(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau) {
        for (int y = yPos; y <= this.positionHorizontaleDroite(yPos, bateau); y++) {
            if (!plateau.getLePlateau()[xPos][y].isWater()) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isWaterVersLaGauche(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau) {
        for (int y = this.positionHorizontaleGauche(yPos, bateau); y <= yPos; y++) {
            if (!plateau.getLePlateau()[xPos][y].isWater()) {
                return false;
            }
        }
        return true;
    }
    
    private int positionHorizontaleDroite(int yPos, Bateau bateau) {
        return yPos + (bateau.getTabPoints().length - 1);
    }
    
    private int positionVerticaleBas(int xPos, Bateau bateau) {
        return xPos + (bateau.getTabPoints().length - 1);
    }
    
    private int positionHorizontaleGauche(int yPos, Bateau bateau) {
        return yPos - (bateau.getTabPoints().length - 1);
    }
    
    private int positionVerticaleHaut(int xPos, Bateau bateau) {
        return xPos - (bateau.getTabPoints().length - 1);
    }
    
    private void remplissageDesCasesIntermediaires(Points coordonneesAvant, Points coordonneesArriere, Bateau bateau) {
        // On remplie les cases interm�diaires
        int indice = 1;
        while (indice < (bateau.getTabPoints().length - 1)) {
            if (coordonneesArriere.getxPos() == coordonneesAvant.getxPos()) {
                bateau.getTabPoints()[indice] = new Points((coordonneesAvant.getxPos()), coordonneesAvant.getyPos() + indice);
                indice++;
            } else {
                bateau.getTabPoints()[indice] = new Points((char) (coordonneesAvant.getxPos() + indice), coordonneesAvant.getyPos());
                indice++;
            }
        }
    }
    
    private boolean caseBateauCorrespondCasePlateau(Plateau plateau, Bateau bateau, int caseBateau, int i, int j) {
        return (bateau.getTabPoints()[caseBateau].getxPos() == plateau.getLePlateau()[i][j].getPoint().getxPos())
                        && (bateau.getTabPoints()[caseBateau].getyPos() == plateau.getLePlateau()[i][j].getPoint().getyPos());
    }
    
    private void checkCoherenceDesCoordonnesPourLePlacementDesBateaux(Joueur j, EnumTypeBateau typeBateau, Points coordonneesAvant,
        Points coordonneesArriere) {
        Preconditions.checkArgument(
                        !this.bateauEnPositionVerticale(coordonneesAvant, coordonneesArriere)
                                        || !this.bateauEnPositionHorizontale(coordonneesAvant, coordonneesArriere),
                        "Le bateau doit être positionné verticalement ou horizontalement");
        Preconditions.checkArgument(
                        this.bateauEnPositionVerticale(coordonneesAvant, coordonneesArriere)
                                        || this.bateauEnPositionHorizontale(coordonneesAvant, coordonneesArriere),
                        "Les coordonnées ne sont pas correctes");
        this.checkCoherenceCoordonneesEtLongueurBateau(j, typeBateau, coordonneesAvant, coordonneesArriere);
    }
    
    private boolean bateauEnPositionVerticale(Points coordonneesAvant, Points coordonneesArriere) {
        return (coordonneesAvant.getxPos() == coordonneesArriere.getxPos()) && (coordonneesAvant.getyPos() != coordonneesArriere.getyPos());
    }
    
    private boolean bateauEnPositionHorizontale(Points coordonneesAvant, Points coordonneesArriere) {
        return (coordonneesAvant.getxPos() != coordonneesArriere.getxPos()) && (coordonneesAvant.getyPos() == coordonneesArriere.getyPos());
    }
    
    private boolean checkCoherenceCoordonneesEtLongueurBateau(Joueur j, EnumTypeBateau typeBateau, Points coordonneesAvant,
        Points coordonneesArriere) {
        boolean coherent = false;
        if (CollectionUtils.isNotEmpty(j.getListeBateaux())) {
            for (Bateau bateau : j.getListeBateaux()) {
                if (typeBateau.equals(bateau.getTypeBateau())) {
                    if (this.bateauEnPositionVerticale(coordonneesAvant, coordonneesArriere)) {
                        if (((coordonneesArriere.getyPos() - coordonneesAvant.getyPos()) > 0)
                                        && ((coordonneesArriere.getyPos() - coordonneesAvant.getyPos()) == (bateau.getTabPoints().length - 1))) {
                            coherent = true;
                            break;
                        } else if (((coordonneesAvant.getyPos() - coordonneesArriere.getyPos()) > 0)
                                        && ((coordonneesAvant.getyPos() - coordonneesArriere.getyPos()) == (bateau.getTabPoints().length - 1))) {
                            coherent = true;
                            break;
                        }
                    }
                    if (this.bateauEnPositionHorizontale(coordonneesAvant, coordonneesArriere)) {
                        if (((coordonneesAvant.getxPos() - coordonneesArriere.getyPos()) > 0)
                                        && ((coordonneesAvant.getxPos() - coordonneesArriere.getxPos()) == (bateau.getTabPoints().length - 1))) {
                            coherent = true;
                            break;
                        } else if (((coordonneesArriere.getxPos() - coordonneesAvant.getxPos()) > 0)
                                        && ((coordonneesArriere.getxPos() - coordonneesAvant.getxPos()) == (bateau.getTabPoints().length - 1))) {
                            coherent = true;
                            break;
                        }
                    }
                }
            }
        }
        return coherent;
    }
    
}