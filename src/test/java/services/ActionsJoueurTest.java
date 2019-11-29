package services;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import data.bateau.Bateau;
import data.bateau.SousMarin;
import data.interfaceJeu.Plateau;
import data.joueur.Joueur;

@RunWith(MockitoJUnitRunner.class)
public class ActionsJoueurTest
{

    // -------------------------------
    // Classe à tester (@InjectMocks)
    // -------------------------------

    @InjectMocks
    private ActionsJoueur actionsJoueur;

    // -------------------------
    // METHODES de test (@Test)
    // -------------------------

    @Before
    public void avantLesTests()
    {
        this.actionsJoueur = new ActionsJoueur();
    }

    @Ignore
    @Test
    public void testBateauTouche()
    {

        // Arrange
        final Joueur j1 = new Joueur();
        final Joueur j2 = new Joueur();
        final Plateau plateau = new Plateau(10, 10);
        final Bateau sousMarin = new SousMarin();
        j1.getListeBateaux().add(sousMarin);
        final int xTir = 0, yTir = 4;

        // actionsBateau.assignerCoordonneesBateaux(j, EnumTypeBateau.SOUS_MARIN, new Points('A', 1), new Points('A',
        // 5));
        // actionsBateau.placerLesBateauxSurLePlateau(Lists.newArrayList(sousMarin), plateau);

        // Act
        this.actionsJoueur.tirer(j2, j1, plateau, xTir, yTir, null);
        final boolean retour = plateau.getLePlateau()[xTir][yTir].isCaseTouche();

        // Assert
        assertTrue(retour);

    }

    @Test
    public void testTirer() throws Exception
    {

        // Arrange

        // Act

        // Assert
    }

    @Test
    public void testCoulerLeBateau() throws Exception
    {

        // Arrange

        // Act

        // Assert
    }

}
