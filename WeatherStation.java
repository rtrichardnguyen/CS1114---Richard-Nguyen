
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  This class represents the basic statistics collected by
 *  one weather observation station.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.12)
 */
public class WeatherStation
{
    //~ Fields ................................................................
    
    private double[] monthlyRainTotal;
    private int[] dailyRecordsCount;
    private String identifier;
    
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created WeatherStation object.
     * @param id for station identification
     */
    public WeatherStation(String id)
    {
        
        super();
        this.identifier = id;
        monthlyRainTotal = new double[12];
        dailyRecordsCount = new int[12];
        
    }


    //~ Methods ...............................................................
    /**
     * Accessor for station id
     * @return station id
     */
    public String getId() {
        return this.identifier;
    }
    
    /**
     * Records the information from one daily summary line in a
     * data file, which adds the rainfall to the month.
     * @param month which month to view
     * @param rainfall added to the month element
     */
    public void recordDailyRain(int month, double rainfall) {

        this.monthlyRainTotal[month - 1] += rainfall;
        
        this.dailyRecordsCount[month - 1]++;
        
    }
    
    /**
     * Returns the number of daily rainfall values that have
     * been recorded for the specified month.
     * @param month for specified month
     * @return count in specified month
     */
    public int getCountForMonth(int month) {
        return this.dailyRecordsCount[month - 1];
    }
    
    /**
     * Returns the average daily rainfall for the specified month
     * @param month for specified month
     * @return average of rainfall for month
     */
    public double getAvgForMonth(int month) {
        if (this.dailyRecordsCount[month - 1] == 0) {
            return -1;
        } 
        else {
            return this.monthlyRainTotal[month - 1] / 
            this.dailyRecordsCount[month - 1];
        }
    }
    
    /**
     * Returns the number of the month indicating the month
     * that had the lowest average rainfall recorded at this 
     * station
     * @return month with lowest average
     */
    public int getLowestMonth() {
        double low = 9999.9;
        int index = 1;
        
        for (int i = 1; i < 13; i++) {
            if (this.getAvgForMonth(i) != -1 
                && this.getAvgForMonth(i) < low) {
                low = this.getAvgForMonth(i);
                index = i;
            }
        }
        
        return index;
    }
}
