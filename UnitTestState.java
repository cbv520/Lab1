public class UnitTestState
{
    public static void main(String args[])
    {
        State state;
        String name;
        String contactName;
        String contactEmail;
        String parent;
        Association[] associations;
        int numTests = 0;
        int numPassed = 0;

        System.out.println("");
        System.out.println("testing: class State");
        System.out.println("");
        System.out.println("Testing normal conditions");
        System.out.println("=========================");
        name = "Test Name";
        parent = "Test Parent";
        contactName = "Test ContactName";
        contactEmail = "testemail@testdomain.com";
        associations = new Association[1];
        associations[0] = new Association();
        try
        {
            System.out.println("Testing constructor");
            numTests++;
            state = new State(name, parent, contactName, contactEmail, associations);
            System.out.println("passed");
            numPassed++;

            System.out.println("Testing getParent()");
            numTests++;
            if(parent.equals(state.getParent()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getAssociations()");
            numTests++;
            if(associations.equals(state.getAssociations()))
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
        associations = new Association[1];
        associations[0] = new Association();
        state = new State(name, parent, contactName, contactEmail, associations);

        try
        {
            System.out.println("Testing constructor");
            numTests++;
            name = "";
            state = new State(name, parent, contactName, contactEmail, associations);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
            name = "Test Name";
            state = new State(name, parent, contactName, contactEmail, associations);
        }

        try
        {
            System.out.println("Testing setParent()");
            numTests++;
            parent = "";
            state.setParent(parent);
            parent = null;
            state.setParent(parent);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setAssociations()");
            numTests++;
            associations[0] = null;
            state.setAssociations(associations);
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
