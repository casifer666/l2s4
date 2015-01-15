
/**
 * Classe permettant de modeliser des interrupteurs qui controlent plusieurs ampoules a la fois
 * 
 * @author Salla Diagne
 * @version 01/02/13
 */
public class InterrupteurMulti {
    // les attributs de la classe InterrupteurMulti
    /**
     * @param tableauAmpoules = le tableau des ampoules controlees par l'interrupteur
     */
    private Ampoule [] tableauAmpoules;
    private int nbreAmpoules;
    
    // le constructeur pour les objets de la classe InterrupteurMulti
    /**
     * constructeur pour les objets de la classe InterrupteurMulti
     */
    public InterrupteurMulti (int nbreMAXampoules) {
        this.tableauAmpoules = new Ampoule [nbreMAXampoules];
        this.nbreAmpoules = 0;
    }
    
    // les methodes de la classe InterrupteurMulti
    /**
     * ajoute une ampoule
     * @param i = l'indice a laquelle doit etre ajoutee l'ampoule
     * @param ampoule = l'ampoule a ajouter
     */
    public void ajouteAmpoule (int i, Ampoule ampoule) {
        if ((i >= 0) && (i < tableauAmpoules.length)) {
            this.tableauAmpoules[i] = ampoule;
            this.nbreAmpoules = this.nbreAmpoules + 1;
        }
        else {
            System.out.println("l'indice de l'ampoule a ajouter doit etre positif et inferieur a la longueur du tableau d'ampoules !"); 
        }
    }
    
    /**
     * appuie sur l'interrupteur
     */
    public void appuiInterrupteurMulti () {
        for (int i = 0; i < tableauAmpoules.length; i++) {
            if ((tableauAmpoules[i] != null) && (tableauAmpoules[i].getEtat())) {
                tableauAmpoules[i].eteint();
            }
            else {
                if ((tableauAmpoules[i] != null) && (tableauAmpoules[i].getEtat() == false)) {
                    tableauAmpoules[i].allume();
                }
            }
        }
    }
    
    /**
     * affiche l'etat de l'ampoule
     * @return l'etat de l'ampoule
     */
    public void afficheEtatAmpoules () {
        for (int i = 0; i < tableauAmpoules.length; i++) {
            if ((tableauAmpoules[i] != null) && (tableauAmpoules[i].getEtat())) {
                System.out.println ("ampoule se situant a l'indice "+i+" : ampoule allumee.");
            }
            else {
                if ((tableauAmpoules[i] != null) && (tableauAmpoules[i].getEtat() == false)) {
                    System.out.println ("ampoule se situant a l'indice "+i+" : ampoule eteinte.");
                }
            }
        }
    }                  
}
