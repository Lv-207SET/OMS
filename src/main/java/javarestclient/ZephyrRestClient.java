package javarestclient;

import com.google.gson.Gson;
import javarestclient.pojo.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


/**
 * Created by Voropai Dmytro on 13/01/2017.
 */
public class ZephyrRestClient {
    //  Global access to data
    private static volatile ZephyrRestClient instance = null;
    public String response;

    // Default constructor
    private ZephyrRestClient() {
    }
    //Singleton body
    public static ZephyrRestClient getInstance() {
        if (instance == null) {
            synchronized (ZephyrRestClient.class) {
                if (instance == null) {
                    instance = new ZephyrRestClient();
                }
            }
        }
        return instance;
    }
    //Get password, login and base url form environment variables
    public static final String login = System.getenv("loginforjira");
    public static final String password = System.getenv("passwordforjira");
    private static final String urlForCycle = System.getenv("urlcycle");
    private static final String urlForIssue ="http://localhost:8082/rest/api/2/issue/";
    private static final String urlForUpdate="http://localhost:8082/rest/zapi/latest/execution";

    /**
     * Set up connection with zapi rest server
     */
    public static Client setUpConnectionWithZapi(){
//        Get Basic Authentication
        HttpAuthenticationFeature httpAuthenticationFeature = HttpAuthenticationFeature.basic(login, password);
        final Client restClient = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        restClient.register(httpAuthenticationFeature);
        return restClient;
    }

    /**
     * Create test cycle
     */
    public void createNewCycle(String cycleName, String buid, String startDate,
                               String projectId, String versionId ,String endDate, String environment){
        Entity body = Entity.json(cycleJsonParser(cycleName,buid,startDate,projectId,
                versionId,endDate,environment));
        Response responseFormServer = setUpConnectionWithZapi()
                .target(urlForCycle)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(body);
        System.out.println("Status: " + responseFormServer.getStatus());
        System.out.println("Headers: " + responseFormServer.getHeaders());
    }

    /**
     * Parse object to Json
     */
    private String cycleJsonParser(String cycleName, String buid, String startDate, String projectId,
                                  String versionId ,String endDate, String environment){
        Gson gson = new Gson();
        Cycle cycleBuilder = new Cycle(cycleName,projectId,versionId, buid, startDate, endDate,environment);
        String jsonToObject = gson.toJson(cycleBuilder);
        System.out.println(jsonToObject);
        return jsonToObject;
    }

    private String testCaseParseJson( String testStep, String description, String issueType, String projectName){
        Gson gson = new Gson();
        ForFields fields =new ForFields( new Fields(
                new Project(projectName),testStep, description,new Issuetype(issueType)));
        String jsonToObject = gson.toJson(fields);
        System.out.println(jsonToObject);
        return jsonToObject;
    }

    /**
     * Create a test case in Jira
     *
     * */
    public void createAndExecuteTestCase(ITestResult result, String issueType, String projectName) {
        String testStep = result.getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(Step.class)
                .value();
        String description = result.getMethod()
                .getConstructorOrMethod()
                .getMethod()
                .getAnnotation(Description.class)
                .value();
        ZephyrRestClient zephyrRestClient = new ZephyrRestClient();
        Entity payload = Entity.json(zephyrRestClient.testCaseParseJson(testStep, description,
                issueType, projectName));
        Response response = setUpConnectionWithZapi()
                .target(urlForIssue)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(payload);
        System.out.println("Status: " + response.getStatus());
        System.out.println("Headers: " + response.getHeaders());
        String getResponseFromServer = response.readEntity(String.class);
        parseJSONToObject(getResponseFromServer);
    }

    public void parseJSONToObject(String getResponse){
        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseFromServer responseFromServer = null;
        try {
            responseFromServer = objectMapper.readValue(getResponse, ResponseFromServer.class);
            String response = responseFromServer.getId();
            this.response = response;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String parseUpdateToJson() {
        Gson gson = new Gson();
        UpdateTestCase updateTestCase = new UpdateTestCase("200", response,"10001",
                "10100","assignee","dimon1165");
        String jsonToObject = gson.toJson(updateTestCase);
        System.out.println(jsonToObject);
        return jsonToObject;
    }


    public void executeAndUpdate(){
        Entity payload = Entity.json(parseUpdateToJson());
        Response response = setUpConnectionWithZapi()
                .target(urlForUpdate)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(payload);
        System.out.println("Status: " + response.getStatus());
        System.out.println("Headers: " + response.getHeaders());
        System.out.println("Body: " + response.readEntity(String.class));

    }
}

