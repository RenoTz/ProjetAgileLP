package data.plateau;

public class Position
{

    // -----------------------
    // Attributs de la classe
    // -----------------------
    private char x;

    private Integer y;

    // --------------------------
    // Constructeur de la classe
    // --------------------------

    public Position()
    {
    }

    public Position(final char x, final Integer y)
    {
        this.setX(x);
        this.setY(y);
    }

    // ----------------
    // Getters/Setters
    // ----------------

    public char getX()
    {
        return this.x;
    }

    public void setX(final char x)
    {
        this.x = x;
    }

    public Integer getY()
    {
        return this.y;
    }

    public void setY(final Integer y)
    {
        this.y = y;
    }

}
