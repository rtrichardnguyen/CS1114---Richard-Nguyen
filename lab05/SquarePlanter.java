
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  Class to plant a square of flowers
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.22)
 */
public class SquarePlanter
    extends Jeroo
{
    //~ Fields ................................................................
    
    private int oneSide;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created SquarePlanter object.
     * 
     * @param flowersPerSide The amount of flowers per side
     */
    public SquarePlanter(int flowersPerSide)
    {
        super(flowersPerSide * 4);
        
        oneSide = flowersPerSide;
        
    }


    //~ Methods ...............................................................

    /**
     * plantSquare method to call plantOneSide and finishCorner
     * 4 times
     */
    public void plantSquare() {
        
        for (int i = 0; i < 4; i++) {
            
            plantOneSide();
        
            turnCorner();
        
        }
    
    }
    
    /**
     * method to plant one side of square and also subtracts used
     * flowers from total
     */
    public void plantOneSide() {
        
        int oneSideCount = getOneSide();
        
        while (oneSideCount != 0) {
            
            plant();
            hop();
            
            oneSideCount--;
            
        }
        
    }
    
    /**
     * method to turn one corner after a side
     */
    public void turnCorner() {
    
        turn(RIGHT);
        
    }
    
    /**
     * accessor method for oneSide field
     * 
     * @return number of flowers for one side
     */
    public int getOneSide() {
        
        return oneSide;
        
    }
    
}
