import student.tetris.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  CleverBrain class to decide efficient moves in tetris game.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.29)
 */
public class CleverBrain implements Brain
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created CleverBrain object.
     */
    public CleverBrain()
    {
        super();
    }


    //~ Methods ...............................................................
    /**
     * Method to determine best possible move with lowest
     * point cost.
     * @param board Board for current canvas being played on
     * @param piece piece to iterate through all rotations
     * @param heightLimit to not go over
     * @return Move object of best determined move
     */
    public Move bestMove(Board board, Piece piece, int heightLimit) {
        Move bestMove = new Move(piece);
        bestMove.setScore(10000.0);
        
        for (int rot = 0; rot < piece.numRotations(); rot++) {           
                
            this.allRotations(piece, board, bestMove);
            piece = this.rotatedPiece(piece, rot);
            
        }

        return bestMove;
    }
    
    /**
     * Method to iterate thorugh all rotations
     * @param piece piece to iterate thorugh
     * @param b board to evaluate
     * @param move move to change score
     */
    public void allRotations(Piece piece, Board b, Move move) {
        double initialRating = this.rateBoard(b);
        double bestRating;
        move.setScore(this.rateBoard(b) + 10000.0);
        for (int i = 0; i < b.getWidth() - piece.getWidth() + 1; i++) {
            
            int y = b.rowAfterDrop(piece, i);
            Point newPoint = new Point(i, y);
            b.place(piece, newPoint);
            
            b.clearRows();
            bestRating = this.rateBoard(b) - initialRating;
            
            if (bestRating < move.getScore()) {
                move.setPiece(piece);
                move.setLocation(newPoint);
                move.setScore(bestRating);
            }
            
            b.undo();
            
        }
 
    }
    
    /**
     * Method to return next rotation piece
     * @param p piece to iterate through
     * @param n rotation number
     * @return rotated piece
     */
    public Piece rotatedPiece(Piece p, int n) {
        Piece[] arr = p.getRotations();
        return arr[n];
    }
    
    /**
     * Method to rate current board using column heights and 
     * row densities
     * @param board current board to rate
     * @return double determined rating of board
     */
    public double rateBoard(Board board) {
        double totalRating = 0.0;
        
        for (int i = 0; i < board.getWidth(); i++) {
            
            double colRating = rateColumn(board, i);
            double holeCount = countHoles(board);
            totalRating += colRating + holeCount;
            
        }
        
        return totalRating;
    }
    
    /**
     * Method to rate column by height
     * @param board board to evaluate
     * @param column column to rate
     * @return total column rating
     */
    public double rateColumn(Board board, int column) {
        double totalRating = 0.0;
        
        totalRating += board.getColumnHeights()[column];
        
        return totalRating;
    }
    
    /**
     * Method to count holes on board
     * @param board board to count holes on
     * @return double of hole count
     */
    public double countHoles(Board board) {
        double holeCount = 0.0;
        
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                Point point = new Point(i, j);
                Point nextPoint = new Point(i, j + 1);
                if (!board.hasBlockAt(point) && board.hasBlockAt(nextPoint)) {
                    holeCount++;
                }
            }
        }
        return holeCount;
    }
}
