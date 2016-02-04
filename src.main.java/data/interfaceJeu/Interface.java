package data.interfaceJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.apache.commons.lang.StringUtils;

import data.bateau.Bateau;
import data.composants.Case;
import data.composants.Points;
import data.joueur.Joueur;
import enumeration.EnumTypeBateau;
import services.ActionsBateau;
import utils.FactoryUtils;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	static List<JButton> listeBoutonJoueur;
	static List<JButton> listeBoutonAdversaire;
	static List<JButton> listeBoutonCoordsLettres;
	static List<JButton> listeBoutonCoordsChiffres;
	static List<JButton> listeBoutonCoordsChiffres2;
	private Plateau plateauJoueur;
	private Plateau plateauAdversaire;
	private static Joueur joueur;
	private static Joueur adversaire;
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	@SuppressWarnings("static-access")
	public Interface(){
		this.plateauJoueur = new Plateau(10,10);
		this.plateauAdversaire = new Plateau(10, 10);
		this.listeBoutonJoueur = creerCasesGraphiques(this.plateauJoueur);
		this.listeBoutonAdversaire = creerCasesGraphiques(this.plateauAdversaire);
		this.listeBoutonCoordsLettres = creerListeBoutons("l");
		this.listeBoutonCoordsChiffres = creerListeBoutons("c");
		this.listeBoutonCoordsChiffres2 = creerListeBoutons("c");
		createWindow();
	}

	//------------------------
	// METHODES DE LA CLASSE
	//------------------------
	
	public static void createWindow() {  
		
		final JFrame frame = new JFrame("Bataille navale");
		frame.setTitle("Bataille Navale - Groupe 1");
		
		// Panneau principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(1,2));
		panelPrincipal.setBackground(Color.black);
	
		// Grille de jeu du joueur
		JPanel panelJoueur = new JPanel();
		panelJoueur.setLayout(new GridLayout(10,10));
		panelJoueur.setBackground(Color.black);
		
		Border margeJ = BorderFactory.createEmptyBorder(0, 15, 0, 0);
		panelJoueur.setBorder(margeJ);
		
		// Grille de jeu de l'adversaire
		JPanel panelAdversaire = new JPanel();
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
		gridMenu.setLayout(new GridLayout(1, 4, 240, 120));
		gridMenu.setBackground(Color.BLACK);
		
	
		// Bouton 'Nouvelle partie'
        final JButton nouvellePartieBouton = new JButton();
        nouvellePartieBouton.setText("Nouvelle Partie");
        nouvellePartieBouton.setBackground(Color.WHITE); 
        nouvellePartieBouton.setForeground(Color.BLACK);   
				
		//Bouton 'Joueur'
        JButton boutonJoueur = new JButton();
        boutonJoueur.setBackground(Color.WHITE);
        boutonJoueur.setPreferredSize(new Dimension(145, 55));
        boutonJoueur.setText("Joueur");
        boutonJoueur.setForeground(Color.BLACK);
        boutonJoueur.setEnabled(false);
        
        //Bouton 'Score'
        JButton boutonScore = new JButton();
        boutonScore.setBackground(Color.WHITE);
        boutonScore.setPreferredSize(new Dimension(145, 55));
        boutonScore.setText("Score");
        boutonScore.setForeground(Color.BLACK);
        boutonScore.setEnabled(false);
		
        //Bouton 'Adversaire'
        JButton boutonAdversaire = new JButton();
        boutonAdversaire.setBackground(Color.WHITE);
        boutonAdversaire.setPreferredSize(new Dimension(145, 55));
        boutonAdversaire.setText("Adversaire");
        boutonAdversaire.setForeground(Color.BLACK);
        boutonAdversaire.setEnabled(false);

		// Ajout des paneaux au paneau principal
		
        panelPrincipal.add(panelJoueur);   
        panelPrincipal.add(panelAdversaire);
        
        //Ajout des boutons au layout
        panelMenu.add(gridMenu);
        gridMenu.add(boutonJoueur);
        gridMenu.add(nouvellePartieBouton);
        gridMenu.add(boutonScore);
        gridMenu.add(boutonAdversaire);
        

        // emplacement de titre
        //final JLabel fenetreJoueur = new JLabel("	Joueur - Adversaire  ", JLabel.CENTER);
        // frame.add(fenetreJoueur, BorderLayout.NORTH);
        //fenetreJoueur.setForeground(Color.black); 

		
		// Create button
		ajouterLaListeBoutonsAuPanel(panelJoueur, listeBoutonJoueur);
		ajouterLaListeBoutonsAuPanel(panelAdversaire, listeBoutonAdversaire);
		ajouterLaListeBoutonsAuPanel(panelCoordLettres, listeBoutonCoordsLettres);
		ajouterLaListeBoutonsAuPanel(panelCoordChiffres1, listeBoutonCoordsChiffres);
		ajouterLaListeBoutonsAuPanel(panelCoordChiffres2, listeBoutonCoordsChiffres2);
		

		//panelJoueur.setSize(1000,600);
		//panelAdversaire.setSize(600, 600);
		
		//Colonne des Lettres du plateau
		Border padding = BorderFactory.createEmptyBorder(120, 60, 15, 15);
		panelPrincipal.setBorder(padding);

		// Panneau du Menu
		panelMenu.setBounds(0, 0, 1300, 65);
		
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
		
		// Test pour savoir si une partie est gagn�
		//JOptionPane.showMessageDialog(null, "Vous avez gagn� la partie");

		
		
		
		nouvellePartieBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				initialiserPartie();				
			}
		});
		
		//panelJoueur.setVisible(false);
		//panelAdversaire.setVisible(false);
	}
	
	public static void initialiserPartie() {
		Interface interfaceJeu = new Interface();
		
		ActionsBateau actions = new ActionsBateau();
		
		// Creation du joueur
		joueur = new Joueur();
		adversaire = new Joueur();
		
		// Intialisation de la liste des bateaux des joueurs
		joueur.setListeBateaux(actions.initialiserListeBateaux());
		adversaire.setListeBateaux(actions.initialiserListeBateaux());
		
		// TODO RT : Creation d'une nouvelle partie (fixe temporairement, aleatoire A VENIR !!!)
		// Placement des bateaux du joueur
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.PORTE_AVION, new Points('A', 3), new Points('A', 7));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.CROISEUR, new Points('C', 1), new Points('F', 1));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		actions.assignerCoordonneesBateaux(joueur, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		
		// Placement des bateaux de l'adversaire	
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.PORTE_AVION, new Points('A', 3), new Points('A', 7));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CROISEUR, new Points('E', 1), new Points('H', 1));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.CONTRE_TORPILLEUR, new Points('E', 3), new Points('E', 5));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.SOUS_MARIN, new Points('G', 5), new Points('I', 5));
		actions.assignerCoordonneesBateaux(adversaire, EnumTypeBateau.TORPILLEUR, new Points('J', 8), new Points('J', 9));
		
		// Placement des bateaux sur le plateau
		actions.placerLesBateauxSurLePlateau(joueur.getListeBateaux(),interfaceJeu.getPlateauJoueur());
		actions.placerLesBateauxSurLePlateau(adversaire.getListeBateaux(),interfaceJeu.getPlateauAdversaire());
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
						tirer(plateau, FactoryUtils.convertirCharToInt(getXPos(plateau, x, y)), getYPos(plateau, x, y)-1);
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
	
	public void tirer(Plateau plateau, int x , int y) {
		if(plateau.getLePlateau()[x][y].getCouleur().equals(Color.DARK_GRAY) || plateau.getLePlateau()[x][y].isCaseTouche()){
			plateau.getLePlateau()[x][y].setCaseTouche(true);
			plateau.getLePlateau()[x][y].setCouleur(Color.RED);
			plateau.getLePlateau()[x][y].getBouton().setBackground(Color.RED);
			EnumTypeBateau bateauTouche = recupererLeTypeBateauTouche(plateau.getLePlateau()[x][y]);
			if(verifierQueToutesLesCasesBateauxSontTouchees(plateau, bateauTouche)){
				
			}
		}else{
			plateau.getLePlateau()[x][y].getBouton().setBackground(Color.WHITE);
		}
	}

	private boolean verifierQueToutesLesCasesBateauxSontTouchees(Plateau plateau, EnumTypeBateau bateauTouche) {
		if(StringUtils.isNotBlank(bateauTouche.toString())){
			for(Bateau bateau : getJoueur().getListeBateaux()){
				if(bateau.getTypeBateau().equals(bateauTouche)){
					int nombreCasesTouches = 0;
					for(int i = 0; i < bateau.getTabPoints().length; i++){
						if(plateau.getLePlateau()[xCaseBateau(bateau, i)][yCaseBateau(bateau, i) - 1].getCouleur().equals(Color.RED)){
							nombreCasesTouches++;
							if(nombreCasesTouches == bateau.getTabPoints().length){
								coulerLeBateau(bateau, plateau);
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	private void coulerLeBateau(Bateau bateau, Plateau plateau){
		for(int i = 0; i < bateau.getTabPoints().length; i++){
			if(plateau.getLePlateau()[xCaseBateau(bateau, i)][yCaseBateau(bateau, i) - 1].getCouleur().equals(Color.RED)){
				plateau.getLePlateau()[xCaseBateau(bateau, i)][yCaseBateau(bateau, i) - 1].getBouton().setBackground(Color.GREEN);
			}
		}
	}


	private Integer yCaseBateau(Bateau bateau, int i) {
		return bateau.getTabPoints()[i].getyPos();
	}

	private int xCaseBateau(Bateau bateau, int i) {
		return FactoryUtils.convertirCharToInt(bateau.getTabPoints()[i].getxPos());
	}
	
	private EnumTypeBateau recupererLeTypeBateauTouche(Case caseBateau) {
		EnumTypeBateau typeBateauTouche = null;
		for(Bateau bateau : getJoueur().getListeBateaux()){
			for(Points point : Arrays.asList(bateau.getTabPoints())){
				if((point.getxPos()==caseBateau.getPoint().getxPos() && point.getyPos() == caseBateau.getPoint().getyPos())){
					typeBateauTouche = bateau.getTypeBateau();
					break;
				}
			}
		}
		return typeBateauTouche;
	}
	
	public List<JButton> creerListeBoutons(String type){
		List<JButton> listeBouton = new ArrayList<JButton>();
		for(int i = 0; i<10; i++){
			listeBouton.add(generateBouton(i, type));
		}
		return listeBouton;
	}
	
	public JButton generateBouton(int i, String type){
		JButton bouton = new JButton();
		bouton.setBackground(Color.LIGHT_GRAY);
		
		if(type == "c"){
			bouton.setPreferredSize(new Dimension(55, 55));
			bouton.setText(String.valueOf(i + 1));
		}else if(type == "l"){
			bouton.setPreferredSize(new Dimension(45, 46));
			bouton.setText(String.valueOf(FactoryUtils.convertirIntToChar(i + 1)));
		}
		bouton.setEnabled(false);
		return bouton;
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

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		Interface.joueur = joueur;
	}

	public Joueur getAdversaire() {
		return adversaire;
	}

	public void setAdversaire(Joueur adversaire) {
		Interface.adversaire = adversaire;
	}

}
