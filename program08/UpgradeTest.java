// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)

import student.micro.*;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Test class that tests all Upgrade methods and constructor
 *  with new sword object.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.17)
 */
public class UpgradeTest
    extends TestCase
{
    //~ Fields ................................................................
    private Upgrade sword;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new UpgradeTest test object.
     */
    public UpgradeTest()
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
        sword = new Upgrade("Sword", 5);
    }


    // ----------------------------------------------------------
    /**
     * Method to test getName with object sword
     */
    public void testGetName() {
        
        String str = sword.getName();
        
        assertThat(str).isEqualTo("Sword");
        
    }
    
    /**
     * Method to test setName with new name string
     */
    public void testSetName() {
        
        sword.setName("Spear");
        
        assertThat(sword.getName()).isEqualTo("Spear");
        
    }
    
    /**
     * Method to test getPoints with object sword
     */
    public void testGetPoints() {
        
        int n = sword.getPoints();
        
        assertThat(n).isEqualTo(5);
        
    }
    
    /**
     * Method to test setPoints with new integer n
     */
    public void testSetPoints() {
        
        sword.setPoints(6);
        
        assertThat(sword.getPoints()).isEqualTo(6);
        
    }
    
    /**
     * Method to test toString() with field sword
     */
    public void testToString() {
        
        String str = sword.toString();
        
        assertThat(str).isEqualTo("Sword (5)");
        
    }

}
