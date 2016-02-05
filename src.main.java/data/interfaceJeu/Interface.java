package data.interfaceJeu;

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
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.google.common.collect.Lists;

import controleur.Partie;
import data.joueur.Joueur;
import services.ActionsJoueur;
import utils.FactoryUtils;

public class Interface extends JFrame {
	
	//------------
	//  ATTRIBUTS 
	//------------
	
	private ActionsJoueur actionsJoueurs;
	private static Joueur joueur;
	private static Joueur adversaire;
	private static List<JButton> listeBoutonJoueur;
	private static List<JButton> listeBoutonAdversaire;
	private static List<JButton> listeBoutonCoordsLettres;
	private static List<JButton> listeBoutonCoordsChiffres;
	private static List<JButton> listeBoutonCoordsChiffres2;
	private static Plateau plateauJoueur;
	private static Plateau plateauAdversaire;
	private static JFrame frame;
	private static JPanel panelJoueur;
	private static JPanel panelAdversaire;
	private static JButton boutonChangementJoueur;
	private static JButton boutonScore;
	
	//-------------
	//  CONSTANTES
	//-------------
	
	private static final long serialVersionUID = 1L;
	private static final String TYPE_LETTRE= "lettre";
	private static final String TYPE_CHIFFRE= "chiffre";

	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	@SuppressWarnings("static-access")
	public Interface(Joueur joueur, Joueur adversaire){
		this.joueur = joueur;
		this.adversaire = adversaire;
		plateauJoueur = new Plateau(10,10);
		plateauAdversaire = new Plateau(10, 10);
		this.listeBoutonJoueur = creerCasesGraphiques(plateauJoueur);
		this.listeBoutonAdversaire = creerCasesGraphiques(plateauAdversaire);
		this.listeBoutonCoordsLettres = creerListeBoutonsContourPlateau(TYPE_LETTRE);
		this.listeBoutonCoordsChiffres = creerListeBoutonsContourPlateau(TYPE_CHIFFRE);
		this.listeBoutonCoordsChiffres2 = creerListeBoutonsContourPlateau(TYPE_CHIFFRE);
		actionsJoueurs = new ActionsJoueur();
		creerLaFenetre();
	}

	//------------------------
	// METHODES DE LA CLASSE
	//------------------------
	
