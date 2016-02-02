package data.interfaceJeu;

import java.awt.Button;
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
import data.Points;

public class Interface {
	
	static List<JButton> listeBouton;
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public Interface(){
		
		Plateau plateau = new Plateau(10,10);
		this.listeBouton = creerCasesGraphiques(plateau);
		createWindow();
	}
	
	//------------------------
	// METHODES DE LA CLASSE
	//------------------------
	
	public static void createWindow() {  
		JFrame frame = new JFrame("Bataille navale");

		BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        JButton nouvellePartieBouton = new JButton("Nouvelle Partie");
        frame.add(nouvellePartieBouton, BorderLayout.SOUTH);
        nouvellePartieBouton.setBackground(Color.black); //marche
        nouvellePartieBouton.setForeground(Color.white); //marche        
       
		JPanel panel = new JPanel();
		panel.setBounds(101, 650, 900, 50);
		panel.setBackground(Color.GRAY); //background fenètre du jeu
		
		// Create button
		JButton button = new JButton();
		
		for (JButton bouton : listeBouton) {
			panel.add(bouton);
		}

		frame.add(panel);
		frame.setSize(800, 600);
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
				JButton button = new JButton();
				//button.setBounds(20+  j*20, 10+ i*20, 40, 40);
				button.setBackground(Color.blue);
				button.setPreferredSize(new Dimension(40, 40));//setSize(50, 50); //marche pas
				listeBouton.add(button);
				 
			  }
		}
		return listeBouton;
	}

}
