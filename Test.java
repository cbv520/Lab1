public class Test
{
    public static void main(String args[])
    {
        National nat = new National();
        nat.read("NetballWA.csv", 1);

        System.out.println(nat.getName());
        for(State s : nat.getStates())
        {
            System.out.println("----"+s.getName());
            for(Association a : s.getAssociations())
            {
                System.out.println("--------"+a.getName());
                for(Club c : a.getClubs())
                {
                    System.out.println("------------"+c.getName());
                    for(Team t : c.getTeams())
                    {
                        System.out.println("----------------"+t.getName());
                    }
                }
            }
        }
    }

}
