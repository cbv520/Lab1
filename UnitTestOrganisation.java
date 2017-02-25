/**
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
            name = "TestOrg";
            contactName = "TestName";
            contactEmail = "testemail@testdomain.com";
            
            System.out.println("Testing constructor");
            numTests++;
            organisation = new Organisation(name, contactName, contactEmail);
            numPassed++;
            System.out.println("passed");
            
            System.out.println("Testing getName()");
            numTests++;
            if(name.equals(organisation.getName()))
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
            if(contactName.equals(organisation.getContactName()))
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
            if(contactEmail.equals(organisation.getContactEmail()))
            {
                numPassed++;
                System.out.println("passed");
            }
            else
            {
             System.out.println("FAILED");   
            }    
            
            System.out.println("Normal conditions: " + numPassed + "/" + numTests + " passed");
            
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
**/