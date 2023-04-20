
import student.micro.jeroo.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

//-------------------------------------------------------------------------
/**
 * This program creates Scavenger Jeroo Watney and calls
 * method stub collectFlowers for later completion of LongIsland.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.05)
 */
public class ScavengerHunt
    extends LongIsland
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created ScavengerHunt object.
     */
    public ScavengerHunt()
    {
        super();
    }


    //~ Methods ...............................................................

    /**
     * myProgram method that instantiates watney and calls
     * collectFlower();
     */
    public void myProgram() {
        
        Scavenger watney = new Scavenger();
        this.addObject(watney, 1, 2);
        watney.collectFlowers();
        
    }
}
