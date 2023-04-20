// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.media.*;
import student.*;
import java.awt.Color;
import student.util.Random;
//-------------------------------------------------------------------------
/**
 *  Program that simulates Schelling's model.
 *
 *  @author Richard Nguyen (richardn03)
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
        
        return this.satisfactionThreshold;
        
    }
    
    /**
     * mutator method to set satisfactionThreshold
     * @param n double to represent percent of satisfaction 
     * tolerated
     */
    public void setSatisfactionThreshold(double n) {
        
        this.satisfactionThreshold = n;
        
    }
    
    /**
     * accessor method to return redLine
     * @return int redLine
     */
    public int getRedLine() {
        
        return this.redLine;
        
    }
    
    /**
     * mutator method to set redLine
     * @param n integer that represents horizontal dividing line
     */
    public void setRedLine(int n) {
        
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
        
        double chance = b + o;
        
        for (Pixel p: this.getPixels()) {
            double percent = Math.random();
            
            if (percent < b) {
            
                p.setColor(Color.BLUE);
            
            } 
            else if (percent <= chance && percent > b
                && p.getY() >= this.getRedLine()) {
            
                p.setColor(Color.ORANGE);
            
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
        
        return p1.getColor().equals(p2.getColor());
        
    }
    
    /**
     * method to return true if pixel is empty (white)
     * @param p Pixel object to test if color is white
     * @return boolean value of whether tile is white
     */
    public boolean isEmpty(Pixel p) {
        
        return p.getColor().equals(Color.WHITE); 
                
    }
    
    /**
     * method to determine if pixel p1 is satisfied as Color col
     * @param p Pixel object for specified pixel
     * @param col Color object for specific color
     * @return boolean value of whether agent would be satisfied
     * at pixel location
     */
    public boolean isSatisfied(Pixel p, Color col) {
        
        double satisfaction = 0.0;
        double sameCount = 0.0;
        double totalCount = 0.0;
        
        for (Pixel neighbor : p.getNeighborPixels()) {
            
            if (!isEmpty(neighbor)) {
                totalCount++;
            }
            if (neighbor.getColor().equals(col)) {
                sameCount++;
            }
            
        }
        
        satisfaction = sameCount / totalCount;
        
        if (totalCount == 0) {
            return true;
        } 
        else {
            return satisfaction >= this.getSatisfactionThreshold();
        }

    }
    
    /**
     * method to relocate Pixel p if the location is empty and the
     * pixel would be satisfied
     * @param p Pixel object to be moved
     * @return boolean if agent was moved or false if agent stayed
     * in place
     */
    public boolean maybeRelocate(Pixel p) {
        
        Random random = new Random();
        int x = 0;
        int y = 0;
        
        if (p.getColor().equals(Color.ORANGE)) {
            
            y = random.nextInt(this.getHeight() - getRedLine())
                + getRedLine();
            x = random.nextInt(this.getWidth());
            
        } 
        else if (p.getColor().equals(Color.BLUE)) {
            
            y = random.nextInt(this.getHeight());
            x = random.nextInt(this.getWidth());
            
        }
        
        if (isSatisfied(this.getPixel(x, y), p.getColor())
            && this.getPixel(x, y).getColor().equals(Color.WHITE)) {
            
            this.getPixel(x, y).setColor(p.getColor());
            p.setColor(Color.WHITE);
            
            return true;
            
        }
        
        return false;
    }
    
    /**
     * method to check if all agents are satisfied, if not call
     * maybeRelocate()
     * @return integer of how many successful moves were completed
     */
    public int cycleAgents() {
        
        int agentsMoved = 0;
        
        for (Pixel p: this.getPixels()) {
            if (!this.isSatisfied(p, p.getColor()) 
                && this.maybeRelocate(p)) {
                
                this.maybeRelocate(p);
                agentsMoved++;
                       
            }
        }
        return agentsMoved;
    }
}
