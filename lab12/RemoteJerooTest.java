
import student.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;
import static org.assertj.core.api.Assertions.*;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 *  Tests for the RemoteJeroo class.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.11)
 */
public class RemoteJerooTest
    extends TestCase
{
    //~ Fields ................................................................

    private RemoteJeroo jeroo;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RemoteJerooTest test object.
     */
    public RemoteJerooTest()
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
        jeroo = new RemoteJeroo();
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
        
        // Could provide multiple lines to setIn(), which has the
        // same effect as if each string included a line terminator at
        // the end:
        setIn(
            "forward",
            "forward",
            "forward");

        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(6);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }

    /**
     * Test RemoteJeroo with a scanner containing all commands.
     */
    public void testAll()
    {
        // Set the built-in scanner's contents
        setIn("forward right left");
        
        // Could provide multiple lines to setIn(), which has the
        // same effect as if each string included a line terminator at
        // the end:
        setIn(
            "forward",
            "right",
            "left");

        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(in());

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(4);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test for jeroo to turn right on command
     */
    public void testRight() {
        setIn("right right right right");
        
        jeroo.interpretAllCommands(in());
        
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test for jeroo to turn right on command
     */
    public void testLeft() {
        setIn("left left left left");
        
        jeroo.interpretAllCommands(in());
        
        assertThat(jeroo.getX()).isEqualTo(3);
        assertThat(jeroo.getY()).isEqualTo(3);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
    
    /**
     * Test RemoteJeroo with a scanner containing all commands.
     */
    public void testURL()
    {
        Scanner input = IOHelper.createScannerForURL(
            "https://courses.cs.vt.edu/~cs1114/Fall2021/jeroo-commands.txt");
        // Set the built-in scanner's contents

        // Run all the commands by reading from the built-in scanner:
        jeroo.interpretAllCommands(input);

        // Check ending conditions, started at (3, 3):
        assertThat(jeroo.getX()).isEqualTo(8);
        assertThat(jeroo.getY()).isEqualTo(9);
        assertThat(jeroo.isFacing(EAST)).isTrue();
    }
}
