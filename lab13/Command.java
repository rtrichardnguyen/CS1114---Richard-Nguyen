// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  Interface that declares execute
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.20)
 */
public interface Command
{
    
    /**
     * Carries out corresponding action by sending appropriate
     * message(s) to the rocket
     */
    void execute();
    
}
