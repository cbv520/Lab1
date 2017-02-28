import java.io.*;

public class Club extends Organisation
{
    private String shortName;
    private String parent;
    private Player[] players;
    private Team[] teams;

     //default constructor should only be used to read in a file
    Club()
    {
        super("defaultClubName","defaultClubContactName","defaultClubContactEmail");
        parent = "defaultNatParent";
        players = null;
        teams = null;
    }

    Club(String inName, String inShort, String inParent, String inContactName, String inContactEmail, Team[] inTeams)
    {
        super(inName, inContactName, inContactEmail);

        if(inShort == null || inParent == null)
        {
            throw new IllegalArgumentException("invalid input");
        }

        shortName = inShort;
        parent = inParent;
    }

    Club(Club otherClub)
    {
        super(otherClub);
        shortName = otherClub.getShort();
        parent = otherClub.getParent();
    }

    public String getShort()
    {
        return shortName;
    }

    public void setShort(String inShort)
    {
        if(inShort == null || inShort.equals(""))
        {
            throw new IllegalArgumentException("invalid short");
        }

        shortName = inShort;
    }

    public String getParent()
    {
        return parent;
    }

    public void setParent(String inParent)
    {
        if(inParent == null || inParent.equals(""))
        {
            throw new IllegalArgumentException("invalid parent");
        }

        parent = inParent;
    }

    public Team[] getTeams()
    {
        return teams;
    }

    public void setTeams(Team[] inTeams)
    {
        teams = inTeams;
    }

    public void read(String file, int row)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String[] fields = null;

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            for(int i = 0; i < row; i++)
            {
                line = bufRdr.readLine();
            }

            fields = line.split(",");
            fileStrm.close();
            processFields(fields);
            createTeams(file);
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }

    private void processFields(String[] fields)
    {
        if(!fields[0].equals("CLUB"))
        {
            throw new IllegalArgumentException("Object not of type Club");
        }
        else
        {
            this.setName(fields[1].split(":")[1]);
            this.setShort(fields[2].split(":")[1]);
            this.setParent(fields[3].split(":")[1]);
            this.setContactName(fields[4]);
            this.setContactEmail(fields[5].split(":")[1]);
        }
    }

    private void createTeams(String file)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String[] fields = null;
        int numTeams = 0;
        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("TEAM"))
                {
                    if(fields[2].equals("PARENT:"+this.getShort()))
                    {
                        numTeams++;
                    }
                }
                line = bufRdr.readLine();
            }

            teams = new Team[numTeams];

            fileStrm.close();
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            int teamCount = 0;
            int rowCount = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("TEAM"))
                {
                    if(fields[2].equals("PARENT:"+this.getShort()))
                    {
                        teams[teamCount] = new Team();
                        teams[teamCount].read(file, rowCount+1);
                        teamCount++;
                    }
                }
                line = bufRdr.readLine();
                rowCount++;
            }
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }

    }
}
