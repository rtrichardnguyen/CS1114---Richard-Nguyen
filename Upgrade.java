// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
//-------------------------------------------------------------------------
/**
 *  Upgrade class that provides mutators and accessors for 
 *  name and points fields.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.15)
 */
public class Upgrade implements GameElement
{
    //~ Fields ................................................................

    private String name;
    private int points;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Upgrade object.
     * @param n String for name
     * @param p integer for points
     */
    public Upgrade(String n, int p)
    {
        super();
        this.name = n;
        this.points = p;
    }


    //~ Methods ...............................................................

    /**
     * mutator for name field
     * @param str for Upgrade name
     */
    public void setName(String str) {
        
        this.name = str;
        
    }
    
    /**
     * accessor for name field
     * @return name for name field
     */
    public String getName() {
        
        return this.name;
        
    }
    
    /**
     * mutator for points field
     * @param p for points field
     */
    public void setPoints(int p) {
        
        this.points = p;
        
    }
    
    /**
     * accessor for points field
     * @return points for points field
     */
    public int getPoints() {
        
        return this.points;
        
    }
}
