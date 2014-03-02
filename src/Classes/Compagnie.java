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
			if (l.getNb_passagers() > 0) {
				
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
		
		for(int i = 0; i < limousines.length; i++) {
			if(limousines[i].trajetAssocie()) {
				
				System.out.println("Trajets : ");
				
				System.out.println("Ville de depart : " + limousines[i].getTrajet().getVille_depart());
				System.out.println("Ville d'arrivee : " + limousines[i].getTrajet().getVille_arrivee());
				System.out.println("Kilometrage de depart : " + limousines[i].getTrajet().getKilo_depart());
				System.out.println("Kilometrage d'arrivee : " + limousines[i].getTrajet().getKilo_arrivee());
				
				System.out.println("");
				

				System.out.println("Limousines : ");

				System.out.println("Numero d'immatriculation : " + limousines[i].getNo_immatriculation());
				System.out.println("Couleur : " + limousines[i].getCouleur());
				System.out.println("Capacite : " + limousines[i].getCapacite());
				System.out.println("Nombre de passagers : " + limousines[i].getNb_passagers());
				System.out.println("Numero d'identification du chauffeur : " + limousines[i].getChauffeur().getNo_identification());

				System.out.println("");

			}
		}
		
		Interface.lecture();
		Interface.menuPrincipal();

	}
}
