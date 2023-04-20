
//-------------------------------------------------------------------------
/**
 *  Army class to represent player profile.
 *  
 *  @author Richard Nguyen (richardn03)
 *  @version (2022.10.20)
 */
public class Army extends Squad
{
    //~ Fields ................................................................

    private String playerName;
    private String faction;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created Army object.
     * @param n army name
     * @param f faction name
     * @param pn player name
     */
    public Army(String n, String f, String pn)
    {
        super(n);
        this.faction = f;
        this.playerName = pn;
    }


    //~ Methods ...............................................................

    /**
     * mutator for playerName field
     * @param str for playerName
     */
    public void setPlayerName(String str) {
        
        this.playerName = str;
        
    }
    
    /**
     * accessor for playerName field
     * @return playerName for playerName field
     */
    public String getPlayerName() {
        
        return this.playerName;
        
    }
    
    /**
     * mutator for faction field
     * @param str for faction
     */
    public void setFaction(String str) {
        
        this.faction = str;
        
    }
    
    /**
     * accessor for faction field
     * @return faction for faction field
     */
    public String getFaction() {
        
        return this.faction;
        
    }
    
    /**
     * toString for Army object
     * @return super string and list of Units
     */
    public String toString() {
        
        return "player:" + this.getPlayerName().toString() + 
            ", faction:" + this.getFaction().toString() + 
            ", army:" + super.toString();       
        
    }
}
