import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  Lab 02 solution to solve lab problem; creates and adds three jeroos;
 *  also calls polymorphic methods.
 *  
 *  @author Richard Nguyen (906512730)
 *  @version (2022.08.31)
 */
public class Lab02Solution
    extends PlantationIsland
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Lab02Solution object.
     */
    public Lab02Solution()
    {
        super();
    }


    //~ Methods ...............................................................

    /**
     * myProgram method to add 3 jeroos and call main actions
     */
    public void myProgram() {
        
        Harvester george = new Harvester(); //first Harvester Jeroo
        this.addObject(george, 2, 3);
        
        george.harvestRow();
        
        SkippingHarvester taylor = new SkippingHarvester(); //harvester 2
        this.addObject(taylor, 2, 5);
        
        taylor.harvestRow();
        
        PlantingHarvester michael = new PlantingHarvester(); //harvester 3
        this.addObject(michael, 2, 7);
        
        michael.plantRow();
        
    }

}
