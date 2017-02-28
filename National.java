import java.io.*;

public class National extends Organisation
{
    private String sport;
    private State[] states;

    National()
    {
        super("default","default","default");
        sport = "default";
        states = null;
    }

    National(String inSport, String inName, String inContactName, String inContactEmail, State[] inStates)
    {
        super(inName, inContactName, inContactEmail);

        if(inSport == null || inSport.equals(""))
        {
            throw new IllegalArgumentException("Invalid sport");
        }
        if(inStates == null)
        {
            throw new IllegalArgumentException("invalid states");
        }

        sport = inSport;
        states = inStates;
    }

    National(National otherNational)
    {
        super(otherNational);
        sport = otherNational.getSport();
        states = otherNational.getStates();
    }

    public String getSport()
    {
        return sport;
    }

    public void setSport(String inSport)
    {
        if(inSport == null || inSport.equals(""))
        {
            throw new IllegalArgumentException("Invalid sport");
        }

        sport = inSport;
    }

    public State[] getStates()
    {
        return states;
    }

    public void setStates(State[] inStates)
    {
        states = inStates;
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

            fileStrm.close();
            fields = line.split(",");
            processLine(fields);
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }

    }

    private void processLine(String[] fields)
    {
        if(!fields[0].equals("NATIONAL"))
        {
            throw new IllegalArgumentException("Object not of type National");
        }
        else
        {
            this.setSport(fields[1].split(":")[1]);
            this.setName(fields[2].split(":")[1]);
            this.setContactName(fields[3].split(":")[1]);
            this.setContactEmail(fields[4].split(":")[1]);

            System.out.println(sport);
            System.out.println(getName());
            System.out.println(getContactName());
            System.out.println(getContactEmail());
        }
    }
}
