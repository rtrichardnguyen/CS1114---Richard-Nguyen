import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris.*;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
// -------------------------------------------------------------------------
/**
 *  Test class to test all methods in CleverBrain
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.01)
 */
public class CleverBrainTest
    extends TestCase
{
    //~ Fields ................................................................
    
    private CleverBrain myBrain;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new CleverBrainTest test object.
     */
    public CleverBrainTest()
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
        myBrain = new CleverBrain();
    }


    // ----------------------------------------------------------
    /**
     * Method to test bestMove on lowest row with set board
     */
    public void testBestMove() {
        Board board = new Board(6, 10,
            "# ####");
            
        Piece piece = Piece.getPiece(Piece.STICK, 0);
        Move move = myBrain.bestMove(board, piece, 6);
        
        assertThat(move.getLocation()).isEqualTo(new Point(1, 0));
        assertThat(move.getPiece()).isEqualTo(Piece.getPiece(Piece.STICK, 0));
    }
    
    /**
     * Method to test all rotations of piece on set board
     */
    public void testAllRotations() {
        Board board = new Board(6, 10,
            "# ####");
            
        Piece piece = Piece.getPiece(Piece.STICK, 0);
        Move move = myBrain.bestMove(board, piece, 6);
        myBrain.allRotations(piece, board, move);
        
        assertThat(move.getLocation()).isEqualTo(new Point(1, 0));
        assertThat(move.getPiece()).isEqualTo(Piece.getPiece(Piece.STICK, 0));
    }
    
    /**
     * Method to test next rotated piece
     */
    public void testRotatedPiece() {
        Piece piece = Piece.getPiece(Piece.STICK, 0);
        Piece newPiece = myBrain.rotatedPiece(piece, 1);
        
        assertThat(newPiece).isEqualTo(Piece.getPiece(Piece.STICK, 1));
    }
    
    /**
     * Method to test rateBoard on given board
     */
    public void testRateBoard() {

        Board board = new Board(10, 24,
            "#### #####"
            );

        double score = myBrain.rateBoard(board);

        assertThat(score).isEqualTo(109.0, within(0.001));
    }
    
    /**
     * Method to test rate column on new set board
     */
    public void testRateColumn() {
        Board board = new Board(10, 24,
            "#         ",    
            "#### #####",
            "#### #####"
            );

        double score = myBrain.rateColumn(board, 0);

        assertThat(score).isEqualTo(3.0, within(0.001));
    }
    
    /**
     * Method to test count holes on set board, counting holes
     */
    public void testCountHoles() {

        Board board = new Board(10, 24,
            "#### #####"
            );

        double score = myBrain.countHoles(board);

        assertThat(score).isEqualTo(10.0, within(0.001));
    }
}
