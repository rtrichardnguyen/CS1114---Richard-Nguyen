
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A picture that supports basic color transformations for Lab 06.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.28)
 */
public class TransformablePicture
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created TransformablePicture object as a copy
     * of another image.
     * @param original Picture object
     */
    public TransformablePicture(Picture original)
    {
        super(original);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Turns the red intensity of every pixel in this image up to
     * the maximum value.
     */
    public void maxRed()
    {
        for (Pixel pix: this.getPixels()) {
            
            pix.setRed(255);
            
        }
    }
    
    /**
     * Turns the green intensity of every pixel in this image up to
     * the maximum value.
     */
    public void maxGreen()
    {
        for (Pixel pix: this.getPixels()) {
            
            pix.setGreen(255);
            
        }
    }
    
    /**
     * Turns the blue intensity of every pixel in this image up to
     * the maximum value.
     */
    public void maxBlue()
    {
        for (Pixel pix: this.getPixels()) {
            
            pix.setBlue(255);
            
        }
    }
    
    /**
     * method to brighten image by amount more than current value
     * @param amount integer to increase or decrease brightness by
     */
    public void brighten(int amount) {
        
        for (Pixel pix: this.getPixels()) {
            
            pix.setRed(pix.getRed() + amount);
            pix.setGreen(pix.getGreen() + amount);
            pix.setBlue(pix.getBlue() + amount);
            
        }
        
    }
}
