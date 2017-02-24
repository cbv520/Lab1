public class National extends Organisation
{
    private String sport;
    
    National(String inSport, String inName, String inContactName, String inContactEmail)
    {
        super(inName, inContactName, inContactEmail);
        
        if(inSport == null || inSport.equals(""))
        {
            throw new IllegalArgumentException("Invalid sport");
        }    
        
        sport = inSport;
    }
    
    National(National otherNational)
    {
        super(otherNational);
        sport = otherNational.getSport();
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
    
    public void read()
    {
        
    }
}