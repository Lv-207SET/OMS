package javarestclient.pojo;

/**
 * Created by Dmytro Voropai on 15/01/2017.
 */
public class Issuetype {
    private String name;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }
}
