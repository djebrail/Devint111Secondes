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
				if (ligne.charAt(0) == lettre) {
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
}
