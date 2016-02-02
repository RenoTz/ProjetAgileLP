package data.interfaceJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface extends JFrame{

	private static final long serialVersionUID = 1L;
	static List<JButton> listeBouton;
	private Plateau plateau;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	@SuppressWarnings("static-access")
	public Interface(){
		
		this.plateau = new Plateau(10,10);
		this.listeBouton = creerCasesGraphiques(this.plateau);
		createWindow();
	}
	
	//------------------------
	// METHODES DE LA CLASSE
	//------------------------
	
	public static void createWindow() {  
		
		JFrame frame = new JFrame("Bataille navale");
		
		// Grille de jeu du joueur
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10,10));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		// Grille de jeu de l'adversaire
		JPanel panelAdversaire = new JPanel();
		panelAdversaire.setLayout(new GridLayout(10,10));
        
		// Bouton 'Nouvelle partie'
        JButton nouvellePartieBouton = new JButton("Nouvelle Partie");
        frame.add(nouvellePartieBouton, BorderLayout.SOUTH);
        nouvellePartieBouton.setBackground(Color.black); 
        nouvellePartieBouton.setForeground(Color.white);        
       
		frame.setBackground(Color.GRAY);
		
		// Create button
		for (JButton bouton : listeBouton) {
			panel.add(bouton);
		}  
		panel.setSize(600,600);
		frame.add(panel);
		frame.add(panelAdversaire);
		frame.setSize(600, 600);
		frame.setTitle("Bataille Navale - Groupe 1");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
		return plateau;
	}

}
