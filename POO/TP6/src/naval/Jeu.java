package naval;

import java.util.InputMismatchException;
import java.util.Scanner;

// a ajouter eventuellement  pour importer des classes/types du projet definies dans d'autres paquetages
// import naval.??? ;  // par exemple : import naval.direction.*;


public class Jeu {

    private Mer mer;

    public Jeu(int nl, int nc) {
        this.mer = new Mer(nl, nc);
    }

    public void init() throws IllegalStateException {
        // par exemple, a modifier
        this.mer.poseBateau(new Bateau(3), new Position(2, 3), new DirectionEst());
        this.mer.poseBateau(new Bateau(4), new Position(6, 5), new DirectionNord());
    }

    public void joue() {
        System.out.println("Saisissez les coordonnees de la case (x,y) visee sous la forme : x y, exemple : 3 2");
        System.out.println("Pour arreter la partie, entrer une coordonnee x negative.");

        // on pourrait mettre en place une detection de fin de partie lorsque
        // tous les bateaux sont coulesil faudrait, par exemple et pour faire
        // simple, ajouter dans la classe Mer une information
        // sur le nombre de points de vie total des bateaux (obtenu a la pause)
        // et disposer d'une methode indiquant lorsque la mer est "vide".
        // C'est ce qui est fait dans l'archive fournie pour test.

        Scanner in = new Scanner(System.in);
        boolean fini = false;
        while (!fini) {
            this.mer.affichage(false);
            try {
                System.out.print("x y ? ");
                int x = in.nextInt();
                if (x < 0) {
                    fini = true;
                }
                if (!fini) {
                    int y = in.nextInt();
                    System.out.println(this.mer.vise(new Position(x, y)));
                    // si tous les bateaux sont coules la mer est vide et on
                    // arrete de jouer
		    // ligne a decommenter pour gerer "une fin de partie" comme 
		    // indique ci-dessus		
                    //fini = this.mer.estVide();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // la methode vise() de Mer lance "naturellement" cette
                // exception si on tente d'acceder a une position en dehors du
                // plateau de jeu (car on "sort" du tableau de cases)
            } catch (InputMismatchException e) {
                // pour gerer les mauvaises saisies (lettres au lieu de chiffres
                // par exemple)
                // il faut alors faire ignorer par le scanner cette entree non
                // valide
                in.skip(".*");
            }
        }
        System.out.println("Voici ou etaient les bateaux : ");
        this.mer.affichage(true);
        System.out.println("Au revoir ");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Jeu jeu = new Jeu(9, 9);
        try {
            jeu.init();
            jeu.joue();
        } catch (IllegalStateException e) {
            System.out.println("Partie impossible : bateaux non poses.");
        }
    }
}
 
