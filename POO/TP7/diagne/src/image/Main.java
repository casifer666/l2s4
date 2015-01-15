package image;

import image.color.*;

/**
 * Classe qui teste la classe Image
 */
public class Main {

	/**
	 * methode qui teste notre classe
	 */
	public static void main(String[] args) {
		String nomFichier = new String(args[0]);
		Image window = new Image(640,480);
		Image image = window.initImagePGM(nomFichier);
		ImageDisplayer affichage = new ImageDisplayer();
		Image contoursSeuls = image.edges(Integer.parseInt(args[1]));
		Image gris = image.decreaseGrayLevels(Integer.parseInt(args[2]));
		affichage.display(image,"Image initiale",100,100);
		affichage.display(contoursSeuls,"Edges",500,100);
		affichage.display(gris,"Decrease Gray Levels",900,100);
	}

}

