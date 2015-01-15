package naval;

/**
 * Classe qui definit une direction dans laquelle la "position voisine" est a l'ouest de la position donnee
 */
public class DirectionOuest implements Direction {

	/**
	 * fournit la position suivante de <code>p</code> dans la direction ouest
	 * @return la position suivante de <code>p</code> dans la direction ouest
	 */
	public Position positionSuivante(Position p) {
		return (new Position(p.getX(),p.getY()-1));
	}

}