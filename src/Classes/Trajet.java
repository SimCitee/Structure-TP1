package Classes;


public class Trajet {

	private String 	ville_depart;
	private String 	ville_arrivee;
	private int 	kilo_depart;
	private int 	kilo_arrivee;
	private Limousine limo;
	
	public Trajet(Limousine limousine) {
		this.limo = limousine;
	}
	
	public String getVille_depart() {
		return ville_depart;
	}
	public void setVille_depart(String ville_depart) {
		this.ville_depart = ville_depart;
	}
	public String getVille_arrivee() {
		return ville_arrivee;
	}
	public void setVille_arrivee(String ville_arrivee) {
		this.ville_arrivee = ville_arrivee;
	}
	public int getKilo_depart() {
		return kilo_depart;
	}
	public void setKilo_depart(int kilo_depart) {
		this.kilo_depart = kilo_depart;
	}
	public int getKilo_arrivee() {
		return kilo_arrivee;
	}
	public void setKilo_arrivee(int kilo_arrivee) {
		this.kilo_arrivee = kilo_arrivee;
	}
	public Limousine getLimo() {
		return limo;
	}
	public void setLimo(Limousine limo) {
		this.limo = limo;
	}
	
	public void saisirTrajet() {
		Interface.clearConsole();
		
		this.ville_depart = validerVilleDepart();
		this.ville_arrivee = validerVilleArrivee();
		
	}
	
	private String validerVilleDepart() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree la ville de depart : \n");
			str = Interface.lecture();
		} while (str.length() == 0);
		
		return str;
	}
	
	private String validerVilleArrivee() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree la ville d'arrivee (different de la ville de depart) : \n");
			str = Interface.lecture();
		} while (str.length() == 0 || str.equalsIgnoreCase(this.ville_depart) );
		
		return str;
	}
	
	@Override 
	public String toString() { 
		return "Caracteristique \n"+
			   "================================================== \n"+
			   "Ville depart : "+ this.ville_depart +
			   "Ville arrivee : "+ this.ville_arrivee +
			   "Kilometrage depart : " + String.valueOf(this.kilo_depart) +
			   "Kilometrage arrivee : " + String.valueOf(this.kilo_arrivee) + 
			   "Limousine : \n"+ limo.toString();
	}
	
}
