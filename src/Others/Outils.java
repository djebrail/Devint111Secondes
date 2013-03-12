package Others;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;


public class Outils {
	
	private BufferedReader br;

	public Outils(){
	
	}
	
	public boolean leMotEstDansLaListe(String mot,String texte){
		String fichier =texte;
		//lecture du fichier texte	
				try{
					InputStream ips=new FileInputStream(fichier); 
					InputStreamReader ipsr=new InputStreamReader(ips);
					br = new BufferedReader(ipsr);
					String ligne;
					String word = mot.toUpperCase();
					while ((ligne=br.readLine())!=null){							
						String ligneMaj=ligne.toUpperCase();
						if( motPossible(word,ligneMaj)){								
							return true;
						}
					}					
					br.close(); 
				}		
				catch (Exception e){
					System.out.println(e.toString());
				}
				return false;
	}

	// Gere la possibilité que la personne est mal tapé
	public boolean motPossible(String motTape,String motReference){
		/*if(motTape.length()!= motReference.length()){
			return false;
		}
		*/
		int nbReference;
		if(motReference.length()>motTape.length()){
			nbReference=motTape.length();
		}
		else{
			nbReference=motReference.length();
		}
		int nbCharJuste = 0;
		for(int i = 0 ; i<nbReference ; i++){
			if(String.valueOf(motTape.charAt(i)).compareTo(String.valueOf(motReference.charAt(i)))==0){
				nbCharJuste++;
			}
		}
		int nbTemp=nbReference-nbCharJuste;
		if(nbTemp==0 || nbTemp==1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int nbLigneTexte(String texte) throws IOException{
		int count = 0;
		String str;
		FileInputStream fis = new FileInputStream(texte);
		LineNumberReader l = new LineNumberReader(br);      
		new BufferedReader(new InputStreamReader(fis));
		   while ((str=l.readLine())!=null){ 
		      count = l.getLineNumber();
		   }
		  return count;
	}
}

