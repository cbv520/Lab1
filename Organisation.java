import java.io.*;

public abstract class Organisation implements Serializable
{
    private String name;
    private String contactName;
    private String contactEmail;
    
    Organisation(String inName, String inContactName, String inContactEmail)
    {
        if(inName == null || inContactName == null || inContactEmail == null)
        {
            throw new IllegalArgumentException("Invalid name");
        }
        
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
        if(inName == null || inName.equals(""))
        {
            throw new IllegalArgumentException("Invalid name");
        }
        
        name = inName;
    }
    
    public String getContactName()
    {
        return contactName;
    }
    
    public void setContactName(String inContactName)
    {
        if(inContactName == null)
        {
            throw new IllegalArgumentException("Invalid contact name");
        }
        
        contactName = inContactName;
    }
    
    public String getContactEmail()
    {
        return contactEmail;
    }
    
    public void setContactEmail(String inContactEmail)
    {
        if(inContactEmail == null || inContactEmail.equals(""))
        {
            throw new IllegalArgumentException("Invalid contact email");
        }
        
        contactEmail = inContactEmail;
    }
        
    abstract public void read();
}
