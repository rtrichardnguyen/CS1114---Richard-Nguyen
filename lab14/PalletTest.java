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
 *  Test class for pallet.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.29)
 */
public class PalletTest
    extends TestCase
{
    //~ Fields ................................................................

    private Pallet pallet;
    private Pallet pallet1;
    private Pallet pallet2;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PalletTest test object.
     */
    public PalletTest()
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
        pallet = new Pallet(5, 5);
        pallet1 = new Pallet(3, 8);
        pallet2 = new Pallet(0, 0);
    }


    // ----------------------------------------------------------
    /**
     * Test the basic accessors on a brand new Pallet.
     */
    public void testPalletConstructor()
    {
        double weight = pallet.getWeight();
        double height = pallet.getHeight();
        
        assertThat(weight).isEqualTo(102.5, within(0.1));
        assertThat(height).isEqualTo(55, within(0.1));
    }
    
    /**
     * Test the basic accessors on a brand new Pallet.
     */
    public void testPalletConstructor1()
    {
        double weight = pallet1.getWeight();
        double height = pallet1.getHeight();
        
        assertThat(weight).isEqualTo(98.66, within(0.1));
        assertThat(height).isEqualTo(79, within(0.1));
    }

    /**
     * Test the basic accessors on a brand new Pallet.
     */
    public void testPalletConstructor2()
    {
        double weight = pallet2.getWeight();
        double height = pallet2.getHeight();
        
        assertThat(weight).isEqualTo(6.5, within(0.1));
        assertThat(height).isEqualTo(15.0, within(0.1));
    }
}
