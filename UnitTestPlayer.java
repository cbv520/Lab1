public class UnitTestPlayer
{
    public static void main(String args[])
    {
        Player player;
        String name;
        String contactEmail;
        String club;
        String dob;
        int numTests = 0;
        int numPassed = 0;

        System.out.println("");
        System.out.println("testing: abstract class Person and class Player");
        System.out.println("");
        System.out.println("Testing normal conditions");
        System.out.println("=========================");
        name = "Test Name";
        club = "Test Club";
        dob = "Test date of birth";
        contactEmail = "testemail@testdomain.com";
        try
        {
            System.out.println("Testing constructor");
            numTests++;
            player = new Player(name, club, contactEmail, dob);
            System.out.println("passed");
            numPassed++;

            System.out.println("Testing getName()");
            numTests++;
            if(name.equals(player.getName()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getClub()");
            numTests++;
            if(club.equals(player.getClub()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getEmail()");
            numTests++;
            if(contactEmail.equals(player.getEmail()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getDateBirth()");
            numTests++;
            if(dob.equals(player.getDateBirth()))
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
        club = "Test Club";
        dob = "Test date of birth";
        contactEmail = "testemail@testdomain.com";
        player = new Player(name, club, contactEmail, dob);

        try
        {
            System.out.println("Testing constructor - empty string");
            numTests++;
            name = "";
            club = "";
            player = new Player(name, club, contactEmail, dob);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        name = "Test Name";
        club = "Test Club";
        player = new Player(name, club, contactEmail, dob);

        try
        {
            System.out.println("Testing constructor - null string");
            numTests++;
            name = null;
            club = null;
            player = new Player(name, club, contactEmail, dob);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }
        name = "Test Name";
        club = "Test Club";
        player = new Player(name, club, contactEmail, dob);

        try
        {
            System.out.println("Testing setName()");
            numTests++;
            name = "";
            player.setName(name);
            name = null;
            player.setName(name);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setClub()");
            numTests++;
            club = "";
            player.setClub(club);
            club = null;
            player.setClub(club);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setEmail()");
            numTests++;
            contactEmail = "";
            player.setEmail(contactEmail);
            contactEmail = null;
            player.setEmail(contactEmail);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setDateBirth()");
            numTests++;
            dob = "";
            player.setDateBirth(dob);
            dob = null;
            player.setDateBirth(dob);
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
