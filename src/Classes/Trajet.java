package Classes;


public class Trajet {

	private String 	ville_depart;
	private String 	ville_arrivee;
	private int 	kilo_depart;
	private int 	kilo_arrivee;
	
	public Trajet(String v_depart, String v_arrivee, int k_depart, int k_arrivee) {
		this.ville_depart = v_depart;
		this.ville_arrivee = v_arrivee;
		this.kilo_depart = k_depart;
		this.kilo_arrivee = k_arrivee;
	}
	
	public Trajet() {
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
	
	public static String validerVilleDepart() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree la ville de depart : \n");
			str = Interface.lecture();
		} while (str.length() == 0);
		
		return str;
	}
	
	public static String validerVilleArrivee(String ville_depart) {
		String str = "";
		
		do {
			System.out.print("Veuillez entree la ville d'arrivee (different de la ville de depart) : \n");
			str = Interface.lecture();
		} while (str.length() == 0 || str.equalsIgnoreCase(ville_depart) );
		
		return str;
	}
	
	public static int validerKiloDepart() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree le kilometrage de depart (max 500 000) : \n");
			str = Interface.lecture();
		} while (!(Interface.validerEntier(str,  0, 500000)));
		
		return Integer.parseInt(str);
	}
	
	public static int validerDistance() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree la distance du trajet (max 500 km) : \n");
			str = Interface.lecture();
		} while (!(Interface.validerEntier(str,  0, 500)));
		
		return Integer.parseInt(str);
	}
	
	@Override 
	public String toString() { 
		return "Caracteristique \n"+
			   "================================================== \n"+
			   "Ville depart : "+ this.ville_depart + "\n"+
			   "Ville arrivee : "+ this.ville_arrivee + "\n"+
			   "Kilometrage depart : " + String.valueOf(this.kilo_depart) + "\n"+
			   "Kilometrage arrivee : " + String.valueOf(this.kilo_arrivee) + "\n";
	}
	
}
