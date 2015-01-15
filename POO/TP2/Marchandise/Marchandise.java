
/**
 * Classe permettant la modelisation des marchandises
 * 
 * @author Salla Diagne 
 * @version 01/02/13
 */
public class Marchandise {
    // les attributs de la classe Marchandise
    /**
     * @param value = la valeur de la marchandise
     * @param name = le nom de la marchandise
     */
    private float value;
    private String name;
    
    // les constructeurs pour les objets de la classe Marchandise
    /**
     * constructeur pour les objets de la classe Marchandise permettant l'initialisation de l'attribut name
     */
    public Marchandise (String name) {
        this.value = 0;
        this.name = name;
    }
    
    /**
     * constructeur pour les objets de la classe Marchandise permettant l'initialisation des deux attributs
     */
    public Marchandise (float value, String name) {
        this.value = value;
        this.name = name;
    }
    
    // les methodes de la classe Marchandise
    /**
     * renvoie la valeur de la marchandise
     * @return la valeur de la marchandise
     */
    public float getValue () {
        return (this.value);
    }
    
    /**
     * modifie la valeur de la marchandise
     * @param la nouvelle valeur de la marchandise
     */
    public void setValue (float newValue) {
        this.value = newValue;
    }
    
    /**
     * renvoie le nom de la marchandise
     * @return le nom de la marchandise
     */
    public String getName () {
        return (this.name);
    }
    
    /**
     * modifie le nom de la marchandise
     * @param le nouveau nom de la marchandise
     */
    public void setName (String newName) {
        this.name = newName;
    }
    
    /**
     * affiche l'etat de la marchandise
     * @return l'etat de la marchandise
     */
    public String toString () {
        return ("la marchandise "+name+" vaut "+value);
    }
    
    /**
     * retourne la valeur TTC de la marchandise
     * @return la valeur TTC de la marchandise
     */
    public float valeurTTC () {
        return (this.value + ((this.value * 19.6f) / 100));
    }
}
