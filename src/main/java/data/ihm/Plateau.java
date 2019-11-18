package data.ihm;

import data.plateau.Case;
import data.plateau.Position;

public class Plateau
{

    private Case[][] cases;

    public Plateau(final int largeur, final int longueur)
    {
        this.cases = new Case[largeur][longueur];
        this.init();
    }

    public void init()
    {
        for (int i = 0; i < this.cases.length; i++) {
            for (int j = 0; j < this.cases.length; j++) {
                final Case casePlateau = new Case(new Position((char) ('A' + i), j + 1));
                this.cases[i][j] = casePlateau;
            }
        }
    }

    public Case[][] getCases()
    {
        return this.cases;
    }

    public void setCases(final Case[][] cases)
    {
        this.cases = cases;
    }

}
