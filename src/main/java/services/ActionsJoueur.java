package services;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import utils.FactoryUtils;
import data.bateau.Bateau;
import data.composants.Case;
import data.composants.Points;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;

public class ActionsJoueur {
    
    // ------------------------
    // ATTRIBUTS DE LA CLASSE
    // ------------------------
    
    private ActionsBateau actionsBateau = new ActionsBateau();
    private EnumTypeBateau bateauTouche;
    private Bateau bateauCoule;
    
    // ------------------------
    // METHODES DE LA CLASSE
    // ------------------------
    
    public void tirer(Joueur joueurEnCours, Joueur adversaire, Plateau plateau, int x, int y, JButton boutonScore) {
        
        if (!plateau.getLePlateau()[x][y].isWater() || plateau.getLePlateau()[x][y].isCaseTouche()) {
            plateau.getLePlateau()[x][y].setCaseTouche(true);
            plateau.getLePlateau()[x][y].getBouton().setIcon(new ImageIcon("img/bomb.png"));
            plateau.getLePlateau()[x][y].getBouton().setBackground(Color.RED);
            plateau.getLePlateau()[x][y].getBouton().setEnabled(false);
            
            this.bateauTouche = this.recupererLeTypeBateauTouche(plateau.getLePlateau()[x][y], adversaire);
            
            if (this.verifierQueToutesLesCasesBateauxSontTouchees(adversaire, plateau, this.bateauTouche)) {
                
                this.bateauCoule = this.recupererBateau(adversaire.getListeBateaux(), this.bateauTouche);
                
                if (this.bateauCoule != null) {
                    this.coulerLeBateau(this.bateauCoule, plateau, adversaire, joueurEnCours, boutonScore);
                }
            }
        } else {
            plateau.getLePlateau()[x][y].getBouton().setBackground(Color.WHITE);
        }
    }
    
    // --------------------------------
    // METHODES UTILITAIRES : PRIVEES
    // --------------------------------
    
    private void coulerLeBateau(Bateau bateau, Plateau plateau, Joueur adversaire, Joueur joueurEnCours, JButton boutonScore) {
        // On colore le bateau coulé et on désactive les cases
        for (int i = 0; i < bateau.getTabPoints().length; i++) {
            if (plateau.getLePlateau()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton().getBackground()
                            .equals(Color.RED)) {
                plateau.getLePlateau()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton().setBackground(
                                new Color(0, 150, 0));
                plateau.getLePlateau()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton().setEnabled(false);
            }
        }
        this.actionsBateau.supprimerBateau(adversaire, bateau);
        // MAJ du score et du label
        joueurEnCours.setScore(joueurEnCours.getScore());
        boutonScore.setText(" " + joueurEnCours.getScore());
    }
    
    private boolean verifierQueToutesLesCasesBateauxSontTouchees(Joueur joueur, Plateau plateau, EnumTypeBateau bateauTouche) {
        if (StringUtils.isNotBlank(bateauTouche.toString())) {
            for (Bateau bateau : joueur.getListeBateaux()) {
                if (bateau.getTypeBateau().equals(bateauTouche)) {
                    int nombreCasesTouches = 0;
                    for (int i = 0; i < bateau.getTabPoints().length; i++) {
                        if (plateau.getLePlateau()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton().getBackground()
                                        .equals(Color.RED)) {
                            nombreCasesTouches++;
                            if (nombreCasesTouches == bateau.getTabPoints().length) {
                                return true;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return false;
    }
    
    private Bateau recupererBateau(List<Bateau> listeBateaux, EnumTypeBateau bateauTouche) {
        if (CollectionUtils.isNotEmpty(listeBateaux)) {
            for (Bateau bateau : listeBateaux) {
                if (bateau.getTypeBateau().equals(bateauTouche)) {
                    return bateau;
                }
            }
        }
        return null;
    }
    
    private EnumTypeBateau recupererLeTypeBateauTouche(Case caseBateau, Joueur joueur) {
        EnumTypeBateau typeBateauTouche = null;
        for (Bateau bateau : joueur.getListeBateaux()) {
            for (Points point : Arrays.asList(bateau.getTabPoints())) {
                if (((point.getxPos() == caseBateau.getPoint().getxPos()) && (point.getyPos() == caseBateau.getPoint().getyPos()))) {
                    typeBateauTouche = bateau.getTypeBateau();
                    break;
                }
            }
        }
        return typeBateauTouche;
    }
    
    private Integer yCaseBateau(Bateau bateau, int i) {
        return bateau.getTabPoints()[i].getyPos();
    }
    
    private int xCaseBateau(Bateau bateau, int i) {
        return FactoryUtils.convertirCharToInt(bateau.getTabPoints()[i].getxPos());
    }
}
