/**
 * Shark.java
 *   
 */
package wator;

import java.awt.Color;

import grid.*;

/**
 * @author jc
 */
/**
 * @author jc
 * 
 */
public class Shark implements Fish {

	private static final char SHARK_CHAR = 'S';

	private Position position;

	/**
	 * the duration of the gestation
	 */
	public int gestationPeriod;

	public int starvationPeriod;

	public Shark(Position p) {
		this.position = p;
	}

	/**
	 * returns true if the shark can eat and move to the position occupied by the fish <code>f</code>
	 * @param f the fish in question
	 * @return true if the shark can eat and move to the position occupied by the fish <code>f</code>
	 */
	public boolean canEat(Fish f) {
		return (f.getFishType() == FishType.Tuna);
	}

	/**
	 * returns the position occupied by the shark
	 * @return the position occupied by the shark
	 */
	public Position getPosition() {
		return this.position;
	}

	/**
	 * move the shark to the position <code>p</code>
	 * @param p the new position of the shark
	 */
	public void setPosition(Position p) {
		this.position = p;
	}

	/**
	 * returns the type of the fish
	 * @return the type of the fish
	 */
	public FishType getFishType() {
		return FishType.Shark;
	}

	/**
	 * returns the gestation period of the shark
	 * @return the gestation period of the shark
	 */
	public int getGestationPeriod() {
		return this.gestationPeriod;
	}

	/**
	 * modify the gestation period of the fish
	 * @param period the new gestation period of the shark
	 */
	public void setGestationPeriod(int period) {
		this.gestationPeriod = period;
	}

	public int getStarvationPeriod() {
		return this.starvationPeriod;
	}

	/**
	 * modify the gestation period of the fish
	 * @param period the new gestation period of the shark
	 */
	public void setStarvationPeriod(int period) {
		this.starvationPeriod = period;
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
	 * creates a new shark at the position <code>p</code>
	 * @param p the position where the shark has to be created
	 * @return the new shark
	 */
	public Fish createNewFish(Position p) {
		return new Shark(p);
	}

	/**
	 * returns <code>true</code> if the shark is dying
	 * @return true if the shark is dying
	 */
	public boolean isDead() {
		return (this.starvationPeriod == 0);
	}

	/**
	 * returns the description of the shark
	 * @return the description of the shark
	 */
	public char getDescriptionChar() {
		return SHARK_CHAR;
	}

	/**
	 * returns the color used to display the shark
	 */
	public Color getColor() {
		return Color.RED;
	}


}// Shark
