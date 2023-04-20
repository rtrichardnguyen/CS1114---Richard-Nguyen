import student.media.*;

//-------------------------------------------------------------------------
/**
 *  A picture that supports basic color transformations for Lab 08.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.13)
 */
public class TransformablePicture
    extends Picture
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created TransformablePicture object as a copy
     * of another image.
     * @param original Picture object to be in super call
     */
    public TransformablePicture(Picture original)
    {
        super(original);
    }


    //~ Methods ...............................................................
    /**
     * Method that adds num to Red, Green, and Blue value of pixel
     * @param p pixel to ajust
     * @param num integer that increases each RGB value by
     */
    public void adjustPixel(Pixel p, int num) {
        
        p.setRed(p.getRed() + num);
        p.setGreen(p.getGreen() + num);
        p.setBlue(p.getBlue() + num);
        
    }
    
    // ----------------------------------------------------------
    /**
     * Adds a radial shadow that gets darker the farther a pixel is from
     * the upper left corner.
     * 
     * @param rate The speed at which the shadow gets darker, where
     *             a larger number produces a more gradual shadow
     */
    public void radialShadow(int rate)
    {
        for (int x = 0; x < this.getWidth(); x++) {
            
            for (int y = 0; y < this.getHeight(); y++) {
                Pixel pix = this.getPixel(x, y);
                this.adjustPixel(pix, -((x + y) / rate));
            }
            
        }
    }
    
    /**
     * Method that gets lighter the farther a pixel is from the 
     * bottom right corner
     * @param rate The speed at which the image gets lighter from
     * the upper left pixel
     */
    public void radialGlow(int rate) {
        
        for (int x = 0; x < this.getWidth(); x++) {
            
            for (int y = 0; y < this.getHeight(); y++) {
                Pixel pix = this.getPixel(x, y);
                this.adjustPixel(pix, ((this.getWidth() - 1 - x) + 
                    (this.getHeight() - 1 - y)) / rate);
            }
            
        }
    }
    
    /**
    * Method to that adjusts RGB values individually, red based
    * on distance from upper left corner and blue based on distance
    * from lower right corner
    * @param rate integer the speed of change between red and blue
    * values
    */
    public void colorShift(int rate) {
        
        for (int x = 0; x < this.getWidth(); x++) {
            
            for (int y = 0; y < this.getHeight(); y++) {
                
                Pixel pix = this.getPixel(x, y);
                pix.setRed(pix.getRed() + (((this.getWidth() - 1 - x) + 
                    (this.getHeight() - 1 - y)) / rate));
                pix.setBlue(pix.getBlue() + ((x + y) / rate));
                
            }
            
        }
        
    }
}
