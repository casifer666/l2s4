
/**
 * Fish.java
 *
 */
package wator;
import grid.*;

/**
 * @author   jc
 */
public interface Fish {

    /** tells if the fish can move to the position occupied by the fish <em>f</em>
     * @param f the fish at targeted position
     * @return <em>true</em> if move is possible
     */  
    public boolean canEat(Fish f);
    /**
     * returns the current position of the fish
     * @return   the current position of the fish
     */
    public Position getPosition();
    /**
     * sets the  position of the fish
     * @param the   position of the fish
     */
    public void setPosition(Position p);
    /** returns the type of the fish
     * @return  the type of the fish
     */
    public FishType getFishType();
    /**
     * returns the duration of the period of gestation
     * @return    the duration of the period of gestation
     */
    public int getGestationPeriod();
    /**
     * sets the duration of the period of gestation
     * @param period   the period of gestation
     */
    public void setGestationPeriod(int period);
    /** decreases the time before this fish gives birth (creates) a new fish
     */
    public void decreaseTimeBeforeNextBirth();
    /** Returns true iff the gestation period is over
     * @return  true iff the gestation period is over
     */
    public boolean canGiveBirth();
    /** Gestation period is assumed to be over. This method returns the new created fish, it is created at the given position. Resets gestation. 
     * @param position the position 
     *  @return the new created fish 
     */
    public Fish createNewFish(Position position);
    /** returns <em>true</em> iff the fish is dying
     * @return  <em>true</em> iff the fish is dying
     */
    public boolean isDead();
    /** returns a char that represents the fish
     * @return the char
     */
    public char getDescriptionChar();
    /** returns a color used to display the fish
     * @return the color
     */
    public java.awt.Color getColor();
    
}// Fish
