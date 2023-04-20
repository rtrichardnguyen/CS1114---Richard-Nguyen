// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  Class to hold all post data.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.27)
 */
public class Post
{
    //~ Fields ................................................................

    private String name;
    private String message;
    private int day;
    private int hour;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Post object.
     * @param n for name field
     * @param m for message field
     * @param d for day field
     * @param h for hour field
     */
    public Post(String n, String m, int d, int h)
    {
        super();
        this.name = n;
        this.message = m;
        this.day = d;
        this.hour = h;
    }


    //~ Methods ...............................................................
    /**
     * Accessor for name field
     * @return name field
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Accessor for message field
     * @return message field
     */
    public String getMessage() {
        return this.message;
    }
    
    /**
     * Accessor for day field
     * @return day field
     */
    public int getDay() {
        return this.day;
    }
    
    /**
     * Accessor for hour field
     * @return hour field
     */
    public int getHour() {
        return this.hour;
    }
}
