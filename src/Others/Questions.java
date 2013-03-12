package Others;

// Cette classe permets de choisir 
//une liste au hasard et une lettre aléatoire.
public class Questions {
	private String[] listes;
	
	public Questions(){		

	}
	
	//Utilise un random, parcours la liste à la ligne rdm
	//Et retourne la premiére lettre.
	public char choisirLettre(){
		String lettres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char caract;
		int i = (int)Math.floor(Math.random()*lettres.length());
		caract=lettres.charAt(i);
		return caract;
	}
	
	//Utilise random pour choisir une liste
	//Les liste dans un tableau ?
	public String choisirListe(){
		listes = new String[5];
		listes[1]= "ListeFruits.txt";
		listes[2]= "ListeMetiers.txt";
		listes[3]= "ListeVilles.txt";
		listes[4]= "ListePays.txt";
		listes[0]= "ListeSports.txt";
		int i = (int)Math.floor(Math.random()*5);
		return listes[i];
	}
	
	public String laQuestionEst(){
		return choisirListe() + " en " + choisirLettre();
	}
}
