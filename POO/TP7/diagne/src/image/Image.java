package image;

import image.color.*;
import java.util.Scanner;

/**
 * Classe permettant de representer une image
 */
public class Image {

    /**
     * tableau de pixels
     */
    private Pixel[][] lesPixels;

    /**
     * le constructeur pour les objets de la classe Image
     * @param width = la largeur de l'image
     * @param height = la hauteur de l'image
     */
    public Image(int width, int height) {
        this.lesPixels = new Pixel[width][height];
        for (int i = 0 ; i < width ; i++) {
            for (int j = 0 ; j < height ; j++) {
                lesPixels[i][j] = new Pixel(GrayColor.WHITE);
            }
        }
    }

    /**
     * renvoie la largeur de l'image
     * @return la largeur de l'image
     */
    public int getWidth() {
        return (this.lesPixels.length);
    }

    /**
     * renvoie la hauteur de l'image
     * @return la hauteur de l'image
     */
    public int getHeight() {
        return (this.lesPixels[0].length);
    }

    /**
     * renvoie le pixel de coordonnees <code>(x,y)</code>
     * @param x = l'abscisse du pixel
     * @param y = l'ordonnee du pixel
     * @return le pixel de coordonnees <code>(x,y)</code>
     */
    public Pixel getPixel(int x, int y) {
        return (this.lesPixels[x][y]);
    }

    /**
     * change la couleur du pixel de coordonnees <code>(x,y)</code>
     * @param x = l'abscisse du pixel dont on doit changer la couleur
     * @param y = l'ordonnee du pixel dont on doit changer la couleur
     * @param color = la nouvelle couleur qu'on doit attribuer au pixel
     */
    public void changeColorPixel(int x, int y, GrayColor color) {
        this.lesPixels[x][y].setColor(color);
    }
 
    /**
     * @param threshold = le seuil fixe pour produire l'image par extraction de contours
     * @return l'image obtenue par extraction des contours de l'image initiale
     */
    public Image edges(int threshold) {
        Image edge = new Image(this.getWidth(),this.getHeight());
        for (int i = 0 ; i < this.getWidth() ; i++) {
            for (int j = 0 ; j < this.getHeight() ; j++) {
				if ((i == this.getWidth() - 1) && (j == this.getHeight() - 1)) {
					// on ne fait rien, i et j varient tout seuls (boucles for)
				}
				else {
					if (i == this.getWidth() - 1) {
						Pixel pixelCourant = this.lesPixels[i][j];    
						Pixel pixelDroit = this.lesPixels[i][j+1];
						if (pixelCourant.colorDifference(pixelDroit) > threshold) {
							edge.getPixel(i,j).setColor(GrayColor.BLACK);
						}
					}
					else {
						if (j == this.getHeight() - 1) {
							Pixel pixelCourant = this.lesPixels[i][j];    
							Pixel pixelBas = this.lesPixels[i+1][j];
							if (pixelCourant.colorDifference(pixelBas) > threshold) {
							edge.getPixel(i,j).setColor(GrayColor.BLACK);
							}
						}
						else {
							Pixel pixelCourant = this.lesPixels[i][j];    
							Pixel pixelDroit = this.lesPixels[i][j+1];
							Pixel pixelBas = this.lesPixels[i+1][j];
							if ((pixelCourant.colorDifference(pixelDroit) > threshold) || (pixelCourant.colorDifference(pixelBas) > threshold)) {
							edge.getPixel(i,j).setColor(GrayColor.BLACK);
							}
						}
					}
				}
			}
		}
		return edge;
	}
	
    /**
     * @param nbGrayLevels = le nombre de niveaux de gris a diminuer
     * @return l'image obtenue en diminuant le niveau de gris de <code>nbGrayLevels</code>
     */
	public Image decreaseGrayLevels(int nbGrayLevels) {
		Image gris = new Image(this.getWidth(),this.getHeight());
		int t = 256/nbGrayLevels;
		for (int i = 0 ; i < this.getWidth() ; i++) {
			for (int j = 0 ; j < this.getHeight() ; j++) {
				int k = this.getPixel(i,j).getColor().getLevel()/t;
				GrayColor newColor = new GrayColor(k*t);
				gris.getPixel(i,j).setColor(newColor);
			}
		}
		return gris;
	}

    // ======================================================================
    /** Lecture d'un fichier image au format PGM.
     * On suppose que le fichier respecte la syntaxe suivante :
     *  <ul><li> première ligne :  chaîne "P2"</li>
     *  <li>seconde ligne : un commentaire</li> 
     *  <li>un entier pour la largeur <code>l</code>, un entier pour la hauteur <code>h</code></li>
     *  <li>un entier pour le niveau de gris max (pas utilisé par la suite, pour nous max = 255)</li>
     *  <li><code>l</code> x <code>h</code> entiers entre 0 et max (pour nous =255) pour chacun des pixels</li></ul>
     *  
     *  @param fileName le nom du fichier qui contient l'image
     *  @return l'image créée à partir du fichier
     */
    public static Image initImagePGM(String fileName) {
        Scanner scan = new Scanner(Image.class.getResourceAsStream(fileName));

        scan.nextLine(); // ligne P2
        scan.nextLine(); // ligne commentaire
        int width = scan.nextInt();
        // scan.nextLine();
        int height = scan.nextInt();
        scan.nextInt(); // niveau de gris max
        // creation de l'image initialement blanche
        Image result = new Image(width, height); 
        for (int x = 0; x < height; x++) {
            // scan.nextLine();
            for (int y = 0; y < width; y++) {
                result.changeColorPixel(y, x, new GrayColor(scan.nextInt()));
            }
        }
        return result;
    }

}

