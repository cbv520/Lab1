import java.io.*;

public class TestSerialize
{
    public static void main(String args[])
    {
        //writing
        try
        {
            FileOutputStream fileStrm;
            ObjectOutputStream objStrm;

            National nat = new National();
            nat.read("NetballWA.csv");

            System.out.println("Testing write to \"TestObjFile.ser\"");
            fileStrm = new FileOutputStream("TestObjFile.ser");
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(nat);
            System.out.println("Write successful");
        }
        catch(IOException e)
        {
            System.out.println("file error: " + e.getMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //reading
        try
        {
           FileInputStream fileStrm;
           ObjectInputStream objStrm;
           National nat;

           System.out.println("Testing read in from \"TestObjFile.ser\"");
           fileStrm = new FileInputStream("TestObjFile.ser");
           objStrm = new ObjectInputStream(fileStrm);
           nat = (National)objStrm.readObject();
           System.out.println("Read successful");
           System.out.println("");
           System.out.println(nat.getName());
           for(State s : nat.getStates())
           {
               System.out.println("|  |"+s.getName());
               for(Association a : s.getAssociations())
               {
                   System.out.println("|  |  |"+a.getName());
                   for(Club c : a.getClubs())
                   {
                       System.out.println("|  |  |  |"+c.getName());
                       for(Team t : c.getTeams())
                       {
                           System.out.println("|  |  |  |  |"+t.getName());
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
            e.printStackTrace();
        }
    }
}
