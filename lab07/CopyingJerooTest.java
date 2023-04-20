// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class to test all copyingJeroo class methods.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.10.09)
 */
public class CopyingJerooTest
    extends TestCase
{
    //~ Fields ................................................................

    private Island island;
    private CopyingJeroo jeroo;
    private Jeroo copier;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CopyingJerooTest test object.
     */
    public CopyingJerooTest()
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
        island = new DualIsland();
        copier = new Jeroo(1000);
        island.addObject(copier, 10, 1);
        jeroo = new CopyingJeroo(copier);
        island.addObject(jeroo, 1, 1);
    }


    // ----------------------------------------------------------
    /**
     * Method to test the entire walkIsland with copied flowers
     */
    public void testWalkIsland() {
        jeroo.walkIsland();
        assertThat(copier.getX()).isEqualTo(10);
        assertThat(jeroo.getY()).isEqualTo(8);
        assertThat(copier.getX()).isEqualTo(10);
        assertThat(jeroo.getY()).isEqualTo(8);
        assertThat(copier.getFlowers()).isEqualTo(985);
    }
    
    /**
     * Check hopToWater(), assuming that setUp() places the
     * jeroo at (1, 1) facing east.
     */
    public void testHopToWater()
    {
        jeroo.hopToWater();
        assertThat(jeroo.getX()).isEqualTo(8);
        assertThat(jeroo.seesWater(AHEAD)).isTrue();
        
        assertThat(copier.getX()).isEqualTo(17);
        assertThat(copier.seesWater(AHEAD)).isTrue();
    }
    
    /**
     * Method to test if jeroo turns from east to west and moves
     * one block down
     */
    public void testTurnRightAround() {
        jeroo.turnRightAround();
        assertThat(jeroo.getY()).isEqualTo(2);
        assertThat(jeroo.isFacing(WEST)).isTrue();
        
        assertThat(copier.getY()).isEqualTo(2);
        assertThat(copier.isFacing(WEST)).isTrue();
    }
    
    /**
     * Method to test if jeroo turns from west to east and moves
     * one block down
     */
    public void testTurnLeftAround() {
        jeroo.turn(LEFT);
        jeroo.turn(LEFT);
        copier.turn(LEFT);
        copier.turn(LEFT);
        
        jeroo.turnLeftAround();
        assertThat(jeroo.getY()).isEqualTo(2);
        assertThat(jeroo.isFacing(EAST)).isTrue();
        
        assertThat(copier.getY()).isEqualTo(2);
        assertThat(copier.isFacing(EAST)).isTrue();
    }
    
    /**
     * Method to test if jeroo traverses two full rows
     */
    public void testFullRow2() {
        jeroo.fullRow2();
        
        assertThat(jeroo.getY()).isEqualTo(2);
        assertThat(jeroo.isFacing(WEST)).isTrue();
        
        assertThat(copier.getY()).isEqualTo(2);
        assertThat(copier.isFacing(WEST)).isTrue();
    }
    
    /**
     * Method to test overridden hop
     */
    public void testHop() {
        jeroo.hop(copier);
        assertThat(jeroo.getX()).isEqualTo(2);
        assertThat(copier.getX()).isEqualTo(11);
    }
    
    /**
     * Method to test overridden turn
     */
    public void testTurn() {
        jeroo.turn(RIGHT, copier);
        assertThat(jeroo.isFacing(SOUTH)).isTrue();
        assertThat(copier.isFacing(SOUTH)).isTrue();
    }
    
    /**
     * Method to test if flower pattern was copied
     */
    public void testCopyPattern() {
        island.addObject(new Flower(), 1, 1);
        jeroo.copyPattern(copier);
        assertThat(jeroo.seesFlower(HERE)).isTrue();
        assertThat(copier.seesFlower(HERE)).isTrue();
    }
}
