// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)

import student.micro.*;
import static org.assertj.core.api.Assertions.*;

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
        
        assertThat(uk.getCountForMonth(2)).isEqualTo(1);
        
    }
    
    /**
     * Method to test getAvgForMonth with singular double
     */
    public void testGetAvgForMonth() {
        uk.recordDailyRain(2, 0.04);
        double ave = uk.getAvgForMonth(2);
        
        assertThat(ave).isEqualTo(0.04, within(0.001));
    }
    
    /**
     * Method to test getLowestMonth with only one value, expecting
     * first month
     */
    public void testGetLowestMonth() {
        int month = uk.getLowestMonth();
        
        assertThat(month).isEqualTo(1);
    }
    
    /**
     * Method to test getLowestMonth with only one value, expecting
     * first month
     */
    public void testGetLowestMonth1() {
        uk.recordDailyRain(1, 2.0);
        int month = uk.getLowestMonth();
        
        assertThat(month).isEqualTo(1);
    }
    
    /**
     * Method to test getLowestMonth with only one value, expecting
     * first month
     */
    public void testGetLowestMonth2() {
        uk.recordDailyRain(1, 2.0);
        uk.recordDailyRain(2, 1.0);
        int month = uk.getLowestMonth();
        
        assertThat(month).isEqualTo(2);
    }
    
    /**
     * Method to test getLowestMonth with only one value, expecting
     * first month
     */
    public void testGetLowestMonth3() {
        uk.recordDailyRain(1, 2.0);
        uk.recordDailyRain(2, 1.0);
        uk.recordDailyRain(4, 0.5);
        uk.recordDailyRain(5, 3.0);
        int month = uk.getLowestMonth();
        
        assertThat(month).isEqualTo(4);
    }
    
    /**
     * Tests recordDailySummary with setIn string of one station
     */
    public void testRecordDailySummary() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line);
            
        int rain = bureau.getStation("KE000063612").getCountForMonth(2);
        
        assertThat(rain).isEqualTo(1);
    }
    
    /**
     * Tests recordDailySummary with setIn string of one station
     */
    public void testRecordDailySummaryNew() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line);
        String line1 = "KE000063612 3.117 35.617 515 2/11/16 0.08 87 98 73";
        bureau.recordDailySummary(line1);
        int rain = bureau.getStation("KE000063612").getCountForMonth(2);
        
        assertThat(rain).isEqualTo(2);
    }
    
    /**
     * Tests recordDailySummary with setIn string of one station
     */
    public void testRecordDailySummaryDead() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 -1.0 87 98 73";
        bureau.recordDailySummary(line);
        
        assertThat(bureau.getStation("KE000063612")).isNull();
    }
    
    /**
     * Tests recordDailySummary with setIn string of one station
     */
    public void testRecordDailySummaryDead1() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 1.0 87 98 73";
        bureau.recordDailySummary(line);
        
        String line1 = "KE000063612 3.117 35.617 515 2/10/16 -1.0 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.getStation("KE000063612")
            .getCountForMonth(2)).isEqualTo(1);
    }
    
    /**
     * Tests recordDailySummary with setIn string of one station
     */
    public void testRecordDailySummaryDeadDIff() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 1.0 87 98 73";
        bureau.recordDailySummary(line);
        
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 1.0 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.getStation("KE000063612")
            .getCountForMonth(2)).isEqualTo(1);
        assertThat(bureau.getStation("UK000063612")
            .getCountForMonth(2)).isEqualTo(1);
    }
    
    /**
     * Tests recordDailySummary with setIn string of one station
     */
    public void testRecordDailySummaryDeadD() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 -1.0 87 98 73";
        bureau.recordDailySummary(line);
        
        String lin = "KE000063612 3.117 35.617 515 2/10/16 1.0 87 98 73";
        bureau.recordDailySummary(lin);
        
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 1.0 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.getStation("KE000063612")
            .getCountForMonth(2)).isEqualTo(1);
        assertThat(bureau.getStation("UK000063612")
            .getCountForMonth(2)).isEqualTo(1);
    }
    
    /**
     * Tests testRecordDailySummaries with string set in 
     * built in scanner
     */
    public void testRecordDailySummaries() {
        WeatherStation ke = new WeatherStation("KE000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        String line2 = "KE000063612 3.117 35.617 515 2/9/16 0.08 87 98 73";
        setIn(line);
        bureau.recordDailySummaries(in());
        
        assertThat(ke.getId()).isEqualTo("KE000063612");
        assertThat(ke.getCountForMonth(2)).isEqualTo(0);
    }
    
    /**
     * Tests getStation with one weather station
     */
    public void testGetStation() {
        WeatherStation ke = new WeatherStation("KE000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        setIn(line);
        bureau.recordDailySummaries(in());
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        setIn(line1);
        boolean test = ke.equals(bureau.getStation("KE000064612"));
        assertThat(test).isFalse();
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStation() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.02 87 98 73";
        bureau.recordDailySummary(line);
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.lowestStation().getId()).isEqualTo("KE000063612");
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStationD() {
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line);
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 0.02 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.lowestStation().getId()).isEqualTo("UK000063612");
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStationDead() {
        assertThat(bureau.lowestStation()).isNull();
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStationDead1() {
        assertThat(bureau.lowestStation(0)).isNull();
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStation2() {
        //WeatherStation ke = new WeatherStation("KE000063612");
        //WeatherStation ukk = new WeatherStation("UK000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.02 87 98 73";
        bureau.recordDailySummary(line);
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.lowestStation(2).getId()).isEqualTo("KE000063612");
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStation3() {
        //WeatherStation ke = new WeatherStation("KE000063612");
        //WeatherStation ukk = new WeatherStation("UK000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 0.02 87 98 73";
        bureau.recordDailySummary(line);
        String line1 = "UK000063612 3.117 35.617 515 2/20/16 0.04 87 98 73";
        bureau.recordDailySummary(line1);
        String line2 = "VT000063612 3.117 35.617 515 2/30/16 0.01 87 98 73";
        bureau.recordDailySummary(line2);
        
        assertThat(bureau.lowestStation(2).getId()).isEqualTo("VT000063612");
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStation4() {
        //WeatherStation ke = new WeatherStation("KE000063612");
        //WeatherStation ukk = new WeatherStation("UK000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 -1 87 98 73";
        bureau.recordDailySummary(line);
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 0.04 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.lowestStation(2).getId()).isEqualTo("UK000063612");
    }
    
    /**
     * Tests lowestStation with two weather stations differing in
     * rain
     */
    public void testLowestStation5() {
        //WeatherStation ke = new WeatherStation("KE000063612");
        //WeatherStation ukk = new WeatherStation("UK000063612");
        String line = "KE000063612 3.117 35.617 515 2/10/16 1 87 98 73";
        bureau.recordDailySummary(line);
        String line1 = "UK000063612 3.117 35.617 515 2/10/16 -1 87 98 73";
        bureau.recordDailySummary(line1);
        
        assertThat(bureau.lowestStation(2).getId()).isEqualTo("KE000063612");
    }
}
