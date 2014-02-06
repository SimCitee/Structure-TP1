package Classes;

public class Compagnie {

	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override 
	public String toString() { 
		return "Caracteristique \n"+
			   "Nom : "+ this.nom;
	}
	
}
