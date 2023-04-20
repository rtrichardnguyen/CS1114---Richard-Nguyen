// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
//-------------------------------------------------------------------------
/**
 *  GameElement interface that declares getName() and getPoints().
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.10.12)
 */
public interface GameElement
{
    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Get this GameElement's name.
     *
     * @return This object's name as a string.
     */
    public String getName();


    // ----------------------------------------------------------
    /**
     * Get this GameElement's cost in points.
     *
     * @return The number of points for this object.
     */
    public int getPoints();
    // ----------------------------------------------------------
    /*
    /**
     * An example of a method header - replace this comment with your own
     *
     * @param  y a sample parameter for a method
     * @return   the result produced by sampleMethod
     
    int sampleMethod(int y);
    */
}
