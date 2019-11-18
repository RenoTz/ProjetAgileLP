package controleur;

import javax.swing.JOptionPane;

import data.ihm.Interface;
import data.joueur.Joueur;

public class Partie
{

    private Joueur joueur;

    private Joueur adversaire;

    private static boolean start;

    public void run()
    {
        this.initPlayers();
        final Interface interfaceJeu = new Interface(this.joueur, this.adversaire);
        setStart(false);
        interfaceJeu.getLabelConsole()
            .setText("VEUILLEZ PLACER VOTRE " + this.joueur.getBateaux().get(0).getTypeBateau().toString());
    }

    private void initPlayers()
    {
        // Creation du joueur 1
        this.joueur = new Joueur();
        this.joueur.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :", "Joueur 1"));
        this.joueur.setPlaying(true);
        // Creation du joueur 2
        this.adversaire = new Joueur();
        this.adversaire.setNom(JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :", "Joueur 2"));
    }

    public static boolean isStart()
    {
        return start;
    }

    public static void setStart(final boolean start)
    {
        Partie.start = start;
    }

}
