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
 *  Tests for the Calendar class.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.04)
 */
public class CalendarTest
    extends TestCase
{
    //~ Fields ................................................................

    private Calendar calendar;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CalendarTest test object.
     */
    public CalendarTest()
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
        calendar = new Calendar();
    }


    // ----------------------------------------------------------
    /**
     * Method to test adding an event with cs1114 event
     */
    public void testAddEvent() {
        Event cs1114 = new Event("4pm", "CS 1114");
        calendar.addEvent(3, cs1114);
        
        assertThat(calendar.getEvent(3, 4)).isEqualTo(null);
    }
    
    /**
     * Method to test getting an event with cs1114 event
     */
    public void testAddEvent1() {
        Event cs1114 = new Event("4pm", "CS 1114");
        calendar.addEvent(3, cs1114);
        Event e = calendar.getEvent(3, 4);
        
        assertThat(e).isEqualTo(null);
    }
    
    /**
     * Method to test getting an event with cs1114 event
     */
    public void testAddEvent2() {
        Event cs1114 = new Event("12am", "CS 1114");
        calendar.addEvent(3, cs1114);
        Event e = calendar.getEvent(3, 4);
        
        assertThat(e).isEqualTo(null);
    }
    
    /**
     * Method to test getting an event with cs1114 event
     */
    public void testAddEvent3() {
        Event cs1114 = new Event(17, "CS 1114");
        calendar.addEvent(3, cs1114);
        Event e = calendar.getEvent(3, 4);
        
        assertThat(e).isEqualTo(null);
    }
    
    /**
     * Method to test getting an event with cs1114 event
     */
    public void testAddEvent4() {
        Event cs1114 = new Event(19, "CS 1114");
        calendar.addEvent(3, cs1114);
        Event e = calendar.getEvent(3, 4);
        
        assertThat(e).isEqualTo(null);
    }
    
    /**
     * Method to test getting an event with cs1114 event
     */
    public void testAddEvent5() {
        Event cs1114 = new Event(19, "CS 1114");
        calendar.addEvent(3, cs1114);
        Event e = calendar.getEvent(3, 7);
        
        assertThat(e).isEqualTo(null);
    }
    
    /**
     * Method to test getting an event with cs1114 event
     */
    public void testAddEvent6() {
        Event cs1114 = new Event(16, "CS 1114");
        calendar.addEvent(3, cs1114);
        Event e = calendar.getEvent(3, 4);
        
        assertThat(e).isEqualTo(null);
    }
    
    /**
     * Method to test getEvent
     */
    public void testGetEvent() {
        Event cs1114 = new Event(10, "CS");
        calendar.addEvent(4, cs1114);
        assertThat(calendar.getEvent(4, 10)).isEqualTo(cs1114);
    }
}
