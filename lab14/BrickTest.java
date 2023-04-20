// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.TestCase;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class for Brick
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.29)
 */
public class BrickTest
    extends TestCase
{
    //~ Fields ................................................................

    private Brick brick;
    private Brick brick1;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BrickTest test object.
     */
    public BrickTest()
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
        brick = new Brick(5, 5, 5);
        brick1 = new Brick(3, 4, 5);
    }


    // ----------------------------------------------------------
    /**
     * Test the basic accessors on a brand new Brick.
     */
    public void testBrickConstructor()
    {
        double volume = brick.getVolume();
        double height = brick.getHeight();
        double weight = brick.getWeight();
        double sa = brick.getSurfaceArea();
        
        assertThat(volume).isEqualTo(125);
        assertThat(height).isEqualTo(5, within(0.1));
        assertThat(weight).isEqualTo((double)250 / 1000, within(0.1));
        assertThat(sa).isEqualTo(150, within(0.1));
    }
    
    /**
     * Test the basic accessors on a brand new Brick.
     */
    public void testBrickConstructor1()
    {
        double volume = brick1.getVolume();
        double height = brick1.getHeight();
        double weight = brick1.getWeight();
        double sa = brick1.getSurfaceArea();
        
        assertThat(volume).isEqualTo(60);
        assertThat(height).isEqualTo(3, within(0.1));
        assertThat(weight).isEqualTo((double)120 / 1000, within(0.1));
        assertThat(sa).isEqualTo(94, within(0.1));
    }

}
