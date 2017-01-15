package javarestclient.pojo;

/**
 * Created by Voropai Dmytro on 15/01/2017.
 */
public class Fields {

    private Project project;
    private String summary;
    private String description;
    private Issuetype issuetype;

    public Fields(Project project, String summary, String description, Issuetype issuetype) {
        this.project = project;
        this.summary = summary;
        this.description = description;
        this.issuetype = issuetype;
    }


    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public Project getProject ()
    {
        return project;
    }

    public void setProject (Project project)
    {
        this.project = project;
    }

    public Issuetype getIssuetype ()
    {
        return issuetype;
    }

    public void setIssuetype (Issuetype issuetype)
    {
        this.issuetype = issuetype;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", project = "+project+", issuetype = "+issuetype+", description = "+description+"]";
    }
}
