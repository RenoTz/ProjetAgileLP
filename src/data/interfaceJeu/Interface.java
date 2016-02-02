package data.interfaceJeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.Plateau;
import data.bateau.Bateau;

public class Interface extends JFrame{
	
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
		
		JPanel panel = new JPanel();
//		BorderLayout layout = new BorderLayout();
//        frame.setLayout(layout);
        panel.setLayout(new GridLayout(10,10));
        
        JButton nouvellePartieBouton = new JButton("Nouvelle Partie");
        frame.add(nouvellePartieBouton, BorderLayout.SOUTH);
        nouvellePartieBouton.setBackground(Color.black); 
        nouvellePartieBouton.setForeground(Color.white);        
       
//		panel.setBounds(101, 650, 900, 50);
		panel.setBackground(Color.GRAY); //background fenètre du jeu
		
		// Create button
		for (JButton bouton : listeBouton) {
			panel.add(bouton);
		}  
		panel.setSize(600,600);
		frame.add(panel);
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
				  //creer bouton + couleurs + clik dessus modifié
				listeBouton.add(plateau.getLePlateau()[i][j].getBouton());
			  }
		}
		return listeBouton;
	}

	public Plateau getPlateau() {
		return plateau;
	}

}
