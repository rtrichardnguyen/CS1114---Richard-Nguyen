
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 * Harvester subclass of Jeroo that creates a jeroo to harvest plants; 
 * superclass of subsequent harvester subclasses.
 * 
 *  @author Richard Nguyen (906512730)
 *  @version (2022.08.31)
 */
public class Harvester
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Harvester object.
     */
    public Harvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................

    /**
     * hop and pick calls to simplify hop2AndPick()
     */
    public void hopAndPick() { 
            
        hop();
        pick();
        
    }
    
    /**
     * hopAndPick method used twice to build
     */
    public void hop2AndPick() { 
            
        hopAndPick();
        hopAndPick();
        
    }
    
    /**
     * harvestRow to be used in myProgram()
     */
    public void harvestRow() { 
        
        hop2AndPick();
        hop2AndPick();
        hop2AndPick();
        
    }
    
    
}
