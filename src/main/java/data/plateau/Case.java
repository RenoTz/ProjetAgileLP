package data.plateau;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Case
{

    // ------------------------
    // ATTRIBUTS DE LA CLASSE
    // ------------------------

    private Position position;

    private boolean touche;

    private boolean water;

    private JButton bouton;

    // ---------------
    // CONSTRUCTEUR
    // ---------------

    public Case(final Position point)
    {
        this.setPosition(point);
        this.touche = false;
        this.setWater(true);
        this.bouton = this.creerBouton();
    }

    // --------------------------------
    // METHODES SPECIFIQUES : PRIVEES
    // --------------------------------

    private JButton creerBouton()
    {
        this.bouton = new JButton(new ImageIcon("img/waves.png"));
        this.bouton.setBackground(Color.BLUE);
        this.bouton.setPreferredSize(new Dimension(40, 40));
        this.bouton.setForeground(Color.WHITE);
        return this.bouton;
    }

    // -----------------
    // GETTERS/SETTERS
    // -----------------

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(final Position position)
    {
        this.position = position;
    }

    public boolean isTouche()
    {
        if (this.getBouton().getBackground().equals(Color.RED)) {
            this.touche = true;
        }
        return this.touche;
    }

    public void setTouche(final boolean touche)
    {
        this.touche = touche;
    }

    public JButton getBouton()
    {
        return this.bouton;
    }

    public void setBouton(final JButton bouton)
    {
        this.bouton = bouton;
    }

    public boolean isWater()
    {
        return this.water;
    }

    public void setWater(final boolean water)
    {
        this.water = water;
    }
}
