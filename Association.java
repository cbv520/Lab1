public class Association extends Organisation
{
    private String shortName;
    private String parent;
    
    Association(String inName, String inShort, String inParent, String inContactName, String inContactEmail)
    {
        super(inName, inContactName, inContactEmail);
        
        if(inShort == null || inParent == null)
        {
            throw new IllegalArgumentException("invalid input");
        }
        
        shortName = inShort;
        parent = inParent;
    }
    
    Association(Association otherAssociation)
    {
        super(otherAssociation);
        shortName = otherAssociation.getShort();
        parent = otherAssociation.getParent();
    }
    
    public String getShort()
    {
        return shortName;
    }
    
    public void setShort(String inShort)
    {
        if(inShort == null || inShort.equals(""))
        {
            throw new IllegalArgumentException("invalid short");
        }
        
        shortName = inShort;
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