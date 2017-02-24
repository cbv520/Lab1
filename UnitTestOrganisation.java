public class UnitTestOrganisation
{
    public static void main(String args[])
    {
        int numPassed = 0;
        int numTests = 0;
        Organisation organisation;
        String name;
        String contactName;
        String contactEmail;
        
        try
        {
            System.out.println("Testing normal conditions");
            name = "Test";
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal argument: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }
    }
}