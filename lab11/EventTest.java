import student.TestCase;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests for the Event class.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.04)
 */
public class EventTest
    extends TestCase
{
    //~ Fields ................................................................

    private Event event;
    private Event event1;
    private Event event2;
    private Event event3;
    private Event event4;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new EventTest test object.
     */
    public EventTest()
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
        // You'll need to fix this after modifying the Event constructor
        event = new Event(12, "Party");
        event1 = new Event("2pm", "Funeral");
        event2 = new Event(0, "CS 1114");
        event3 = new Event(8, "CS");
        event4 = new Event (17, "CS");
    }


    // ----------------------------------------------------------
    /**
     * Method to test getDescription for event field
     */
    public void testGetDescription() {
        String str = event.getDescription();
        
        assertThat(str).isEqualTo("Party");
    }
    
    /**
     * Method to test getHour for hour field
     */
    public void testGetHour() {
        int n = event.getHour();
        
        assertThat(n).isEqualTo(12);
    }
    
    /**
     * Method to test setDescription with new class event
     */
    public void testSetDescription() {
        event.setDescription("Class");
        
        assertThat(event.getDescription()).isEqualTo("Class");
    }
    
    /**
     * Method to set hour with 14 military time
     */
    public void testSetHour() {
        event.setHour(14);
        
        assertThat(event.getHour()).isEqualTo(14);
    }

    /**
     * Method to test set time with 11am
     */
    public void testSetTime() {
        event.setTime("11am");
        
        assertThat(event.getHour()).isEqualTo(11);
        
    }
    
    /**
     * Method to test setTime with pm hour
     */
    public void testSetTimePM() {
        event.setTime("4pm");
        
        assertThat(event.getHour()).isEqualTo(16);
    }
    
    /**
     * Method to test getTime with current attribute
     */
    public void testGetTime1() {
        int n = event1.getHour();
        
        assertThat(n).isEqualTo(14);
    }
    
    /**
     * Method to test setTime with 12pm
     */
    public void testSetTime12() {
        event1.setTime("12pm");
        
        assertThat(event.getHour()).isEqualTo(12);
    }
    
    /**
     * Method to test toString
     */
    public void testToString() {
        String str = event1.toString();
        
        assertThat(str).isEqualTo("2pm: Funeral");
    }
    
    /**
     * Method to test toString
     */
    public void testToString0() {
        String str = event.toString();
        
        assertThat(str).isEqualTo("12pm: Party");
    }
    
    /**
     * Method to test toString
     */
    public void testToString2() {
        String str = event2.toString();
        
        assertThat(str).isEqualTo("12am: CS 1114");
    }
    
    /**
     * Method to test toString
     */
    public void testToString3() {
        String str = event3.toString();
        
        assertThat(str).isEqualTo("8am: CS");
    }
    
    /**
     * Method to test toString
     */
    public void testToString4() {
        String str = event4.toString();
        
        assertThat(str).isEqualTo("5pm: CS");
    }
}
