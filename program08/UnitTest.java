// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Your Name (richardn03)

import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Test class that tests all accessors and mutators in Unit class
 *  using 5 new objects.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.17)
 */
public class UnitTest
    extends TestCase
{
    //~ Fields ................................................................
    private Unit lancelot;
    private EnhancedUnit gawain;
    private Hero geraint;
    private Monster percival;
    private Squad knights;
    private Army roundTableKnights;
    private Upgrade sword;
    private Upgrade spear;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new UnitTest test object.
     */
    public UnitTest()
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
        lancelot = new Unit("Lancelot", 5);
        gawain = new EnhancedUnit("Gawain", 5);
        geraint = new Hero("Geraint", 5);
        percival = new Monster("Percival", 5);
        knights = new Squad("knights");
        roundTableKnights = new Army("roundTableKnights", 
            "richyFighters", "Richard Nguyen");
        sword = new Upgrade("Sword", 5);
        spear = new Upgrade("Spear", 5);
    }


    // ----------------------------------------------------------
    /**
     * Method to test setName with new name for lancelot
     */
    public void testSetName() {
        
        lancelot.setName("arthur");
        
        assertThat(lancelot.getName()).isEqualTo("arthur");
        
    }
    
    /**
     * Method to test getName with lancelot object
     */
    public void testGetName() {
        
        String str = lancelot.getName();
        
        assertThat(str).isEqualTo("Lancelot");
        
    }
    
    /**
     * Method to test setPoints() with new 10 integer
     */
    public void testSetPoints() {
        
        gawain.setPoints(10);
        
        assertThat(gawain.getPoints()).isEqualTo(10);
        
    }
    
    /**
     * Method to test getPoints() with gawain object
     */
    public void testGetPoints() {
        
        int n = gawain.getPoints();
        
        assertThat(n).isEqualTo(5);
        
    }
    
    /**
     * Method to test setQuality() with new 10 integer
     */
    public void testSetQuality() {
        
        geraint.setQuality(10);
        
        assertThat(geraint.getQuality()).isEqualTo(10);
        
    }
    
    /**
     * Method to test getQuality() with geraint object
     */
    public void testGetQuality() {
        
        int n = geraint.getQuality();
        
        assertThat(n).isEqualTo(5);
        
    }
    
    /**
     * Method to test setDefense() with new 10 integer
     */
    public void testSetDefense() {
        
        percival.setQuality(10);
        
        assertThat(percival.getQuality()).isEqualTo(10);
        
    }
    
    /**
     * Method to test getDefense with percival object
     */
    public void testGetDefense() {
        
        int n = percival.getQuality();
        
        assertThat(n).isEqualTo(4);
        
    }
    
    /**
     * Method to test addUnit with squad field
     */
    public void testAddUnit() {
        
        knights.addUnit(lancelot);
        knights.addUnit(gawain);
        knights.addUnit(geraint);
        knights.addUnit(percival);
        
        assertThat(knights.getUnits().size()).isEqualTo(4);
        
    }
    
    /**
     * Method to test removeUnit with squad field
     */
    public void testRemoveUnit() {
        
        knights.addUnit(lancelot);
        knights.addUnit(gawain);
        knights.addUnit(geraint);
        knights.addUnit(percival);
        knights.removeUnit(geraint);
        
        assertThat(knights.getUnits().size()).isEqualTo(3);
        
    }
    
    /**
     * Method to test setPlayerName() with army field
     */
    public void testSetPlayerName() {
        
        roundTableKnights.setPlayerName("Richy Nguyen");
        
        assertThat(roundTableKnights.getPlayerName())
            .isEqualTo("Richy Nguyen");
        
    }
    
    /**
     * Method to test setFaction() with army field
     */
    public void testSetFaction() {
        
        roundTableKnights.setFaction("richFighters");
        
        assertThat(roundTableKnights.getFaction())
            .isEqualTo("richFighters");
        
    }
    
    /**
     * Method to test add and remove upgrades on upgrades list
     */
    public void testAddUpgrade() {
        Upgrade stick = new Upgrade("Stick", 5);
        lancelot.addUpgrade(sword);
        lancelot.addUpgrade(spear);
        lancelot.removeUpgrade(sword);
        lancelot.removeUpgrade(stick);
        
        assertThat(lancelot.getUpgrades().size()).isEqualTo(1);
        assertThat(lancelot.getPoints()).isEqualTo(10);
        
    }
    
    /**
     * Method to test toString() with field lancelot
     */
    public void testToString() {
        
        gawain.addUpgrade(sword);
        gawain.setSpecialRule("Squad Heal");
        knights.addUnit(gawain);
        String str = knights.toString();
        
        assertThat(str).isEqualTo("knights (10, 2, 2) units:[Gawain " +
            "(10, 2, 2) upgrades:[Sword (5)] special rule:[Squad Heal]]");
        
    }
    
    /**
     * Method to test toString() with enhanced unit
     */
    public void testToStringEU() {
        
        gawain.addUpgrade(sword);
        knights.addUnit(gawain);
        String str = knights.toString();
        
        assertThat(str).isEqualTo("knights (10, 2, 2) units:[Gawain " +
            "(10, 2, 2) upgrades:[Sword (5)]]");
        
    }
    
    /**
     * Method to test toString() with enhanced unit
     */
    public void testToStringArmy() {
        
        gawain.addUpgrade(sword);
        knights.addUnit(gawain);
        String str = roundTableKnights.toString();
        
        assertThat(str).isEqualTo("player:Richard Nguyen, " +
            "faction:richyFighters, army:roundTableKnights " +
            "(0, 2, 2) units:[]");
        
    }
}
