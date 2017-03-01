public class UnitTestTeam
{
    public static void main(String args[])
    {
        Team team;
        String name;
        String contactName;
        String contactEmail;
        String parent;
        int numTests = 0;
        int numPassed = 0;

        System.out.println("");
        System.out.println("testing: class Team");
        System.out.println("");
        System.out.println("Testing normal conditions");
        System.out.println("=========================");
        name = "Test Name";
        parent = "Test Parent";
        contactName = "Test ContactName";
        contactEmail = "testemail@testdomain.com";
        try
        {
            System.out.println("Testing constructor");
            numTests++;
            team = new Team(name, parent, contactName, contactEmail);
            System.out.println("passed");
            numPassed++;

            System.out.println("Testing getParent()");
            numTests++;
            if(parent.equals(team.getParent()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal Argument: "+ e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("FAILED");
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("Testing error conditions");
        System.out.println("=========================");
        name = "Test Name";
        parent = "Test Parent";
        contactName = "Test ContactName";
        contactEmail = "testemail@testdomain.com";
        team = new Team(name, parent, contactName, contactEmail);

        try
        {
            System.out.println("Testing constructor - empty string");
            numTests++;
            parent = "";
            team = new Team(name, parent, contactName, contactEmail);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        parent = "Test Parent";
        team = new Team(name, parent, contactName, contactEmail);

        try
        {
            System.out.println("Testing constructor - null string");
            numTests++;
            parent = null;
            team = new Team(name, parent, contactName, contactEmail);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        parent = "Test Parent";
        team = new Team(name, parent, contactName, contactEmail);

        try
        {
            System.out.println("Testing setParent()");
            numTests++;
            parent = "";
            team.setParent(parent);
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
