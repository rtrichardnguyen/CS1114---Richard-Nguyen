//-------------------------------------------------------------------------
/**
 *  Application launcher for JTetris, Program 09.
 *
 *  @author Stephen Edwards
 *  @version 2021.10.28
 */
public class Application
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Application object.
     */
    public Application()
    {
        super();
        Application.run();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Launches the JTetris graphical user interface to play the game.
     */
    public static void run()
    {
        student.tetris.JTetris.main(null);
    }
}
