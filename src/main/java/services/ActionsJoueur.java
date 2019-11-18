package services;

import static java.util.Objects.nonNull;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import data.bateau.Bateau;
import data.ihm.Plateau;
import data.joueur.Joueur;
import data.plateau.Case;
import data.plateau.Position;
import enumeration.EnumTypeBateau;
import utils.FactoryUtils;

public class ActionsJoueur implements Serializable
{

    private static final long serialVersionUID = -7821067315687213267L;

    private final ActionsBateau actionsBateau;

    public ActionsJoueur()
    {
        this.actionsBateau = new ActionsBateau();
    }

    public void tirer(final Joueur joueurEnCours, final Joueur adversaire, final Plateau plateau, final int x,
        final int y, final JButton boutonScore)
    {

        if (!plateau.getCases()[x][y].isWater() || plateau.getCases()[x][y].isTouche()) {
            plateau.getCases()[x][y].setTouche(true);
            plateau.getCases()[x][y].getBouton().setIcon(new ImageIcon("img/bomb.png"));
            plateau.getCases()[x][y].getBouton().setBackground(Color.RED);
            plateau.getCases()[x][y].getBouton().setEnabled(false);

            final EnumTypeBateau bateauTouche = this.recupererLeTypeBateauTouche(plateau.getCases()[x][y], adversaire);

            if (nonNull(bateauTouche)
                && this.verifierQueToutesLesCasesBateauxSontTouchees(adversaire, plateau, bateauTouche)) {

                final Bateau bateauCoule = this.recupererBateau(adversaire.getBateaux(), bateauTouche);

                if (nonNull(bateauCoule)) {
                    this.coulerLeBateau(bateauCoule, plateau, adversaire, joueurEnCours, boutonScore);
                }
            }
        } else {
            plateau.getCases()[x][y].getBouton().setBackground(Color.WHITE);
        }
    }

    private void coulerLeBateau(final Bateau bateau, final Plateau plateau, final Joueur adversaire,
        final Joueur joueurEnCours, final JButton boutonScore)
    {
        // On colore le bateau coulé et on désactive les cases
        for (int i = 0; i < bateau.getTabPoints().length; i++) {
            if (plateau.getCases()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton()
                .getBackground().equals(Color.RED)) {
                plateau.getCases()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton()
                    .setBackground(new Color(0, 150, 0));
                plateau.getCases()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton()
                    .setEnabled(false);
            }
        }
        this.actionsBateau.supprimerBateau(adversaire, bateau);
        // MAJ du score et du label
        joueurEnCours.setScore(joueurEnCours.getScore());
        boutonScore.setText(" " + joueurEnCours.getScore());
    }

    private boolean verifierQueToutesLesCasesBateauxSontTouchees(final Joueur joueur, final Plateau plateau,
        final EnumTypeBateau bateauTouche)
    {
        for (final Bateau bateau : joueur.getBateaux()) {
            if (bateau.getTypeBateau().equals(bateauTouche)) {
                int nombreCasesTouches = 0;
                for (int i = 0; i < bateau.getTabPoints().length; i++) {
                    if (plateau.getCases()[this.xCaseBateau(bateau, i)][this.yCaseBateau(bateau, i) - 1].getBouton()
                        .getBackground().equals(Color.RED)) {
                        nombreCasesTouches++;
                        if (nombreCasesTouches == bateau.getTabPoints().length) {
                            return true;
                        }
                    }
                }
                break;
            }
        }
        return false;
    }

    private Bateau recupererBateau(final List<Bateau> listeBateaux, final EnumTypeBateau bateauTouche)
    {
        return listeBateaux.stream().filter(b -> b.getTypeBateau() == bateauTouche).findFirst().orElse(null);
    }

    private EnumTypeBateau recupererLeTypeBateauTouche(final Case caseBateau, final Joueur joueur)
    {
        EnumTypeBateau typeBateauTouche = null;
        for (final Bateau bateau : joueur.getBateaux()) {
            for (final Position point : Arrays.asList(bateau.getTabPoints())) {
                if (((point.getX() == caseBateau.getPosition().getX())
                    && (point.getY().equals(caseBateau.getPosition().getY())))) {
                    typeBateauTouche = bateau.getTypeBateau();
                    break;
                }
            }
        }
        return typeBateauTouche;
    }

    private Integer yCaseBateau(final Bateau bateau, final int i)
    {
        return bateau.getTabPoints()[i].getY();
    }

    private int xCaseBateau(final Bateau bateau, final int i)
    {
        return FactoryUtils.convertirCharToInt(bateau.getTabPoints()[i].getX());
    }
}
