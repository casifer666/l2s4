package calculette;

public class Main {

	public static void main(String[] args) {
		new VueCalculette(new CalculetteInfixee()).lancer("Infixee");
		new VueCalculette(new CalculettePostfixee()).lancer("Postfixee");
	}

}
