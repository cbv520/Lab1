import java.io.*;

public class Association extends Organisation
{
    private String shortName;
    private String parent;
    private Club[] clubs;

     //default constructor should only be used to read in a file
    Association()
    {
        super("defaultAssociationName","defaultAssociationContactName","defaultAssociationContactEmail");
        shortName = "defaultAssociationShort";
        parent = "defaultAssociationParent";
        clubs = null;
    }

    Association(String inName, String inShort, String inParent, String inContactName, String inContactEmail, Club[] inClubs)
    {
        super(inName, inContactName, inContactEmail);

        if(inShort == null || inParent == null || inClubs == null)
        {
            throw new IllegalArgumentException("invalid input");
        }
        if(inShort.equals("") || inParent.equals(""))
        {
            throw new IllegalArgumentException("invalid input");
        }

        shortName = inShort;
        parent = inParent;
        clubs = inClubs;
    }

    Association(Association otherAssociation)
    {
        super(otherAssociation);
        shortName = otherAssociation.getShort();
        parent = otherAssociation.getParent();
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

    public Club[] getClubs()
    {
        return clubs;
    }

    public void setClubs(Club[] inClubs)
    {
        clubs = inClubs;
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
            createClubs(file);
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

            pw.println("ASSOCIATION,NAME:"+getName()+",SHORT:"+shortName+",PARENT:"+parent+",CONTACT_NAME:"+getContactName()+",CONTACT_EMAIL:"+getContactEmail());
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
    }

    private void processFields(String[] fields)
    {
        if(!fields[0].equals("ASSOCIATION"))
        {
            throw new IllegalArgumentException("Object not of type Association");
        }
        else
        {
            this.setName(fields[1].split(":")[1]);
            this.setShort(fields[2].split(":")[1]);
            this.setParent(fields[3].split(":")[1]);
            this.setContactName(fields[3].split(":")[1]);
            this.setContactEmail(fields[4].split(":")[1]);
        }
    }

    private void createClubs(String file)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String[] fields = null;
        int numClubs = 0;
        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("CLUB"))
                {
                    if(fields[3].equals("PARENT:"+this.getShort()))
                    {
                        numClubs++;
                    }
                }
                line = bufRdr.readLine();
            }

            clubs = new Club[numClubs];

            fileStrm.close();
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            int clubCount = 0;
            int rowCount = 0;
            line = bufRdr.readLine();
            while(line != null)
            {
                fields = line.split(",");
                if(fields[0].equals("CLUB"))
                {
                    if(fields[3].equals("PARENT:"+this.getShort()))
                    {
                        clubs[clubCount] = new Club();
                        clubs[clubCount].read(file, rowCount+1);
                        clubCount++;
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
