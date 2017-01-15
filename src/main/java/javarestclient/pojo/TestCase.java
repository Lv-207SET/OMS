package javarestclient.pojo;

/**
 * Created by Dmytro Voropai on 14/01/2017.
 */
public class TestCase {
    private String testStep;
    private String description;


    public TestCase(String testStep, String description) {
        this.testStep = testStep;
        this.description = description;
    }

    public String getTestStep() {
        return testStep;
    }

    public void setTestStep(String testStep) {
        this.testStep = testStep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
