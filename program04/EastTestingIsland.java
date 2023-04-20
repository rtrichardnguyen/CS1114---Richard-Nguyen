
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
/**
 *  Testing island with east path only
 *
 *  @author Richard Nguyen(906512730)
 *  @version (2022.09.26)
 */
public class EastTestingIsland
    extends Island
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created EastTestingIsland object.
     */
    public EastTestingIsland()
    {
        super(12, 9);
        
        addObject(new Water(), 2, 1);
        addObject(new Water(), 3, 1);
        addObject(new Water(), 2, 2);
        addObject(new Water(), 3, 2);
        addObject(new Water(), 4, 2);
        addObject(new Water(), 4, 1);

        addObject(new Water(), 2, 4);
        addObject(new Water(), 3, 4);
        addObject(new Water(), 4, 4);
        addObject(new Water(), 2, 5);
        addObject(new Water(), 2, 6);
        addObject(new Water(), 3, 6);
        addObject(new Water(), 4, 6);
        addObject(new Water(), 5, 6);

        addObject(new Water(), 6, 1);
        addObject(new Water(), 6, 2);
        addObject(new Water(), 8, 1);
        addObject(new Water(), 8, 2);
        addObject(new Water(), 9, 2);

        addObject(new Water(), 6, 4);
        addObject(new Water(), 7, 4);
        addObject(new Water(), 9, 4);
        addObject(new Water(), 9, 5);

        addObject(new Water(), 6, 5);
        addObject(new Water(), 6, 6);
        addObject(new Water(), 6, 7);
        addObject(new Water(), 7, 6);
        addObject(new Water(), 9, 6);
        addObject(new Water(), 10, 6);
    }


    //~ Methods ...............................................................


}
