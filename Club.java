import java.io.*;

public class Club extends Organisation implements Serializable
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

    Club(String inName, String inShort, String inParent, String inContactName, String inContactEmail, Player[] inPlayers, Team[] inTeams)
    {
        super(inName, inContactName, inContactEmail);

        if(inShort == null || inParent == null || inPlayers == null || inTeams == null)
        {
            throw new IllegalArgumentException("invalid input");
        }
        if(inShort.equals("") || inParent.equals(""))
        {
            throw new IllegalArgumentException("invalid input");
        }
        for(Player p : inPlayers)
        {
            if(p == null)
            {
                throw new IllegalArgumentException("Invalid player");
            }
        }
        for(Team t : inTeams)
        {
            if(t == null)
            {
                throw new IllegalArgumentException("Invalid teams");
            }
        }

        shortName = inShort;
        parent = inParent;
        players = inPlayers;
        teams = inTeams;
    }

    Club(Club otherClub)
    {
        super(otherClub);
        shortName = otherClub.getShort();
        parent = otherClub.getParent();
        players = otherClub.getPlayers();
        teams = otherClub.getTeams();
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
        for(Team t : inTeams)
        {
            if(t == null)
            {
                throw new IllegalArgumentException("Invalid teams");
            }
        }
        teams = inTeams;
    }

    public Player[] getPlayers()
    {
        return players;
    }

    public void setPlayers(Player[] inPlayers)
    {
        for(Player p : inPlayers)
        {
            if(p == null)
            {
                throw new IllegalArgumentException("Invalid player");
            }
        }
        players = inPlayers;
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
            createPlayers(file);
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }

    public void write(String file)
    {
        FileOutputStream fileStrm;
        PrintWriter pw;

        try
        {
            fileStrm = new FileOutputStream(file, true);
            pw = new PrintWriter(fileStrm);

            pw.println("CLUB,NAME:"+getName()+",SHORT:"+shortName+",PARENT:"+parent+",CONTACT_NAME:"+getContactName()+",CONTACT_EMAIL:"+getContactEmail());
            pw.close();
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

        countChildTeams(file);

        try
        {
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
            fileStrm.close();
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }

    }

    private void createPlayers(String file)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String[] fields = null;

        countChildPlayers(file);

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            int playerCount = 0;
            int rowCount = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("PLAYER"))
                {
                    if(fields[2].equals("CLUB:"+this.getShort()))
                    {
                        players[playerCount] = new Player();
                        players[playerCount].read(file, rowCount+1);
                        playerCount++;
                    }
                }
                line = bufRdr.readLine();
                rowCount++;
            }
            fileStrm.close();
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }

    }

    private void countChildTeams(String file)
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
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }

    private void countChildPlayers(String file)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String[] fields = null;
        int numPlayers = 0;

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("PLAYER"))
                {
                    if(fields[2].equals("CLUB:"+this.getShort()))
                    {
                        numPlayers++;
                    }
                }
                line = bufRdr.readLine();
            }

            players = new Player[numPlayers];

            fileStrm.close();
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }
}
