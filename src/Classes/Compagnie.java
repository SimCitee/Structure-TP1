package Classes;
import java.io.*;

public class Compagnie {

	private Limousine[] limousines;
	private Chauffeur[] chauffeurs;
	private int compteurChauffeur;
	private int compteurLimousine;
	private static Compagnie INSTANCE = new Compagnie();

	private Compagnie() {
		this.compteurChauffeur = this.compteurLimousine = 0;
	}
	
	public static Compagnie getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Compagnie();
		}
		
		return INSTANCE;
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
	
	public Chauffeur getChauffeur(int index) {
		return this.chauffeurs[index];
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
			
			Interface.afficherEnTete("Saisir vehicule no." + (this.compteurLimousine+1));
			
			no_immatriculation = Limousine.validerImmatriculation();
			couleur = Limousine.validerCouleur();
			capacite = Limousine.validerCapacite();
			nb_passagers = Limousine.validerPassagers();
			
			limo = new Limousine(no_immatriculation, couleur, capacite, nb_passagers);
			
			this.limousines[this.compteurLimousine] = limo;
			
			this.compteurLimousine++;
			
		}
		
		for(Chauffeur chauffeur : this.chauffeurs) {
			
			Interface.afficherEnTete("Saisir chauffeur no." + (this.compteurChauffeur+1));
			
			nom = Chauffeur.validerNom();
			prenom = Chauffeur.validerPrenom();
			adresse = Chauffeur.validerAdresse();
			annee_embauche = Integer.parseInt(Chauffeur.validerAnneeEmbauche());
			
			chauffeur = new Chauffeur(nom, prenom, adresse, annee_embauche);
			
			this.chauffeurs[this.compteurChauffeur] = chauffeur;
			
			this.compteurChauffeur++;
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
		kilo_arrivee = Trajet.validerDistance(); // obtenir la distance du trajet
		kilo_arrivee += kilo_depart;	// ajouter le kilometrage de depart a la distance du trajet
		
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
	
	public Limousine trouverLimousineDisponible() {
		
		for (Limousine l : this.limousines) {
			if (!l.trajetAssocie()) {			
				return l;
			}
		}
		
		return null;
	}
	
	@Override 
	public String toString() { 
		return "Nombre de limousines : " + this.limousines.length + "\n" +
			   "Nombre de chauffeurs : " + this.chauffeurs.length;
	}
	
	public void afficherLesLimousinesParChauffeur() {

		int choix = 0;
		String str = "";
		
		System.out.println("");
		
		Interface.afficherEnTete("Afficher les limousines d'un chauffeur");
		
		do {
			
			System.out.println("Veuillez choisir un chauffeur :");
			
			for(int i = 0; i < chauffeurs.length; i++) {
				System.out.println((i+1) + ". " + chauffeurs[i].getPrenom() + " " + chauffeurs[i].getNom());
			}
	
			str = Interface.lecture();
			
			if (!(Interface.validerEntier(str, 1, Compagnie.getInstance().getChauffeurs().length))) {
				str = "";
				System.out.println("Choix invalide.");
			}

		
		} while(str == "");
		
		choix = Integer.parseInt(str);
		choix--;

		System.out.println("Voici les limouses conduites par " + chauffeurs[choix].getPrenom() + chauffeurs[choix].getNom());
		
		for(int j = 0; j < limousines.length; j++) {
						
			if(limousines[j].chauffeurAssocie()) {
				if(limousines[j].getChauffeur().getNo_identification().equalsIgnoreCase(chauffeurs[choix].getNo_identification())) {
					System.out.println("Numero d'immatriculation : " + limousines[j].getNo_immatriculation());
				}
			}
		}
		
		Interface.lecture();
		Interface.menuPrincipal();
	}
	
	
	public void afficherTrajetsEtLimousines() {
		
		System.out.println("");
		
		Interface.afficherEnTete("Afficher les trajets et les limousines utilisees");
		
		for(Limousine l : this.limousines) {
			if(l.trajetAssocie()) {
				
				System.out.println(l.getTrajet().toString());
				System.out.println(l.toString());
				System.out.println(l.getChauffeur().toString());

			}
		}
		
		Interface.lecture();
		Interface.menuPrincipal();

	}
}
