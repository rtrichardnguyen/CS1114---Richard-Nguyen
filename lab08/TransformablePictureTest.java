import student.*;
import student.media.*;
import java.awt.Color;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Unit tests for Transformable Picture in Lab 08.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.13)
 */
public class TransformablePictureTest
    extends TestCase
{
    //~ Fields ................................................................

    private TransformablePicture image;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TransformablePictureTest test object.
     */
    public TransformablePictureTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        // Create a transformable picture for testing.
        // It contains a 3x3 test image where all pixels are (100, 100, 100).
        image = new TransformablePicture(new TestImage(3, 3));
    }


    // ----------------------------------------------------------
    /**
     * An example test case that shows how to test the pixel values
     * in a tiny 3x3 test image.
     */
    public void testRadialShadow()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        image.radialShadow(1);
        
        // 3. Check expected behavior
        
        // Checking the corners should be enough
        assertThat(image.getPixel(0, 0).getColor())
            .isEqualTo(new Color(100, 100, 100));
        assertThat(image.getPixel(0, 2).getColor())
            .isEqualTo(new Color( 98,  98,  98));
        assertThat(image.getPixel(2, 0).getColor())
            .isEqualTo(new Color( 98,  98,  98));
        assertThat(image.getPixel(2, 2).getColor())
            .isEqualTo(new Color( 96,  96,  96));
    }

    /**
     * An example test case that shows how to test the pixel values
     * in a tiny 3x3 test image.
     */
    public void testRadialShadowRate2()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        image.radialShadow(2);
        
        // 3. Check expected behavior
        
        // Checking the corners should be enough
        assertThat(image.getPixel(0, 0).getColor())
            .isEqualTo(new Color(100, 100, 100));
        assertThat(image.getPixel(0, 2).getColor())
            .isEqualTo(new Color( 99,  99,  99));
        assertThat(image.getPixel(2, 0).getColor())
            .isEqualTo(new Color( 99,  99,  99));
        assertThat(image.getPixel(2, 2).getColor())
            .isEqualTo(new Color( 98,  98,  98));
    }
    
    /**
     * Method to testRadialGlow across simulated image
     */
    public void testRadialGlow()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        image.radialGlow(1);
        
        // 3. Check expected behavior
        
        // Checking the corners should be enough
        assertThat(image.getPixel(0, 0).getColor())
            .isEqualTo(new Color(104, 104, 104));
        assertThat(image.getPixel(0, 2).getColor())
            .isEqualTo(new Color( 102,  102,  102));
        assertThat(image.getPixel(2, 0).getColor())
            .isEqualTo(new Color( 102,  102,  102));
        assertThat(image.getPixel(2, 2).getColor())
            .isEqualTo(new Color( 100,  100,  100));
    }
    
    /**
     * Method to test adjustPixel on one singular pixel
     */
    public void testAdjustPixel() {
        
        image.adjustPixel(image.getPixel(0, 0), 50);
        
        assertThat(image.getPixel(0, 0).getRed()).isEqualTo(150);
        assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(150);
        assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(150);
        
    }
    
    /**
     * Method to test colorShift() across simulated image
     */
    public void testColorShift()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        image.colorShift(1);
        
        // 3. Check expected behavior
        
        // Checking the corners should be enough
        assertThat(image.getPixel(0, 0).getColor())
            .isEqualTo(new Color(104, 100, 100));
        assertThat(image.getPixel(0, 2).getColor())
            .isEqualTo(new Color( 102,  100,  102));
        assertThat(image.getPixel(2, 0).getColor())
            .isEqualTo(new Color( 102,  100,  102));
        assertThat(image.getPixel(2, 2).getColor())
            .isEqualTo(new Color( 100,  100,  104));
    }
    
}
