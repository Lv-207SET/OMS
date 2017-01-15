package javarestclient;

import com.google.gson.Gson;
import javarestclient.pojo.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
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


/**
 * Created by Voropai Dmytro on 13/01/2017.
 */
public class ZephyrRestClient {
    //  Global access to data
    private static volatile ZephyrRestClient instance = null;
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
        System.out.println("Body: " + responseFormServer.readEntity(String.class));
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

    private Object parseJSONtoObject(String response){
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseFromServer responseFromServer = new
        return ;
    }

    /**
     * Create a test case. The data for test cases creating will
     * be extracted from all methods which annotated with @TransferToJira
     */
    public void createTestCase(String testStep, String description,String issueType, String projectName){
            Entity payload = Entity.json(ZephyrRestClient.getInstance().testCaseParseJson(testStep, description,
                    issueType, projectName));
            Response response = setUpConnectionWithZapi()
                    .target(urlForIssue)
                    .request(MediaType.APPLICATION_JSON)
                    .post(payload);
            System.out.println("Status: " + response.getStatus());
            System.out.println("Headers: " + response.getHeaders());
            String responseFromServer = response.readEntity(String.class);
            parseJSONtoObject(responseFromServer);
        }

    public void createTestCaseFromListener(ITestResult result) {
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
        ZephyrRestClient.getInstance().createTestCase(testStep,description,"Test","LVSETOMS");
    }
}


