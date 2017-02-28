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
        int numStates = 0;

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();
            fields = line.split(",");
            fileStrm.close();
            processFields(fields);
            createStates(file);
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }

    }

    private void processFields(String[] fields)
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
        }
    }

    private void createStates(String file)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String[] fields = null;
        int numStates = 0;

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            //get number of states that are under this national
            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("STATE"))
                {
                    if(fields[2].equals("PARENT:"+this.getName()))
                    {
                        numStates++;
                    }
                }
                line = bufRdr.readLine();
            }

            states = new State[numStates];

            fileStrm.close();
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            //read in all states that are under this national
            int stateCount = 0;
            int rowCount = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("STATE"))
                {
                    if(fields[2].equals("PARENT:"+this.getName()))
                    {
                        states[stateCount] = new State();
                        states[stateCount].read(file, rowCount+1);
                        stateCount++;
                    }
                }
                line = bufRdr.readLine();
                rowCount++;
            }
            System.out.println(states[0].getName());
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }

    }
}
