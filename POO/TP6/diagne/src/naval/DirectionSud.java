package naval;

/**
 * Classe qui definit une direction dans laquelle la "position voisine" est au sud de la position donnee
 */
public class DirectionSud implements Direction {

	/**
	 * fournit la position suivante de <code>p</code> dans la direction sud
	 * @return la position suivante de <code>p</code> dans la direction sud
	 */
	public Position positionSuivante(Position p) {
		return (new Position(p.getX()+1,p.getY()));
	}

}