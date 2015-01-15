package image;

import image.color.*;

/**
 * Classe qui teste la methode edges de la classe Image
 */
public class Test {

	/**
	 * methode qui teste notre classe
	 */
	public static void main(String args[]) {
		Image image = new Image(100,200);
		for (int i = 10 ; i <= 30 ; i++) {
			for (int j = 30 ; j <= 60 ; j++) {
				image.getPixel(i,j).setColor(GrayColor.BLACK);
			}
		}
		for (int k = 50 ; k <= 70 ; k++) {
			for (int l = 50 ; l <= 100 ; l++) {
				image.getPixel(k,l).setColor(new GrayColor(64));
			}
		}
		for (int m = 20 ; m <= 40 ; m++) {
			for (int n = 110 ; n <= 160 ; n++) {
				image.getPixel(m,n).setColor(new GrayColor(230));
			}
		}
		ImageDisplayer id = new ImageDisplayer();
		id.display(image,"Test",100,200);
		Image contoursSeuls1 = image.edges(10);
		id.display(contoursSeuls1,"Test10",100,200);
		Image contoursSeuls2 = image.edges(20);
		id.display(contoursSeuls2,"Test20",100,200);
		Image contoursSeuls3 = image.edges(30);
		id.display(contoursSeuls3,"Test30",100,200);
		// on constate une disparition du rectangle "le plus clair" sur l'image contoursSeuls3
	}

}

