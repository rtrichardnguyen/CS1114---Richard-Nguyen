
import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *   Class that tests all methods in SquarePlanter class
 *   
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.22)
 */
public class SquarePlanterTest
    extends TestCase
{
    //~ Fields ................................................................

    private Island island;
    private SquarePlanter jeroo;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SquarePlanterTest test object.
     */
    public SquarePlanterTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        island = new Lab05Island();
        jeroo = new SquarePlanter(6);
        island.addObject(jeroo, 1, 1);
    }


    // ----------------------------------------------------------
    
    /**
     * method to test if jeroo plants one whole side
     */
    public void testPlantOneSide() {
        
        jeroo.plantOneSide();
        
        assertThat(jeroo.getX()).isEqualTo(7);
        assertThat(jeroo.getY()).isEqualTo(1);
        assertThat(jeroo.isFacing(EAST)).isTrue();
        
    }
    
    /**
     * method to test if a side is finished and then turns for
     * next side
     */
    public void testTurnCorner() {
        
        jeroo.turnCorner();
        
        assertThat(jeroo.getX()).isEqualTo(1);
        assertThat(jeroo.getY()).isEqualTo(1);
        assertThat(jeroo.isFacing(SOUTH)).isTrue();
        
    }
    
    /**
     * method to test if jeroo plants entire square and faces 
     * east
     */
    public void testSquarePlanter() {
        
        jeroo.plantSquare();
        
        assertThat(jeroo.getX()).isEqualTo(1);
        assertThat(jeroo.getY()).isEqualTo(1);
        assertThat(jeroo.isFacing(EAST)).isTrue();
        assertThat(island.countFlowers()).isEqualTo(24);
        
    }
    
    /**
     * method to test if jeroo plants entire square and faces 
     * east for a 10 x 10 square
     */
    public void testSquarePlanterBigger() {
        
        jeroo.remove();
        
        jeroo = new SquarePlanter(4);
        island.addObject(jeroo, 1, 1);
        
        jeroo.plantSquare();
        
        assertThat(jeroo.getX()).isEqualTo(1);
        assertThat(jeroo.getY()).isEqualTo(1);
        assertThat(jeroo.isFacing(EAST)).isTrue();
        assertThat(island.countFlowers()).isEqualTo(16);
        
    }

}
