// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)

import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Test class that tests all accessors and mutators in Unit class
 *  using 5 new objects.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.17)
 */
public class UnitTest
    extends TestCase
{
    //~ Fields ................................................................
    private Unit lancelot;
    private EnhancedUnit gawain;
    private Hero geraint;
    private Monster percival;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new UnitTest test object.
     */
    public UnitTest()
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
        lancelot = new Unit("Lancelot", 5);
        gawain = new EnhancedUnit("Gawain", 5);
        geraint = new Hero("Geraint", 5);
        percival = new Monster("Percival", 5);
    }


    // ----------------------------------------------------------
    /**
     * Method to test setName with new name for lancelot
     */
    public void testSetName() {
        
        lancelot.setName("arthur");
        
        assertThat(lancelot.getName()).isEqualTo("arthur");
        
    }
    
    /**
     * Method to test getName with lancelot object
     */
    public void testGetName() {
        
        String str = lancelot.getName();
        
        assertThat(str).isEqualTo("Lancelot");
        
    }
    
    /**
     * Method to test setPoints() with new 10 integer
     */
    public void testSetPoints() {
        
        gawain.setPoints(10);
        
        assertThat(gawain.getPoints()).isEqualTo(10);
        
    }
    
    /**
     * Method to test getPoints() with gawain object
     */
    public void testGetPoints() {
        
        int n = gawain.getPoints();
        
        assertThat(n).isEqualTo(5);
        
    }
    
    /**
     * Method to test setQuality() with new 10 integer
     */
    public void testSetQuality() {
        
        geraint.setQuality(10);
        
        assertThat(geraint.getQuality()).isEqualTo(10);
        
    }
    
    /**
     * Method to test getQuality() with geraint object
     */
    public void testGetQuality() {
        
        int n = geraint.getQuality();
        
        assertThat(n).isEqualTo(5);
        
    }
    
    /**
     * Method to test setDefense() with new 10 integer
     */
    public void testSetDefense() {
        
        percival.setQuality(10);
        
        assertThat(percival.getQuality()).isEqualTo(10);
        
    }
    
    /**
     * Method to test getDefense with percival object
     */
    public void testGetDefense() {
        
        int n = percival.getQuality();
        
        assertThat(n).isEqualTo(4);
        
    }

}
