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
	
	public void saisirRessourceCompagnie() {
		String no_immatriculation;
		String couleur;
		int capacite;
		int nb_passagers;
		String 	nom;
		String 	prenom;
		String 	adresse;
		int		annee_embauche;
		
		
		this.validerNombreLimousines();
		this.validerNombreChauffeurs();
		
		for(Limousine limo : this.limousines) {
			no_immatriculation = Limousine.validerImmatriculation();
			couleur = Limousine.validerCouleur();
			capacite = Limousine.validerPassagers();
			nb_passagers = Limousine.validerPassagers();
			
			limo = new Limousine(no_immatriculation, couleur, capacite, nb_passagers);
		}
		
		for(Chauffeur chauffeur : this.chauffeurs) {
			nom = Chauffeur.validerNom();
			prenom = Chauffeur.validerPrenom();
			adresse = Chauffeur.validerAdresse();
			annee_embauche = Integer.parseInt(Chauffeur.validerAnneeEmbauche());
			
			chauffeur = new Chauffeur(nom, prenom, adresse, annee_embauche);
		}
		
	}
	
	public Trajet saisirTrajet() {
		String 	ville_depart;
		String 	ville_arrivee;
		int 	kilo_depart;
		int 	kilo_arrivee;
		
		Interface.clearConsole();
		
		ville_depart = Trajet.validerVilleDepart();
		ville_arrivee = Trajet.validerVilleArrivee(ville_depart);
		kilo_depart = Trajet.validerKiloDepart();
		kilo_arrivee = Trajet.validerKiloArrivee(kilo_depart);
		
		Trajet t = new Trajet(ville_depart, ville_arrivee, kilo_depart, kilo_arrivee);
		
		return t;
		
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
