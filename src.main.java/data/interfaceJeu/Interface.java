package data.interfaceJeu;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.google.common.collect.Lists;

import controleur.Partie;
import data.bateau.Bateau;
import data.composants.Points;
import data.joueur.Joueur;
import services.ActionsBateau;
import services.ActionsJoueur;
import utils.FactoryUtils;

public class Interface extends JFrame {
	
	//------------
	//  ATTRIBUTS 
	//------------
	private boolean premierClic;
	private ActionsJoueur actionsJoueurs;
	private ActionsBateau actionsBateau;
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
	private JButton boutonCasePlateau;
	private static JButton boutonScore;
	private static JButton labelConsole;
	
	//-------------
	//  CONSTANTES
	//-------------
	
	private static final long serialVersionUID = 1L;
	private static final String TYPE_LETTRE= "lettre";
	private static final String TYPE_CHIFFRE= "chiffre";
	private static final int TAILLE_PLATEAU = 12;

	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	@SuppressWarnings("static-access")
	public Interface(Joueur joueur, Joueur adversaire){
		actionsJoueurs = new ActionsJoueur();
		actionsBateau = new ActionsBateau();
		this.joueur = joueur;
		this.adversaire = adversaire;
		plateauJoueur = new Plateau(TAILLE_PLATEAU,TAILLE_PLATEAU);
		plateauAdversaire = new Plateau(TAILLE_PLATEAU, TAILLE_PLATEAU);
		this.listeBoutonJoueur = creerCasesGraphiques(plateauJoueur);
		this.listeBoutonAdversaire = creerCasesGraphiques(plateauAdversaire);
		this.listeBoutonCoordsLettres = creerListeBoutonsContourPlateau(TYPE_LETTRE);
		this.listeBoutonCoordsChiffres = creerListeBoutonsContourPlateau(TYPE_CHIFFRE);
		this.listeBoutonCoordsChiffres2 = creerListeBoutonsContourPlateau(TYPE_CHIFFRE);
		this.premierClic = true;
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
		panelJoueur.setLayout(new GridLayout(TAILLE_PLATEAU,TAILLE_PLATEAU));
		panelJoueur.setBackground(Color.black);
		
		Border margeJ = BorderFactory.createEmptyBorder(0, 15, 0, 0);
		panelJoueur.setBorder(margeJ);
		
		// Grille de jeu de l'adversaire
		panelAdversaire = new JPanel();
		panelAdversaire.setLayout(new GridLayout(TAILLE_PLATEAU,TAILLE_PLATEAU));
		panelAdversaire.setBackground(Color.black);
		panelAdversaire.setVisible(false);
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
		gridMenu.setLayout(new GridLayout(1, 5, 145, 80));
		gridMenu.setBackground(Color.BLACK);
		
		//Panneau "console"
		JPanel panelConsole = new JPanel();
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
					eventChangementDeJoueur(adversaire, plateauJoueur, false, true,true, false);
				}else{
					eventChangementDeJoueur(joueur, plateauAdversaire, true, false, false, true);
				}
			}

			private void eventChangementDeJoueur(Joueur joueurProchain, Plateau plateau, boolean joueurJoue,boolean adversaireJoue,boolean plateauJoueurVisible,boolean plateauAdversaireVisible ) {
				labelConsole.setText("Au tour de " + joueurProchain.getNom());
				boutonScore.setText("     " + joueurProchain.getScore());
				// Changement de joueur
				joueur.setEnTrainDeJouer(joueurJoue);
				adversaire.setEnTrainDeJouer(adversaireJoue);
				// On alterne l'affichage des plateaux
				panelJoueur.setVisible(plateauJoueurVisible);
				panelAdversaire.setVisible(plateauAdversaireVisible);
				reactiverLesCasesDuPlateau(plateau);
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
		Border padding = BorderFactory.createEmptyBorder(120, 60, 5, 5);
		panelPrincipal.setBorder(padding);

		// Panneau du Menu
		panelMenu.setBounds(0, 0, 1430, 65);
		panelMenu.setBackground(Color.black);
		
		//Panneau colonne lettres
		panelCoordLettres.setBounds(0, 120, 60, 600);
		
		//Ligne avec les chiffres du plateau du joueur
		panelCoordChiffres1.setBounds(67, 60, 655, 60);
		panelCoordChiffres2.setBounds(738, 60, 650, 60);
		
		frame.add(panelConsole, BorderLayout.SOUTH);
		frame.add(panelMenu);
		frame.add(panelCoordLettres);
		frame.add(panelCoordChiffres1);
		frame.add(panelCoordChiffres2);	
		frame.add(panelPrincipal);
		
		frame.setSize(1400, 700);	
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
				boutonCasePlateau = plateau.getLePlateau()[i][j].getBouton();
				boutonCasePlateau.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						// La partie n'est pas démarrée tant que tous les bateaux ne sont pas placés
						if(!Partie.isStart()){
							if(premierClic){
								actionPremierClicPlacementBateau(x, y);
								premierClic = false;
							}else{
								actionSecondClicPlacementBateau(plateau, x, y);
								
								if(joueur.isEnTrainDeJouer()){
									rafraichirLaZoneDeJeu(joueur.getListeBateaux(), plateauJoueur,x, y);
								}else{
									rafraichirLaZoneDeJeu(adversaire.getListeBateaux(), plateauAdversaire,x, y);
								}
								premierClic = true;
							}
							if(joueur.isTousLesBateauxPlaces() && adversaire.isTousLesBateauxPlaces()){
								Partie.setStart(true);
								reactiverLesCasesDuPlateau(plateauJoueur,false);
								reactiverLesCasesDuPlateau(plateauAdversaire,true);
								labelConsole.setText("<<< THE GAME BEGINS >>>");
							}
						}else{
							
							if(joueur.isEnTrainDeJouer()){
								actionsJoueurs.tirer(joueur, adversaire,plateauAdversaire,getXPos(plateauAdversaire, x, y), getYPos(plateauAdversaire, x, y)-1, boutonScore);
								desactiverToutesLesCasesDuPlateau(plateauAdversaire);
							}else{
								actionsJoueurs.tirer(adversaire, joueur,plateauJoueur, getXPos(plateauJoueur, x, y), getYPos(plateauJoueur, x, y)-1, boutonScore);
								desactiverToutesLesCasesDuPlateau(plateauJoueur);
							}
							if(aucunJoueurAGagne()){
								// On colore en ROUGE le bouton de changement de joueur et on le désactive
								boutonChangementJoueur.setBackground(new Color(0, 150, 0));
								boutonChangementJoueur.setEnabled(true);
							}else{
								verifierFinDePartie();
							}
						}
					}

					private boolean aucunJoueurAGagne() {
						return !joueur.isGagne(adversaire) && !adversaire.isGagne(joueur);
					}

					private void verifierFinDePartie() {
						if(joueur.isGagne(adversaire)){
							JOptionPane.showMessageDialog(null, "Bravo ! "+ joueur.getNom() +" a gagné la partie !");
						}else{
							JOptionPane.showMessageDialog(null, "Bravo ! "+ adversaire.getNom() +" a gagné la partie !");
						}
					}

					private void rafraichirLaZoneDeJeu(List<Bateau> listeBateau, Plateau plateau, final int x, final int y) {
						afficherLabelProchainBateauAPlacer(listeBateau);
						plateau.getLePlateau()[x][y].getBouton().setEnabled(false);
						reactiverLesCasesDuPlateau(plateau,true);
					}

					private void actionPremierClicPlacementBateau(final int x,final int y) {
						if(joueur.isEnTrainDeJouer()){
							panelAdversaire.setVisible(false);
							panelJoueur.setVisible(true);
							desactiverToutesLesCasesDuPlateau(plateauJoueur);
							actionsBateau.saisieDesCoordonneesDesBateaux(joueur,plateauJoueur,FactoryUtils.getXPos(plateauJoueur, x, y), 
									FactoryUtils.getYPos(plateauJoueur, x, y)-1);
						}else{
							panelJoueur.setVisible(false);
							panelAdversaire.setVisible(true);
							desactiverToutesLesCasesDuPlateau(plateauAdversaire);
							actionsBateau.saisieDesCoordonneesDesBateaux(adversaire,plateauAdversaire,FactoryUtils.getXPos(plateauAdversaire, x, y), 
									FactoryUtils.getYPos(plateauAdversaire, x, y)-1);
						}
					}
					
					private void actionSecondClicPlacementBateau(
							final Plateau plateau, final int x, final int y) {
						if(joueur.isEnTrainDeJouer()){
							for(Bateau bateau : joueur.getListeBateaux()){
								if(!bateau.isPlace()){
									if(FactoryUtils.convertirCharToInt(plateauJoueur.getLePlateau()[x][y].getPoint().getxPos()) 
											> FactoryUtils.convertirCharToInt(bateau.getTabPoints()[0].getxPos()) 
											|| plateauJoueur.getLePlateau()[x][y].getPoint().getyPos() > bateau.getTabPoints()[0].getyPos()){
										actionsBateau.assignerCoordonneesBateaux(joueur, bateau.getTypeBateau(), new Points(plateau.getLePlateau()[x][y].getPoint().getxPos(), 
												plateau.getLePlateau()[x][y].getPoint().getyPos()));
										actionsBateau.placerLesBateauxSurLePlateau(bateau, plateauJoueur);
										break;
									}else{
										Points coordonneesArriere = bateau.getTabPoints()[0];
										bateau.getTabPoints()[0] = plateau.getLePlateau()[x][y].getPoint();
										actionsBateau.assignerCoordonneesBateaux(joueur, bateau.getTypeBateau(), coordonneesArriere);
										actionsBateau.placerLesBateauxSurLePlateau(bateau, plateauJoueur);
										break;
									}
								}
							}
							if(joueur.isTousLesBateauxPlaces()){
								panelJoueur.setVisible(false);
								panelAdversaire.setVisible(true);
								joueur.setEnTrainDeJouer(false);
								adversaire.setEnTrainDeJouer(true);
							}
						}else{
							for(Bateau bateau : adversaire.getListeBateaux()){
								if(!bateau.isPlace()){
									if(FactoryUtils.convertirCharToInt(plateauAdversaire.getLePlateau()[x][y].getPoint().getxPos()) 
											> FactoryUtils.convertirCharToInt(bateau.getTabPoints()[0].getxPos()) 
											|| plateauAdversaire.getLePlateau()[x][y].getPoint().getyPos() > bateau.getTabPoints()[0].getyPos()){
										actionsBateau.assignerCoordonneesBateaux(adversaire, bateau.getTypeBateau(), new Points(plateau.getLePlateau()[x][y].getPoint().getxPos(), 
												plateau.getLePlateau()[x][y].getPoint().getyPos()));
										actionsBateau.placerLesBateauxSurLePlateau(bateau, plateauAdversaire);
										break;
									}else{
										Points coordonneesArriere = bateau.getTabPoints()[0];
										bateau.getTabPoints()[0] = plateau.getLePlateau()[x][y].getPoint();
										actionsBateau.assignerCoordonneesBateaux(adversaire, bateau.getTypeBateau(), coordonneesArriere);
										actionsBateau.placerLesBateauxSurLePlateau(bateau, plateauAdversaire);
										break;
									}
								}
								
							}
							if(adversaire.isTousLesBateauxPlaces()){
								joueur.setEnTrainDeJouer(true);
								adversaire.setEnTrainDeJouer(false);
								reactiverLesCasesDuPlateau(plateauAdversaire,true);
							}
						}
					}

					private Integer getYPos(Plateau plateau, final int i, final int j) {
						return plateau.getLePlateau()[i][j].getPoint().getyPos();
					}

					private Integer getXPos(Plateau plateau, final int i, final int j) {
						return FactoryUtils.convertirCharToInt(plateau.getLePlateau()[i][j].getPoint().getxPos());
					}
					
					private void afficherLabelProchainBateauAPlacer(List<Bateau> listeBateaux) {
						for(Bateau bateau : listeBateaux){
							if(!bateau.isPlace()){
								labelConsole.setText("VEUILLEZ PLACER VOTRE " + bateau.getTypeBateau().toString());
								break;
							}
						}
					}

					private void reactiverLesCasesDuPlateau( Plateau plateau, boolean actif) {
						for(int i = 0; i < plateau.getLePlateau().length; i++){
							for(int j = 0; j < plateau.getLePlateau().length; j++){
								if(plateau.getLePlateau()[i][j].isWater() || Partie.isStart()){
									plateau.getLePlateau()[i][j].getBouton().setEnabled(actif);
									plateau.getLePlateau()[i][j].getBouton().setBackground(Color.BLUE);
								}
							}
						}
					}
					
					private void desactiverToutesLesCasesDuPlateau(Plateau plateau) {
						for(int i = 0; i < plateau.getLePlateau().length; i++){
							for(int j = 0; j < plateau.getLePlateau().length; j++){
								plateau.getLePlateau()[i][j].getBouton().setEnabled(false);
							}
						}
					}
				});
							
				listeBouton.add(boutonCasePlateau);
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
		for(int i = 0; i<TAILLE_PLATEAU; i++){
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
			bouton.setPreferredSize(new Dimension(49, 47));
			bouton.setText(String.valueOf(i + 1));
		}else if(type == TYPE_LETTRE){
			bouton.setPreferredSize(new Dimension(50, 38));
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
	
	public JButton getLabelConsole() {
		return labelConsole;
	}

}
