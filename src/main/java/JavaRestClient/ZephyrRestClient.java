package JavaRestClient;

import com.google.gson.Gson;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;

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
    public final String password = System.getenv("passwordforjira");
    public final String urlForCycle = System.getenv("urlcycle");

    /**
     * Set up connection with zapi rest server
     */
    public Client setUpConnectionWithZapi(){
//        Get Basic Authentication
        HttpAuthenticationFeature httpAuthenticationFeature = HttpAuthenticationFeature.basic(login, password);
        final Client restClient = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        restClient.register(httpAuthenticationFeature);
        return restClient;
    }

    /**
     * Create test cycle
     */
    public ZephyrRestClient createNewCycle(String cycleName, String buid, String startDate,
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
        return this;
    }

    /**
     * Parse cycle object to Json
     */
    public String cycleJsonParser(String cycleName, String buid, String startDate, String projectId,
                                  String versionId ,String endDate, String environment){
        Gson gson = new Gson();
        Cycle cycleBuilder = new Cycle(cycleName,projectId,versionId, buid, startDate, endDate,environment);
        String jsonToObject = gson.toJson(cycleBuilder);
        System.out.println(jsonToObject);
        return jsonToObject;
    }
}
