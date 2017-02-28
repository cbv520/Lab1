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
        State[] states;

        try
        {
            System.out.println("");
            System.out.println("testing: abstract class Organisation methods and its child class National methods");
            System.out.println("");
            System.out.println("Testing normal conditions");
            System.out.println("=========================");
            sport = "Test Sport";
            name = "Test Name";
            contactName = "Test ContactName";
            contactEmail = "testemail@testdomain.com";
            states = new State[1];
            states[0] = new State();

            System.out.println("Testing constructor");
            numTests++;
            national = new National(sport, name, contactName, contactEmail, states);
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

            System.out.println("Testing getStates()");
            numTests++;
            if(states.equals(national.getStates()))
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
        states = new State[1];
        states[0] = new State();

        try
        {
            numTests++;
            System.out.println("Testing name = null in constructor");
            sport = null;
            national = new National(sport, name, contactName, contactEmail, states);
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
            System.out.println("Testing name = \"\" in constructor");
            sport = "";
            national = new National(sport, name, contactName, contactEmail, states);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
            sport = "Test Sport";
            national = new National(sport, name, contactName, contactEmail, states);
        }

        try
        {
            numTests++;
            System.out.println("Testing setSport()");
            sport = null;
            national.setSport(sport);
            sport = "";
            national.setSport(sport);
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
            System.out.println("Testing setName()");
            name = null;
            national.setName(name);
            name = "";
            national.setName(name);
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
            System.out.println("Testing setContactName()");
            contactName = null;
            national.setContactName(contactName);
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
            System.out.println("Testing setContactEmail()");
            contactEmail = null;
            national.setContactEmail(contactEmail);
            contactEmail = "";
            national.setContactEmail(contactEmail);
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
            System.out.println("Testing setStates()");
            states[0] = null;
            national.setStates(states);
            states = null;
            national.setStates(states);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        System.out.println("");
        System.out.println("Tests passed: " + numPassed + "/" + numTests);
    }
}
