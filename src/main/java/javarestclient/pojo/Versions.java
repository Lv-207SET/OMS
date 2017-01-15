package javarestclient.pojo;

/**
 * Created by Nadya on 15/01/2017.
 */
public class Versions {
    private String name;

    public Versions(String name) {
        this.name = name;
    }

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
