
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
import student.micro.jeroo.*;
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  FloweCollector class for instance terry and jerooTest
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.19)
 */
public class FlowerCollector
    extends Jeroo
{
    //~ Fields ................................................................

    private List<Flower> basket;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created FlowerCollector object.
     */
    public FlowerCollector()
    {
        super();
        basket = new ArrayList<Flower>();
    }


    //~ Methods ...............................................................
    /**
     * Method that walks entire island and collects all the flowers
     */
    public void collectFlowers() {
        
        for (int x = 1; x < this.getWorld().getWidth() - 1; x++) {
            
            for (int y = 1; y < this.getWorld().getHeight() - 1; y++) {
                this.setLocation(x, y);
            
                if (this.seesFlower(HERE)) {
                    this.pick();
                }
            }
            
        }
        
    }
    
    /**
     * Accessor for basket field
     * @return basket ArrayList
     */
    public List<Flower> getBasket() {
        return this.basket;
    }
    
    /**
     * Overriden pick method
     */
    public void pick() {
        Flower flower = this.getOneIntersectingObject(Flower.class);
        flower.remove();
        this.getBasket().add(flower);
        
    }
}
