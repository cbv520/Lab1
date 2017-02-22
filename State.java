public class State extends Organisation
{
    private String parent;
    
    State(String inName, String inParent, String inContactName, String inContactEmail)
    {
        super(inName, inContactName, inContactEmail);
        parent = inParent;
    }
    
    State(State otherState)
    {
        super(otherState);
        parent = otherState.getParent();
    }
    
    public String getParent()
    {
        return parent;
    }
    
    public void setParent(String inParent)
    {
        parent = inParent;
    }
    
    
}