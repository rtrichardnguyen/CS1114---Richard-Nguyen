// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
//-------------------------------------------------------------------------
/**
 *  EnhancedUnit subclass to Unit with extra field specialRule.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.15)
 */
public class EnhancedUnit extends Unit
{
    //~ Fields ................................................................

    private String specialRule;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created EnhancedUnit object.
     * @param n String for name
     * @param p integer for points
     */
    public EnhancedUnit(String n, int p)
    {
        super(n, p);
        this.specialRule = null;
    }


    //~ Methods ...............................................................

    /**
     * Mutator for EnhancedUnit Special Rule
     * @param s String for special rule
     */
    public void setSpecialRule(String s) {
        
        this.specialRule = s;
        
    }
    
    /**
     * Accessor for EnhancedUnit Special Rule
     * @return specialRule for object EnhancedUnit
     */
    public String getSpecialRule() {
        
        return this.specialRule;
        
    }
    
    /**
     * toString for EnhancedUnit object
     * @return super string and special rule
     */
    public String toString() {
        
        if (this.getSpecialRule() != null) {
            return super.toString() + " special rule:[" +
                this.getSpecialRule().toString() + "]"; 
        }
        
        return super.toString();
    }
}
