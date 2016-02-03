package data.interfaceJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.composants.Case;
import utils.FactoryUtils;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	static List<JButton> listeBoutonJoueur;
	static List<JButton> listeBoutonAdversaire;
	private Plateau plateauJoueur;
	private Plateau plateauAdversaire;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	@SuppressWarnings("static-access")
	public Interface(){
		this.plateauJoueur = new Plateau(10,10);
		this.plateauAdversaire = new Plateau(10, 10);
		this.listeBoutonJoueur = creerCasesGraphiques(this.plateauJoueur);
		this.listeBoutonAdversaire = creerCasesGraphiques(this.plateauAdversaire);
		createWindow();
	}
	
	//------------------------
	// METHODES DE LA CLASSE
	//------------------------
	
	public static void createWindow() {  
		
		JFrame frame = new JFrame("Bataille navale");
		frame.setTitle("Bataille Navale - Groupe 1");
		// Panneau principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(1,2));
	
		
		// Grille de jeu du joueur
		JPanel panelJoueur = new JPanel();
		panelJoueur.setLayout(new GridLayout(10,10));
		
		// Grille de jeu de l'adversaire
		JPanel panelAdversaire = new JPanel();
		panelAdversaire.setLayout(new GridLayout(10,10));
		
		// Ajout des paneaux au paneau principal
        panelPrincipal.add(panelJoueur);
        panelPrincipal.add(panelAdversaire);

        // emplacement de titre
        final JLabel fenetreJoueur = new JLabel("  Bienvenue dans le jeu de la bataille Navale                                                          "
        		+ "              Joueur                              -                       Adversaire  ");
        frame.add(fenetreJoueur, BorderLayout.NORTH);
        fenetreJoueur.setForeground(Color.black); 
		
		// Bouton 'Nouvelle partie'
        final JButton nouvellePartieBouton = new JButton("Nouvelle Partie");
        frame.add(nouvellePartieBouton, BorderLayout.SOUTH);
        nouvellePartieBouton.setBackground(Color.black); 
        nouvellePartieBouton.setForeground(Color.white);   
		frame.setBackground(Color.GRAY);
		
		// Create button
		ajouterLaListeBoutonsAuPanel(panelJoueur, listeBoutonJoueur);
		ajouterLaListeBoutonsAuPanel(panelAdversaire, listeBoutonAdversaire);
		
		
		//panelJoueur.setSize(1000,600);
		//panelAdversaire.setSize(600, 600);
		frame.add(panelPrincipal);
		frame.setSize(1200, 600);
	
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private static void ajouterLaListeBoutonsAuPanel(JPanel panel, List<JButton> listeBouton)  {
		for (JButton bouton : listeBouton) {
			panel.add(bouton);
		}
	}
	
	public List<JButton> creerCasesGraphiques(final Plateau plateau) {  
		List<JButton> listeBouton = new ArrayList<JButton>();
		for( int i = 0; i < plateau.getLePlateau().length; i++ ){
			for( int j = 0; j < plateau.getLePlateau().length; j++ ) {
				final int x = i;
				final int y = j;
				plateau.getLePlateau()[i][j].getBouton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tirer(plateau.getLePlateau(), FactoryUtils.convertirCharToInt(getXPos(plateau, x, y)), getYPos(plateau, x, y)-1);
					}

					private Integer getYPos(Plateau plateau, final int i,
							final int j) {
						return plateau.getLePlateau()[i][j].getPoint().getyPos();
					}

					private char getXPos(Plateau plateau, final int i,
							final int j) {
						return plateau.getLePlateau()[i][j].getPoint().getxPos();
					}
				});
				listeBouton.add(plateau.getLePlateau()[i][j].getBouton());
			}
		}
		return listeBouton;
	}
	
	public void tirer(Case[][] cases, int x , int y) {
		if(cases[x][y].getCouleur().equals(Color.DARK_GRAY) || cases[x][y].isCaseTouche()){
			cases[x][y].setCaseTouche(true);
			cases[x][y].setCouleur(Color.RED);
			cases[x][y].getBouton().setBackground(Color.RED);
		}else{
			cases[x][y].getBouton().setBackground(Color.WHITE);
		}
	}
	
	public Plateau getPlateauJoueur() {
		return plateauJoueur;
	}
	
	public Plateau getPlateauAdversaire() {
		return plateauAdversaire;
	}

	public void setPlateauAdversaire(Plateau plateauAdversaire) {
		this.plateauAdversaire = plateauAdversaire;
	}

}