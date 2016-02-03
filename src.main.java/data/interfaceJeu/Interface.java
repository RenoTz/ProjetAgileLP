package data.interfaceJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame{

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
        JButton nouvellePartieBouton = new JButton("Nouvelle Partie");
        frame.add(nouvellePartieBouton, BorderLayout.SOUTH);
        nouvellePartieBouton.setBackground(Color.black); 
        nouvellePartieBouton.setForeground(Color.white);   
       
		frame.setBackground(Color.GRAY);
		
		// Create button
		ajouterLaListeBoutonsAuPanel(panelJoueur, listeBoutonJoueur);
//		ajouterLaListeBoutonsAuPanel(panelAdversaire, listeBoutonAdversaire);

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
	
	public List<JButton> creerCasesGraphiques(Plateau plateau) {  
		List<JButton> listeBouton = new ArrayList<JButton>();
		for( int i = 0; i < plateau.getLePlateau().length; i++ ){
			for( int j = 0; j < plateau.getLePlateau().length; j++ ) {
				  //creer bouton + couleurs + clik dessus modifi�
				listeBouton.add(plateau.getLePlateau()[i][j].getBouton());
			  }
		}
		return listeBouton;
	}

	public Plateau getPlateau() {
		return plateauJoueur;
	}

	public Plateau getPlateauAdversaire() {
		return plateauAdversaire;
	}

	public void setPlateauAdversaire(Plateau plateauAdversaire) {
		this.plateauAdversaire = plateauAdversaire;
	}

}
