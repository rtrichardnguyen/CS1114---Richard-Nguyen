// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

//-------------------------------------------------------------------------
/**
 *  Represents a simple weekly calendar of events that are
 *  shown in a grid from 8am to 5pm on each day of the week.
 *  Internally, events are stored in a 2D array
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.04)
 */
public class Calendar
{
    //~ Fields ................................................................

    private Event[][] events;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Calendar object.
     */
    public Calendar()
    {
        events = new Event[7][10];
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Add a new event on the specified day.  The time for the event
     * is extracted from the event object itself. If the day is
     * invalid, the method does nothing.  If the event is outside
     * the window of 8am-5pm, the method does nothing. If another
     * event has already been entered for the specified day/time, it
     * is removed and replaced by the one being added.
     * 
     * @param day   The day for the event (0-6).
     * @param event The appointment to add on that day (contains
     *              its own time).
     */
    public void addEvent(int day, Event event) {
        if ((event.getHour() >= 8 && event.getHour() <= 17) &&
            (day <= 6 && day >= 0)) {
            this.events[day][event.getHour() - 8] = event;
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve an existing event (if any) by day and hour.
     * 
     * @param day  The day to check (0-6).
     * @param hour The hour to check (0-23), in military time.
     * @return The event at the specified day and time,
     * if there is one, or null if no event is found, if
     * the day specified is invalid, or if the hour specified is
     * outside the range 8-17.
     */
    public Event getEvent(int day, int hour) {
        if ((hour >= 8 && hour <= 17) &&
            (day <= 6 && day >= 0)) {
            return this.events[day][hour - 8]; 
        }
        
        return null;
        
    }
    
}
