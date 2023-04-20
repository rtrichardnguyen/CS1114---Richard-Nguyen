// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.micro.*;
import static org.assertj.core.api.Assertions.*;
//import student.IOHelper;
//import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 *  Class to test all methods in WeatherStation and WeatherBureau
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.12)
 */
public class WeatherStationTest
    extends TestCase
{
    //~ Fields ................................................................
    
    private WeatherStation uk;
    private WeatherBureau bureau;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeatherStationTest test object.
     */
    public WeatherStationTest()
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
        uk = new WeatherStation("UK00001298");
        bureau = new WeatherBureau();
    }


    // ----------------------------------------------------------
    /**
     * Method to test getId with new WeatherStation object
     */
    public void testGetId() {
        String str = uk.getId();
        
        assertThat(str).isEqualTo("UK00001298");
    }
    
    /**
     * Method to test recordDailyRain in February and 0.04 double
     */
    public void testRecordDailyRain() {
        uk.recordDailyRain(2, 0.04);
        
        assertThat(uk.getCountForMonth(2)).isEqualTo(1);
    }
    
    /**
     * Method to test recordDailyRain and getCountForMonth with
     * rainfall of 0.04 in month February
     */
    public void testGetCountForMonth() {
        
        uk.recordDailyRain(2, 0.04);
        
        assertThat(uk.getCountForMonth(2)).isEqualTo(0.04);
        
    }
    
    /**
     * Method to test getAvgForMonth with singular double
     */
    public void testGetAvgForMonth() {
        double ave = uk.getAvgForMonth(2);
        
        assertThat(uk.getAvgForMonth(2)).isEqualTo(0.04, within(0.001));
    }
    
    /**
     * Method to test getLowestMonth with only one value, expecting
     * first month
     */
    public void testGetLowestMonth() {
        int month = uk.getLowestMonth();
        
        assertThat(uk.getLowestMonth()).isEqualTo(1);
    }
    
    /**
     * Tests recordDailySummary with setIn string of one station
     */
    public void testRecordDailySummary() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line);
            
        double rain = bureau.getStation(uk.getId()).getCountForMonth(2);
        
        assertThat(rain).isEqualTo(1);
    }
    
    /**
     * Tests testRecordDailySummaries with string set in 
     * built in scanner
     */
    public void testRecordDailySummaries() {
        WeatherStation ke = new WeatherStation("KE000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        setIn(line);
        bureau.recordDailySummaries(in());
        
        assertThat(bureau.getStation("KE000063612")).isEqualTo(ke);
    }
    
    /**
     * Tests getStation with one weather station
     */
    public void testGetStation() {
        WeatherStation ke = new WeatherStation("KE000063612");
        WeatherStation ukk = new WeatherStation("UK000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        setIn(line);
        bureau.recordDailySummaries(in());
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        setIn(line1);
        
        assertThat(bureau.getStation("KE000064612")).isEqualTo(ke);
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStation() {
        WeatherStation ke = new WeatherStation("KE000063612");
        WeatherStation ukk = new WeatherStation("UK000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.02 87 98 73";
        setIn(line);
        bureau.recordDailySummaries(in());
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        setIn(line1);
        
        assertThat(bureau.lowestStation()).isEqualTo(ke);
    }
}
