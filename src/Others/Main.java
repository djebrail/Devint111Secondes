package Others;

import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Questions question = new Questions();
		Outils outils = new Outils();
		System.out.println("Le mot est il dans la liste ?"); 
		char lettre = question.choisirLettre();
		System.out.println("La lettre choisi est "+lettre);
		System.out.println(outils.leMotEstDansLaListe("litchazez","ListeFruits.txt", lettre));
//		System.out.println("test de rechercheDuMotDansLaListe");
//		System.out.println(outils.rechercheDuMotDansLaListe("cacaboudion","ListeFruits.txt", 'C'));
//		System.out.println(outils.motMalTape("azejaivefovb", "litchi"));
		

//		System.out.println(question.choisirListe());
//		System.out.println(question.choisirListe());
//		System.out.println(question.choisirLettre());
//		System.out.println(question.choisirLettre());
//		System.out.println(question.laQuestionEst());
		
//		System.out.println(outils.MotPossible("ListeFruits.txt", lettre));
		
		System.out.println("Le nombre de ligne du fichier est de : " + outils.nbLigneTexte("ListeFruits.txt"));
	}

}
