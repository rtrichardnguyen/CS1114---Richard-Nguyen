// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)
import java.util.*;
//-------------------------------------------------------------------------
/**
 *  Squad class to represent a list of units.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.20)
 */
public class Squad extends EnhancedUnit
{
    //~ Fields ................................................................

    private List<Unit> units;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Squad object.
     * @param n for squad name
     */
    public Squad(String n)
    {
        super(n, 0);
        this.units = new ArrayList<Unit>();
    }


    //~ Methods ...............................................................

    /**
     * Accessor to return list of units
     * @return units list
     */
    public List<Unit> getUnits() {
        
        return this.units;
        
    }
    
    /**
     * Mutator to add unit to list
     * @param u unit to add to list
     */
    public void addUnit(Unit u) {
        
        this.units.add(u);
        
    }
    
    /**
     * Mutator to remove unit from list
     * @param u unit to remove from list
     */
    public void removeUnit(Unit u) {
        
        for (int i = 0; i < this.getUnits().size(); i++) {
            
            if (this.getUnits().get(i).equals(u)) {
                this.units.remove(i);
            }
            
        }
        
    }
    
    /**
     * accessor for points field
     * @return points for points field
     */
    public int getPoints() {
        
        int sum = 0;
        
        for (int i = 0; i < this.getUnits().size(); i++) {
            
            sum += this.getUnits().get(i).getPoints();
            
        }
        
        return sum + super.getPoints();
        
    }
    
    /**
     * toString for Squad object
     * @return super string and list of Units
     */
    public String toString() {
        
        return super.toString() + " units:" +
            this.getUnits().toString();       
        
    }
}
