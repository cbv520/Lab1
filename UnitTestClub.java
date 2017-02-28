public class UnitTestClub
{
    public static void main(String args[])
    {
        Club club;
        String name;
        String shortName;
        String parent;
        String contactName;
        String contactEmail;
        Team[] teams;
        Player[] players;
        int numTests = 0;
        int numPassed = 0;

        System.out.println("");
        System.out.println("testing: class Club");
        System.out.println("");
        System.out.println("Testing normal conditions");
        System.out.println("=========================");
        name = "Test Name";
        shortName = "Test short";
        parent = "Test Parent";
        contactName = "Test ContactName";
        contactEmail = "testemail@testdomain.com";
        teams = new Team[1];
        teams[0] = new Team();
        players = new Player[1];
        players[0] = new Player();
        try
        {
            System.out.println("Testing constructor");
            numTests++;
            club = new Club(name, shortName, parent, contactName, contactEmail, players, teams);
            System.out.println("passed");
            numPassed++;

            System.out.println("Testing getShort()");
            numTests++;
            if(shortName.equals(club.getShort()))
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
            if(parent.equals(club.getParent()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getPlayers()");
            numTests++;
            if(players.equals(club.getPlayers()))
            {
                System.out.println("passed");
                numPassed++;
            }
            else
            {
                System.out.println("FAILED");
            }

            System.out.println("Testing getTeams()");
            numTests++;
            if(teams.equals(club.getTeams()))
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
        teams = new Team[1];
        teams[0] = new Team();
        players = new Player[1];
        players[0] = new Player();
        club = new Club(name, shortName, parent, contactName, contactEmail, players, teams);

        try
        {
            System.out.println("Testing constructor");
            numTests++;
            name = "";
            club = new Club(name, shortName, parent, contactName, contactEmail, players, teams);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
            name = "Test Name";
            club = new Club(name, shortName, parent, contactName, contactEmail, players, teams);
        }

        try
        {
            System.out.println("Testing setShort()");
            numTests++;
            shortName = "";
            club.setShort(shortName);
            shortName = null;
            club.setShort(shortName);
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
            club.setParent(parent);
            parent = null;
            club.setParent(parent);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setPlayers()");
            numTests++;
            players[0] = null;
            club.setPlayers(players);
            players = null;
            club.setPlayers(players);
            System.out.println("FAILED");
        }
        catch(Exception e)
        {
            System.out.println("passed");
            numPassed++;
        }

        try
        {
            System.out.println("Testing setTeams()");
            numTests++;
            teams[0] = null;
            club.setTeams(teams);
            teams = null;
            club.setTeams(teams);
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
