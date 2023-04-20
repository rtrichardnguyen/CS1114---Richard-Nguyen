
import java.util.*;

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

    private Map<String, WeatherStation> map;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created WeatherBureau object.
     */
    public WeatherBureau()
    {
        super();
        map = new HashMap<String, WeatherStation>();
    }


    //~ Methods ...............................................................
    /**
     * Takes a single string representing a single one-line daily
     * weather summary for one day at one weather station.
     * @param text single string of weather data for specific day
     */
    public void recordDailySummary(String text) {
        String dateS = "";
        String rain = "";
        double rainM = 0.0;
        int dateM = 0;
        
        Scanner scanner = new Scanner(text);
        
        String localID = scanner.next();
        for (int i = 0; i < 4; i++) {
            dateS = scanner.next();
        }
        rain = scanner.next();
        
        String[] date = dateS.split("/");
        dateM = Integer.parseInt(date[0]);
        rainM = Double.parseDouble(rain);
        
        if (rainM != -1 && map.containsKey(localID)) {
            
            map.get(localID).recordDailyRain(dateM, rainM);
            
        }    
        else if (rainM != -1 && !map.containsKey(localID)) {
            
            WeatherStation newStation = new WeatherStation(localID);
            newStation.recordDailyRain(dateM, rainM);
            map.put(localID, newStation);
            
        }
    }
    
    /**
     * Takes a Scanner object as a parameter that represents
     * an input data source, such as a file containing a series
     * of daily summary records for one or more weather stations
     * and records rainfall for corresponding station.
     * @param input scanner for scanning data source
     */
    public void recordDailySummaries(Scanner input) {
        while (input.hasNextLine()) {
            this.recordDailySummary(input.nextLine());
        }
    }
    
    /**
     * Return the weather station object for the given weather station
     * ID
     * @param identifier to return object by id
     * @return specified station
     */
    public WeatherStation getStation(String identifier) {
        return map.get(identifier);
    }
    
    /**
     * Returns the weather station that has the lowest average
     * rainfall recorded for any month.
     * @return station with lowest average
     */
    public WeatherStation lowestStation() {
        if (!map.isEmpty()) {
            String stationID = "";
            double low = 9999.9;
            for (String id : map.keySet()) {
                if (map.get(id).getAvgForMonth(map.get(id).getLowestMonth()) 
                    < low) {
                    low = map.get(id)
                        .getAvgForMonth(map.get(id).getLowestMonth());
                    stationID = id;
                }
            }
            return map.get(stationID);
        }
        return null;
    }
    
    /**
     * Returns the weather station that has the lowest average
     * rainfall recorded for specified month.
     * @param month month of station
     * @return station with lowest average
     */
    public WeatherStation lowestStation(int month) {
        if (!map.isEmpty()) {
            String stationID = "";
            double low = 9999.9;
        
            for (String localID : map.keySet()) {
                
                if (map.get(localID).getAvgForMonth(month) < low
                    && map.get(localID).getAvgForMonth(month) != -1) {
                    low = map.get(localID).getAvgForMonth(month);
                    stationID = localID;
                }
                
            }
            return map.get(stationID);
        }
        return null;
    }
}
