public class Team extends Organisation
{
    private String parent;
    
    Team(String inName, String inParent, String inContactName, String inContactEmail)
    {
        super(inName, inContactName, inContactEmail);
        
        if(inParent == null)
        {
            throw new IllegalArgumentException("invalid parent");
        }
        
        parent = inParent;
    }
    
    Team(Team otherTeam)
    {
        super(otherTeam);
        parent = otherTeam.getParent();
    }
    
    public String getParent()
    {
        return parent;
    }
    
    public void setParent(String inParent)
    {
        if(inParent == null || inParent.equals(""))
        {
            throw new IllegalArgumentException("invalid parent");
        }
        
        parent = inParent;
    }
    
    public void read()
    {
        
    }
}