
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  PlantingHarvester class that extends harvester and gives planting methods;
 *  a demonstration of sub-class of harvester and plants row.
 *  @author Richard Nguyen (906512730)
 *  @version (2022.08.31)
 */
public class PlantingHarvester
    extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created PlantingHarvester object.
     */
    public PlantingHarvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................


    /**
     * hop2AndPick method for PlantingHarvester
     */
    public void hop2AndPick() { 
            
        hopAndPick();
        hop();
        plant();
        
    }
    
    /**
     * plantRow method to be called in myProgram()
     */
    public void plantRow() { 
            
        hop2AndPick();
        hop2AndPick();
        hop2AndPick();
        
    }
    
}
