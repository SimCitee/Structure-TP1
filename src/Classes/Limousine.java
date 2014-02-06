package Classes;

import java.io.IOException;

public class Limousine {
	
	
	private String no_immatriculation;
	private String couleur;
	private int capacite;
	private int nb_passagers;
	
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
	
	public void saisirLimousine() {
		Interface.clearConsole();
		
		this.no_immatriculation = validerImmatriculation();
	}
	
	public String validerImmatriculation() {
		String str = "";
		
		do {
			System.out.print("Veuillez entree l'immatriculation du vehicule (6 caracteres) : \n");
			str = Interface.lecture();
		} while (str.length() == 0 || str.length() != 6 );
		
		return str;
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
