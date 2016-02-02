package data.interfaceJeu;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface {
	
	//---------------
	//	CONSTRUCTEUR
	//---------------
	
	public Interface(){
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
		panel.add(button);

		frame.add(panel);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
