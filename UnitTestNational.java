public class UnitTestNational
{
    public static void main(String args[])
    {
        int numPassed = 0;
        int numTests = 0;
        National national;
        String sport;
        String name;
        String contactName;
        String contactEmail;
        
        try
        {
            System.out.println("Testing normal conditions");
            sport = "Test Sport";
            name = "Test Name";
            contactName = "Test ContactName";
            contactEmail = "testemail@testdomain.com";
            
            System.out.println("Testing constructor");
            numTests++;
            national = new National(sport, name, contactName, contactEmail);
            System.out.println("passed");
            numPassed++;
            
            System.out.println("Testing getSport()");
            numTests++;
            if(sport.equals(national.getSport()))
            {
                System.out.println("passed");
                numTests++;
            }
            else
            {
                System.out.println("FAILED");
            }
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