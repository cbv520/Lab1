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
    
    National(String inSport, String inName, String inContactName, String inContactEmail)
    {
        super(inName, inContactName, inContactEmail);
        
        if(inSport == null || inSport.equals(""))

            throw new IllegalArgumentException("Invalid sport");
        }    
        
        sport = inSport;
    }
    
    National(National otherNational)
    {
        super(otherNational);
        sport = otherNational.getSport();
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
    
    public void read(String file, int entryNum)
    {
        FileInputStream fileStrm;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        String line = null;
        String fields = null;

        try
        {
            fileStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fileStrm);
            buffRdr = new BufferedReader(rdr);
            

            for(int i = 0; i < entryNum; i++)
            {
                line = buffRdr.readLine();
            }
            
            fields = line.split(",");
        }
        
    }
}







