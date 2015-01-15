/**
 * Tuna.java
 */
package wator;

import java.awt.Color;

import grid.*;

/**
 * @author jc
 */
public class Tuna implements Fish {

	/**
	 * the description of the tuna
	 */
	private static final char TUNA_CHAR = 'T';

	/**
	 * the position of the tuna
	 */
	private Position position;

	/**
	 * the duration of the gestation
	 */
	public int gestationPeriod;

	/**
	 * the constructor for the objects of the class Tuna
	 */
	public Tuna(Position p) {
		this.position = p;
	}

	/**
	 * returns true if the tuna can eat and move to the position occupied by the fish <code>f</code>
	 * @param f the fish in question
	 * @return true if the tuna can eat and move to the position occupied by the fish <code>f</code>
	 */
	public boolean canEat(Fish f) {
		return false;
	}

	/**
	 * returns the position occupied by the tuna
	 * @return the position occupied by the tuna
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * move the tuna to the position <code>p</code>
	 * @param p the new position of the tuna
	 */
	public void setPosition(Position p) {
		this.position = p;
	}

	/**
	 * returns the type of the fish
	 * @return the type of the fish
	 */
	public FishType getFishType() {
		return FishType.Tuna;
	}

	/**
	 * returns the gestation period of the tuna
	 * @return the gestation period of the tuna
	 */
	public int getGestationPeriod() {
		return this.gestationPeriod;
	}

	/**
	 * modify the gestation period of the fish
	 * @param period the new gestation period of the tuna
	 */
	public void setGestationPeriod(int period) {
		this.gestationPeriod = period;
	}

	/**
	 * decrease the time before next birth
	 */
	public void decreaseTimeBeforeNextBirth() {
		this.gestationPeriod--;
	}

	/**
	 * returns <code>true</code> if the gestation period is over
	 * @return <code>true</code> if the gestation period is over
	 */
	public boolean canGiveBirth() {
		return (this.gestationPeriod == 0);
	}

	/**
	 * creates a new tuna at the position <code>p</code>
	 * @param p the position where the tuna has to be created
	 * @return the new tuna
	 */
	public Fish createNewFish(Position p) {
		return new Tuna(p);
	}

	/**
	 * returns <code>true</code> if the tuna is dying
	 * @return true if the tuna is dying
	 */
	public boolean isDead() {
		return false;
	}

	/**
	 * returns the description of the tuna
	 * @return the description of the tuna
	 */
	public char getDescriptionChar() {
		return TUNA_CHAR;
	}

	/**
	 * returns the color used to display the tuna
	 */
	public Color getColor() {
		return Color.BLUE;
	}

}// Tuna
