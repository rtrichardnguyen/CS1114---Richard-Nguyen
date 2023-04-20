// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.micro.jeroo.*;
import java.util.Scanner;
import student.IOHelper;

//-------------------------------------------------------------------------
/**
 *  A simple island for a jeroo to play in.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.11)
 */
public class RemoteIsland
    extends Island
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new RemoteIsland object.
     */
    public RemoteIsland()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Creates a RemoteJeroo, adds it to the island, and instructs
     * it to interpret commands from a remote file on a designated
     * web server.
     */
    public void myProgram()
    {
        // Create jeroo
        RemoteJeroo jeroo = new RemoteJeroo();
        
        // Add it to the island
        this.addObject(jeroo, 3, 3);

        // Create a scanner from the web and read its commands
        Scanner input = IOHelper.createScannerForURL(
            "https://courses.cs.vt.edu/~cs1114/Fall2021/jeroo-commands.txt");
        jeroo.interpretAllCommands(input);
        input.close();
    }
}
