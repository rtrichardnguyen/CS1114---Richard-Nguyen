// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  A Jeroo that walks every cell in on an island and uses delegation
 *  to instruct a second jeroo to follow its motions and plant a flower
 *  anywhere it finds one.
 *
 *  @author Richard Nguyen (906512730)
 *  @version 2022.10.09
 */
public class CopyingJeroo
    extends Jeroo
{
    //~ Fields ................................................................

    private Jeroo copier;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created CopyingJeroo object.
     * @param j jeroo object for second jeroo
     */
    public CopyingJeroo(Jeroo j)
    {
        super();
        copier = new Jeroo(1000);
        copier = j;
        
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Walk a pattern over every grid location on the current island.
     */
    public void walkIsland()
    {
        for (int i = 0; i < 3; i++) {
         
            hopToWater();
            turnRightAround();
            hopToWater();
            turnLeftAround();
            
        }
        
        fullRow2();
        
    }


    // ----------------------------------------------------------
    /**
     * Hop forward until we reach the water.
     */
    public void hopToWater()
    {
        while (!this.seesWater(AHEAD))
        {
            copyPattern(copier);
            this.hop(copier);
        }
        
        copyPattern(copier);
    }
    
    /**
     * Move one block down and ready to traverse another row (Right turn)
     */
    public void turnRightAround() {
        
        turn(RIGHT, copier);
        hop(copier);
        turn(RIGHT, copier);
        
    }
    
    /**
     * Move one block down and ready to traverse another row (Left turn)
     */
    public void turnLeftAround() {
        
        turn(LEFT, copier);
        hop(copier);
        turn(LEFT, copier);
        
    }
    
    /**
     * Traverse two complete rows
     */
    public void fullRow2() {
        hopToWater();
        turnRightAround();
        hopToWater();
    }
    
    /**
     * Overridden hop method to delegate jeroo
     * @param j jeroo for second jeroo to hop
     */
    public void hop(Jeroo j) {
        super.hop();
        j.hop();
    }
    
    /**
     * Overridden turn method to delegate jeroo
     * @param point for direction to be turned to
     * @param j jeroo for second jeroo to turn
     */
    public void turn(RelativeDirection point, Jeroo j) {
        super.turn(point);
        j.turn(point);
    }
    
    /**
     * Copy flower pattern onto second island
     * @param j second jeroo to plant when first jeroo sees flower
     */
    public void copyPattern(Jeroo j) {
        
        if (this.seesFlower(HERE)) {
            
            j.plant();
            
        }
        
    }
    
}
