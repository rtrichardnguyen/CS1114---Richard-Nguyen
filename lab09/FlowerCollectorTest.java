import student.micro.*;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
import static org.assertj.core.api.Assertions.*;
import java.util.*;
// -------------------------------------------------------------------------
/**
 *  Class to test FlowerCollector over controlled island.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.19)
 */
public class FlowerCollectorTest
    extends TestCase
{
    //~ Fields ................................................................
    private FlowerIsland island;
    private FlowerCollector jerooTest;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlowerCollectorTest test object.
     */
    public FlowerCollectorTest()
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
        island = new FlowerIsland(5, 5);
        jerooTest = new FlowerCollector();
        island.addObject(jerooTest, 1, 1);
    }


    // ----------------------------------------------------------
    /**
     * collectFlower test on 2x2
     */
    public void testCollectFlowers() {
        jerooTest.collectFlowers();
        
        assertThat(jerooTest.getX()).isEqualTo(3);
        assertThat(jerooTest.getY()).isEqualTo(3);
        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(jerooTest.getBasket().size()).isEqualTo(5);
    }
    
    /**
     * getBasket test on 2x2
     */
    public void testGetBasket() {
        List n = jerooTest.getBasket();
        
        assertThat(n.size()).isEqualTo(0);
    }
}
