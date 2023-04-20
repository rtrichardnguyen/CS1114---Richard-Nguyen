// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.micro.jeroo.*;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  A remotely controllable jeroo that reads commands
 *  from a scanner and uses a map to translate words
 *  into commands.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.14)
 */
public class InterpreterJeroo
    extends Jeroo
{
    //~ Fields ................................................................

    private Map<String, Command> map;

    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new InterpreterJeroo object.
     */
    public InterpreterJeroo()
    {
        super();
        
        map = new HashMap<String, Command>();
        
        ForwardCommand forward = new ForwardCommand(this);
        LeftCommand left = new LeftCommand(this);
        RightCommand right = new RightCommand(this);
        
        map.put("forward", forward);
        map.put("left", left);
        map.put("right", right);
        
        map.put("Forward", forward);
        map.put("Left", left);
        map.put("Right", right);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Calls interpretCommand() repeatedly until there are no more
     * words left in the given Scanner.
     * 
     * @param input The Scanner to read the command from.
     */
    public void interpretAllCommands(Scanner input)
    {
        while (input.hasNext()) {
            this.interpretCommand(input);
        }
    }


    // ----------------------------------------------------------
    /**
     * Reads one word from the scanner (if there is any), and executes
     * the corresponding command.  If the scanner has no words remaining,
     * then nothing happens.
     * 
     * @param input The Scanner to read the command from.
     */
    public void interpretCommand(Scanner input)
    {
        String str = input.next();
        map.get(str).execute();
    }
}
