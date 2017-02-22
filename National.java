public class National extends Organisation
{
    private String sport;
    
    National(String inName, String inContactName, String inContactEmail, String inSport)
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
        sport = otherNational.getSoprt();
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
}