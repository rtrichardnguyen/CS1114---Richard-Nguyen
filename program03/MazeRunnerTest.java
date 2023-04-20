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
        island.addObject(new Net(), 10, 7);
        island.addObject(new Net(), 10, 1);
        
        runner.clearMaze();
        
        assertThat(runner.getX()).isEqualTo(1);
        assertThat(runner.getY()).isEqualTo(1);
        assertThat(island.countFlowers()).isEqualTo(0);
        assertThat(island.countNets()).isEqualTo(0);
        
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
    
}
