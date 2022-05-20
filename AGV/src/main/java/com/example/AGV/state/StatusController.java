package com.example.AGV.state;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.*;
import java.util.Collections;

@RestController
public class StatusController {
    private RestTemplate restTemplate;

    //-------------------------------------PUT REQUEST-------------------------------------
    public String putStatusRequest(String name, int setStatus){
        RestTemplateBuilder rt = new RestTemplateBuilder();
        RestService(rt);
        String url = "http://localhost:8082/v1/status";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // create a post object
        Status status = new Status(name,setStatus);

        // make status object
        Gson gson = new Gson();
        String jsonStatus = gson.toJson(status);
        String data= jsonStatus.toString();

        // change the names
        data=data.replace("name","Program name");
        data=data.replace("id","State");

        HttpEntity<String> newEntity = new HttpEntity<>(data, headers);

        // send PUT request to update post
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.PUT, newEntity, String.class);

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    //method to force state 2 after put request
    public String forceState2(){
        String url = "http://localhost:8082/v1/status";
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // create a status JSON
        String jsonString = String.valueOf(new JSONObject().put("State",2));
        String data = jsonString.toString();
        System.out.println(data);

        HttpEntity<String> newEntity = new HttpEntity<>(data, headers);

        // send PUT request to update post
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.PUT, newEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return String.valueOf(response);
        } else {
            return null;
        }
    }

    //-------------------------------------PROGRAMS-------------------------------------
    public void moveToChargerOperation(){
        putStatusRequest("MoveToChargerOperation",1);
        forceState2();
        System.exit(1);
    }

    public void moveToAssemblyOperation(){
        putStatusRequest("MoveToAssemblyOperation",1);
        forceState2();
        System.exit(1);
    }

    public void moveToStorageOperation(){
        putStatusRequest("MoveToStorageOperation",1);
        forceState2();
        System.exit(1);
    }

    public void putAssemblyOperation(){
        putStatusRequest("PutAssemblyOperation",1);
        forceState2();
        System.exit(1);
    }

    public void pickAssemblyOperation(){
        putStatusRequest("PickAssemblyOperation",1);
        forceState2();
        System.exit(1);
    }

    public void pickWarehouseOperation(){
        putStatusRequest("PickWarehouseOperation",1);
        forceState2();
        System.exit(1);
    }

    public void putWarehouseOperation(){
        putStatusRequest("PutWarehouseOperation",1);
        forceState2();
        System.exit(1);
    }

    //-------------------------------------GET REQUEST-------------------------------------
    public String getStatusRequest() throws IOException {
        RestTemplateBuilder rt = new RestTemplateBuilder();
        RestService(rt);
        String url = "http://localhost:8082/v1/status";
        return this.restTemplate.getForObject(url, String.class);
    }

    //-------------------------------------REST SERVICE-------------------------------------
    public void RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
}

