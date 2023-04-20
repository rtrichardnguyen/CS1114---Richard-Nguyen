// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

import student.media.*;
import java.awt.Color;
//import student.util.Random;
//-------------------------------------------------------------------------
/**
 *  Program that simulates Schelling's model.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.28)
 */
public class SchellingSimulation extends Picture
{
    //~ Fields ................................................................

    private double satisfactionThreshold;
    private int redLine;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created SchellingSimulation object.
     * @param width integer for side value
     * @param height integer for side value
     */
    public SchellingSimulation(int width, int height)
    {
        super(width, height);
        
        satisfactionThreshold = 0.3;
        redLine = 0;
        
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................

    /**
     * accessor method to return satisfactionThreshold
     * @return double satisfactionThreshold
     */
    public double getSatisfactionThreshold() {
        
        //accessor method to return satisfactionThreshold
        
        return this.satisfactionThreshold;
        
    }
    
    /**
     * mutator method to set satisfactionThreshold
     * @param n double to represent percent of satisfaction 
     * tolerated
     */
    public void setSatisfactionThreshold(double n) {
        
        //mutator method to set satisfactionThreshold
        
        this.satisfactionThreshold = n;
        
    }
    
    /**
     * accessor method to return redLine
     * @return int redLine
     */
    public int getRedLine() {
        
        //accessor method to return redLine 
        
        return this.redLine;
        
    }
    
    /**
     * mutator method to set redLine
     * @param n integer that represents horizontal dividing line
     */
    public void setRedLine(int n) {
        
        //mutator method to set redLine
        
        this.redLine = n;
        
    }
    
    /**
     * method to fill the image with a taken percentage of blue
     * and orange pixels
     * @param b double to represent percentage to be painted in 
     * blue
     * @param o double to represent percentage to be painted in 
     * orange
     */
    public void populate(double b, double o) {
        
        //method to populate image with blue and orange pixels
        
        
        double chance = b + o;
        
        for (Pixel p: this.getPixels()){
            double percent = Math.random();
            
            if (percent < b) {
            
            p.setColor(Color.BLUE);
            
            } else if (percent < b + o && percent > b) {
            
            p.setColor(Color.ORANGE);
            
            } else {
            
            p.setColor(Color.WHITE);
            
            }
            
        }
        
    }
    
    /**
     * method to return if both taken pixels have same RGB values
     * @param p1 Pixel object to test color value against p2
     * @param p2 Pixel object to test color value against p1
     * @return boolean of whether both pixels are same color
     */
    public boolean areSameColor(Pixel p1, Pixel p2) {
        
        //method to compare two pixel colors and return boolean
        
        
        if (p1.getColor().equals(p2.getColor())) {
        
            return true;
        
        }
        
        return false;
    }
    
    /**
     * method to return true if pixel is empty (white)
     * @param p Pixel object to test if color is white
     * @return boolean value of whether tile is white
     */
    public boolean isEmpty(Pixel p) {
        
        //method to test if selected pixel is equal to white
        
        
        if (p.getColor().equals(Color.WHITE)) {
                
                return true;
                
        }
    
        return false;
    }
    
    /**
     * method to determind if pixel p1 is determined as Color col
     * @param p Pixel object for specified pixel
     * @param col Color object for specific color
     * @return boolean value of whether agent would be satisfied
     * at pixel location
     */
    public boolean isSatisfied(Pixel p, Color col) {
        
        //method to populate image with input percentages of 
        //blue and orange agents
        
        
        double satisfaction = 0.0;
        double satisfactionCount = 0.0;
        double occupiedPixels = 0.0;
        
        int px = p.getX();
        int py = p.getY();
        
        for (int i = 1; i < 3; i++) {
            
            for (int n = 1; n < i; n++) {
                if (this.getPixel(px - i, py - n).getColor().equals(col)) {
            
                satisfactionCount++;
            
                }
            }
        
        }
        
        if (satisfaction >= this.satisfactionThreshold) {
            
            return true;
            
        }
        
        return false;
        
    }
    
    /**
     * method to relocate Pixel p if the location is empty and the
     * pixel would be satisfied
     * @param p Pixel object to be moved
     * @return boolean if agent was moved or false if agent stayed
     * in place
     */
    public boolean maybeRelocate(Pixel p) {
        
        //method to return true if agent would be satisfied at a
        //different location
        
        return false;
    }
    
    /**
     * method to check if all agents are satisfied, if not call
     * maybeRelocate()
     * @return integer of how many successful moves were completed
     */
    public int cycleAgents() {
        
        //method to count how many movements and test maybeRelocate()
        //on all pixels
        
        int agentsMoved = 0;
        
        
        for (Pixel p: this.getPixels()) {
            
            if (!this.isSatisfied(p, p.getColor())) {
                
                if (this.maybeRelocate(p)) {
                    
                    maybeRelocate(p);
                    agentsMoved++;
                    
                }    
            }
        
        
        }
        return agentsMoved;
    }
}
