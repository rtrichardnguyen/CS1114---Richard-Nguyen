import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  This program instantiates NetRemover watson and calls
 *  pickFlowersAndDisableNets();.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.06)
 */
public class NetIsland
    extends NetIslandBase
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created NetIsland object.
     */
    public NetIsland()
    {
        super();
    }
    
    /**
     * myProgram() method that creates watson NetRemover and calls
     * pickFlowersAndDisableNets()
     */
    public void myProgram() {
        
        NetRemover watson = new NetRemover();
        this.addObject(watson, 3, 1);
        watson.pickFlowersAndDisableNets();
        
    }
}
