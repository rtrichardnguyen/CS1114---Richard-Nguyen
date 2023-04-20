
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 * This class holds all methods necessary to pick all flowers
 * and disable all nets.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.06)
 */
public class NetRemover
    extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created NetRemover object.
     */
    public NetRemover()
    {
        super();
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    
    /**
     * method to call all flower picking and net disabling
     * methods.
     */
    public void pickFlowersAndDisableNets() {
        
        //to pick all flowers and disable all nets
        turn(RIGHT);
        pickFlowers();
        returnToStart();
        goToNets();
        disableNets();
        
    }
    
    /**
     * method to pick all flowers ahead of jeroo
     */
    public void pickFlowers() {
        
        
        while (this.seesFlower(AHEAD)) {
            this.hop();
            this.pick();
            
        }
        
        
    }
    
    /**
     * method to return to starting position
     */
    public void returnToStart() {
        
        turn(RIGHT);
        turn(RIGHT);
        
        while (!this.seesWater(AHEAD)) {
            hop();
        }
        
        turn(RIGHT);
        
    }
    
    /**
     * method to navigate to first net
     */
    public void goToNets() {
        
        while (!this.seesNet(AHEAD)) {
            hop();
        }
        
    }
    
    /**
     * method to disable all nets
     */
    public void disableNets() {
        
        toss();
        hop();
        turn(RIGHT);
        
        while (this.seesNet(AHEAD)) {
            toss();
            hop();
            
            if (!this.hasFlower()) {
                break;
            }
            
        }
        
    }
    
}
