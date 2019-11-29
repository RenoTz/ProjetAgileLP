package data.joueur;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;

import data.bateau.Bateau;

public class Joueur
{

    // -----------------------
    // Attributs de la classe
    // -----------------------

    private String nom;

    private List<Bateau> listeBateaux;

    private boolean enTrainDeJouer;

    private int score;

    // ---------------
    // CONSTRUCTEUR
    // ---------------

    public Joueur()
    {
        this.listeBateaux = Lists.newArrayList();
        this.score = 0;
    }

    // ------------------------------
    // Getters / Setters specifiques
    // ------------------------------

    public String getNom()
    {
        return this.nom;
    }

    public void setNom(final String nom)
    {
        this.nom = nom;
    }

    public boolean isEnTrainDeJouer()
    {
        return this.enTrainDeJouer;
    }

    public void setEnTrainDeJouer(final boolean enTrainDeJouer)
    {
        this.enTrainDeJouer = enTrainDeJouer;
    }

    public boolean isGagne()
    {
        return CollectionUtils.isEmpty(this.listeBateaux);
    }

    public List<Bateau> getListeBateaux()
    {
        return this.listeBateaux;
    }

    public void setListeBateaux(final List<Bateau> listeBateaux)
    {
        this.listeBateaux = listeBateaux;
    }

    public boolean isTousLesBateauxPlaces()
    {
        for (final Bateau bateau : this.listeBateaux) {
            if (!bateau.isPlace()) {
                return false;
            }
        }
        return true;
    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(final int score)
    {
        this.score = score + 1;
    }
}
