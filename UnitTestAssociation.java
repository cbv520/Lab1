public class UnitTestAssociation
{
    public static void main(String args[])
    {
        Association association;
        String name;
        String shortName;
        String parent;
        String contactName;
        String contactEmail;
        Club[] clubs;
        int numTests = 0;
        int numPassed = 0;

        System.out.println("");
        System.out.println("testing: class Association");
        System.out.println("");
        System.out.println("Testing normal conditions");
        System.out.println("=========================");
        name = "Test Name";
        shortName = "Test short";
        parent = "Test Parent";
        contactName = "Test ContactName";
        contactEmail = "testemail@testdomain.com";
        clubs = new Club[1];
        clubs[0] = new Club();
        try
        {
            System.out.println("Testing constructor");
            numTests++;
            association = new Association(name, shortName, parent, contactName, contactEmail, clubs);
            System.out.println("passed");
            numPassed++;

            System.out.println("Testing getShort()");
            numTests++;
            if(shortName.equals(association.getShort()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getParent()");
            numTests++;
            if(parent.equals(association.getParent()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getClubs()");
            numTests++;
            if(clubs.equals(association.getClubs()))
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
        shortName = "Test short";
        parent = "Test Parent";
        contactName = "Test ContactName";
        contactEmail = "testemail@testdomain.com";
        clubs = new Club[1];
        clubs[0] = new Club();
        association = new Association(name, shortName, parent, contactName, contactEmail, clubs);

        try
        {
            System.out.println("Testing constructor - empty string");
            numTests++;
            shortName = "";
            association = new Association(name, shortName, parent, contactName, contactEmail, clubs);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        shortName = "Test Short";
        association = new Association(name, shortName, parent, contactName, contactEmail, clubs);

        try
        {
            System.out.println("Testing constructor - null string");
            numTests++;
            shortName = null;
            association = new Association(name, shortName, parent, contactName, contactEmail, clubs);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        shortName = "Test Short";
        association = new Association(name, shortName, parent, contactName, contactEmail, clubs);

        try
        {
            System.out.println("Testing constructor - null array element");
            numTests++;
            clubs[0] = null;
            association = new Association(name, shortName, parent, contactName, contactEmail, clubs);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        clubs[0] = new Club();
        association = new Association(name, shortName, parent, contactName, contactEmail, clubs);

        try
        {
            System.out.println("Testing setShort()");
            numTests++;
            shortName = "";
            association.setShort(shortName);
            shortName = null;
            association.setShort(shortName);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setParent()");
            numTests++;
            parent = "";
            association.setParent(parent);
            parent = null;
            association.setParent(parent);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setClubs()");
            numTests++;
            clubs[0] = null;
            association.setClubs(clubs);
            clubs = null;
            association.setClubs(clubs);
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
