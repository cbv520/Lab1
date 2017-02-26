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
            System.out.println("");
            System.out.println("Testing normal conditions");
            System.out.println("=========================");
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
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }
            
            System.out.println("Testing getName()");
            numTests++;
            if(name.equals(national.getName()))
            {
                numPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("FAILED");
            }
            
            System.out.println("Testing getContactName()");
            numTests++;
            if(contactName.equals(national.getContactName()))
            {
                numPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("FAILED");
            }
            
            System.out.println("Testing getContactEmail()");
            numTests++;
            if(contactEmail.equals(national.getContactEmail()))
            {
                numPassed++;
                System.out.println("passed");
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
        
        System.out.println("");
        System.out.println("Testing error conditions");
        System.out.println("=========================");
        
        sport = "Test Sport";
        name = "Test Name";
        contactName = "Test ContactName";
        contactEmail = "testemail@testdomain.com";
        
        try
        {
            numTests++;
            System.out.println("Testing name = null");
            sport = null;
            national = new National(sport, name, contactName, contactEmail);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        
        try
        {
            numTests++;
            System.out.println("Testing name = \"\"");
            sport = "";
            national = new National(sport, name, contactName, contactEmail);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        
        System.out.println("");
        System.out.println("Tests passed: " + numPassed + "/" + numTests + " passed");
    }
}