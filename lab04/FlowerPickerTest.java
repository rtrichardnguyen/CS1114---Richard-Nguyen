// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)
import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  Program to test all methods in FlowerPicker class.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.14)
 */
public class FlowerPickerTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlowerPickerTest test object.
     */
    public FlowerPickerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................
    
    
    
    // ----------------------------------------------------------
    
    /**
     * Test the pickLine() method on flower path A's northwest
     * corner.
     */
    public void testPickLine() {
        
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 2);
        
        // 2. Call the method(s) you are testing
        picker.pickLine();
        
        // 3. Make assertions capturing your expected outcomes
        assertThat(picker.getX()).isEqualTo(6);
        assertThat(picker.getY()).isEqualTo(2);
        assertThat(picker.isFacing(EAST)).isTrue();
        assertThat(picker.getFlowers()).isEqualTo(5);
        assertThat(island.countFlowers()).isEqualTo(37);
        
    }
    
    /**
     * method to test method pickLine() on lot E
     */
    public void testPickLineE() {
        
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 10, 8);
        picker.turn(RIGHT);
        
        // 2. Call the method(s) you are testing
        picker.pickLine();
        
        // 3. Make assertions capturing your expected outcomes
        assertThat(picker.getX()).isEqualTo(10);
        assertThat(picker.getY()).isEqualTo(10);
        assertThat(picker.isFacing(SOUTH)).isTrue();
        assertThat(island.countFlowers()).isEqualTo(39);
    }
    
    /**
     * method to testTurnAroundRight()
     */
    public void testTurnAroundRight() {
        
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 1);
        
        // 2. Call the method(s) you are testing
        picker.turnAroundRight();
        
        // 3. Make assertions capturing your expected outcomes
        assertThat(picker.getX()).isEqualTo(2);
        assertThat(picker.getY()).isEqualTo(2);
        assertThat(picker.isFacing(WEST)).isTrue();
    }
    
    /**
     * method to testPick2Lines() on lot A
     */
    public void testPick2LinesA() {
        
        // 1. Set up initial conditions
        Island island = new Lab04Island();
        FlowerPicker picker = new FlowerPicker();
        island.addObject(picker, 2, 2);
        
        // 2. Call the method(s) you are testing
        picker.pick2Lines();
        
        // 3. Make assertions capturing your expected outcomes
        assertThat(picker.getX()).isEqualTo(2);
        assertThat(picker.getY()).isEqualTo(3);
        assertThat(picker.isFacing(WEST)).isTrue();
        assertThat(island.countFlowers()).isEqualTo(32);
    }

}
