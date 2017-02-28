public class Association extends Organisation
{
    private String shortName;
    private String parent;
    private Club[] clubs;

    Association()
    {
        super("default","default","default");
        shortName = "default";
        parent = "default";
        clubs = null;
    }

    Association(String inName, String inShort, String inParent, String inContactName, String inContactEmail, Club[] inClubs)
    {
        super(inName, inContactName, inContactEmail);

        if(inShort == null || inParent == null || inClubs == null)
        {
            throw new IllegalArgumentException("invalid input");
        }
        if(inShort.equals("") || inParent.equals(""))
        {
            throw new IllegalArgumentException("invalid input");
        }

        shortName = inShort;
        parent = inParent;
        clubs = inClubs;
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

    public void read(String file, int row)
    {

    }
}
