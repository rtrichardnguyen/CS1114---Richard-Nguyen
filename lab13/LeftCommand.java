import static student.micro.jeroo.RelativeDirection.*;
import student.micro.jeroo.*;
//-------------------------------------------------------------------------
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  Class to interpret left command.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.14)
 */
public class LeftCommand implements Command
{
    //~ Fields ................................................................

    private Jeroo jeroo;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created LeftCommand object.
     * @param jeroo executes input
     */
    public LeftCommand(Jeroo jeroo)
    {
        super();
        this.jeroo = jeroo;
    }


    //~ Methods ...............................................................
    /**
     * Implemented command method
     */
    public void execute() {
        jeroo.turn(LEFT);
    }
}
