// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Richard Nguyen (richardn03)
//-------------------------------------------------------------------------
/**
 *  Class to monitor all posts from Post class.
 *
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.27)
 */
public class PostMonitor
{
    //~ Fields ................................................................

    private int postCount;
    private int[] hourCounts;
    private int[] dayCounts;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created PostMonitor object.
     */
    public PostMonitor()
    {
        super();
        this.postCount = 0;
        this.hourCounts = new int[24];
        this.dayCounts = new int[7];
    }


    //~ Methods ...............................................................
    /**
     * Accessor for postCount field
     * @return postCount field
     */
    public int getPostCount() {
        return this.postCount;
    }
    
    /**
     * Accessor for hourCounts field
     * @return hourCounts array field
     */
    public int[] getHourCounts() {
        return this.hourCounts;
    }
    
    /**
     * Accessor for dayCounts field
     * @return dayCounts array field
     */
    public int[] getDayCounts() {
        return this.dayCounts;
    }
    
    /**
     * Method to record hour, day, and increment number of posts
     * @param p Post object to account for
     */
    public void recordPost(Post p) {
        this.hourCounts[p.getHour()] += 1;
        this.dayCounts[p.getDay()] += 1;
        this.postCount++;
    }
    
    /**
     * Method to find index of largest integer in parameter array
     * @param arr int array to iterate over
     * @return int of index of largest int in array
     */
    public int getIndexOfLargest(int[] arr) {
        int index = 0;
        int lValue = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] > lValue) {
                lValue = arr[i];
                index = i;
            }
            
        }
        
        return index;
    }
    
    /**
     * Method to return largest integer in hour array
     * @return largest hour in count hours array
     */
    public int getBusiestHour() {
        return this.getIndexOfLargest(this.hourCounts);
    }
    
    /**
     * Method to return largest integer in day array
     * @return largest day in count days array
     */
    public int getBusiestDay() {
        return this.getIndexOfLargest(this.dayCounts);
    }
    
    /**
     * Method to find index of lowest integer in parameter array
     * @param arr integer array to iterate through
     * @return index of smallest integer in array
     */
    public int getIndexOfSmallest(int[] arr) {
        int index = 0;
        int sValue = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] < sValue) {
                sValue = arr[i];
                index = i;
            }
            
        }
        
        return index;
    }
    
    /**
     * Method to return smallest integer in hour array
     * @return smallest hour in count hours array
     */
    public int getSlowestHour() {
        return this.getIndexOfSmallest(this.hourCounts);
    }
    
    /**
     * Method to return smallest integer in day array
     * @return smallest day in count days array
     */
    public int getSlowestDay() {
        return this.getIndexOfSmallest(this.dayCounts);
    }
}
