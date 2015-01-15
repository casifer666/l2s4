package agence;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe permettant de tester les classes InterCritere et Agence
 */
public class Main {

	/**
	 * methode principale qui va tester nos classes
	 */
	public static void main(String[] args) {
		System.out.println("DEBUT DU MAIN\n");
		System.out.println("Creation d'une voiture v1 de marque Peugeot et de prix 54");
		Voiture v1 = new Voiture("Peugeot","205",2000,54);
		System.out.println("Creation d'une voiture v2 de marque Audi et de prix 538");
		Voiture v2 = new Voiture("Audi","A4",2010,538);
		System.out.println("Creation d'une voiture v3 de marque Citroen et de prix 249");
		Voiture v3 = new Voiture("Citroen","C5",2008,249);
		System.out.println("Creation d'une voiture v4 de marque Renault et de prix 97");
		Voiture v4 = new Voiture("Renault","Laguna",2006,97);
		System.out.println("Creation d'une voiture v5 de marque Mitsubishi et de prix 380");
		Voiture v5 = new Voiture("Mitsubishi","Pajero",2009,380);
		System.out.println("Creation d'une voiture v6 de marque Volkswagen et de prix 426");
		Voiture v6 = new Voiture("Volkswagen","Tiguan",2007,426);
		System.out.println("Creation d'une voiture v7 de marque Trueno et de prix 71");
		Voiture v7 = new Voiture("Trueno","86",2002,71);
		System.out.println("Creation d'une voiture v8 de marque Timoleon et de prix 86");
		Voiture v8 = new Voiture("Timoleon","POO",2004,86);
		System.out.println("Creation d'une voiture v9 de marque Timoleon et de prix 148");
		Voiture v9 = new Voiture("Timoleon","POO",2005,148);
		System.out.println("-------------------------Test afficheSelection-------------------------");
		System.out.println("Creation d'une agence agence");
		Agence agence = new Agence();
		System.out.println("Ajout des 7 voitures dans l'agence");
		agence.ajouteVoiture(v1);
		agence.ajouteVoiture(v2);
		agence.ajouteVoiture(v3);
		agence.ajouteVoiture(v4);
		agence.ajouteVoiture(v5);
		agence.ajouteVoiture(v6);
		agence.ajouteVoiture(v7);
		agence.ajouteVoiture(v8);
		agence.ajouteVoiture(v9);
		System.out.println("Creation d'un critere de prix c1 : 100");
		Critere c1 = new CriterePrix(100);
		System.out.println("Les voitures qui satisfont le critere c1 (prix inferieur a 100) sont :");
		agence.afficheSelection(c1);
		System.out.println("---------------------------Test InterCritere----------------------------");
		System.out.println("Creation d'un critere de marque c2 : Timoleon");
		Critere c2 = new CritereMarque("Timoleon");
		System.out.println("Creation d'un intercritere c");
		InterCritere c = new InterCritere();
		System.out.println("Ajout de c1 et c2 dans c");
		c.addCritere(c1); c.addCritere(c2);
		System.out.println("Les voitures qui satisfont tous les criteres de c sont :");
		agence.afficheSelection(c);
		System.out.println("\nFIN DU MAIN");
	}
}