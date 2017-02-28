import java.io.*;

public class Player extends Person
{
    private String club;

    Player()
    {
        super("defaultPlayerName","defaultPlayerEmail","defaultPlayerDOB");
        club = "defaultPlayerClub";
    }

    Player(String inName, String inClub, String inEmail, String inDOB)
    {
        super(inName, inEmail, inDOB);

        if(inClub == null || inClub.equals(""))
        {
            throw new IllegalArgumentException("invalid club");
        }

        club = inClub;
    }

    Player(Player otherPlayer)
    {
        super(otherPlayer);
        club = otherPlayer.getClub();
    }

    public String getClub()
    {
        return club;
    }

    public void setClub(String inClub)
    {
        if(inClub == null || inClub.equals(""))
        {
            throw new IllegalArgumentException("invalid club");
        }

        club = inClub;
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
        if(!fields[0].equals("PLAYER"))
        {
            throw new IllegalArgumentException("Object not of type Team");
        }
        else
        {
            this.setName(fields[1].split(":")[1]);
            this.setClub(fields[2].split(":")[1]);
            this.setEmail(fields[3].split(":")[1]);
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

            pw.println("PLAYER,NAME:"+getName()+",CLUB:"+club+",CONTACT_EMAIL:"+getEmail());
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }
}
