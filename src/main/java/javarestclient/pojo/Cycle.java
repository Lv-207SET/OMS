package javarestclient.pojo;

/**
 * Created by Dmytro on 13/01/2017.
 */
public class Cycle {
    private String name;
    private String projectId;
    private  String versionId;
    private String build;
    private String startDate;
    private String endDate;
    private String environment;

    public Cycle(String name, String projectId, String versionId, String build, String startDate, String endDate, String environment) {
        this.name = name;
        this.projectId = projectId;
        this.versionId = versionId;
        this.build = build;
        this.startDate = startDate;
        this.endDate = endDate;
        this.environment = environment;
    }

    public String getName() {
        return name;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getVersionId() {
        return versionId;
    }

    public String getBuild() {
        return build;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
