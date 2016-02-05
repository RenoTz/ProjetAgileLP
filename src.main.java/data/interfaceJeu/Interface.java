package data.interfaceJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private static JPanel panelPoserBateau;
	
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
		actionsJoueurs = new ActionsJoueur();
		actionsBateau = new ActionsBateau();
		this.joueur = joueur;
		this.adversaire = adversaire;
		plateauJoueur = new Plateau(10,10);
		plateauAdversaire = new Plateau(10, 10);
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
		panelJoueur.setLayout(new GridLayout(10,10));
		panelJoueur.setBackground(Color.black);
		
		Border margeJ = BorderFactory.createEmptyBorder(0, 15, 0, 0);
		panelJoueur.setBorder(margeJ);
		
		// Grille de jeu de l'adversaire
		panelAdversaire = new JPanel();
		panelAdversaire.setLayout(new GridLayout(10,10));
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
        JButton boutonScore = creerBoutonBandeauSuperieur();
        boutonScore = new JButton(new ImageIcon("img/award.png"));
        boutonScore.setText("Score");
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
					// Changement de joueur
					joueur.setEnTrainDeJouer(false);
					adversaire.setEnTrainDeJouer(true);
					// On alterne l'affichage des plateaux
					panelJoueur.setVisible(true);
					panelAdversaire.setVisible(false);
					reactiverLesCasesDuPlateau(plateauJoueur);
				}else{
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

		// Ajout des paneaux au paneau principal
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
				boutonCasePlateau = plateau.getLePlateau()[i][j].getBouton();
				boutonCasePlateau.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(!Partie.isStart()){
							if(premierClic){
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
								premierClic = false;
							}else{
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
								afficherPopUpProchainBateauAPlacer(joueur.getListeBateaux());
								if(joueur.isEnTrainDeJouer()){
									reactiverLesCasesDuPlateau(plateauJoueur,true);
								}else{
									reactiverLesCasesDuPlateau(plateauAdversaire,true);
								}
								
								premierClic = true;
							}
							if(joueur.isTousLesBateauxPlaces() && adversaire.isTousLesBateauxPlaces()){
								Partie.setStart(true);
								reactiverLesCasesDuPlateau(plateauJoueur,false);
								reactiverLesCasesDuPlateau(plateauAdversaire,true);
							}
						}else{
							
							if(joueur.isEnTrainDeJouer()){
								actionsJoueurs.tirer(adversaire,plateauAdversaire,getXPos(plateauAdversaire, x, y), getYPos(plateauAdversaire, x, y)-1);
								desactiverToutesLesCasesDuPlateau(plateauAdversaire);
							}else{
								actionsJoueurs.tirer(joueur,plateauJoueur, getXPos(plateauJoueur, x, y), getYPos(plateauJoueur, x, y)-1);
								desactiverToutesLesCasesDuPlateau(plateauJoueur);
							}
							// On colore en ROUGE le bouton de changement de joueur et on le désactive
							boutonChangementJoueur.setBackground(Color.GREEN);
							boutonChangementJoueur.setEnabled(true);
						}
						
					}
					
					private Integer getYPos(Plateau plateau, final int i, final int j) {
						return plateau.getLePlateau()[i][j].getPoint().getyPos();
					}

					private Integer getXPos(Plateau plateau, final int i, final int j) {
						return FactoryUtils.convertirCharToInt(plateau.getLePlateau()[i][j].getPoint().getxPos());
					}
					
					private void afficherPopUpProchainBateauAPlacer(List<Bateau> listeBateaux) {
						for(Bateau bateau : listeBateaux){
							if(!bateau.isPlace()){
								JOptionPane.showMessageDialog(null, "Veuillez placer votre " + bateau.getTypeBateau().toString());
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
							
//				plateau.getLePlateau()[FactoryUtils.getXPos(plateauJoueur, x, y)][FactoryUtils.getYPos(plateauJoueur, x, y)-1].getBouton().removeActionListener(al);
//				plateau.getLePlateau()[FactoryUtils.getXPos(plateauJoueur, x, y)][FactoryUtils.getYPos(plateauJoueur, x, y)-1].getBouton().removeActionListener(al);
//				
//				plateau.getLePlateau()[FactoryUtils.getXPos(plateauJoueur, x, y)][FactoryUtils.getYPos(plateauJoueur, x, y)-1].getBouton().addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO Auto-generated method stub
//						System.out.println("nouvelle action");
//						placerLesBateauxSurLePlateau(bateau,plateau);
//					}
//
//					private void placerLesBateauxSurLePlateau(Bateau bateauPlace, Plateau plateau) {
//						for(Bateau bateau : joueur.getListeBateaux()){
//							if(bateau.getTypeBateau().equals(bateauPlace.getTypeBateau())){
//								// Placement des coordonn�es pour la premiere et la derniere case
//								Points posAvant = new Points(FactoryUtils.convertirIntToChar(xPos), yPos);
//								Points posArriere = new Points(FactoryUtils.convertirIntToChar(positionVerticale(xPos, bateau)), yPos);
//								bateau.getTabPoints()[0] = posAvant;
//								bateau.getTabPoints()[bateau.getTabPoints().length-1] = posArriere;
//								actionsBateau.remplissageDesCasesIntermediaires(posAvant,	posArriere, bateau);
//								break;
//							}
//						}
//						
//					}
//				});
				
//				plateau.getLePlateau()[FactoryUtils.getXPos(plateauJoueur, x, y)][FactoryUtils.getYPos(plateauJoueur, x, y)-1].getBouton().addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						System.out.println("nouvelle action");
//						placerLesBateauxSurLePlateau(bateau,plateau);
//					}

//					private void placerLesBateauxSurLePlateau(Bateau bateauPlace, Plateau plateau) {
//						for(Bateau bateau : joueur.getListeBateaux()){
//							if(bateau.getTypeBateau().equals(bateauPlace.getTypeBateau())){
//								// Placement des coordonn�es pour la premiere et la derniere case
//								Points posAvant = new Points(FactoryUtils.convertirIntToChar(xPos), yPos);
//								Points posArriere = new Points(FactoryUtils.convertirIntToChar(positionHorizontale(xPos, bateau)), yPos);
//								bateau.getTabPoints()[0] = posAvant;
//								bateau.getTabPoints()[bateau.getTabPoints().length-1] = posArriere;
//								remplissageDesCasesIntermediaires(posAvant,	posArriere, bateau);
//								break;
//							}
//						}
//						
//					}
//				});
				
				
				listeBouton.add(boutonCasePlateau);
			}
		}
		return listeBouton;
	}
	
	private int getYPosCaseBouton() {
		return boutonCasePlateau.getVerticalAlignment();
	}

	private int getXposCaseBouton() {
		return boutonCasePlateau.getHorizontalAlignment();
	}
	
	private void desactiverToutesLesCasesDuPlateau(Plateau plateau) {
		for(int i = 0; i < plateau.getLePlateau().length; i++){
			for(int j = 0; j < plateau.getLePlateau().length; j++){
				plateau.getLePlateau()[i][j].getBouton().setEnabled(false);
			}
		}
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
