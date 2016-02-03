package data.interfaceJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.lang.StringUtils;

import controleur.Main;
import data.bateau.Bateau;
import data.composants.Case;
import data.composants.Points;
import enumeration.EnumTypeBateau;
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
        
		// Bouton 'Nouvelle partie'
        final JButton nouvellePartieBouton = new JButton("Nouvelle Partie");
        frame.add(nouvellePartieBouton, BorderLayout.SOUTH);
        nouvellePartieBouton.setBackground(Color.black); 
        nouvellePartieBouton.setForeground(Color.white);   
		frame.setBackground(Color.GRAY);
		
		// Create button
		ajouterLaListeBoutonsAuPanel(panelJoueur, listeBoutonJoueur);
		ajouterLaListeBoutonsAuPanel(panelAdversaire, listeBoutonAdversaire);
		

		panelJoueur.setSize(600,600);
//		panelAdversaire.setSize(600, 600);
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
			for(Bateau bateau : Main.getJoueur().getListeBateaux()){
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
		for(Bateau bateau : Main.getJoueur().getListeBateaux()){
			for(Points point : Arrays.asList(bateau.getTabPoints())){
				if((point.getxPos()==caseBateau.getPoint().getxPos() && point.getyPos() == caseBateau.getPoint().getyPos())){
					typeBateauTouche = bateau.getTypeBateau();
					break;
				}
			}
		}
		return typeBateauTouche;
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
