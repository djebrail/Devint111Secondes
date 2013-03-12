package Others;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outils outils = new Outils();
		System.out.println(outils.leMotEstDansLaListe("litch","ListeFruits.txt"));
		System.out.println(outils.motPossible("litchE", "litchi"));
		System.out.println(outils.motPossible("litehE", "litchi"));
		System.out.println(outils.motPossible("litchiazejaivefovb", "litchi"));
		System.out.println(outils.motPossible("azejaivefovb", "litchi"));
		
		Questions question = new Questions();
		System.out.println(question.choisirListe());
		System.out.println(question.choisirListe());
		System.out.println(question.choisirLettre());
		System.out.println(question.choisirLettre());
		System.out.println(question.laQuestionEst());
	}

}
