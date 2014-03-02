package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.Iterator;

public class Interface {
	
	public static String lecture()
	{
		String str = "";
		
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    str = bufferRead.readLine(); 
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return str;
		
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
				return;
				//break;
			
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
			
			Interface.lecture();
			menuPrincipal();		// retour au menu principal
		}
		else {
			if (l == null)
				Interface.afficherEnTete("Aucune limousine disponible.");
			else
				Interface.afficherEnTete("Aucun chauffeur disponible.");
		}

	}
	
	/*
	private static void menuTypeBillets(Spectacle spectacle)
	{
		String choixUtilisateur;
		
		while(true)
		{
			System.out.println("Choisissez le type de billet.");
			System.out.println("1. VIP");
			System.out.println("2. Ordinaire");
			System.out.println("3. Economique");
			System.out.println("0. Retour");
			
			choixUtilisateur = Interfaces.lectureEntreUtilisateur();
			
			if(Interfaces.validerChoixEntier(choixUtilisateur, 0, 3))
		    {
		    	//Le choix est valide, on sort de la validation
		    	break;
		    }
		}
		
		switch(choixUtilisateur)
		{
			case "0" : 
				menuAcheterBillets();
				break;
			
			case "1" : 
				menuQteBillet(spectacle, "BilletVIP");
				break;
				
			case "2" : 
				menuQteBillet(spectacle, "BilletOrdinaire");
				break;
				
			default : 
				menuQteBillet(spectacle, "BilletEconomique");
				break;
				
		}
		
	}
	
	public static void menuQteBillet(Spectacle spectacle, String typeBillet)
	{
		int nbBilletDisponible;
		int nbBilletAchete = 0;
		String choixUtilisateur;
		boolean transactionReussite = false;
		
		while(true)
		{
			//D�termine le nb. de billets restant selon le type de billets
			switch(typeBillet)
			{
				case "BilletVIP" :
					nbBilletDisponible = spectacle.getNombreBilletRestantVIP();
					System.out.println("Nombre de billets VIP disponibles : " + nbBilletDisponible);
					break;
					
				case "BilletOrdinaire" :
					nbBilletDisponible = spectacle.getNombreBilletRestantORD();
					System.out.println("Nombre de billets ordinaires disponibles : " + nbBilletDisponible);
					break;
					
				default :
					nbBilletDisponible = spectacle.getNombreBilletRestantECO();
					System.out.println("Nombre de billets economiques disponibles : " + nbBilletDisponible);
					break;	
			}
		
		
			System.out.println("0. Retour");
			System.out.print("Entrez la quantite : ");
			
			choixUtilisateur = Interfaces.lectureEntreUtilisateur();
			
			if(Interfaces.validerChoixEntier(choixUtilisateur, 0, 10000))
		    {
		    	//Le choix est valide, on sort de la validation
		    	break;
		    }

		}
		
		if(choixUtilisateur.equals("0"))
		{
			menuTypeBillets(spectacle);
		}
		else
		{
			//Qt� choisie par l'utilisateur
			nbBilletAchete = Integer.parseInt(choixUtilisateur);
			
			switch(typeBillet)
			{
				case "BilletVIP" :
					//System.out.println("nbBilletAchete : " + nbBilletAchete);
					//System.out.println("spectacle.getNombreBilletRestantVIP() : " + spectacle.getNombreBilletRestantVIP());
					
					if(nbBilletAchete <= spectacle.getNombreBilletRestantVIP()) {
						transactionReussite = Transactions.getInstance().acheterBillet(UtilisateurActif.getInstance(), nbBilletAchete, typeBillet, spectacle);
					}
					break;
					
				case "BilletOrdinaire" :
					if(nbBilletAchete <= spectacle.getNombreBilletRestantORD()) {
						transactionReussite = Transactions.getInstance().acheterBillet(UtilisateurActif.getInstance(), nbBilletAchete, typeBillet, spectacle);
					}
					break;
					
				default :
					if(nbBilletAchete <= spectacle.getNombreBilletRestantECO()) {
						transactionReussite = Transactions.getInstance().acheterBillet(UtilisateurActif.getInstance(), nbBilletAchete, typeBillet, spectacle);
					}
					break;	
			}
			
			if (transactionReussite) {
				System.out.println(" ");
				System.out.println("Transaction approuvee");
				System.out.println(" ");
			}
			else {
				System.out.println(" ");
				System.out.println("Transaction echouee.");
				System.out.println(" ");
			}
			
			//Menu pr�c�dent
			menuTypeBillets(spectacle);
		}
	}
	
	//Interface d'achat de billets
	public static void menuAfficherTransactions()
	{
		
		ConsoleTableLayout layout = new ConsoleTableLayout(20, 20, 20, 20);
		ConsoleTableLayout layout2 = new ConsoleTableLayout(15, 15);
		
		if(!Transactions.getInstance().getTransactions().isEmpty()) {
			System.out.println(" ");
			System.out.println(" ");
			layout.newLine("Spectacle", "Type de billet", "Nombre de billet", "Coût");
			System.out.println(" ");
			for(Iterator<Transaction> transactions = Transactions.getInstance().getTransactions().iterator(); transactions.hasNext();) {
				Transaction trans = transactions.next();
				layout.newLine(trans.getSpectacle().getArtiste(), trans.getTypeBillet(), Integer.toString(trans.getNbBillets()), Double.toString(trans.getCout()) + " $");
			}
			System.out.println(" ");
			layout2.newLine("Crédit restant : ", Double.toString(UtilisateurActif.getInstance().getCredit()));
			System.out.println(" ");
		}
		else {
			System.out.println(" ");
			System.out.println("Aucune transaction enregistree.");
			System.out.println(" ");
		}
		
		menuPrincipal();
	}
	
	public static void afficherMessageErreurSoldeInsufisant()
	{
		System.out.println("");
		System.out.println("Le solde est insufisant!");
		System.out.println("");
	}
	
	private static void afficherMsgErreur()
	{
		System.out.print("Choix invalide!");
	}
	
	//"Efface" la console
	private static void clearConsole()
	{
		
		System.out.print("\n\n\n\n");

	}*/

}
