package services;

import java.awt.Color;
import java.io.Serializable;

import org.apache.commons.collections.CollectionUtils;

import data.bateau.Bateau;
import data.ihm.Plateau;
import data.joueur.Joueur;
import data.plateau.Position;
import enumeration.EnumTypeBateau;
import utils.FactoryUtils;

public class ActionsBateau implements Serializable
{

    private static final long serialVersionUID = -5000084123460559258L;

    public void saisieDesCoordonneesDesBateaux(final Joueur joueur, final Plateau plateau, final int xPos,
        final int yPos)
    {

        joueur.getBateaux().stream().filter(bateau -> !bateau.isPlace()).forEach(bateau -> {
            plateau.getCases()[xPos][yPos].getBouton().setBackground(Color.CYAN);
            if ((this.positionVerticaleBas(xPos, bateau) < plateau.getCases().length)
                && this.isWaterOnTheBottom(plateau, xPos, yPos, bateau)) {
                plateau.getCases()[this.positionVerticaleBas(xPos, bateau)][yPos].getBouton()
                    .setBackground(Color.ORANGE);
                plateau.getCases()[this.positionVerticaleBas(xPos, bateau)][yPos].getBouton().setEnabled(true);
            }
            if ((this.positionVerticaleHaut(xPos, bateau) >= 0) && this.isWaterOnTheTop(plateau, xPos, yPos, bateau)) {
                plateau.getCases()[this.positionVerticaleHaut(xPos, bateau)][yPos].getBouton()
                    .setBackground(Color.ORANGE);
                plateau.getCases()[this.positionVerticaleHaut(xPos, bateau)][yPos].getBouton().setEnabled(true);
            }
            if ((this.positionHorizontaleDroite(yPos, bateau) < plateau.getCases().length)
                && this.isWaterOnTheRight(plateau, xPos, yPos, bateau)) {
                plateau.getCases()[xPos][this.positionHorizontaleDroite(yPos, bateau)].getBouton()
                    .setBackground(Color.ORANGE);
                plateau.getCases()[xPos][this.positionHorizontaleDroite(yPos, bateau)].getBouton().setEnabled(true);
            }
            if ((this.positionHorizontaleGauche(yPos, bateau) >= 0)
                && this.isWaterOnTheLeft(plateau, xPos, yPos, bateau)) {
                plateau.getCases()[xPos][this.positionHorizontaleGauche(yPos, bateau)].getBouton()
                    .setBackground(Color.ORANGE);
                plateau.getCases()[xPos][this.positionHorizontaleGauche(yPos, bateau)].getBouton().setEnabled(true);
            }
            bateau.getTabPoints()[0] = new Position(FactoryUtils.convertirIntToChar(xPos + 1), yPos + 1);
        });
    }

    public void assignerCoordonneesBateaux(final Joueur j, final EnumTypeBateau typeBateau,
        final Position coordonneesArriere)
    {
        // Placement des coordonn�es pour la premiere et la derniere case
        j.getBateaux().stream().filter(b -> b.getTypeBateau() == typeBateau).forEach(b -> {
            final Position coordonneesAvant = b.getTabPoints()[0];
            b.getTabPoints()[b.getTabPoints().length - 1] = coordonneesArriere;
            this.remplissageDesCasesIntermediaires(coordonneesAvant, coordonneesArriere, b);
        });
    }

    public void supprimerBateau(final Joueur j, final Bateau bateauCoule)
    {
        if (CollectionUtils.isNotEmpty(j.getBateaux())) {
            for (final Bateau bateau : j.getBateaux()) {
                if (bateau.getTypeBateau().equals(bateauCoule.getTypeBateau())) {
                    j.getBateaux().remove(bateau);
                    break;
                }
            }
        }
    }

    public void placerLesBateauxSurLePlateau(final Bateau bateau, final Plateau plateau)
    {

        int x = 0, y = 0;
        if (bateau.getTabPoints()[0] != null) {
            for (int caseBateau = 0; caseBateau < bateau.getTabPoints().length; caseBateau++) {
                x = FactoryUtils.convertirCharToInt(bateau.getTabPoints()[caseBateau].getX());
                y = bateau.getTabPoints()[caseBateau].getY() - 1;
                plateau.getCases()[x][y].setWater(false);
                plateau.getCases()[x][y].getBouton().setBackground(Color.DARK_GRAY);
            }
            bateau.setPlace(true);
        }
    }

    // --------------------------------
    // METHODES UTILITAIRES : PRIVEES
    // --------------------------------

    private boolean isWaterOnTheBottom(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau)
    {
        for (int x = xPos; x <= this.positionVerticaleBas(xPos, bateau); x++) {
            if (!plateau.getCases()[x][yPos].isWater()) {
                return false;
            }
        }
        return true;
    }

    private boolean isWaterOnTheTop(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau)
    {
        for (int x = this.positionVerticaleHaut(xPos, bateau); x <= xPos; x++) {
            if (!plateau.getCases()[x][yPos].isWater()) {
                return false;
            }
        }
        return true;
    }

    private boolean isWaterOnTheRight(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau)
    {
        for (int y = yPos; y <= this.positionHorizontaleDroite(yPos, bateau); y++) {
            if (!plateau.getCases()[xPos][y].isWater()) {
                return false;
            }
        }
        return true;
    }

    private boolean isWaterOnTheLeft(final Plateau plateau, final int xPos, final int yPos, final Bateau bateau)
    {
        for (int y = this.positionHorizontaleGauche(yPos, bateau); y <= yPos; y++) {
            if (!plateau.getCases()[xPos][y].isWater()) {
                return false;
            }
        }
        return true;
    }

    private int positionHorizontaleDroite(final int yPos, final Bateau bateau)
    {
        return yPos + (bateau.getTabPoints().length - 1);
    }

    private int positionVerticaleBas(final int xPos, final Bateau bateau)
    {
        return xPos + (bateau.getTabPoints().length - 1);
    }

    private int positionHorizontaleGauche(final int yPos, final Bateau bateau)
    {
        return yPos - (bateau.getTabPoints().length - 1);
    }

    private int positionVerticaleHaut(final int xPos, final Bateau bateau)
    {
        return xPos - (bateau.getTabPoints().length - 1);
    }

    private void remplissageDesCasesIntermediaires(final Position coordonneesAvant, final Position coordonneesArriere,
        final Bateau bateau)
    {
        // On remplie les cases interm�diaires
        int indice = 1;
        while (indice < (bateau.getTabPoints().length - 1)) {
            if (coordonneesArriere.getX() == coordonneesAvant.getX()) {
                bateau.getTabPoints()[indice] =
                    new Position((coordonneesAvant.getX()), coordonneesAvant.getY() + indice);
                indice++;
            } else {
                bateau.getTabPoints()[indice] =
                    new Position((char) (coordonneesAvant.getX() + indice), coordonneesAvant.getY());
                indice++;
            }
        }
    }

}
