package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.Iterator;

public class Interface {
	
	public static String lecture ()
	{
		String str = "";
		
		try {
			str = Interface.lectureException();
		}
		catch(ExceptionBlank e) {
			System.err.println("L'entree de donnees contient : " + e.str);
			System.err.println(e.getMessage());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return str;
		
	}
	
	private static String lectureException () throws ExceptionBlank, IOException
	{
		String str = "";

	    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    str = bufferRead.readLine(); 

		if(str == "") {
			throw new ExceptionBlank(str);
		}
		else {
			return str;
		}
	}
	
	public static void clearConsole()
	{
		
		System.out.print("\n\n\n\n");

	}
	
	// valider si chiffre entree est un entier
	public static boolean validerEntier(String valeur, int plageDebut, int plageFin)
	{
		int choixUtilisateur;

		try { 
			choixUtilisateur = Integer.parseInt(valeur); 
	        
	    } 
		catch(NumberFormatException e) { 
	        return false; 
	    }
		
		if((choixUtilisateur >= plageDebut) && (choixUtilisateur <= plageFin))
		{
			return true;
		}

		return false;

		
	}
	
	public void initialiser() {
		
		afficherEnTete("Bienvenue chez AutoSuperieur");
		
		Compagnie.getInstance().saisirRessourceCompagnie();
		
		menuPrincipal();
	}
	
	public static void afficherEntete()
	{
		Interface.afficherEnTete("Menu principal");
	}
	
	public static void afficherEnTete(String titre)
	{
		System.out.print("***** " + titre + " ***** \n\n");
	}
	
	//Interface principale
	public static void menuPrincipal()
	{
		
		String choixUtilisateur;
		
		while(true)
		{
			
			System.out.print("\n1. Reserver une limousine");
			System.out.print("\n2. Afficher les limousines par chauffeur");
			System.out.print("\n3. Afficher details trajets");
			System.out.print("\n0. Quitter");
			
			choixUtilisateur = lecture();
			
		    if (validerEntier(choixUtilisateur, 0, 3))
		    {
		    	//Le choix est valide, on sort de la validation
		    	break;
		    }
		    
		    clearConsole();
		}
	
		
		switch(choixUtilisateur)
		{
		
			case "0" :
				System.exit(0);
				break;
			case "1" :
				clearConsole();
				clearConsole();
				Interface.reserverLimousine();
				break;
				
			case "2" :
				clearConsole();
				clearConsole();
				Compagnie.getInstance().afficherLesLimousinesParChauffeur();
				break;
				
			case "3" : 
				clearConsole();
				clearConsole();
				Compagnie.getInstance().afficherTrajetsEtLimousines();
				break;
				
			default :
				clearConsole();
				menuPrincipal();
			
		}
		
	}
	
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	//Interface d'achat de billets
	private static void reserverLimousine()
	{
		int compteur;
		int choix;
		String str;
		Limousine l;
		
		l = Compagnie.getInstance().trouverLimousineDisponible();
		
		if ((l != null) || (Compagnie.getInstance().getChauffeurs().length == 0)) {
			
			System.out.print("Veuillez choisir un chauffeur : \n");
			
			do {
				
				compteur = 1;
				
				for (Chauffeur c : Compagnie.getInstance().getChauffeurs()) {
					System.out.print(compteur + ". " + c.getPrenom() + " " + c.getNom() + "\n");
					compteur++;
				}
				
				str = Interface.lecture();
				
				if (!(Interface.validerEntier(str, 1, Compagnie.getInstance().getChauffeurs().length))) {
					str = "";
					System.out.print("Choix invalide.");
				}
				
			} while (str.equals(""));
			
			
			Chauffeur c = Compagnie.getInstance().getChauffeur(Integer.parseInt(str) - 1);
			Trajet t = Compagnie.getInstance().saisirTrajet();	// creer le trajet
			
			l.setChauffeur(c);									// assigner le chauffeur
			l.setTrajet(t);										// assigner le trajet
			
			
			Interface.afficherEnTete("Chauffeur et trajet assigne a la limousine avec le no. immatriculation : " +
										l.getNo_immatriculation()
									);
		}
		else {
			if (l == null)
				Interface.afficherEnTete("Aucune limousine disponible.");
			else
				Interface.afficherEnTete("Aucun chauffeur disponible.");
		}
		
		Interface.lecture();
		menuPrincipal();		// retour au menu principal

	}

}
