package com.company.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import static org.junit.Assert.*;

public class TestUtil {
    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200(Response res) {
        assertEquals( "Status Check Failed!", res.getStatusCode(), 200);
    }
    //Get Clients
    public <T> List<T> getClients(JsonPath jp) {
        return jp.get("tags.name");
    }
}