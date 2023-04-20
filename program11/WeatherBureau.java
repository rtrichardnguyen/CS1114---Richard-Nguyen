import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  This class represents a weather service that keeps track
 *  of all the weather stations.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.11.12)
 */
public class WeatherBureau
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created WeatherBureau object.
     */
    public WeatherBureau()
    {
        super();
        
    }


    //~ Methods ...............................................................
    /**
     * Takes a single string representing a single one-line daily
     * weather summary for one day at one weather station.
     * @param text single string of weather data for specific day
     */
    public void recordDailySummary(String text) {
        //adjusts arrays in WeatherStation object and 
        //creates a new one of station ID does not exist
    }
    
    /**
     * Takes a Scanner object as a parameter that represents
     * an input data source, such as a file containing a series
     * of daily summary records for one or more weather stations
     * and records rainfall for corresponding station.
     * @param input scanner for scanning data source
     */
    public void recordDailySummaries(Scanner input) {
        //record correspoinding rainfall into month array, and update
        //dailyRecord array, ignore if -1
    }
    
    /**
     * Return the weather station object for the given weather station
     * ID
     * @param identifier to return object by id
     * @return specified station
     */
    public WeatherStation getStation(String identifier) {
        //loop over WeatherStation and return with matching
        //identifier and station id
        return null;
    }
    
    /**
     * Returns the weather station that has the lowest average
     * rainfall recorded for any month.
     * @return station with lowest average
     */
    public WeatherStation lowestStation() {
        //loop over weather stations and return object with 
        //lowest stored stored average
        return null;
    }
    
    /**
     * Returns the weather station that has the lowest average
     * rainfall recorded for any month.
     * @param n month
     * @return station with lowest average
     */
    public WeatherStation lowestStation(int n) {
        //loop over weather stations and return object with 
        //lowest stored stored average
        return null;
    }
}
