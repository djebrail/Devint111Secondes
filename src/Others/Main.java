package Others;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
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
		
	}

}
