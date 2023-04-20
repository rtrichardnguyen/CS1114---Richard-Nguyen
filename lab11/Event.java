// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  Represents a weekly event at a specified time, including a
 *  description.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.04)
 */
public class Event
{
    //~ Fields ................................................................

    private int hour;
    private String description;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Event object.
     * 
     * @param hour The hour (time) of this event, in military time
     *             (0-23).
     * @param description The description of this event.
     */
    public Event(int hour, String description)
    {
        
        this.hour = hour;
        this.description = description;
       
    }

    /**
     * Creates a new Event object.
     * 
     * @param hour The hour (time) of this event, in military time
     *             (0-23).
     * @param description The description of this event.
     */
    public Event(String hour, String description)
    {
        this.description = description;
        this.setTime(hour);
    }
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get the description of this event.
     * @return This event's description.
     */
    public String getDescription() {
        return this.description;
    }


    // ----------------------------------------------------------
    /**
     * Get the hour of this event.
     * @return This event's hour, in military time.
     */
    // place getHour() here
    public int getHour() {
        return this.hour;
    }

    // ----------------------------------------------------------
    /**
     * Set the description of this event.
     * @param newDescription The new description for this event.
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }


    // ----------------------------------------------------------
    /**
     * Set the hour of this event.
     * @param newHour The new hour for this  event, in military
     *                time.
     */
    public void setHour(int newHour) {
        this.hour = newHour;
    }


    // ----------------------------------------------------------
    /**
     * Set the hour of this event, using a more human-friendly
     * string.
     * @param newHour The new hour for this  event, using an
     *                am/pm designation such as "9am" or "5pm".
     */
    public void setTime(String newHour) {
        String digitsOnly = 
            newHour.substring(0, newHour.length() - 2);
        String meridiem = newHour.substring(newHour.length() - 2);

        int h = Integer.parseInt(digitsOnly);
        
        if (meridiem.equals("pm") && h != 12) {
            h += 12;
        }
        
        if (meridiem.equals("am") && h == 12) {
            h = 0;
        }
        
        this.setHour(h);
    }


    // ----------------------------------------------------------
    /**
     * Get a string representation of this event.
     * @return A human-readable representation of this event
     * that includes the time (in am/pm format) and the description,
     * such as "11am: CS 1114".
     * @Override
     */
    public String toString() {
        if (this.getHour() == 12) {
            return "12pm: " + this.getDescription();
        }
        else if (this.getHour() > 12) {
            return this.getHour() - 12 + "pm: " + 
                this.getDescription();
        }
        else if (this.getHour() == 0) {
            return "12am: " + this.getDescription();
        }
        else {
            return this.getHour() + "am: " + this.getDescription();
        }
    }
}
