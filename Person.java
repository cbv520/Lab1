import java.io.*;

public class Person  implements Serializable
{
    private String name;
    private String email;
    private String dateBirth;

    Person(String inName, String inEmail, String inDOB)
    {
        if(inName == null || inEmail == null || inDOB == null)
        {
            throw new IllegalArgumentException("invalid input");
        }
        if(inName.equals("") || inEmail.equals("") || inDOB.equals(""))
        {
            throw new IllegalArgumentException("invalid input");
        }

        name = inName;
        email = inEmail;
        dateBirth = inDOB;
    }

    Person(Person otherPerson)
    {
        name = otherPerson.getName();
        email = otherPerson.getEmail();
        dateBirth = otherPerson.getDateBirth();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String inName)
    {
        if(inName == null || inName.equals(""))
        {
            throw new IllegalArgumentException("invalid name");
        }

        name = inName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String inEmail)
    {
        if(inEmail == null || inEmail.equals(""))
        {
            throw new IllegalArgumentException("invalid email");
        }

        email = inEmail;
    }

    public String getDateBirth()
    {
        return dateBirth;
    }

    public void setDateBirth(String inDOB)
    {
        if(inDOB == null || inDOB.equals(""))
        {
            throw new IllegalArgumentException("invalid date of birth");
        }

        dateBirth = inDOB;
    }
}
