// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.*;
import student.media.*;
import java.awt.Color;
import static org.assertj.core.api.Assertions.*;
import student.util.Random;

// -------------------------------------------------------------------------
/**
 *  Test class to test all SchellingSimulation methods in a 
 *  blank simulated 9x9 square
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.02)
 */
public class SchellingSimulationTest
    extends TestCase
{
    //~ Fields ................................................................
    
    private SchellingSimulation image;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SchellingSimulationTest test object.
     */
    public SchellingSimulationTest()
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
        image = new SchellingSimulation(3, 3);
        image.setRedLine(2);
        image.setSatisfactionThreshold(0.3);
    }


    // ----------------------------------------------------------
    /**
     * method to test return of getSatisfactionThreshold()
     */
    public void testGetSatisfactionThreshold() {
        
        image.setSatisfactionThreshold(0.6);
        double testSTValue = image.getSatisfactionThreshold();
        
        assertThat(testSTValue).isEqualTo(0.6);
        
    }
    
    /**
     * method to test new value for satisfactionThreshold
     */
    public void testSetSatisfactionThreshold() {
          
        image.setSatisfactionThreshold(0.8);
        
        assertThat(image.getSatisfactionThreshold()).isEqualTo(0.8);
        
    }
    
    /**
     * method to test return of getRedLine()
     */
    public void testGetRedLine() {
        
        image.setRedLine(80);
        double testRLValue = image.getRedLine();
        
        assertThat(testRLValue).isEqualTo(80);
        
    }
    
    /**
     * method to test new value for redLine
     */
    public void testSetRedLine() {
        
        image.setRedLine(50);
        
        assertThat(image.getRedLine()).isEqualTo(50);
        
    }
    
    /**
     * method to test population of blue pixels
     */
    public void testPopulate() {
        
        image.populate(1.0, 0.0);
        
        for (Pixel p: image.getPixels()) {
            
            assertThat(p.getColor()).isEqualTo(Color.BLUE);
            
        }
        
    }
    
    /**
     * method to test population of orange pixels
     */
    public void testPopulateOrange() {
        
        image.populate(0.0, 1.0);
        
        assertThat(image.getPixel(0, 2).getColor()).isEqualTo(Color.ORANGE);
        assertThat(image.getPixel(1, 2).getColor()).isEqualTo(Color.ORANGE);
        assertThat(image.getPixel(2, 2).getColor()).isEqualTo(Color.ORANGE);
        
    }
    
    /**
     * method to test population of blue and orange pixels
     */
    public void testPopulateNotWhite() {
        int coloredPixels = 0;
        image.populate(1.0, 0.0);
        
        for (Pixel p: image.getPixels()) {
            
            if (p.getColor().equals(Color.BLUE)
                || p.getColor().equals(Color.ORANGE)) {
                coloredPixels++;
            }
            
        }
        
        assertThat(coloredPixels).isGreaterThanOrEqualTo(3);
        
    }
    
    /**
     * method to test population of blue and orange pixels
     */
    public void testPopulateChance() {
        int orangeCount = 0;
        image.populate(0.0, 1.0);
        
        Random.setNextDoubles(0.5, 0.4, 0.5, 0.4, 0.5, 0.4, 0.5, 0.4, 0.4);
        
        for (Pixel p: image.getPixels()) {
            
            if (p.getColor().equals(Color.ORANGE)) {
                orangeCount++;
            }
            
        }
        
        assertThat(orangeCount).isGreaterThanOrEqualTo(3);
    }
    
    /**
     * method to test population of blue and orange pixels
     */
    public void testPopulateWhite() {
        
        image.populate(0.0, 0.0);
        
        for (Pixel p: image.getPixels()) {
            
            assertThat(p.getColor()).isEqualTo(Color.WHITE);
            
        }
        
    }
    
    /**
     * method to test areSameColor method with all white pixels
     */
    public void testAreSameColor() {
        
        image.populate(1.0, 0.0);
        Pixel p1 = new Pixel(image, 1, 1);
        Pixel p2 = new Pixel(image, 0, 1);
        Pixel p3 = new Pixel(image, 1, 0);
        
        for (Pixel p: image.getPixels()) {
            
            assertThat(image.areSameColor(p, p1)).isTrue();
            assertThat(image.areSameColor(p, p2)).isTrue();
            assertThat(image.areSameColor(p, p3)).isTrue();
            
        }
        
    }
    
    /**
     * method to test isEmpty() with all white pixels
     */
    public void testIsEmpty() {
        
        for (Pixel p: image.getPixels()) {
            boolean isEmpty = image.isEmpty(p);
            assertThat(isEmpty).isEqualTo(true);
            assertThat(p.getColor()).isEqualTo(Color.WHITE);
        }
        
    }
    
    /**
     * method to test if agent is satisfied at location
     */
    public void testIsSatisfied() {
        
        Pixel p = new Pixel(image, 0, 0);
        Pixel p1 = new Pixel(image, 1, 1);
        Pixel p2 = new Pixel(image, 0, 1);
        Pixel p3 = new Pixel(image, 1, 0);
        
        p.setColor(Color.BLUE);
        p1.setColor(Color.ORANGE);
        p2.setColor(Color.BLUE);
        p3.setColor(Color.BLUE);
        
        assertThat(image.isSatisfied(p, Color.BLUE)).isTrue();
        
    }
    
    /**
     * method to test if agent is satisfied at location (orange)
     */
    public void testIsSatisfiedOrange() {
        
        Pixel p = new Pixel(image, 1, 2);
        Pixel p1 = new Pixel(image, 1, 1);
        Pixel p2 = new Pixel(image, 0, 1);
        Pixel p3 = new Pixel(image, 1, 0);
        
        p.setColor(Color.WHITE);
        p1.setColor(Color.ORANGE);
        p2.setColor(Color.ORANGE);
        p3.setColor(Color.ORANGE);
        
        assertThat(image.isSatisfied(p, Color.ORANGE)).isTrue();
        
    }
    
    /**
     * method to test if agent is satisfied at location with 
     * all white neighboring pixels
     */
    public void testIsSatisfiedAllWhite() {
        
        Pixel p = new Pixel(image, 0, 0);
        
        assertThat(image.isSatisfied(p, Color.ORANGE)).isTrue();
        
    }
    
    /**
     * method to test if blue agent is satisfied at location
     */
    public void testIsSatisfiedBlue() {
        
        Pixel p = new Pixel(image, 0, 0);
        Pixel p1 = new Pixel(image, 1, 1);
        Pixel p2 = new Pixel(image, 0, 1);
        Pixel p3 = new Pixel(image, 1, 0);
        
        p.setColor(Color.BLUE);
        p1.setColor(Color.ORANGE);
        p2.setColor(Color.BLUE);
        p3.setColor(Color.BLUE);
        
        assertThat(image.isSatisfied(p, Color.BLUE)).isTrue();
        
    }
    
    /**
     * method to test orange agent satisfaction at an unsatisfactory
     * pixel coordinate
     */
    public void testIsSatisfiedFalse() {
        
        Pixel p = new Pixel(image, 0, 0);
        Pixel p1 = new Pixel(image, 1, 1);
        Pixel p2 = new Pixel(image, 0, 1);
        Pixel p3 = new Pixel(image, 1, 0);
        
        p.setColor(Color.BLUE);
        p1.setColor(Color.ORANGE);
        p2.setColor(Color.ORANGE);
        p3.setColor(Color.ORANGE);
        
        assertThat(image.isSatisfied(p, Color.BLUE)).isFalse();
        
    }
    
    /**
     * method to relocate pixel succesfully at a new location
     */
    public void testMaybeRelocate() {
        
        // Initial setup creates a 3x3 simulation
        // an orange agent is at (0, 0)
        image.getPixel(2, 2).setColor(Color.BLUE);
        image.getPixel(1, 0).setColor(Color.BLUE);
        image.getPixel(0, 1).setColor(Color.BLUE);
        image.getPixel(1, 2).setColor(Color.ORANGE);
        image.getPixel(1, 1).setColor(Color.WHITE);
        image.getPixel(2, 1).setColor(Color.ORANGE);
    
        // I want maybeRelocate() to choose (2, 2) as the destination
        Random.setNextInts(0, 0);
        boolean agentMoved = image.maybeRelocate(image.getPixel(2, 2));

        assertThat(agentMoved).isTrue();
        assertThat(image.getPixel(2, 2).getColor()).isEqualTo(Color.WHITE);
        assertThat(image.getPixel(0, 0).getColor()).isEqualTo(Color.BLUE);
        
    }
    
    /**
     * method to relocate pixel unsuccesfully at a new location
     */
    public void testMaybeRelocateFalse() {
        
        // Initial setup creates a 3x3 simulation
        // a blue agent is at (0, 0)
        image.getPixel(0, 0).setColor(Color.BLUE);
        image.getPixel(1, 2).setColor(Color.ORANGE);
        image.getPixel(1, 1).setColor(Color.ORANGE);
        image.getPixel(2, 1).setColor(Color.ORANGE);
        image.getPixel(2, 2).setColor(Color.WHITE);
    
        // I want maybeRelocate() to choose (2, 2) as the destination
        Random.setNextInts(2, 2);
        boolean agentMoved = image.maybeRelocate(image.getPixel(0, 0));

        assertThat(agentMoved).isFalse();
        assertThat(image.getPixel(0, 0).getColor()).isEqualTo(Color.BLUE);
        assertThat(image.getPixel(2, 2).getColor()).isEqualTo(Color.WHITE);
        
    }
    
    /**
     * method to test cycle agent with one pixel movement
     */
    public void testCycleAgents() {
        
        // Initial setup creates a 3x3 simulation
        // an orange agent is at (0, 0)
   
        image.getPixel(0, 0).setColor(Color.ORANGE);
        image.getPixel(1, 0).setColor(Color.ORANGE);
        image.getPixel(2, 0).setColor(Color.BLUE);
    
        // I want to cycle agent to (0, 1)
        int countMoves = image.cycleAgents();

        // Assume (0, 1) is what it really selected
        assertThat(countMoves).isGreaterThanOrEqualTo(1);
        
    }
    
    /**
     * method to test cycle agent with one pixel movement
     */
    public void testCycleAgentsNotSuccessfull() {
        
        // Initial setup creates a 3x3 simulation
        // an orange agent is at (3, 3)
        image.getPixel(0, 0).setColor(Color.BLUE);
        image.getPixel(1, 2).setColor(Color.BLUE);
        image.getPixel(1, 1).setColor(Color.BLUE);
        image.getPixel(2, 1).setColor(Color.BLUE);
    
        // I want to cycle agent to (0, 1)
        Random.setNextInts(0, 0);
        int countMoves = image.cycleAgents();

        // Assume (0, 1) is what it really selected
        assertThat(countMoves).isEqualTo(0);
        assertThat(image.getPixel(2, 2).getColor()).isEqualTo(Color.WHITE);
        assertThat(image.getPixel(0, 0).getColor()).isEqualTo(Color.BLUE);
        
    }

}
