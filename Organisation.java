//Greetings from Cmder!

public class Organisation
{
    private String name;
    private String contactName;
    private String contactEmail;
    
    Organisation(String inName, String inContactName, String inContactEmail)
    {
        name = inName;
        contactName = inContactName;
        contactEmail = inContactEmail;
    }
    
    Organisation(Organisation otherOrg)
    {
        name = otherOrg.getName();
        contactName = otherOrg.getContactName();
        contactEmail = otherOrg.getContactEmail();
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String inName)
    {
        name = inName;
    }
    
    public String getContactName()
    {
        return contactName;
    }
    
    public void setContactName(String inContactName)
    {
        contactName = inContactName;
    }
    
    public String getContactEmail()
    {
        return contactEmail;
    }
    
    public void setContactEmail(String inContactEmail)
    {
        contactEmail = inContactEmail;
    }
    
}
