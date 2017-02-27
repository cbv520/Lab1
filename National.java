public class National extends Organisation
{
    private String sport;
    private State[] states;
    
    National
    {
        super("default","default","default");
        sport = "default";
        states = null;
    }
    
    National(String inSport, String inName, String inContactName, String inContactEmail, State[] inStates)
    {
        super(inName, inContactName, inContactEmail);
        
        if(inSport == null || inSport.equals(""))
        {
            throw new IllegalArgumentException("Invalid sport");
        }
        if(inStates == null)
        {
            throw new IllegalArgumentException("invalid states");
        }
        
        sport = inSport;
        states = inStates;
    }
    
    National(National otherNational)
    {
        super(otherNational);
        sport = otherNational.getSport();
        states = otherNational.getStates();
    }
    
    public String getSport()
    {
        return sport;
    }
    
    public void setSport(String inSport)
    {
        if(inSport == null || inSport.equals(""))
        {
            throw new IllegalArgumentException("Invalid sport");
        } 
        
        sport = inSport;
    }
    
    public void read(String file, int row)
    {
        
    }
}