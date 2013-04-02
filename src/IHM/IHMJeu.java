package IHM;


import javax.swing.*;
import javax.swing.border.LineBorder;

import Others.Outils;

import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/** Cette classe est un exemple d'interface de jeu.
 * Elle étend DevintFrame pour avoir un Frame et réagir aux évênements claviers
 * Implémente ActionListener pour réagir au clic souris sur le bouton.
 * On surchage la méthode "keyPressed" pour associer une action à la touche F3
 *
 * @author helene
 */
public class IHMJeu extends FenetreAbstraite implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3618784748797233087L;
	
	private JTextArea lb1;
	private JTextArea lb2;
	//protected JTextField textField;
	String mot="";
	
	/*
	 * Constructeur
	 */
	public IHMJeu(String title) {
		super(title);
	}


	/*
	 * Initialisation du frame.
	 */
	protected void init() {
    	//Genère une question :
		
    	lb1 = new JTextArea ("Appuyez sur Entree pour debuter");
    	lb1.setLineWrap(true);
    	lb1.setEditable(false);
    	lb1.setFont(new Font("Georgia",1,80));
    	this.add(lb1,BorderLayout.NORTH);
    	
    	
    	lb2 = new JTextArea ("");
    	lb2.setLineWrap(true);
    	lb2.setEditable(true);
    	lb2.setFont(new Font("Georgia",1,80));
        this.add(lb2,BorderLayout.SOUTH);
       
    	
    	/*
    	question.setText(texte);
    	question.setBackground(new Color(50,50,255));
    	question.setBorder(new LineBorder(Color.BLACK,10));
     	question.setFont(new Font("Georgia",1,40));
     	// c'est l'objet Jeu lui-même qui réagit au clic souris
       	question.addActionListener(this);
    	// on met le bouton à droite
     	this.add(question);
     	*/
    	
    	//Affiche ce qui est entré au clavier
    	/*
    	textField = new JTextField(20);
        textField.addActionListener(this);
        textField.setFont(new Font("Georgia",1,180));
       this.add(textField,BorderLayout.SOUTH);
       */
	}


	/*
	 * Fonctions permettant de gérer les évènements et les actions
	 */

	//Action performed: Défini les actions à effectuer lors de détection des évènements
	public void actionPerformed(ActionEvent ae){
		/*
		voix.stop();	// toujours stopper la voix avant de parler

		Object source = ae.getSource(); // on récupère la source de l'évènement

		if (source.equals(question)) { // si c'est le bouton "question" on lit la question
			String text = outils.laQuestionEst();
			voix.playText(text); // le contenu des questions est variable donc on les lit avec SI_VOX
			
			
			
		}

		this.requestFocus(); // on redonne le focus au JFrame principal (après un clic, le focus est sur le bouton)
	*/
		
	}
	


	//Keyboard event listener: détecte les éléments clavier.
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);	// appel à la méthode mère qui gère les évènements ESC, F1, F3, F4
		Outils o = new Outils();
		String question=o.laQuestionEst();
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_ENTER:
			 
			lb1.setText(question);
			voix.playText(question);
			lb2.setText("too");

			
			break;
			
		case KeyEvent.VK_SPACE:
			
			//String s = question.substring(question.lastIndexOf(" "));
			//char lettreGeneree = s.charAt(0);
			//String nomFichier ="..\\ressources\\Liste" + question.substring(0,question.indexOf(" "))+".txt" ;
			String message = o.leMotEstDansLaListe("saturne","..\\ressources\\ListePlanete.txt",'s');
			lb2.setText("mot");
			
			//mot="";
			break;
			
		default:
			mot=mot+e.getKeyChar();
			//mot=textField.getText();
			//break;

		}
	}


	/*
	 * Fonctions qui renvoient les sons d'accueil et d'aide.
	 * Pour plus d'informations, regarder la classe DevintFrameListener (dans le package devintAPI)
	 */

	protected String wavAccueil() {	// renvoie le fichier wave contenant le message d'accueil
		return "../ressources/sons/accueilJeu.wav";
	}

	protected String wavRegleJeu() {	// renvoie le fichier wave contenant la règle du jeu
		return "../ressources/sons/aideF1.wav";
	}

	protected String wavAide() {	// renvoie le fichier wave contenant la règle du jeu
		return "../ressources/sons/aide.wav";
	}


	@Override
	public void changeColor() {
		// TODO Auto-generated method stub

	}




}
