public class Player
{
    private String name;
    private String club;
    private String email;
    
    Player(String inName, String inClub, String inEmail)
    {
        if(inName == null || inClub == null || inEmail == null)
        {
            throw new IllegalArgumentException("invalid input");
        }
        
        name = inName;
        club = inClub;
        email = inEmail;
    }
    
    Player(Player otherPlayer)
    {
        name = otherPlayer.getName();
        club = otherPlayer.getClub();
        email = otherPlayer.getEmail();
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String inName)
    {
        if(inName == null || inName.equals(""))
        {
            throw new IllegalArgumentException("invalid name");
        }
        
        name = inName;
    }

    public String getClub()
    {
        return club;
    }
    
    public void setClub(String inClub)
    {
        if(inClub == null || inClub.equals(""))
        {
            throw new IllegalArgumentException("invalid club");
        }
        
        club = inClub;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String inEmail)
    {
        if(inEmail == null || inEmail.equals(""))
        {
            throw new IllegalArgumentException("invalid email");
        }
        
        email = inEmail;
    }
    
    public void read()
    {
        
    }
}