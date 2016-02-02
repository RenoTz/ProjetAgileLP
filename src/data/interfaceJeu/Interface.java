package data.interfaceJeu;

import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

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

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		// Create button
		JButton button = new JButton();
		button.setText("Nouvelle partie");
		button.setBackground(Color.blue);
		

		panel.add(button);
		for (JButton bouton : listeBouton) {
			panel.add(bouton);
		}

		frame.add(panel);
		frame.setSize(800, 600);
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
				button.setBounds(40+  j*40, 40+ i*40, 40, 40);
				button.setBackground(Color.BLACK);
				listeBouton.add(button);
				
			  }
		}
		return listeBouton;
	}

}
