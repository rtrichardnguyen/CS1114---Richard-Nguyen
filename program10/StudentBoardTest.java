// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris2.*;

// -------------------------------------------------------------------------
/**
 *  Class to test all methods for StudentBoard implementation.
 *
 *  @author RichardNguyen (richardn03)
 *  @version (2022.11.02)
 */
public class StudentBoardTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new StudentBoardTest test object.
     */
    public StudentBoardTest()
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
        /*# Insert your own setup code here */
    }


    // ----------------------------------------------------------
    /**
     * Method to test if method returns false if there is not
     * a block at point and true if there is one
     */
    public void testHasBlockAt() {
        
        Point point = new Point(5, 0);
        Point point1 = new Point(4, 0);
        Point point2 = new Point(1, 23);
        Point point3 = new Point(0, 23);
        
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
        
        assertThat(start1.hasBlockAt(point)).isTrue();
        assertThat(start1.hasBlockAt(point1)).isFalse();
        assertThat(start1.hasBlockAt(point2)).isFalse();
        assertThat(start1.hasBlockAt(point3)).isFalse();

    }

    /**
     * Method to test place() with one empty box at first array
     */
    public void testPlace() {
        
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
            
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = start1.place(piece, new Point(4, 0));
        
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        int[] blocksInRows = start1.getBlocksInAllRows();
        assertThat(blocksInRows[0]).isEqualTo(10);
        assertThat(blocksInRows[1]).isEqualTo(3);
        assertThat(start1.getColumnHeights()).isEqualTo(new int[] {
            1, 1, 1, 1, 2, 2, 2, 1, 1, 1, });

    }
    
    /**
     * Method to test place() out of bounds
     */
    public void testPlaceBounds() {
        
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
            
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = start1.place(piece, new Point(9, 1));
        
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);

    }
    
    /**
     * Method to test place() with block already there
     */
    public void testPlaceBad() {
        
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
            
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = start1.place(piece, new Point(0, 0));
        
        assertThat(result).isEqualTo(Board.PLACE_BAD);

    }
    
    /**
     * Method to test place() with no fill and good place
     */
    public void testPlaceGood() {
        
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
            
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = start1.place(piece, new Point(0, 1));
        
        assertThat(result).isEqualTo(Board.PLACE_OK);

    }
    
    /**
     * Method to test place() with no fill and good place
     */
    public void testPlaceHeight() {
        
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
            
        Piece piece = Piece.getPiece(Piece.RIGHT_L, 3);
        int result = start1.place(piece, new Point(0, 23));
        
        assertThat(result).isEqualTo(Board.PLACE_OUT_BOUNDS);

    }

    /**
     * Method to test clearRows on one full row
     */
    public void testClearRows() {
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "##########"
            ); 
            
        start1.clearRows();
        Point point = new Point(0, 0);
        Point point1 = new Point(1, 0);
        assertThat(start1.hasBlockAt(point)).isFalse();
        assertThat(start1.hasBlockAt(point1)).isFalse();
        //assertThat(start1.getColumnHeights()).isEqualTo(new int[] {
        //    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, });
            
    }
    
    /**
     * Method to test clearRows on one full row
     */
    public void testClearRows1() {
        StudentBoard start1 = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "##########",
            "### ######"
            ); 
        Point point = new Point(0, 0);
        start1.clearRows();
        
        assertThat(start1.hasBlockAt(point)).isFalse();
        //assertThat(start1.getGrid()[23][0]).isTrue();
        //assertThat(start1.getColumnHeights()).isEqualTo(new int[] {
        //    1, 1, 1, 0, 1, 1, 1, 1, 1, 1, });
            
    }
}
