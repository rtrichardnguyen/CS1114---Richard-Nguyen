
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 * SkippingHarvester subclass of harvester to harvest second row of plants;
 * demonstrates subclass of harvester.
 * 
 *  @author Richard Nguyen (906512730)
 *  @version (2022.08.31)
 */
public class SkippingHarvester
    extends Harvester
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created SkippingHarvester object.
     */
    public SkippingHarvester()
    {
        super();
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................

    /**
     * uses inherited hopAndPick() and adds hop
     */
    public void hop2AndPick() { 
        
        hopAndPick();
        hop();
        
    }

}
