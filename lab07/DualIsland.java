import student.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author your name (your-pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class DualIsland
    extends DualIslandBase
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created DualIsland object.
     */
    public DualIsland()
    {
        this(false);
    }


    // ----------------------------------------------------------
    /**
     * Initializes a newly created DualIsland object.
     * @param random If true, use a random arrangement of flowers, instead of
     *        the default triangle shape.
     */
    public DualIsland(boolean random)
    {
        super(random);
    }


    //~ Methods ...............................................................

    public void myProgram()
    {
        Jeroo slave = new Jeroo(1000);
        this.addObject(slave, 10, 1);

        CopyingJeroo master = new CopyingJeroo(slave);
        this.addObject(master, 1, 1);

        master.walkIsland();
    }
}
