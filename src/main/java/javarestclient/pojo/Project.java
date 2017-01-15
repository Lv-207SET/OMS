package javarestclient.pojo;

/**
 * Created by Nadya on 15/01/2017.
 */
public class Project {
    private String key;

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [key = "+key+"]";
    }
}
