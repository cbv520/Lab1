import java.io.*;

public class State extends Organisation
{
    private String parent;
    private Association[] associations;

    //default constructor should only be used to read in a file
    State()
    {
        super("defaultStateName","defaultStateContactName","defaultStateContactEmail");
        parent = "defaultStateParent";
        associations = null;
    }

    State(String inName, String inParent, String inContactName, String inContactEmail, Association[] inAssociations)
    {
        super(inName, inContactName, inContactEmail);

        if(inParent == null || inAssociations == null)
        {
            throw new IllegalArgumentException("invalid input");
        }
        for(Association a : inAssociations)
        {
            if(a == null)
            {
                throw new IllegalArgumentException("Invalid association");
            }
        }

        parent = inParent;
        associations = inAssociations;
    }

    State(State otherState)
    {
        super(otherState);
        parent = otherState.getParent();
    }

    public String getParent()
    {
        return parent;
    }

    public void setParent(String inParent)
    {
        if(inParent == null || inParent.equals(""))
        {
            throw new IllegalArgumentException("Invalid association");
        }
        parent = inParent;
    }

    public Association[] getAssociations()
    {
        return associations;
    }

    public void setAssociations(Association[] inAssociations)
    {
        if(inAssociations == null)
        {
            throw new IllegalArgumentException("Invalid association");
        }
        for(Association a : inAssociations)
        {
            if(a == null)
            {
                throw new IllegalArgumentException("Invalid association");
            }
        }
        associations = inAssociations;
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
            createAssociations(file);
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

            pw.println("STATE,NAME:"+getName()+",PARENT:"+parent+",CONTACT_NAME:"+getContactName()+",CONTACT_EMAIL:"+getContactEmail());
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }

    private void processFields(String[] fields)
    {
        if(!fields[0].equals("STATE"))
        {
            throw new IllegalArgumentException("Object not of type State");
        }
        else
        {
            this.setName(fields[1].split(":")[1]);
            this.setParent(fields[2].split(":")[1]);
            this.setContactName(fields[3].split(":")[1]);
            this.setContactEmail(fields[4].split(":")[1]);
        }
    }

    private void createAssociations(String file)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String[] fields = null;
        int numAssociations = 0;

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("ASSOCIATION"))
                {
                    if(fields[3].equals("PARENT:"+this.getName()))
                    {
                        numAssociations++;
                    }
                }
                line = bufRdr.readLine();
            }

            associations = new Association[numAssociations];

            fileStrm.close();
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            int associationCount = 0;
            int rowCount = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("ASSOCIATION"))
                {
                    if(fields[3].equals("PARENT:"+this.getName()))
                    {
                        associations[associationCount] = new Association();
                        associations[associationCount].read(file, rowCount+1);
                        associationCount++;
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
