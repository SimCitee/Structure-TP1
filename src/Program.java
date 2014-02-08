import Classes.*;

public class Program {

	public static void main(String[] args) {
		
		
		Chauffeur jonathan = new Chauffeur("Thivierge", "Jonathan", "1234 adresse", 1986);
		jonathan.createNoIdentification();
		
		Interface layout = new Interface();
		
		layout.initialiser();
		
		//i.initialiser();
		
	}

}