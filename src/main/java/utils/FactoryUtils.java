package utils;

import java.util.Map;

import com.google.common.collect.Maps;

import data.bateau.Bateau;
import data.ihm.Plateau;

public class FactoryUtils
{

    private static final Map<Character, Integer> mapCharInt = Maps.newHashMap();

    static {
        mapCharInt.put('A', 1);
        mapCharInt.put('B', 2);
        mapCharInt.put('C', 3);
        mapCharInt.put('D', 4);
        mapCharInt.put('E', 5);
        mapCharInt.put('F', 6);
        mapCharInt.put('G', 7);
        mapCharInt.put('H', 8);
        mapCharInt.put('I', 9);
        mapCharInt.put('J', 10);
        mapCharInt.put('K', 11);
        mapCharInt.put('L', 12);
    }

    private FactoryUtils()
    {
    }

    public static int convertirCharToInt(final char lettre)
    {
        return mapCharInt.get(lettre);
    }

    public static char convertirIntToChar(final int indice)
    {
        // @formatter:off
        return mapCharInt.entrySet().stream()
            .filter(e -> e.getValue().intValue() == indice)
            .map(Map.Entry::getKey)
            .findFirst().orElse(' ');
        // @formatter:on
    }

    public static Integer getYPos(final Plateau plateau, final int i, final int j)
    {
        return plateau.getCases()[i][j].getPosition().getY();
    }

    public static Integer getXPos(final Plateau plateau, final int i, final int j)
    {
        return FactoryUtils.convertirCharToInt(plateau.getCases()[i][j].getPosition().getX());
    }

    public static int positionHorizontale(final int yPos, final Bateau bateau)
    {
        return yPos + bateau.getTabPoints().length - 1;
    }

    public static int positionVerticale(final int xPos, final Bateau bateau)
    {
        return xPos + bateau.getTabPoints().length - 1;
    }
}
