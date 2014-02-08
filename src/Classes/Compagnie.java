package Classes;

public class Compagnie {

	private Limousine[] limousines;
	private Chauffeur[] chauffeurs;
	private static Compagnie INSTANCE = new Compagnie();

	private Compagnie() {
	}
	
	public Limousine[] getLimousines() {
		return limousines;
	}

	public void setNbLimousines(int nb_limousines) {
		this.limousines = new Limousine[nb_limousines];
	}

	public Chauffeur[] getChauffeurs() {
		return chauffeurs;
	}

	public void setNbChauffeurs(int nb_chauffeurs) {
		this.chauffeurs = new Chauffeur[nb_chauffeurs];
	}
	
	public void saisirCompagnie() {
		this.validerNombreLimousines();
		this.validerNombreChauffeurs();
	}
	
	public boolean validerNombreLimousines() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree le nombre de limousines de la compagnie (max 5) : \n");
			str = Interface.lecture();
		} while (!(Interface.validerEntier(str, 1, 5)));
		
		this.setNbLimousines(Integer.parseInt(str));
		
		return true;
	}
	
	public boolean validerNombreChauffeurs() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree le nombre de chauffeurs de la compagnie (max 5) : \n");
			str = Interface.lecture();
		} while (!(Interface.validerEntier(str, 1, 5)));

		this.setNbChauffeurs(Integer.parseInt(str));
		
		return true;
	}
	
	public static Compagnie getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Compagnie();
		}
		
		return INSTANCE;
	}
	
	@Override 
	public String toString() { 
		return "Nombre de limousines : " + this.limousines.length + "\n" +
			   "Nombre de chauffeurs : " + this.chauffeurs.length;
	}
	
}
