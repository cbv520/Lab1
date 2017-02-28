import java.io.*;

public class National extends Organisation
{
    private String sport;
    private State[] states;

    //default constructor should only be used to read in a file
    National()
    {
        super("defaultNatName","defaultNatContactName","defaultNatContactEmail");
        sport = "defaultNatSport";
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
        for(State s : inStates)
        {
            if(s == null)
            {
                throw new IllegalArgumentException("Invalid states");
            }
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
        if(inStates == null)
        {
            throw new IllegalArgumentException("Invalid states");
        }
        for(State s : inStates)
        {
            if(s == null)
            {
                throw new IllegalArgumentException("Invalid states");
            }
        }
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

            //skip to line containing object to be instantiated
            for(int i = 0; i < row; i++)
            {
                line = bufRdr.readLine();
            }

            //seperate desired line into string array
            fields = line.split(",");
            fileStrm.close();

            //set all private members except aggregated classes
            processFields(fields);
            //set aggregated classes
            createStates(file);
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
            fileStrm = new FileOutputStream(file);
            pw = new PrintWriter(fileStrm);

            pw.println("NATIONAL,SPORT:"+sport+",NAME:"+getName()+",CONTACT_NAME:"+getContactName()+",CONTACT_EMAIL:"+getContactEmail());
            pw.close();

            for(State s : states)
            {
                s.write(file);
            }

            for(State s : states)
            {
                for(Association a : s.getAssociations())
                {
                    a.write(file);
                }
            }

            for(State s : states)
            {
                for(Association a : s.getAssociations())
                {
                    for(Club c : a.getClubs())
                    {
                        c.write(file);
                    }
                }
            }

            for(State s : states)
            {
                for(Association a : s.getAssociations())
                {
                    for(Club c : a.getClubs())
                    {
                        for(Team t : c.getTeams())
                        {
                            t.write(file);
                        }
                    }
                }
            }

            for(State s : states)
            {
                for(Association a : s.getAssociations())
                {
                    for(Club c : a.getClubs())
                    {
                        for(Player p : c.getPlayers())
                        {
                            p.write(file);
                        }
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Error while writing: " + e.getMessage());
        }

    }

    private void processFields(String[] fields)
    {
        //make sure we are evaluating an entry of type National
        if(!fields[0].equals("NATIONAL"))
        {
            throw new IllegalArgumentException("Object not of type National");
        }
        else
        {
            //assign values to class members
            //split needed to remove the prepended identifier
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
            //needed to intialise the State array
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

            //restart the file input stream
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
            fileStrm.close();
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }

    }
}
