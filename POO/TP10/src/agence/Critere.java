package agence;

/**
 * Interface permettant de reprensenter un critere pour une voiture
 */
public interface Critere {

    /**
     * teste la satisfaisabilite d'une voiture au critere
     * @param v la voiture dont on teste la satisfaisabilite avec le critere
     * @return <code>true</code> si <code>v</code> satisfait le critere, <code>false</code> sinon
     */
    public boolean estSatisfaitPar(Voiture v);

}