	public static void creerLaFenetre() {  
		
		frame = new JFrame("Bataille navale");
		frame.setTitle("Bataille Navale - Groupe 1");
		// Panneau principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(1,2));
		panelPrincipal.setBackground(Color.black);
	
		// Grille de jeu du joueur
		panelJoueur = new JPanel();
		panelJoueur.setLayout(new GridLayout(10,10));
		panelJoueur.setBackground(Color.black);
		
		Border margeJ = BorderFactory.createEmptyBorder(0, 15, 0, 0);
		panelJoueur.setBorder(margeJ);
		panelJoueur.setVisible(false);
		// Grille de jeu de l'adversaire
		panelAdversaire = new JPanel();
		panelAdversaire.setLayout(new GridLayout(10,10));
		panelAdversaire.setBackground(Color.black);
		
		Border margeA = BorderFactory.createEmptyBorder(0, 15, 0, 0);
		panelAdversaire.setBorder(margeA);
		
		// Panneau des coordonnées des lettres
		JPanel panelCoordLettres = new JPanel();
		panelCoordLettres.setLayout(new FlowLayout());
		panelCoordLettres.setBackground(Color.black);
		
		Border margeL = BorderFactory.createEmptyBorder(0, 15, 0, 0);
		panelCoordLettres.setBorder(margeL);
		
		// Panneau des coordonnées des chiffres
		JPanel panelCoordChiffres1 = new JPanel();
		panelCoordChiffres1.setLayout(new FlowLayout());
		panelCoordChiffres1.setBackground(Color.black);
		
		// Grille de jeu de l'adversaire
		JPanel panelCoordChiffres2 = new JPanel();
		panelCoordChiffres2.setLayout(new FlowLayout());
		panelCoordChiffres2.setBackground(Color.black);
		
		// Panneau du Menu
		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(new FlowLayout());
		JPanel gridMenu = new JPanel();
		gridMenu.setLayout(new GridLayout(1, 5, 130, 80));
		gridMenu.setBackground(Color.BLACK);
		
		
		// Bouton 'Nouvelle partie'
        JButton nouvellePartieBouton = creerBoutonBandeauSuperieur();
        nouvellePartieBouton = new JButton(new ImageIcon("img/reload.png"));
        nouvellePartieBouton.setText("Nouvelle Partie");
        nouvellePartieBouton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				Partie partie = new Partie();				
			}
		});
				
		//Bouton 'Joueur'
        JButton boutonJoueur = creerBoutonBandeauSuperieur();
        boutonJoueur.setPreferredSize(new Dimension(125, 55));
        boutonJoueur = new JButton(new ImageIcon("img/user.png"));
        boutonJoueur.setText(joueur.getNom());
        boutonJoueur.setEnabled(false);
        
        //Bouton 'Score'
        boutonScore = creerBoutonBandeauSuperieur();
        boutonScore = new JButton(new ImageIcon("img/award.png"));
        boutonScore.setText("     " + joueur.getScore());
        boutonScore.setEnabled(false);
		
        //Bouton 'Adversaire'
        JButton boutonAdversaire = creerBoutonBandeauSuperieur();
        boutonAdversaire = new JButton(new ImageIcon("img/user.png"));
        boutonAdversaire.setText(adversaire.getNom());
        boutonAdversaire.setEnabled(false);
        
        //Bouton 'Changement de joueur'
        boutonChangementJoueur = new JButton(new ImageIcon("img/arrow.png"));
        boutonChangementJoueur.setPreferredSize(new Dimension(125, 55));
        boutonChangementJoueur.setBackground(Color.WHITE); 
        boutonChangementJoueur.setForeground(Color.BLACK);   
        boutonChangementJoueur.setEnabled(false);
        boutonChangementJoueur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// On colore en ROUGE le bouton de changement de joueur et on le désactive
				boutonChangementJoueur.setBackground(Color.RED);
				boutonChangementJoueur.setEnabled(false);
				
				if(joueur.isEnTrainDeJouer()){
					boutonScore.setText("     " + joueur.getScore());
					// Changement de joueur
					joueur.setEnTrainDeJouer(false);
					adversaire.setEnTrainDeJouer(true);
					// On alterne l'affichage des plateaux
					panelJoueur.setVisible(true);
					panelAdversaire.setVisible(false);
					reactiverLesCasesDuPlateau(plateauJoueur);
				}else{
					boutonScore.setText("     " + adversaire.getScore());
					// Changement de joueur
					joueur.setEnTrainDeJouer(true);
					adversaire.setEnTrainDeJouer(false);
					// On alterne l'affichage des plateaux
					panelJoueur.setVisible(false);
					panelAdversaire.setVisible(true);
					reactiverLesCasesDuPlateau(plateauAdversaire);
				}
			}
			
			private void reactiverLesCasesDuPlateau( Plateau plateau) {
				for(int i = 0; i < plateau.getLePlateau().length; i++){
					for(int j = 0; j < plateau.getLePlateau().length; j++){
						if(!plateau.getLePlateau()[i][j].isCaseTouche()){
							plateau.getLePlateau()[i][j].getBouton().setEnabled(true);
						}
					}
				}
			}
		});

		// Ajout des paneaux au panneau principal
        panelPrincipal.add(panelJoueur);
        panelPrincipal.add(panelAdversaire);

        //Ajout des boutons au layout
        panelMenu.add(gridMenu);
        gridMenu.add(boutonJoueur);
        gridMenu.add(nouvellePartieBouton);
        gridMenu.add(boutonChangementJoueur);
        gridMenu.add(boutonScore);
        gridMenu.add(boutonAdversaire);		
		
		// Create button
		ajouterLaListeBoutonsAuPanel(panelJoueur, listeBoutonJoueur);
		ajouterLaListeBoutonsAuPanel(panelAdversaire, listeBoutonAdversaire);
		ajouterLaListeBoutonsAuPanel(panelCoordLettres, listeBoutonCoordsLettres);
		ajouterLaListeBoutonsAuPanel(panelCoordChiffres1, listeBoutonCoordsChiffres);
		ajouterLaListeBoutonsAuPanel(panelCoordChiffres2, listeBoutonCoordsChiffres2);
		
		//Colonne des Lettres du plateau
		Border padding = BorderFactory.createEmptyBorder(120, 60, 15, 15);
		panelPrincipal.setBorder(padding);

		// Panneau du Menu
		panelMenu.setBounds(0, 0, 1300, 65);
		panelMenu.setBackground(Color.black);
		
		//Panneau colonne lettres
		panelCoordLettres.setBounds(0, 120, 60, 550);
		
		//Ligne avec les chiffres du plateau du joueur
		panelCoordChiffres1.setBounds(70, 60, 600, 60);
		
		panelCoordChiffres2.setBounds(680, 60, 600, 60);
		
		frame.add(panelMenu);
		frame.add(panelCoordLettres);
		frame.add(panelCoordChiffres1);
		frame.add(panelCoordChiffres2);		
		
		frame.add(panelPrincipal);
		frame.setSize(1300, 680);	
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
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
						
						if(joueur.isEnTrainDeJouer()){
							actionsJoueurs.tirer(adversaire,plateauAdversaire,getXPos(plateauAdversaire, x, y), getYPos(plateauAdversaire, x, y)-1, boutonScore);
							desactiverToutesLesCasesDuPlateau(plateauAdversaire);
						}else{
							actionsJoueurs.tirer(joueur,plateauJoueur, getXPos(plateauJoueur, x, y), getYPos(plateauJoueur, x, y)-1, boutonScore);
							desactiverToutesLesCasesDuPlateau(plateauJoueur);
						}
						// On colore en ROUGE le bouton de changement de joueur et on le désactive
						boutonChangementJoueur.setBackground(Color.GREEN);
						boutonChangementJoueur.setEnabled(true);
					}
					
					private void desactiverToutesLesCasesDuPlateau( Plateau plateau) {
						for(int i = 0; i < plateau.getLePlateau().length; i++){
							for(int j = 0; j < plateau.getLePlateau().length; j++){
								plateau.getLePlateau()[i][j].getBouton().setEnabled(false);
							}
						}
					}
					
					private Integer getYPos(Plateau plateau, final int i, final int j) {
						return plateau.getLePlateau()[i][j].getPoint().getyPos();
					}

					private Integer getXPos(Plateau plateau, final int i, final int j) {
						return FactoryUtils.convertirCharToInt(plateau.getLePlateau()[i][j].getPoint().getxPos());
					}
				});
				listeBouton.add(plateau.getLePlateau()[i][j].getBouton());
			}
		}
		return listeBouton;
	}
	
	//--------------------------------
	//  METHODES UTILITAIRES : PRIVEES
	//--------------------------------
	
	private static void ajouterLaListeBoutonsAuPanel(JPanel panel, List<JButton> listeBouton)  {
		for (JButton bouton : listeBouton) {
			panel.add(bouton);
		}
	}
	
	private List<JButton> creerListeBoutonsContourPlateau(String type){
		List<JButton> listeBouton = Lists.newArrayList();
		for(int i = 0; i<10; i++){
			listeBouton.add(genererUnBoutonContourPlateau(i, type));
		}
		return listeBouton;
	}
	
	private static JButton creerBoutonBandeauSuperieur() {
		JButton nouvellePartieBouton = new JButton();
        nouvellePartieBouton.setBackground(Color.WHITE); 
        nouvellePartieBouton.setForeground(Color.BLACK);  
        nouvellePartieBouton.setPreferredSize(new Dimension(125, 55));
		return nouvellePartieBouton;
	}
	
	private JButton genererUnBoutonContourPlateau(int i, String type){
		JButton bouton = new JButton();
		bouton.setBackground(Color.LIGHT_GRAY);
		
		if(type == TYPE_CHIFFRE){
			bouton.setPreferredSize(new Dimension(55, 55));
			bouton.setText(String.valueOf(i + 1));
		}else if(type == TYPE_LETTRE){
			bouton.setPreferredSize(new Dimension(45, 46));
			bouton.setText(String.valueOf(FactoryUtils.convertirIntToChar(i + 1)));
		}
		bouton.setEnabled(false);
		return bouton;
	}
	
	//-----------------
	//	GETTERS/SETTERS
	//-----------------
	
	public Plateau getPlateauJoueur() {
		return plateauJoueur;
	}
	
	public Plateau getPlateauAdversaire() {
		return plateauAdversaire;
	}

}
