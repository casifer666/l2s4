package naval;

/**
 * Interface permettant d'indiquer la direction a suivre pour poser un bateau sur une case de la mer
 */
public interface Direction {

    /**
     * fournit la position suivante de p dans cette direction
     * @return la position suivante de p dans cette direction
     */
	public Position positionSuivante(Position p);

}
