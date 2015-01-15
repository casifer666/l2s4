package naval;

/**
 * Classe qui definit une direction dans laquelle la "position voisine" est a l'est de la position donnee
 */
public class DirectionEst implements Direction {

	/**
	 * fournit la position suivante de <code>p</code> dans la direction est
	 * @return la position suivante de <code>p</code> dans la direction est
	 */
	public Position positionSuivante(Position p) {
		return (new Position(p.getX(),p.getY()+1));
	}

}