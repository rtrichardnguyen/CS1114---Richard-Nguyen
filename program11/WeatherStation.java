//import java.util.Scanner;
//import student.IOHelper;

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
    /*
    private double[] monthlyRain;
    private int[] dailyRecords;
    private String identifier;
    */
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created WeatherStation object.
     * @param id for station identification
     */
    public WeatherStation(String id)
    {
        /*
        super();
        this.identifier = id;
        monthlyRain = new double[12];
        dailyRecords = new int[12];
        */
    }


    //~ Methods ...............................................................
    /**
     * Accessor for station id
     * @return station id
     */
    public String getId() {
        //return identifier field
        
        //return this.identifier;
        return "";
    }
    
    /**
     * Records the information from one daily summary line in a
     * data file, which adds the rainfall to the month.
     * @param month which month to view
     * @param rainfall added to the month element
     */
    public void recordDailyRain(int month, double rainfall) {
        //scans from input file, retrieves rain double and adds
        //to month array
        
        /*
        Scanner scanner = IOHelper.createScanner("input.txt");
        double rain = 0.0;
        for (int i = 0; i < 9; i++) {
            rain = scanner.nextDouble();
        }
        
        this.monthlyRain[month - 1] = this.monthlyRain[month - 1] +
            rain;
        
        this.dailyRecords[month - 1]++;
        */
    }
    
    /**
     * Returns the number of daily rainfall values that have
     * been recorded for the specified month.
     * @param month for specified month
     * @return count in specified month
     */
    public int getCountForMonth(int month) {
        //return dailyRecords element for given month
        
        //return this.dailyRecords[month - 1];
        return -1;
    }
    
    /**
     * Returns the average daily rainfall for the specified month
     * @param month for specified month
     * @return average of rainfall for month
     */
    public double getAvgForMonth(int month) {
        //returns monthly rain month element and divides by daily
        //records identical element to find average of that one
        //month
        
        /*
        return this.monthlyRain[month - 1] / 
            (double)this.dailyRecords[month - 1];
            */
        return -1.0;
    }
    
    /**
     * Returns the number of the month indicating the month
     * that had the lowest average rainfall recorded at this 
     * station
     * @return month with lowest average
     */
    public int getLowestMonth() {
        //loops through all months and returns the one with lowest
        //value from getAvgForMonth()
        
        /*
        double lowest = this.getAvgForMonth(1);
        int index = 0;
        for (int i = 1; i < 13; i++) {
            if (getAvgForMonth(i) < lowest) {
                lowest = getAvgForMonth(i);
                index = i;
            }
        }
        
        return index;
        */
        return -1;
    }
}
