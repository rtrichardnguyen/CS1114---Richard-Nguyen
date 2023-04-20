import student.micro.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;
import java.util.Scanner;
import student.IOHelper;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

// -------------------------------------------------------------------------
/**
 *  Tests for the InterpreterJeroo class.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.16)
 */
public class InterpreterJerooTest
    extends TestCase
{
    //~ Fields ................................................................

    private InterpreterJeroo jeroo;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new InterpreterJerooTest test object.
     */
    public InterpreterJerooTest()
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
        Island island = new Island();
        jeroo = new InterpreterJeroo();
        island.addObject(jeroo, 3, 3);
    }


    // ----------------------------------------------------------
    /**
     * Test RemoteJeroo with a scanner containing three "forward" commands.
     */
    public void testForward()
    {
        // Set the built-in scanner's contents
        setIn("forward forward forward");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(6);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing three "left" commands.
     */
    public void testLeft()
    {
        // Set the built-in scanner's contents
        setIn("left left left left");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing three "right" commands.
     */
    public void testRight()
    {
        // Set the built-in scanner's contents
        setIn("right right right right");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing URL commands.
     */
    public void testURL()
    {
        Scanner input = IOHelper.createScannerForURL(
            "https://courses.cs.vt.edu/~cs1114/Fall2021/jeroo-commands.txt");
        
        jeroo.interpretAllCommands(input);
        input.close();

        assertThat(jeroo.getX()).isEqualTo(8);
        assertThat(jeroo.getY()).isEqualTo(9);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing three "right" commands.
     */
    public void testCapCommands()
    {
        // Set the built-in scanner's contents
        setIn("Forward Right Left");
        
        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (4, 3):
        assertThat(jeroo.getX()).isEqualTo(4);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
}
