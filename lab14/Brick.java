// -------------------------------------------------------------------------
/**
 *  Models a simple brick.
 *  This class is a part of an application for a company producing bricks.
 *  Bricks are delivered in palettes (stacks of bricks).
 * 
 *  There are (at least) four errors in this project. Find them. Fix them.
 *
 * @author Richard Nguyen (richardn03)
 * @version (2002.02.08)
 */
public class Brick
{
    //~ Instance/static variables .............................................

    // instance variables:
    private int height;
    private int width;
    private int depth;

    // Constant: weight per cubic cm in grams
    private static final double WEIGHT_PER_CM3 = 2.0;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a Brick. Parameters are edge lengths.
     * @param height in centimeters
     * @param width  in centimeters
     * @param depth  in centimeters
     */
    public Brick(int height, int width, int depth)
    {
        this.height = height;
        this.width  = width;
        this.depth  = depth;
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get this brick's surface area.
     * @return the surface area in square centimeters
     */
    public double getSurfaceArea()
    {
        double side1 = (width * height) * 2;
        double side2 = (width * depth) * 2;
        double side3 = (depth * height) * 2;
        double total = side1 + side2 + side3;

        return total;
    }


    // ----------------------------------------------------------
    /**
     * Get this brick's weight.
     * @return the weight in kg.
     */
    public double getWeight()
    {
        return (getVolume() * WEIGHT_PER_CM3) / 1000.0;
    }


    // ----------------------------------------------------------
    /**
     * Get this brick's volume.
     * @return the volume in qubic centimeters
     */
    public double getVolume()
    {
        return this.width * this.height * this.depth;
    }

    /**
     * Get this vrick's height.
     * @return heigh in centimeters
     */
    public double getHeight()
    {
        return this.height;
    }
}
