import student.micro.*;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Method to test all methods in PostMonitor class.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.27)
 */
public class PostMonitorTest
    extends TestCase
{
    //~ Fields ................................................................

    private PostMonitor test;
    private Post ptest;
    private Post ptest1;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PostMonitorTest test object.
     */
    public PostMonitorTest()
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
        test = new PostMonitor();
        ptest = new Post("name", "message", 3, 20);
        ptest1 = new Post("nam", "message", 4, 20);
        
    }


    // ----------------------------------------------------------
    /**
     * Method to test PostMonitor constructor
     */
    public void testPostMonitor() {
        int[] emptyHours = new int[24];
        int[] emptyDays = new int[7];
        
        assertThat(test.getPostCount()).isEqualTo(0);
        assertThat(test.getHourCounts()).isEqualTo(emptyHours);
        assertThat(test.getDayCounts()).isEqualTo(emptyDays);
    }
    
    /**
     * Method to test recordPost with two first post object
     * and two int arrays
     */
    public void testRecordPost() {
        test.recordPost(ptest);
        int[] emptyHours = new int[24];
        int[] emptyDays = new int[7];
        emptyHours[20] = 1;
        emptyDays[3] = 1;
        
        assertThat(test.getHourCounts()).isEqualTo(emptyHours);
        assertThat(test.getDayCounts()).isEqualTo(emptyDays);
    }
    
    /**
     * Method to test getIndexOfLargest with new int array
     */
    public void testGetIndexOfLargest() {
        int[] arrTest = new int[50];
        arrTest[0] = 1;
        arrTest[24] = 8;
        arrTest[49] = 2;
        
        int index = test.getIndexOfLargest(arrTest);
        
        assertThat(index).isEqualTo(24);
    }
    
    /**
     * Method to test getBusiestHour with both post objects
     */
    public void testGetBusiestHour() {
        test.recordPost(ptest);
        test.recordPost(ptest1);
        
        int index = test.getBusiestHour();
        
        assertThat(index).isEqualTo(20);
    }
    
    /**
     * Method to test getBusiestDay with both post objects
     */
    public void testGetBusiestDay() {
        test.recordPost(ptest);
        test.recordPost(ptest1);
        
        int index = test.getBusiestDay();
        
        assertThat(index).isEqualTo(3);
    }
    
    /**
     * Method to testGetIndexOfSmallest with new int array
     */
    public void testGetIndexOfSmallest() {
        int[] arrTest = new int[50];
        arrTest[0] = 9;
        arrTest[24] = 8;
        arrTest[49] = 2;
        
        int index = test.getIndexOfSmallest(arrTest);
        
        assertThat(index).isEqualTo(1);
    }
    
    /**
     * Method to test getSlowestHour with both post objects
     */
    public void testGetSlowestHour() {
        test.recordPost(ptest);
        test.recordPost(ptest1);
        
        int index = test.getSlowestDay();
        
        assertThat(index).isEqualTo(0);
    }
    
    /**
     * Method to test getSlowestDay with both post objects
     */
    public void testGetSlowestDay() {
        test.recordPost(ptest);
        test.recordPost(ptest1);
        
        int index = test.getSlowestHour();
        
        assertThat(index).isEqualTo(0);
    }
}
