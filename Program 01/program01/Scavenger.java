
import student.micro.jeroo.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

//-------------------------------------------------------------------------
/**
 * 
 * Program that maps out the methods to complete LongIsland.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.05)
 */
public class Scavenger
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Scavenger object.
     */
    public Scavenger()
    {
        super();
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................

    /**
     * complete method that calls each step
     */
    public void collectFlowers() {
        
    //Round immediate barrier of nets
        roundNet();
    
    //Collect North Shore Flowers ending at (13, 1)
        collectNorthFlowers();
    
    //Navigate down to the South Shore Flowers at (14, 9)
        migrateSouth();
    
    //Collect 3 South Shore Flowers from right to left
        collectSouthFlowers();
    
    //Go around corner and collect final flower (corner method)
        waterBarrier();
    
    //Navigate to center flower
        pickCenterFlower();
        
    }
    
    /**
     * first step that crosses immediate barrier of nets 
     */
    public void roundNet() {
        
        //Round immediate barrier of nets
        
        /*
         *  hop();
         *  hop();
         *  turn(RIGHT);
         *  hop();
         *  hop();
         *  turn(LEFT);
         *  hop();
         *  hop();
         *  turn(LEFT);
         *  hop();
         *  hop();
         *  hop();
         *  turn(RIGHT);
         */
        
    }
    
    /**
     * second method that collects all North Shore Flowers
     */
    public void collectNorthFlowers() {
        
        //Collect North Shore Flowers ending at (13, 1)
        
        /*
         * pick();
         * hop();
         * hop();
         * hop();
         * pick();
         * hop();
         * hop();
         * hop();
         * hop();
         * pick();
         * turn(RIGHT);
         */
    }
    
    /**
     * third step that navigates jeroo to south row of flowers
     */
    public void migrateSouth() {
        
        //Navigate to South Shore Flower row
        
        /*
         * hop();
         * turn(LEFT);
         * hop();
         * turn(RIGHT);
         * hop();
         * hop();
         * hop();
         * hop();
         * hop();
         * hop();
         * hop();
         * turn(RIGHT);
         */
    }
    
    /**
     * fourth step to collect all South Shore Flowers except for the last
     */
    public void collectSouthFlowers() {
        
        //collect first three south shore flowers
        
        /*
         * pick();
         * hop();
         * hop();
         * pick();
         * hop();
         * hop();
         * hop();
         * pick();
         */
    }
    
    /**
     * fifth step to collect final South Shore Flower
     */
    public void waterBarrier() {
        
        //round water barrier
        
        /*
         * turn(RIGHT);
         * hop();
         * turn(LEFT);
         * hop();
         * hop();
         * turn(LEFT);
         * hop();
         * pick();
         * turn(RIGHT);
         * turn(RIGHT);
         */
    }
    
    /**
     * final step to navigate to and pick center flower
     */
    public void pickCenterFlower() {
        
        //Navigate to Center Flower and pick
        
        /*
         * hop();
         * hop();
         * hop();
         * hop();
         * hop();
         * hop();
         * turn(RIGHT);
         * hop();
         * hop();
         * hop();
         * turn(RIGHT);
         * hop();
         * hop();
         */
    }
    
}
