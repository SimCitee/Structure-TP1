package Classes;

import java.io.IOException;

public class Limousine {
	
	
	private String no_immatriculation;
	private String couleur;
	private int capacite;
	private int nb_passagers;
	private Trajet trajet;
	private Chauffeur chauffeur;
	
	public Limousine(String no_immatriculation, String couleur, int capacite, int nb_passagers) {
		this.no_immatriculation = no_immatriculation;
		this.couleur = couleur;
		this.capacite = capacite;
		this.nb_passagers = nb_passagers;
	}
	
	public Trajet getTrajet() {
		return trajet;
	}
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	public Chauffeur getChauffeur() {
		return chauffeur;
	}
	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}
	public String getNo_immatriculation() {
		return no_immatriculation;
	}
	public void setNo_immatriculation(String no_immatriculation) {
		this.no_immatriculation = no_immatriculation;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getNb_passagers() {
		return nb_passagers;
	}
	public void setNb_passagers(int nb_passagers) {
		this.nb_passagers = nb_passagers;
	}
	
	public static String validerImmatriculation() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree l'immatriculation du vehicule (6 caracteres) : \n");
			str = Interface.lecture();
		} while (str.length() == 0 || str.length() != 6 );
		
		return str;
	}
	
	public static String validerCouleur() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree la couleur du vehicule : \n");
			str = Interface.lecture();
		} while (str.length() == 0);
		
		return str;
	} 
	
	public static int validerCapacite() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree la capacite du reservoir (max 100 litres) : \n");
			str = Interface.lecture();
		} while (!(Interface.validerEntier(str, 0, 100)));
		
		return Integer.parseInt(str);
	} 
	
	public static int validerPassagers() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree le nombre de passager (maximum de 6) : \n");
			str = Interface.lecture();
		} while (!(Interface.validerEntier(str, 0, 6)));
		
		return Integer.parseInt(str);
	} 
	
	@Override 
	public String toString() { 
		return "Caracteristique \n"+
			   "No. Immatriculation : "+ this.no_immatriculation +
			   "Capacite : "+ String.valueOf(this.capacite) +
			   "Nombre passagers : " + String.valueOf(this.nb_passagers) +
			   "Couleur : " + this.couleur;
	}
	
	
}
