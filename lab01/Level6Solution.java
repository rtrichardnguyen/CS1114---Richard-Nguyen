import student.micro.lightbot.*;

//-------------------------------------------------------------------------
/**
 *  Level 6, together with its solution using a single Light-Bot.
 *
 * @author (Richard Nguyen)
 * @version (8/22/2022)
 */
public class Level6Solution
    extends Level6
{
    //~ Methods ...............................................................
    // ----------------------------------------------------------
    /**
     * Program to light 3 tiles for level six LightBot
     */
    public void myProgram()
    {
        LightBot jeremy = new LightBot();
        this.addObject(jeremy, 2, 6);
        

        jeremy.turnLeft(); //1st Tile to be lit
        jeremy.move();
        jeremy.jump();
        jeremy.jump();
        jeremy.turnRight();
        jeremy.jump();
        jeremy.jump();
        jeremy.turnLightOn();
          
        jeremy.jump(); //2nd Tile to be lit
        jeremy.turnRight();
        jeremy.move();
        jeremy.move();
        jeremy.move();
        jeremy.turnLightOn();
          
        jeremy.turnRight(); //3rd Tile to be lit
        jeremy.turnRight();
        
        for (int i = 0; i <= 5; i++) {
            
            jeremy.move();
        }
          
        jeremy.turnLightOn();
        

    
    }
}
