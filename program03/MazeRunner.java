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
        
        //method to pick, orientate, and call method for movement
        
        /*
         
        while (!seesWater(AHEAD) || !seesFlower(AHEAD)
            || !seesNet(AHEAD)) {
                
            keepRight(); //keeps jeroo on right side of maze
             
            deadEnd(); //turns around in a dead end
             
            forceLeft(); //turns left if necessary
             
            pickFlower(); //picks flower at coordinate of jeroo
             
            disableNet(); //disables net ahead
             
            hop();
             
        }
        */
          
    }
    
        /**
         * method to keep jeroo on path with right side of maze
         */
    public void keepRight() {
        
        //method for jeroo to stick to right side throughout maze
        
        /*
        if (!seesWater(RIGHT)) {
              
            pick();
            turn(RIGHT);
              
        }
        */
         
        
    }
    
    /**
     * method to turn jeroo around in a dead end
     */
    public void deadEnd() {
        
        //method for jeroo to navigate a dead end
        
        /*
        if (seesWater(AHEAD) && seesWater(RIGHT)
            && seesWater(LEFT)) {
              
            turn(RIGHT);
            turn(RIGHT);
              
        }
        */
         
        
    }
    
    /**
     * method to turn jeroo left when needed to
     */
    public void forceLeft() {
        
        //method for jeroo in case of a forced left turn
        
        /*
        if (seesWater(RIGHT) && seesWater(AHEAD) &&
            !seesWater(LEFT)) {
             
            turn(LEFT);
             
        }
        */
        
    }
    
    /**
     * method to pick flower at jeroo coordinate
     */
    public void pickFlower() {
        
        //method for jeroo to pick flower
        
        /*
        if (seesFlower(HERE)) {
           
            pick();
           
        }
        */
         
    }
    
    /**
     * method to disable net ahead
     */
    public void disableNet() {
        
        //method for jeroo to disable net
        
        /*
        while (seesNet(AHEAD)) {
              
            toss();
           
        }
        */
    }
    
}
