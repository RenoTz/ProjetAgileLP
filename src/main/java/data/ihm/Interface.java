package data.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.google.common.collect.Lists;

import controleur.Partie;
import data.bateau.Bateau;
import data.joueur.Joueur;
import data.plateau.Position;
import services.ActionsBateau;
import services.ActionsJoueur;
import utils.FactoryUtils;

public class Interface extends JFrame
{

    // ------------
    // ATTRIBUTS
    // ------------
    private boolean premierClic;

    private final ActionsJoueur actionsJoueurs;

    private final ActionsBateau actionsBateau;

    private final Joueur joueur;

    private final Joueur adversaire;

    private final List<JButton> listeBoutonJoueur;

    private final List<JButton> listeBoutonAdversaire;

    private final List<JButton> listeBoutonCoordsLettres;

    private final List<JButton> listeBoutonCoordsChiffres;

    private final List<JButton> listeBoutonCoordsChiffres2;

    private final Plateau plateauJoueur;

    private final Plateau plateauAdversaire;

    private JFrame frame;

    private JPanel panelJoueur;

    private JPanel panelAdversaire;

    private static JButton boutonChangementJoueur;

    private JButton boutonCasePlateau;

    private static JButton boutonScore;

    private static JButton labelConsole;

    // -------------
    // CONSTANTES
    // -------------

    private static final long serialVersionUID = 1L;

    private static final String TYPE_LETTRE = "lettre";

    private static final String TYPE_CHIFFRE = "chiffre";

    private static final int TAILLE_PLATEAU = 12;

    // ---------------
    // CONSTRUCTEUR
    // ---------------

    public Interface(final Joueur joueur, final Joueur adversaire)
    {
        this.actionsJoueurs = new ActionsJoueur();
        this.actionsBateau = new ActionsBateau();
        this.joueur = joueur;
        this.adversaire = adversaire;
        this.plateauJoueur = new Plateau(TAILLE_PLATEAU, TAILLE_PLATEAU);
        this.plateauAdversaire = new Plateau(TAILLE_PLATEAU, TAILLE_PLATEAU);
        this.listeBoutonJoueur = this.creerCasesGraphiques(new Plateau(TAILLE_PLATEAU, TAILLE_PLATEAU));
        this.listeBoutonAdversaire = this.creerCasesGraphiques(new Plateau(TAILLE_PLATEAU, TAILLE_PLATEAU));
        this.listeBoutonCoordsLettres = this.creerListeBoutonsContourPlateau(TYPE_LETTRE);
        this.listeBoutonCoordsChiffres = this.creerListeBoutonsContourPlateau(TYPE_CHIFFRE);
        this.listeBoutonCoordsChiffres2 = this.creerListeBoutonsContourPlateau(TYPE_CHIFFRE);
        this.premierClic = true;
        this.creerLaFenetre();

    }

    // ------------------------
    // METHODES DE LA CLASSE
    // ------------------------

    public void creerLaFenetre()
    {

        this.frame = new JFrame("Bataille navale");
        this.frame.setTitle("Bataille Navale - Groupe 1");
        // Panneau principal
        final JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(1, 2));
        panelPrincipal.setBackground(Color.black);

        // Grille de jeu du joueur
        this.panelJoueur = new JPanel();
        this.panelJoueur.setLayout(new GridLayout(TAILLE_PLATEAU, TAILLE_PLATEAU));
        this.panelJoueur.setBackground(Color.black);

        final Border margeJ = BorderFactory.createEmptyBorder(0, 15, 0, 0);
        this.panelJoueur.setBorder(margeJ);

        // Grille de jeu de l'adversaire
        this.panelAdversaire = new JPanel();
        this.panelAdversaire.setLayout(new GridLayout(TAILLE_PLATEAU, TAILLE_PLATEAU));
        this.panelAdversaire.setBackground(Color.black);
        this.panelAdversaire.setVisible(false);
        final Border margeA = BorderFactory.createEmptyBorder(0, 15, 0, 0);
        this.panelAdversaire.setBorder(margeA);

