// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  
 *  Program to clear all nets, pick all flowers, and return
 *  back to (1, 1) after navigating through the whole maze.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.18)
 */
public class MazeRunner
    extends Jeroo
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created MazeRunner object.
     */
    public MazeRunner()
    {
        super(10);
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    
    /**
     *  method to call all steps to clearing maze
     */
    public void clearMaze() {
        
        while (!seesWater(AHEAD) || !seesNet(AHEAD)) {
            
            clearPath();
            
            //break if only south path exists
            if ((this.getX() == 1 && this.getY() == 1) 
                && this.seesWater(RIGHT)) {
                    
                break;
            
            }
            
            //else if to discover east path if existing
            else if (this.getX() == 1 && this.getY() == 1 
                && !this.seesWater(RIGHT)) {
                
                clearSecondPath();
                
            }
            

                
        }
        
        
    }
            
    
    /**
     * method to explore whole path
     */
    public void clearPath() {
        
        keepRight(); 
        
        deadEnd(); 
             
        forceLeft(); 
             
        pickFlower(); 
             
        disableNet();
             
        hop();
        
    }
    
    /**
    * method to keep jeroo on path with right side of maze
    */
    public void keepRight() {
        
        //method for jeroo to stick to right side throughout maze
        
        if (!seesWater(RIGHT)) {
              
            pick();
            turn(RIGHT);
              
        }
         
    }
    
    /**
     * method to turn jeroo around in a dead end
     */
    public void deadEnd() {
        
        //method for jeroo to navigate a dead end
        
        if (seesWater(AHEAD) && seesWater(RIGHT) && seesWater(LEFT)) {
              
            turn(RIGHT);
            turn(RIGHT);
              
        }
        
    }
    
    /**
     * method to turn jeroo left when needed to
     */
    public void forceLeft() {
        
        //method for jeroo in case of a forced left turn
        
        if (seesWater(RIGHT) && seesWater(AHEAD)) {
             
            turn(LEFT);
             
        }
        
    }
    
    /**
     * method to pick flower at jeroo coordinate
     */
    public void pickFlower() {
        
        //method for jeroo to pick flower
        
        if (seesFlower(HERE)) {
           
            pick();
           
        }
         
    }
    
    /**
     * method to disable net ahead
     */
    public void disableNet() {
        
        //method for jeroo to disable net
        
        while (seesNet(AHEAD)) {
              
            toss();
           
        }
    }
    
    /**
     * method to clear a second path if there is one
     */
    public void clearSecondPath() {
        
        if (this.getX() == 1 && this.getY() == 1) {
            
            turn(RIGHT);
            hop();
            
        }
        
    }
    
}
