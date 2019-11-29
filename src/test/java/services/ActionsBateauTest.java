package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import data.bateau.Bateau;
import data.bateau.Croiseur;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;
import utils.FactoryUtils;

@RunWith(MockitoJUnitRunner.class)
public class ActionsBateauTest
{

    @Mock
    private Bateau bateau;

    // -------------------------------
    // Classe à tester (@InjectMocks)
    // -------------------------------

    @InjectMocks
    private ActionsBateau action;

    // -------------------------
    // METHODES de test (@Test)
    // -------------------------

    @Test
    public void testActionsBateauInitialiserListe()
    {
        // Arrange

        // Act
        final List<Bateau> listeRetour = this.action.initialiserBateaux();

        // Assert
        assertNotNull(listeRetour);
        assertEquals(listeRetour.size(), 5);
        assertEquals(true, this.verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.CONTRE_TORPILLEUR));
        assertEquals(true, this.verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.CROISEUR));
        assertEquals(true, this.verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.PORTE_AVION));
        assertEquals(true, this.verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.SOUS_MARIN));
        assertEquals(true, this.verifierPresenceTypeBateau(listeRetour, EnumTypeBateau.TORPILLEUR));
    }

    @Test
    public void testPlacerLesBateauxSurLePlateaAvecListeBateauNonNulleEtCoordonneesCorrectes()
    {
        // Arrange
        final Joueur j = new Joueur();
        final Plateau plateau = new Plateau(10, 10);
        j.setListeBateaux(this.action.initialiserBateaux());
    }

    @Ignore
    @Test
    public void testPlacerLesBateauxSurLePlateauAvecListeBateauVide()
    {
        // Arrange
        final Joueur j = new Joueur();
        final Plateau plateau = new Plateau(10, 10);
        final List<Bateau> listeVide = Lists.newArrayList();
        j.setListeBateaux(listeVide);

        // Act
        // this.action.placerLesBateauxSurLePlateau(j.getListeBateaux(), plateau);

        // Assert
        assertTrue(this.toutesLesCasesDuPlateauSontBleues(plateau));
    }

    @Ignore
    @Test
    public void testSupprimerBateau()
    {
        // Arrange
        final Joueur j = new Joueur();
        j.setListeBateaux(this.action.initialiserBateaux());
        this.bateau = new Croiseur();
        // Act
        this.action.supprimerBateau(j, this.bateau);

        // Assert
        assertTrue(this.verifierBateauSupprime(j, this.bateau.getTypeBateau()));
    }

    // --------------------------------
    // METHODES UTILITAIRES : PRIVEES
    // --------------------------------

    private boolean verifierCasePlateauModifie(final List<Bateau> listeBateau, final EnumTypeBateau type,
        final Plateau plateau, final char x, final int y)
    {

        final int xPos = FactoryUtils.convertirCharToInt(x);

        if (this.estUneCaseBateau(plateau, xPos, y - 1)) {
            return true;
        }
        return false;
    }

    private boolean toutesLesCasesDuPlateauSontBleues(final Plateau plateau)
    {
        for (int i = 0; i < plateau.getLePlateau().length; i++) {
            for (final int j = 0; i < plateau.getLePlateau().length; i++) {
                if (this.estUneCaseBateau(plateau, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean estUneCaseBateau(final Plateau plateau, final int i, final int j)
    {
        return !plateau.getLePlateau()[i][j].isWater();
    }

    private boolean verifierPresenceTypeBateau(final List<Bateau> listeRetour, final EnumTypeBateau type)
    {
        for (final Bateau bateau : listeRetour) {
            if (bateau.getTypeBateau().equals(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean verifierBateauSupprime(final Joueur j, final EnumTypeBateau typeBateau)
    {
        for (final Bateau bateau : j.getListeBateaux()) {
            if (bateau.getTypeBateau().equals(typeBateau)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testAssignerCoordonneesBateauxListeVide() throws Exception
    {

        // Arrange
        final Joueur j = new Joueur();
        // Act
        // action.assignerCoordonneesBateaux(j, EnumTypeBateau.CROISEUR, new Points('A', 1), new Points('A', 4));
        // Assert

    }

}
