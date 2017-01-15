package javarestclient;

/**
 * Created by Dmytro
 *  Help to parse JSON string to object
 *  {"id":"11519","key":"LVSETOMS-24","self":"http://localhost:8082/rest/api/2/issue/11519"}
 */
public class ResponseFromServer {
    private String id;
    private String key;
    private String self;

    public ResponseFromServer() {
    }

    public ResponseFromServer(String id, String key, String self) {
        this.id = id;
        this.key = key;
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
