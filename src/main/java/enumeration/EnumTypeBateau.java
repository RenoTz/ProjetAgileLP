package enumeration;

public enum EnumTypeBateau
{

    PORTE_AVION("PORTE AVION"),
    CROISEUR("CROISEUR"),
    CONTRE_TORPILLEUR("CONTRE TORPILLEUR"),
    SOUS_MARIN("SOUS-MARIN"),
    TORPILLEUR("TORPILLEUR");

    private String nom;

    private EnumTypeBateau(final String nom)
    {
        this.nom = nom;
    }

    @Override
    public String toString()
    {
        return this.nom;
    }
}
