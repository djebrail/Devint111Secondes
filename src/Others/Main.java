package Others;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		try {
			// création d'une personne
			Score p = new Score("Dupont", 36);
			System.out.println("creation de : " + p);

			// ouverture d'un flux de sortie vers le fichier "personne.serial"
			FileOutputStream fos = new FileOutputStream("scoree.serial");

			// création d'un "flux objet" avec le flux fichier
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				// sérialisation : écriture de l'objet dans le flux de sortie
				oos.writeObject(p); 
				// on vide le tampon
				oos.flush();
			} finally {
				//fermeture des flux
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		*/
		
		/*
		// TODO Auto-generated method stub
		Outils outils = new Outils();
		String texte=outils.choisirListe();
		System.out.println( " Texte : " +texte);
		System.out.println("Le mot est il dans la liste ?"); 
		char lettre = outils.choisirLettre(texte);
		System.out.println("La lettre choisi est "+lettre);
		System.out.println(outils.leMotEstDansLaListe("litchi",texte, lettre));
		System.out.println("test de rechercheDuMotDansLaListe");
		System.out.println("Le nombre de ligne du fichier est de : " + outils.nbLigneTexte(texte));		
		
		
		Chrono chrono = new Chrono(111);
		boolean start = true;
		ActionEvent e = new ActionEvent(start, 1, "go");
		chrono.actionPerformed(e);
		*/
		Outils o = new Outils();
		System.out.println(o.laQuestionEst());
		
		
	}

}
