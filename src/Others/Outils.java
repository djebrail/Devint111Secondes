package Others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Character;

public class Outils {

	private BufferedReader br;
	private String[] listes;

	public Outils() {

	}

	public String leMotEstDansLaListe(String mot, String texte, char lettre) {
		if (rechercheDuMotDansLaListe(mot, texte, lettre)) {
			return "Le mot est dans la liste +1 ! ";
		} else {
			return " Le mot n'est pas bon mais voici un exemple de mot possible :"+ MotPossible(texte, lettre);
		}
	}

	public boolean rechercheDuMotDansLaListe(String mot, String texte, char lettre) {
		String fichier = texte;
		if (Character.toUpperCase(mot.charAt(0)) != Character.toUpperCase(lettre)) {
			return false;
		}
		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
			String ligne;
			String motMaj = mot.toUpperCase();
			while ((ligne = br.readLine()) != null) {
				String ligneMaj = ligne.toUpperCase();
				if (motMalTape(motMaj, ligneMaj)) {
					return true;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}

	// Gere la possibilité que la personne est mal tapé
	public boolean motMalTape(String motTape, String motReference) {
		/*
		 * if(motTape.length()!= motReference.length()){ return false; }
		 */
		int nbReference;
		if (motReference.length() > motTape.length()) {
			nbReference = motTape.length();
		} else {
			nbReference = motReference.length();
		}
		int nbCharJuste = 0;
		for (int i = 0; i < nbReference; i++) {
			if (String.valueOf(motTape.charAt(i)).compareTo(
					String.valueOf(motReference.charAt(i))) == 0) {
				nbCharJuste++;
			}
		}
		int nbTemp = nbReference - nbCharJuste;
		if (nbTemp == 0 || nbTemp == 1) {
			return true;
		} else {
			return false;
		}
	}

	public String MotPossible(String texte, char lettre) {
		try {
			InputStream ips = new FileInputStream(texte);
			InputStreamReader ipsr = new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				if (ligne.toUpperCase().charAt(0) == Character.toUpperCase(lettre)) {
					return ligne;
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "le mot n'existe pas en : " + lettre;
	}
	
	public int nbLigneTexte(String texte) {
		String fichier = texte;
		int count=0;
		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				count++;
				
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return count;
	}
	
	
	public String getMotDeLaLigne(String texte, int nb){
		String fichier = texte;
		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);		
			br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				for(int i = 0; i!= nb;i++) {
					ligne = br.readLine();
				}
				return ligne;
			}
			br.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return "Error";
	}
	
	public char choisirLettre(String texte){
		//texte="ListeFruits.txt";
		int nb = nbLigneTexte(texte);
		int alea = (int)Math.floor(Math.random()*nb);
		String mot = getMotDeLaLigne(texte, alea);
		char lettre = mot.charAt(0);
		return lettre;
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
	
	public String laQuestionEst(String texte){
		return choisirListe() + " en " + choisirLettre(texte);
	}
}

