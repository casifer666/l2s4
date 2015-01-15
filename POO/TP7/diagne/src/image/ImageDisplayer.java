package image;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.JFrame;

/** Classe d'affichage pour les images. Les noms du sujet doivent être respectés pour en permettre l'utilisation 
 * @author jc
 *
 */
public class ImageDisplayer {
    
    /** idem à display(img, title, 100, 100)
     * @see #display(Image, String, int, int)
     */
    public void display(Image img, String title) {
        this.display(img, title, 100,100);
    }
    /** affiche l'image img dans une fenêtre
     * @param img l'image à afficher
     * @param title le titre de la fenêtre
     * @param x la position en x du coin supérieur gauche de la fenêtre d'affichage
     * @param y la position en y du coin supérieur gauche de la fenêtre d'affichage
     */
    public void display(Image img, String title, int x, int y) {
        BufferedImage bfImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = bfImg.getRaster();
        Pixel pixel;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                pixel = img.getPixel(i, j);
                int[] tabInt =  {pixel.getColor().getLevel(), pixel.getColor().getLevel(), pixel.getColor().getLevel()};
                raster.setPixel(i, j, tabInt);
            }
        }
        JFrame frame = new JFrame(title);
        frame.setLocation(x, y);
        frame.addWindowListener(new FermeWindowEvent());
        frame.setSize(img.getWidth(), img.getHeight());
        frame.add(new MonCanvas(bfImg));
        frame.setVisible(true);
    }
    
    // ============================================================
    // classe interne pour le canvas d'affichage
    private class MonCanvas extends Canvas {
        private BufferedImage img;

        public MonCanvas(BufferedImage img) {
            this.img = img;
        }

        public void paint(Graphics g) {
            g.drawImage(this.img, 0, 0, null);
        }
    }
    
    // ----------------------------------------------------------------------
    // CLASSE INTERNE, 
    // pour gérér la fermeture de l'application lorsque l'on ferme une fenêtre
    // ----------------------------------------------------------------------
    class FermeWindowEvent extends WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
        }
    }  
}
