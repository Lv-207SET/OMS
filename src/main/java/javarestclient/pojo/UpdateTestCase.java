package javarestclient.pojo;

/**
 * Created by Dmytro on 15/01/2017.
 */
public class UpdateTestCase {
    private String cycleId;

    private String projectId;

    private String versionId;

    private String issueId;

    private String assigneeType;

    private String assignee;


    public UpdateTestCase(String cycleId, String issueId, String projectId, String versionId, String assigneeType, String assignee) {
        this.cycleId = cycleId;
        this.projectId = projectId;
        this.versionId = versionId;
        this.issueId = issueId;
        this.assigneeType = assigneeType;
        this.assignee = assignee;
    }

    public String getCycleId ()
    {
        return cycleId;
    }

    public void setCycleId (String cycleId)
    {
        this.cycleId = cycleId;
    }

    public String getAssigneeType ()
    {
        return assigneeType;
    }

    public void setAssigneeType (String assigneeType)
    {
        this.assigneeType = assigneeType;
    }

    public String getAssignee ()
    {
        return assignee;
    }

    public void setAssignee (String assignee)
    {
        this.assignee = assignee;
    }

    public String getVersionId ()
    {
        return versionId;
    }

    public void setVersionId (String versionId)
    {
        this.versionId = versionId;
    }

    public String getIssueId ()
    {
        return issueId;
    }

    public void setIssueId (String issueId)
    {
        this.issueId = issueId;
    }

    public String getProjectId ()
    {
        return projectId;
    }

    public void setProjectId (String projectId)
    {
        this.projectId = projectId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cycleId = "+cycleId+", assigneeType = "+assigneeType+", assignee = "+assignee+", versionId = "+versionId+", issueId = "+issueId+", projectId = "+projectId+"]";
    }
}
