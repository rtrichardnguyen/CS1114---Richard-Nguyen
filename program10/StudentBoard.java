// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.tetris2.*;
//-------------------------------------------------------------------------
/**
 *  Class that implements Board interface.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.02)
 */
public class StudentBoard implements Board
{
    //~ Fields ................................................................
    private int width;
    private int height;
    private int[] columnHeights;
    private int[] blocksInAllRows;
    private boolean[][] grid;
    
    /**
     * @field PLACE_OK for good placement
     */
    public static final int PLACE_OK = 0;
    /**
     * @field PLACE_ROW_FILLED filled with good placement
     */
    public static final int PLACE_ROW_FILLED = 1;
    /**
     * @field PLACE_OUT_BOUNDS placed out of with or height of 
     * board
     */
    public static final int PLACE_OUT_BOUNDS = 2;
    /**
     * @field PLACE_BAD not placed
     */
    public static final int PLACE_BAD = 3;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created StudentBoard object.
     * @param w board width
     * @param h board height
     */
    public StudentBoard(int w, int h)
    {
        super();
        this.width = w;
        this.height = h;
        columnHeights = new int[w];
        blocksInAllRows = new int[h];
        grid = new boolean[h][w];
    }


    //~ Methods ...............................................................
    /**
     * Getter for width
     * 
     * @return width field
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Getter for height
     * 
     * @return height field
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
     * Getter for columnHeight
     * 
     * @return columnHeight array field
     */
    public int[] getColumnHeights() {
        return this.columnHeights;
    }
    
    /**
     * Getter for blocksInAllRows
     * 
     * @return blocksInAllRows field
     */
    public int[] getBlocksInAllRows() {
        return this.blocksInAllRows;
    }
    
    /**
     * Returns true if the given block is filled in the board.
     * Blocks outside of the valid width/height area
     * always return true.
     * 
     * @param point The location to check
     * @return True if there is a block at the specified (x, y) pos
     */
    public boolean hasBlockAt(Point point) {     
        
        return this.grid[point.getY()][point.getX()];
        
    }

    /**
     * Tries to add body of given piece to board and returns int
     * constants
     * 
     * @param piece piece to place
     * @param location location on board
     * @return int constant result of place
     */
    public int place(Piece piece, Point location) {
        Point[] arr = piece.getBody();
        
        for (int i = 0; i < piece.getBody().length; i++) {
            Point point = new Point(arr[i].getX() +
                location.getX(), arr[i].getY() + location.getY());
            
            if (arr[i].getY() + location.getY() > this.getHeight() - 1 ||
                arr[i].getX() + location.getX() > this.getWidth() - 1) {
                return Board.PLACE_OUT_BOUNDS;
            }
            else if (this.hasBlockAt(point)) {
                return Board.PLACE_BAD;
            }
            else {
                this.grid[point.getY()][point.getX()] = true;
                this.blocksInAllRows[point.getY()]++;
            }
            
            if (point.getY() > this.columnHeights[point.getX()] - 1) {
                this.columnHeights[point.getX()] = point.getY() + 1;
            }
            
        }
        
        for (int j = 0; j < this.getHeight(); j++) {
            if (this.blocksInAllRows[j] == this.getWidth()) {
                return Board.PLACE_ROW_FILLED;
            }
        }
        
        return Board.PLACE_OK;
    }
    
    /**
     * Deletes rows that are completely filled, moving everything
     * above down, returns true if rows was cleared
     * 
     * @return True if rows were cleared
     */
    public boolean clearRows() {
        int trueCount = 0;
        boolean rowFilled = false;
        //boolean[] arr = new boolean[this.getWidth()];
        
        for (int i = this.getHeight() - 1; i >= 0; i--) {
     
            if (this.blocksInAllRows[this.getHeight() - 1 - i]
                == this.getWidth()) {
                
                for (int j = i; j >= 0; j--) {
                    this.grid[i] = this.grid[i - 1];
                    this.grid[0] = new boolean[this.getWidth()];
                }
                rowFilled = true;
            }

        }
        /*
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.blocksInAllRows[i] = 0;
                this.columnHeights[j] = 0;
                if (this.grid[i][j]) {
                    this.blocksInAllRows[i]++;
                }
            }
        }
           */     
        return rowFilled;
    }
    
    /**
     * Getter for grid
     * 
     * @return grid field
     */
    public boolean[][] getGrid() {
        return this.grid;
    }
}
