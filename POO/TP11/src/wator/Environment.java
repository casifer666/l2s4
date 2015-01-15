/**
 * Environment.java
 *
 */
package wator;

import java.awt.Color;

import grid.*;

import java.util.Random;

/**
 * @author jc
 */
public class Environment implements Grid {

    private int width;
    private int height;
    private GridDisplayer gridDisplayer;
    private Fish[][] fishes;

    public Environment(int width,int height,int pt,int ps,int tgp,int sgp,int ssp) {
        this.width = width;
        this.height = height;
        this.gridDisplayer = new GraphicalGridDisplayer(width,height);
        this.fishes = new Fish[width][height];
        Random rand = new Random();
        int maxFishes = height * width;
        int tunasNumber = (maxFishes * pt) / 100;
        int sharksNumber = (maxFishes * ps) / 100;
        for (int i = 0 ; i < tunasNumber ; i++) {
            int randomHeight = rand.nextInt(height);
            int randomWidth = rand.nextInt(width);
            Position randomPosition = new Position(randomWidth,randomHeight);
            Tuna aTuna = new Tuna(randomPosition);
            this.fishes[randomWidth][randomHeight] = aTuna;
            aTuna.setGestationPeriod(tgp);
        }
        for (int j = 0 ; j < sharksNumber ; j++) {
            int randomHeight = rand.nextInt(height);
            int randomWidth = rand.nextInt(width);
            Position randomPosition = new Position(randomWidth,randomHeight);
            Shark aShark = new Shark(randomPosition);
            this.fishes[randomWidth][randomHeight] = aShark;
            aShark.setGestationPeriod(sgp);
            aShark.starvationPeriod = ssp;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public java.awt.Color getColorAtPosition(Position p) {
        int x = p.getX();
        int y = p.getY();
        if (this.fishes[x][y] == null)
            return java.awt.Color.WHITE;
        else
            return fishes[x][y].getColor();
    }

    /**
     * sets the grid displayer
     * 
     * @param displayer
     *            the grid displayer
     */
    public void setGridDisplayer(GridDisplayer displayer) {
        this.gridDisplayer = displayer;
    }


    /**
     * displays the environment using a GridDisplayer
     * 
     * @param msg
     *            the msg given to the displayer
     */
    public void display(String msg) {
        this.gridDisplayer.display(this, msg);
    }

    /**
     * fish at position (i,j) acts
     * 
     * @param i
     * @param j
     */
    public void actAt(int i, int j) {
        Fish fish = this.fishes[i][j];
        if (fish != null) {
            Position current = fish.getPosition();
            Position targetPosition = current.randomNeighbour(width, height);
            Fish targetFish = this.fishes[targetPosition.getX()][targetPosition.getY()]; 
            if (targetFish == null || fish.canEat(targetFish)) {
                fish.setPosition(targetPosition);
                this.fishes[targetPosition.getX()][targetPosition.getY()] = fish;
                this.fishes[i][j] = null;
                if (fish.canGiveBirth()) {
                    this.fishes[i][j] = fish.createNewFish(current);
                } 
            }
	    fish.decreaseTimeBeforeNextBirth();                    
            if (fish.isDead()) {
                this.fishes[fish.getPosition().getX()][fish.getPosition().getY()] = null;
            }
        } // else nothing happens
    }

 

    /**
     * returns the char to be displaid in the box at position<em>p</em>
     * 
     * @param p
     *            the position
     * @return the char to be displaid
     */
    public char getCharAtPosition(Position p) {
        Fish f = fishes[p.getX()][p.getY()];
        if (f != null) {
            return fishes[p.getX()][p.getY()].getDescriptionChar();
        } else {
            return ' ';
        }
    }
    // end of Grid interface

}// Environment
