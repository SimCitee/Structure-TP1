package Classes;

public class Chauffeur {

	private String 	nom;
	private String 	prenom;
	private String 	adresse;
	private String 	no_identification;
	private int		annee_embauche;
	
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
	
	@Override 
	public String toString() { 
		return "Caracteristique \n"+
			   "================================================== \n"+
			   "Nom : "+ this.nom + this.prenom +
			   "Adresse : "+ this.adresse +
			   "No. identification : " + this.no_identification +
			   "Annee embauche : " + String.valueOf(this.annee_embauche);
	}
	
}
