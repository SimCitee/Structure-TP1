package Classes;

public class Chauffeur {

	private String 	nom;
	private String 	prenom;
	private String 	adresse;
	private String 	no_identification;
	private int		annee_embauche;
	
	public Chauffeur(String nom, String prenom, String adresse, int annee_embauche) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.annee_embauche = annee_embauche;
		
		this.createNoIdentification();
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNo_identification() {
		return no_identification;
	}
	public void setNo_identification(String no_identification) {
		this.no_identification = no_identification;
	}
	public int getAnnee_embauche() {
		return annee_embauche;
	}
	public void setAnnee_embauche(int annee_embauche) {
		this.annee_embauche = annee_embauche;
	}
	
	public static String validerNom() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree un nom : \n");
			str = Interface.lecture();
		} while ((str.length() <= 0 || str.length() > 30) || (Interface.isNumeric(str) == true));
		
		return str;
	} 
	
	public static String validerPrenom() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree un prenom : \n");
			str = Interface.lecture();
		} while ((str.length() <= 0 || str.length() > 30) || (Interface.isNumeric(str) == true));
		
		return str;
	} 
	
	public static String validerAdresse() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree une adresse: \n");
			str = Interface.lecture();
		} while ( str.length() <= 0 || str.length() > 50);
		
		return str;
	} 
	
	public static String validerAnneeEmbauche() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree l'annee d'embauche (entre 1950 et 2000) : \n");
			str = Interface.lecture();
		} while (!(Interface.validerEntier(str, 1950, 2000)));
		
		return str;
	} 
	
	@Override 
	public String toString() { 
		return "Caracteristique \n"+
			   "================================================== \n"+
			   "Nom : "+ this.nom + this.prenom + "\n" +
			   "Adresse : "+ this.adresse + "\n" +
			   "No. identification : " + this.no_identification + "\n" +
			   "Annee embauche : " + String.valueOf(this.annee_embauche) + "\n";
	}
	
	private void createNoIdentification() {
		no_identification = nom.substring(0, 3) + prenom.substring(0, 1) + String.valueOf(annee_embauche).substring(2, 4);
	}
	
}
