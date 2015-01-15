package naval;

/**
 * Classe qui definit une direction dans laquelle la "position voisine" est au nord de la position donnee
 */
public class DirectionNord implements Direction {

	/**
	 * fournit la position suivante de <code>p</code> dans la direction nord
	 * @return la position suivante de <code>p</code> dans la direction nord
	 */
	public Position positionSuivante(Position p) {
		return (new Position(p.getX()-1,p.getY()));
	}

}
