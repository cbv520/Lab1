import java.io.*;

public class Team extends Organisation
{
    private String parent;

     //default constructor should only be used to read in a file
    Team()
    {
      super("defaultTeamName","defaultTeamContactName","defaultTeamEmail");
      parent = "defaultTeamParent";
    }

    Team(String inName, String inParent, String inContactName, String inContactEmail)
    {
        super(inName, inContactName, inContactEmail);

        if(inParent == null)
        {
            throw new IllegalArgumentException("invalid parent");
        }

        parent = inParent;
    }

    Team(Team otherTeam)
    {
        super(otherTeam);
        parent = otherTeam.getParent();
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
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }

    private void processFields(String[] fields)
    {
        if(!fields[0].equals("TEAM"))
        {
            throw new IllegalArgumentException("Object not of type Team");
        }
        else
        {
            this.setName(fields[1].split(":")[1]);
            this.setParent(fields[2].split(":")[1]);
            this.setContactName(fields[3].split(":")[1]);
            this.setContactEmail(fields[4].split(":")[1]);
        }
    }

}
