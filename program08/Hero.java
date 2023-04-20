// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
//-------------------------------------------------------------------------
/**
 *  Hero subclass that sets quality and defense to five at default.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.15)
 */
public class Hero extends EnhancedUnit
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Hero object.
     * @param s String for name
     * @param n integer for points
     */
    public Hero(String s, int n)
    {
        super(s, n);
        this.setQuality(5);
        this.setDefense(5);
    }


    //~ Methods ...............................................................


}
