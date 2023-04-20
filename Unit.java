// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
//-------------------------------------------------------------------------
/**
 *  Unit class that all subclasses will inherit with points, 
 *  quality, name, and defense fields.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.15)
 */
public class Unit implements GameElement
{
    //~ Fields ................................................................

    private String name;
    private int points;
    private int quality;
    private int defense;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------

    /**
     * Initializes a newly created Unit object.
     * @param n String for name
     * @param p integer for points
     */
    public Unit(String n, int p)
    {
        super();
        this.name = n;
        this.points = p;
        this.quality = 2;
        this.defense = 2;
    }
    
    //~ Methods ...............................................................
    /**
     * mutator for name field
     * @param str for Unit name
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
    
    /**
     * mutator for quality field
     * @param q for quality field
     */
    public void setQuality(int q) {
        
        this.quality = q;
        
    }
    
    /**
     * accessor for quality field
     * @return quality for Unit quality
     */
    public int getQuality() {
        
        return this.quality;
        
    }
    
    /**
     * mutator for defense field
     * @param d for defense field
     */
    public void setDefense(int d) {
        
        this.defense = d;
        
    }
    
    /**
     * accessor for defense field
     * @return defense for Unit defense
     */
    public int getDefense() {
        
        return this.defense;
        
    }
}
