// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
//-------------------------------------------------------------------------
/**
 *  Monster subclass that sets quality and defense to 4 at default.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.15)
 */
public class Monster extends EnhancedUnit
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Monster object.
     * @param s String for name
     * @param n integer for points
     */
    public Monster(String s, int n)
    {
        super(s, n);
        this.setQuality(4);
        this.setDefense(4);
    }

    //~ Methods ...............................................................


}
