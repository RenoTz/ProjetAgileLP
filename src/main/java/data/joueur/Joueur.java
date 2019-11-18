package data.joueur;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;

import data.bateau.Bateau;
import data.bateau.ContreTorpilleur;
import data.bateau.Croiseur;
import data.bateau.PorteAvion;
import data.bateau.SousMarin;
import data.bateau.Torpilleur;

public class Joueur
{

    // -----------------------
    // Attributs de la classe
    // -----------------------

    private String nom;

    private List<Bateau> bateaux;

    private boolean playing;

    private int score;

    // ---------------
    // CONSTRUCTEUR
    // ---------------

    public Joueur()
    {
        this.bateaux = Lists.newArrayList();
        this.bateaux.add(new PorteAvion());
        this.bateaux.add(new ContreTorpilleur());
        this.bateaux.add(new Croiseur());
        this.bateaux.add(new SousMarin());
        this.bateaux.add(new Torpilleur());

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

    public boolean isPlaying()
    {
        return this.playing;
    }

    public void setPlaying(final boolean playing)
    {
        this.playing = playing;
    }

    public boolean hasWon()
    {
        return CollectionUtils.isEmpty(this.bateaux);
    }

    public List<Bateau> getBateaux()
    {
        return this.bateaux;
    }

    public void setBateaux(final List<Bateau> bateaux)
    {
        this.bateaux = bateaux;
    }

    public boolean isTousLesBateauxPlaces()
    {
        for (final Bateau bateau : this.bateaux) {
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