        // Panneau des coordonnées des lettres
        final JPanel panelCoordLettres = new JPanel();
        panelCoordLettres.setLayout(new FlowLayout());
        panelCoordLettres.setBackground(Color.black);

        final Border margeL = BorderFactory.createEmptyBorder(0, 15, 0, 0);
        panelCoordLettres.setBorder(margeL);

        // Panneau des coordonnées des chiffres
        final JPanel panelCoordChiffres1 = new JPanel();
        panelCoordChiffres1.setLayout(new FlowLayout());
        panelCoordChiffres1.setBackground(Color.black);

        // Grille de jeu de l'adversaire
        final JPanel panelCoordChiffres2 = new JPanel();
        panelCoordChiffres2.setLayout(new FlowLayout());
        panelCoordChiffres2.setBackground(Color.black);

        // Panneau du Menu
        final JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new FlowLayout());
        final JPanel gridMenu = new JPanel();
        gridMenu.setLayout(new GridLayout(1, 5, 145, 80));
        gridMenu.setBackground(Color.BLACK);

        // Panneau "console"
        final JPanel panelConsole = new JPanel();
        labelConsole = new JButton();
        panelConsole.setLayout(new BorderLayout());
        labelConsole.setText("Bienvenue dans la Bataille Navale 3.0");
        labelConsole.setForeground(Color.WHITE);
        labelConsole.setBackground(Color.BLACK);
        labelConsole.setEnabled(false);
        panelConsole.add(labelConsole, BorderLayout.SOUTH);

        // Bouton 'Nouvelle partie'
        JButton nouvellePartieBouton = creerBoutonBandeauSuperieur();
        nouvellePartieBouton = new JButton(new ImageIcon("img/reload.png"));
        nouvellePartieBouton.setText("Nouvelle Partie");
        nouvellePartieBouton.addActionListener(new ActionListener()
        {
            @SuppressWarnings("unused")
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                Interface.this.frame.setVisible(false);
                Interface.this.frame.dispose();
                final Partie partie = new Partie();
            }
        });

        // Bouton 'Joueur'
        JButton boutonJoueur = creerBoutonBandeauSuperieur();
        boutonJoueur.setPreferredSize(new Dimension(125, 55));
        boutonJoueur = new JButton(new ImageIcon("img/user.png"));
        boutonJoueur.setText(this.joueur.getNom());
        boutonJoueur.setEnabled(false);

        // Bouton 'Score'
        boutonScore = creerBoutonBandeauSuperieur();
        boutonScore = new JButton(new ImageIcon("img/award.png"));
        boutonScore.setText("     " + this.joueur.getScore());
        boutonScore.setEnabled(false);

        // Bouton 'Adversaire'
        JButton boutonAdversaire = creerBoutonBandeauSuperieur();
        boutonAdversaire = new JButton(new ImageIcon("img/user.png"));
        boutonAdversaire.setText(this.adversaire.getNom());
        boutonAdversaire.setEnabled(false);

        // Bouton 'Changement de joueur'
        boutonChangementJoueur = new JButton(new ImageIcon("img/arrow.png"));
        boutonChangementJoueur.setPreferredSize(new Dimension(125, 55));
        boutonChangementJoueur.setBackground(Color.WHITE);
        boutonChangementJoueur.setForeground(Color.BLACK);
        boutonChangementJoueur.setEnabled(false);
        boutonChangementJoueur.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(final ActionEvent e)
            {
                // On colore en ROUGE le bouton de changement de joueur et on le
                // désactive
                boutonChangementJoueur.setBackground(Color.RED);
                boutonChangementJoueur.setEnabled(false);

                if (Interface.this.joueur.isPlaying()) {
                    this.eventChangementDeJoueur(Interface.this.adversaire, Interface.this.plateauJoueur, false, true,
                        true, false);
                } else {
                    this.eventChangementDeJoueur(Interface.this.joueur, Interface.this.plateauAdversaire, true, false,
                        false, true);
                }
            }

            private void eventChangementDeJoueur(final Joueur joueurProchain, final Plateau plateau,
                final boolean joueurJoue, final boolean adversaireJoue, final boolean plateauJoueurVisible,
                final boolean plateauAdversaireVisible)
            {
                labelConsole.setText("Au tour de " + joueurProchain.getNom());
                boutonScore.setText("     " + joueurProchain.getScore());
                // Changement de joueur
                Interface.this.joueur.setPlaying(joueurJoue);
                Interface.this.adversaire.setPlaying(adversaireJoue);
                // On alterne l'affichage des plateaux
                Interface.this.panelJoueur.setVisible(plateauJoueurVisible);
                Interface.this.panelAdversaire.setVisible(plateauAdversaireVisible);
                this.reactiverLesCasesDuPlateau(plateau);
            }

            private void reactiverLesCasesDuPlateau(final Plateau plateau)
            {
                for (int i = 0; i < plateau.getCases().length; i++) {
                    for (int j = 0; j < plateau.getCases().length; j++) {
                        if (!plateau.getCases()[i][j].isTouche()) {
                            plateau.getCases()[i][j].getBouton().setEnabled(true);
                        }
                    }
                }
            }
        });

        // Ajout des paneaux au panneau principal
        panelPrincipal.add(this.panelJoueur);
        panelPrincipal.add(this.panelAdversaire);

        // Ajout des boutons au layout
        gridMenu.add(boutonJoueur);
        gridMenu.add(nouvellePartieBouton);
        gridMenu.add(boutonChangementJoueur);
        gridMenu.add(boutonScore);
        gridMenu.add(boutonAdversaire);
        panelMenu.add(gridMenu);

        // Create button
        ajouterLaListeBoutonsAuPanel(this.panelJoueur, this.listeBoutonJoueur);
        ajouterLaListeBoutonsAuPanel(this.panelAdversaire, this.listeBoutonAdversaire);
        ajouterLaListeBoutonsAuPanel(panelCoordLettres, this.listeBoutonCoordsLettres);
        ajouterLaListeBoutonsAuPanel(panelCoordChiffres1, this.listeBoutonCoordsChiffres);
        ajouterLaListeBoutonsAuPanel(panelCoordChiffres2, this.listeBoutonCoordsChiffres2);

        // Colonne des Lettres du plateau
        final Border padding = BorderFactory.createEmptyBorder(120, 60, 5, 5);
        panelPrincipal.setBorder(padding);

        // Panneau du Menu
        panelMenu.setBounds(0, 0, 1430, 65);
        panelMenu.setBackground(Color.black);

        // Panneau colonne lettres
        panelCoordLettres.setBounds(0, 120, 60, 600);

        // Ligne avec les chiffres du plateau du joueur
        panelCoordChiffres1.setBounds(67, 60, 655, 60);
        panelCoordChiffres2.setBounds(738, 60, 650, 60);

        this.frame.add(panelConsole, BorderLayout.SOUTH);
        this.frame.add(panelMenu);
        this.frame.add(panelCoordLettres);
        this.frame.add(panelCoordChiffres1);
        this.frame.add(panelCoordChiffres2);
        this.frame.add(panelPrincipal);

        this.frame.setSize(1400, 700);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setVisible(true);

    }

    public List<JButton> creerCasesGraphiques(final Plateau plateau)
    {
        final List<JButton> listeBouton = new ArrayList<JButton>();
        for (int i = 0; i < plateau.getCases().length; i++) {
            for (int j = 0; j < plateau.getCases().length; j++) {
                final int x = i;
                final int y = j;
                this.boutonCasePlateau = plateau.getCases()[i][j].getBouton();
                this.boutonCasePlateau.addActionListener(new ActionListener()
                {

                    @Override
                    public void actionPerformed(final ActionEvent e)
                    {

                        // La partie n'est pas démarrée tant que tous les
                        // bateaux ne sont pas placés
                        if (!Partie.isStart()) {
                            if (Interface.this.premierClic) {
                                this.actionPremierClicPlacementBateau(x, y);
                                Interface.this.premierClic = false;
                            } else {
                                this.actionSecondClicPlacementBateau(plateau, x, y);

                                if (Interface.this.joueur.isPlaying()) {
                                    this.rafraichirLaZoneDeJeu(Interface.this.joueur.getBateaux(),
                                        Interface.this.plateauJoueur, x, y);
                                } else {
                                    this.rafraichirLaZoneDeJeu(Interface.this.adversaire.getBateaux(),
                                        Interface.this.plateauAdversaire, x, y);
                                }
                                Interface.this.premierClic = true;
                            }
                            if (Interface.this.joueur.isTousLesBateauxPlaces()
                                && Interface.this.adversaire.isTousLesBateauxPlaces()) {
                                Partie.setStart(true);
                                this.reactiverLesCasesDuPlateau(Interface.this.plateauJoueur, false);
                                this.reactiverLesCasesDuPlateau(Interface.this.plateauAdversaire, true);
                                labelConsole.setText("La partie démarre !!!");
                            }
                        } else {

                            if (Interface.this.joueur.isPlaying()) {
                                Interface.this.actionsJoueurs.tirer(Interface.this.joueur, Interface.this.adversaire,
                                    Interface.this.plateauAdversaire,
                                    this.getXPos(Interface.this.plateauAdversaire, x, y),
                                    this.getYPos(Interface.this.plateauAdversaire, x, y) - 1, boutonScore);
                                this.desactiverToutesLesCasesDuPlateau(Interface.this.plateauAdversaire);
                            } else {
                                Interface.this.actionsJoueurs.tirer(Interface.this.adversaire, Interface.this.joueur,
                                    Interface.this.plateauJoueur, this.getXPos(Interface.this.plateauJoueur, x, y),
                                    this.getYPos(Interface.this.plateauJoueur, x, y) - 1, boutonScore);
                                this.desactiverToutesLesCasesDuPlateau(Interface.this.plateauJoueur);
                            }
                            if (this.aucunJoueurAGagne()) {
                                // On colore en ROUGE le bouton de changement de
                                // joueur et on le désactive
                                boutonChangementJoueur.setBackground(new Color(0, 150, 0));
                                boutonChangementJoueur.setEnabled(true);
                            } else {
                                this.verifierFinDePartie();
                            }
                        }
                    }

                    private boolean aucunJoueurAGagne()
                    {
                        return !Interface.this.joueur.hasWon() && !Interface.this.adversaire.hasWon();
                    }

                    private void verifierFinDePartie()
                    {
                        if (Interface.this.joueur.hasWon()) {
                            JOptionPane.showMessageDialog(null,
                                "Bravo ! " + Interface.this.joueur.getNom() + " a gagné la partie !");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                "Bravo ! " + Interface.this.adversaire.getNom() + " a gagné la partie !");
                        }
                    }

                    private void rafraichirLaZoneDeJeu(final List<Bateau> listeBateau, final Plateau plateau,
                        final int x, final int y)
                    {
                        this.afficherLabelProchainBateauAPlacer(listeBateau);
                        plateau.getCases()[x][y].getBouton().setEnabled(false);
                        this.reactiverLesCasesDuPlateau(plateau, true);
                    }

                    private void actionPremierClicPlacementBateau(final int x, final int y)
                    {
                        if (Interface.this.joueur.isPlaying()) {
                            Interface.this.panelAdversaire.setVisible(false);
                            Interface.this.panelJoueur.setVisible(true);
                            this.desactiverToutesLesCasesDuPlateau(Interface.this.plateauJoueur);
                            Interface.this.actionsBateau.saisieDesCoordonneesDesBateaux(Interface.this.joueur,
                                Interface.this.plateauJoueur, FactoryUtils.getXPos(Interface.this.plateauJoueur, x, y),
                                FactoryUtils.getYPos(Interface.this.plateauJoueur, x, y) - 1);
                        } else {
                            Interface.this.panelJoueur.setVisible(false);
                            Interface.this.panelAdversaire.setVisible(true);
                            this.desactiverToutesLesCasesDuPlateau(Interface.this.plateauAdversaire);
                            Interface.this.actionsBateau.saisieDesCoordonneesDesBateaux(Interface.this.adversaire,
                                Interface.this.plateauAdversaire,
                                FactoryUtils.getXPos(Interface.this.plateauAdversaire, x, y),
                                FactoryUtils.getYPos(Interface.this.plateauAdversaire, x, y) - 1);
                        }
                    }

                    private void actionSecondClicPlacementBateau(final Plateau plateau, final int x, final int y)
                    {
                        if (Interface.this.joueur.isPlaying()) {
                            for (final Bateau bateau : Interface.this.joueur.getBateaux()) {
                                if (!bateau.isPlace()) {
                                    if ((FactoryUtils
                                        .convertirCharToInt(Interface.this.plateauJoueur.getCases()[x][y].getPosition()
                                            .getX()) > FactoryUtils.convertirCharToInt(bateau.getTabPoints()[0].getX()))
                                        || (Interface.this.plateauJoueur.getCases()[x][y].getPosition()
                                            .getY() > bateau.getTabPoints()[0].getY())) {
                                        Interface.this.actionsBateau.assignerCoordonneesBateaux(Interface.this.joueur,
                                            bateau.getTypeBateau(),
                                            new Position(plateau.getCases()[x][y].getPosition().getX(),
                                                plateau.getCases()[x][y].getPosition().getY()));
                                        Interface.this.actionsBateau.placerLesBateauxSurLePlateau(bateau,
                                            Interface.this.plateauJoueur);
                                        break;
                                    } else {
                                        final Position coordonneesArriere = bateau.getTabPoints()[0];
                                        bateau.getTabPoints()[0] = plateau.getCases()[x][y].getPosition();
                                        Interface.this.actionsBateau.assignerCoordonneesBateaux(Interface.this.joueur,
                                            bateau.getTypeBateau(), coordonneesArriere);
                                        Interface.this.actionsBateau.placerLesBateauxSurLePlateau(bateau,
                                            Interface.this.plateauJoueur);
                                        break;
                                    }
                                }
                            }
                            if (Interface.this.joueur.isTousLesBateauxPlaces()) {
                                Interface.this.panelJoueur.setVisible(false);
                                Interface.this.panelAdversaire.setVisible(true);
                                Interface.this.joueur.setPlaying(false);
                                Interface.this.adversaire.setPlaying(true);
                            }
                        } else {
                            for (final Bateau bateau : Interface.this.adversaire.getBateaux()) {
                                if (!bateau.isPlace()) {
                                    if ((FactoryUtils.convertirCharToInt(
                                        Interface.this.plateauAdversaire.getCases()[x][y].getPosition()
                                            .getX()) > FactoryUtils.convertirCharToInt(bateau.getTabPoints()[0].getX()))
                                        || (Interface.this.plateauAdversaire.getCases()[x][y].getPosition()
                                            .getY() > bateau.getTabPoints()[0].getY())) {
                                        Interface.this.actionsBateau.assignerCoordonneesBateaux(
                                            Interface.this.adversaire, bateau.getTypeBateau(),
                                            new Position(plateau.getCases()[x][y].getPosition().getX(),
                                                plateau.getCases()[x][y].getPosition().getY()));
                                        Interface.this.actionsBateau.placerLesBateauxSurLePlateau(bateau,
                                            Interface.this.plateauAdversaire);
                                        break;
                                    } else {
                                        final Position coordonneesArriere = bateau.getTabPoints()[0];
                                        bateau.getTabPoints()[0] = plateau.getCases()[x][y].getPosition();
                                        Interface.this.actionsBateau.assignerCoordonneesBateaux(
                                            Interface.this.adversaire, bateau.getTypeBateau(), coordonneesArriere);
                                        Interface.this.actionsBateau.placerLesBateauxSurLePlateau(bateau,
                                            Interface.this.plateauAdversaire);
                                        break;
                                    }
                                }

                            }
                            if (Interface.this.adversaire.isTousLesBateauxPlaces()) {
                                Interface.this.joueur.setPlaying(true);
                                Interface.this.adversaire.setPlaying(false);
                                this.reactiverLesCasesDuPlateau(Interface.this.plateauAdversaire, true);
                            }
                        }
                    }

                    private Integer getYPos(final Plateau plateau, final int i, final int j)
                    {
                        return plateau.getCases()[i][j].getPosition().getY();
                    }

                    private Integer getXPos(final Plateau plateau, final int i, final int j)
                    {
                        return FactoryUtils.convertirCharToInt(plateau.getCases()[i][j].getPosition().getX());
                    }

                    private void afficherLabelProchainBateauAPlacer(final List<Bateau> listeBateaux)
                    {
                        for (final Bateau bateau : listeBateaux) {
                            if (!bateau.isPlace()) {
                                labelConsole.setText("VEUILLEZ PLACER VOTRE " + bateau.getTypeBateau().toString());
                                break;
                            }
                        }
                    }

                    private void reactiverLesCasesDuPlateau(final Plateau plateau, final boolean actif)
                    {
                        for (int i = 0; i < plateau.getCases().length; i++) {
                            for (int j = 0; j < plateau.getCases().length; j++) {
                                if (plateau.getCases()[i][j].isWater() || Partie.isStart()) {
                                    plateau.getCases()[i][j].getBouton().setEnabled(actif);
                                    plateau.getCases()[i][j].getBouton().setBackground(Color.BLUE);
                                }
                            }
                        }
                    }

                    private void desactiverToutesLesCasesDuPlateau(final Plateau plateau)
                    {
                        for (int i = 0; i < plateau.getCases().length; i++) {
                            for (int j = 0; j < plateau.getCases().length; j++) {
                                plateau.getCases()[i][j].getBouton().setEnabled(false);
                            }
                        }
                    }
                });

                listeBouton.add(this.boutonCasePlateau);
            }
        }
        return listeBouton;
    }

    // --------------------------------
    // METHODES UTILITAIRES : PRIVEES
    // --------------------------------

    private static void ajouterLaListeBoutonsAuPanel(final JPanel panel, final List<JButton> listeBouton)
    {
        listeBouton.forEach(panel::add);
    }

    private List<JButton> creerListeBoutonsContourPlateau(final String type)
    {
        final List<JButton> listeBouton = Lists.newArrayList();
        for (int i = 0; i < TAILLE_PLATEAU; i++) {
            listeBouton.add(this.genererUnBoutonContourPlateau(i, type));
        }
        return listeBouton;
    }

    private static JButton creerBoutonBandeauSuperieur()
    {
        final JButton nouvellePartieBouton = new JButton();
        nouvellePartieBouton.setBackground(Color.WHITE);
        nouvellePartieBouton.setForeground(Color.BLACK);
        nouvellePartieBouton.setPreferredSize(new Dimension(125, 55));

        return nouvellePartieBouton;
    }

    private JButton genererUnBoutonContourPlateau(final int i, final String type)
    {
        final JButton bouton = new JButton();
        bouton.setBackground(Color.LIGHT_GRAY);

        if (type.equals(TYPE_CHIFFRE)) {
            bouton.setPreferredSize(new Dimension(49, 47));
            bouton.setText(String.valueOf(i + 1));
        } else if (type.equals(TYPE_LETTRE)) {
            bouton.setPreferredSize(new Dimension(50, 38));
            bouton.setText(String.valueOf(FactoryUtils.convertirIntToChar(i + 1)));
        }
        bouton.setEnabled(false);
        return bouton;
    }

    // -----------------
    // GETTERS/SETTERS
    // -----------------

    public Plateau getPlateauJoueur()
    {
        return this.plateauJoueur;
    }

    public Plateau getPlateauAdversaire()
    {
        return this.plateauAdversaire;
    }

    public JButton getLabelConsole()
    {
        return labelConsole;
    }

}
