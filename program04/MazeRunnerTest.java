// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (906512730)

import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.micro.jeroo.*;
import static student.micro.jeroo.CompassDirection.*;
import static student.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  Class to test all MazeRunner methods.
 *
 *  @author Richard Nguyen (906512730)
 *  @version (2022.09.19)
 */
public class MazeRunnerTest
    extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // -------------------------------------------------------------

    /**
     * method to test clearMaze() on whole testing island
     */
    public void testClearMaze() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        island.addObject(new Flower(), 1, 1);
        island.addObject(new Flower(), 8, 6);
        island.addObject(new Flower(), 3, 1);
        island.addObject(new Net(), 10, 7);
        island.addObject(new Net(), 10, 1);
        island.addObject(new Net(), 1, 2);
        island.addObject(new Net(), 3, 1);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(island.countNets()).isEqualTo(0);
        assertThat(runner.seesWater(AHEAD)).isTrue();
        assertThat(runner.seesWater(RIGHT)).isTrue();
        
    }
    
    /**
     * method to test 2nd else if condition of clearMaze
     */
    public void testClearMaze2ndCondition() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        island.addObject(new Net(), 5, 2);
        runner.turn(RIGHT);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countNets()).isEqualTo(0);
    }
    
    /**
     * method to test while condition of clearMaze
     */
    public void testClearMazeCondition() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 9, 1);
        runner.turn(RIGHT);
        runner.turn(RIGHT);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
    }
    
    /**
     * method to test while condition of clearMaze
     */
    public void testClearMazeWhile() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 5, 1);
        island.addObject(new Net(), 5, 2);
        runner.turn(RIGHT);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countNets()).isEqualTo(0);
    }
    
    /**
     * method to test while condition of clearMaze in a deadEnd
     */
    public void testClearMazeWhileDeadEnd() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 5, 1);
        island.addObject(new Net(), 5, 2);
        runner.turn(LEFT);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countNets()).isEqualTo(0);
    }
    
    /**
     * method to test east path conditional in clearMaze()
     */
    public void testClearMazeEastConditional() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 3, 1);
        runner.turn(RIGHT);
        runner.turn(RIGHT);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        
    }
    
    /**
     * method to test conditional in clearMaze() with a south
     * only path
     */
    public void testClearMazeNetSouth() {
        
        Island island = new EastTestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        island.addObject(new Net(), 1, 2);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countNets()).isEqualTo(0);
        
    }
    
    /**
     * method to test net ahead conditional in clearMaze()
     */
    public void testClearMazeNetAhead() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 3);
        island.addObject(new Net(), 2, 3);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        
    }
    
    /**
     * method to test net clearMaze()
     */
    public void testClearMazeNet() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        island.addObject(new Net(), 1, 2);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countNets()).isEqualTo(0);
        
    }
    
    /**
     * method to test flower clearMaze()
     */
    public void testClearMazeFlower() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        island.addObject(new Flower(), 1, 2);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countFlowers()).isEqualTo(0);
        
    }
    
    /**
     * method to test keepRight() with runner needing to turn with
     * right shore
     */
    public void testKeepRight() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 8, 3);
        
        runner.keepRight();
        
        assertThat(runner.isFacing(SOUTH)).isTrue();
        assertThat(runner.getX()).isEqualTo(8);
        assertThat(runner.getY()).isEqualTo(3);
        
    }
    
    /**
     * method to test keepRight() with runner needing to turn with
     * right shore, with two paths it could take
     */
    public void testKeepRightTwoOptions() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 8, 3);
        
        runner.keepRight();
        
        assertThat(runner.isFacing(SOUTH)).isTrue();
        assertThat(runner.getX()).isEqualTo(8);
        assertThat(runner.getY()).isEqualTo(3);
        
    }
    
    /**
     * method to test deadEnd with runner needing to turn around
     */
    public void testDeadEnd() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 10, 5);
        runner.turn(RIGHT);
        
        runner.deadEnd();
        
        assertThat(runner.isFacing(NORTH)).isTrue();
        assertThat(runner.getX()).isEqualTo(10);
        assertThat(runner.getY()).isEqualTo(5);
        assertThat(runner.seesWater(RIGHT)).isTrue();
        assertThat(runner.seesWater(AHEAD)).isFalse();
        assertThat(runner.seesWater(LEFT)).isTrue();
        
    }
    
    /**
     * method to test dead end conditional failure
     */
    public void testDeadEndFailLeft() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 10, 1);
        runner.turn(LEFT);
        
        runner.deadEnd();
        
        assertThat(runner.getX()).isEqualTo(10);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(runner.isFacing(NORTH)).isTrue();
        assertThat(runner.seesWater(LEFT)).isFalse();
        
    }
    
    /**
     * method to test dead end conditional failure with all paths
     * open
     */
    public void testDeadEndFailAll() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 7, 3);
        runner.turn(LEFT);
        
        runner.deadEnd();
        
        assertThat(runner.getX()).isEqualTo(7);
        assertThat(runner.getY()).isEqualTo(3);
        assertThat(runner.isFacing(NORTH)).isTrue();
        assertThat(runner.seesWater(LEFT)).isFalse();
        assertThat(runner.seesWater(AHEAD)).isFalse();
        assertThat(runner.seesWater(RIGHT)).isFalse();
        
    }
    
    /**
     * method to test dead end conditional failure
     */
    public void testDeadEndFailRight() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 8, 3);
        
        runner.deadEnd();
        
        assertThat(runner.getX()).isEqualTo(8);
        assertThat(runner.getY()).isEqualTo(3);
        assertThat(runner.isFacing(EAST)).isTrue();
        assertThat(runner.seesWater(LEFT)).isTrue();
        
    }
    
    /**
     * method to test forceLeft with runner needing to turn left
     */
    public void testForceLeft() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        runner.turn(RIGHT);
        runner.turn(RIGHT);
        
        runner.forceLeft();
        
        assertThat(runner.isFacing(SOUTH)).isTrue();
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(runner.seesWater(RIGHT)).isTrue();
        assertThat(runner.seesWater(AHEAD)).isFalse();
        assertThat(runner.seesWater(LEFT)).isFalse();
        
    }
    
    /**
     * method to test dead end conditional failure for no path
     * ahead
     */
    public void testDeadEndFailAhead() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 3, 3);
        runner.turn(LEFT);
        
        runner.deadEnd();
        
        assertThat(runner.getX()).isEqualTo(3);
        assertThat(runner.getY()).isEqualTo(3);
        assertThat(runner.isFacing(NORTH)).isTrue();
        
    }
    
    /**
     * method to test forceLeft conditional failure
     */
    public void testForceLeftFail() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 5, 3);
        
        runner.forceLeft();
        
        assertThat(runner.isFacing(EAST)).isTrue();
        assertThat(runner.getX()).isEqualTo(5);
        assertThat(runner.getY()).isEqualTo(3);
        
    }
    
    /**
     * method to test forceLeft conditional failure
     */
    public void testForceLeftFailRight() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 8, 3);
        
        runner.forceLeft();
        
        assertThat(runner.isFacing(EAST)).isTrue();
        assertThat(runner.getX()).isEqualTo(8);
        assertThat(runner.getY()).isEqualTo(3);
        
    }
    
    /**
     * method to test pickFlower() with flower ahead of runner
     */
    public void testPickFlower() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 5, 3);
        island.addObject(new Flower(), 5, 3);
        
        runner.pickFlower();
        
        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(runner.getX()).isEqualTo(5);
        assertThat(runner.getY()).isEqualTo(3);
        
    }
    
    /**
     * method to test disableNet() with net ahead of runner
     */
    public void testDisableNet() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 4, 3);
        island.addObject(new Net(), 5, 3);
        
        runner.disableNet();
        
        assertThat(island.countNets()).isEqualTo(0);
        assertThat(runner.getX()).isEqualTo(4);
        assertThat(runner.getY()).isEqualTo(3);
        assertThat(runner.getFlowers()).isEqualTo(9);
        
    }
    
    /**
     * method to test disableNet() with two nets ahead of runner
     */
    public void testDisableNetTwice() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 4, 3);
        island.addObject(new Net(), 5, 3);
        island.addObject(new Net(), 6, 3);
        
        runner.disableNet();
        runner.hop();
        runner.disableNet();
        
        assertThat(island.countNets()).isEqualTo(0);
        assertThat(runner.getFlowers()).isEqualTo(8);
        assertThat(runner.getX()).isEqualTo(5);
        assertThat(runner.getY()).isEqualTo(3);
        
    }
    
    /**
     * method to test clearMaze() with only east path
     */
    public void testClearMazeEast() {
        
        Island island = new EastTestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        island.addObject(new Flower(), 1, 1);
        island.addObject(new Flower(), 8, 6);
        island.addObject(new Net(), 10, 7);
        island.addObject(new Net(), 10, 1);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(island.countNets()).isEqualTo(0);
    }
    
    /**
     * method to test clearSecondPath()
     */
    public void testClearSecondPath() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 1);
        runner.turn(LEFT);
        
        runner.clearSecondPath();
        
        assertThat(runner.isFacing(EAST)).isTrue();
        assertThat(runner.getX()).isEqualTo(2);
        assertThat(runner.getY()).isEqualTo(1);
        
    }
    
    /**
     * method to test conditional failure of clearSecondPath()
     */
    public void testClearSecondPathFail() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 5, 3);
        
        runner.clearSecondPath();
        
        assertThat(runner.isFacing(EAST)).isTrue();
        assertThat(runner.getX()).isEqualTo(5);
        assertThat(runner.getY()).isEqualTo(3);
    }
    
    /**
     * method to test conditional failure of clearSecondPath()
     * with different x value
     */
    public void testClearSecondPathFailX() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 10, 1);
        
        runner.clearSecondPath();
        
        assertThat(runner.isFacing(EAST)).isTrue();
        assertThat(runner.getX()).isEqualTo(10);
        assertThat(runner.getY()).isEqualTo(1);
    }
    
    /**
     * method to test conditional failure of clearSecondPath()
     * with different y value
     */
    public void testClearSecondPathFailY() {
        
        Island island = new TestingIsland();
        MazeRunner runner = new MazeRunner();
        island.addObject(runner, 1, 7);
        
        runner.clearSecondPath();
        
        assertThat(runner.isFacing(EAST)).isTrue();
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(7);
    }

}
