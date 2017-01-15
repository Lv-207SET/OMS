package javarestclient.pojo;

/**
 * Created by Dmitry on 15/01/2017.
 */
public class TestCaseTOJson {

    private Fields fields;

    public Fields getFields ()
    {
        return fields;
    }

    public void setFields (Fields fields)
    {
        this.fields = fields;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fields = "+fields+"]";
    }
}
