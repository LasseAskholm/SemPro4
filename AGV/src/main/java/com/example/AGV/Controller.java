package com.example.AGV;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/v1/status")
public class Controller {
    private RestTemplate restTemplate;

    @GetMapping
    public String test(){
        System.out.println("11111111111111111111111111111111111");
        RestTemplateBuilder aa = new RestTemplateBuilder();
        RestService(aa);
        String url = "http://localhost:8082/v1/status";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // create a post object
        Status status = new Status("MoveToAssemblyOperation",1);

        // build the request
        HttpEntity<Status> entity = new HttpEntity<>(status, headers);
        System.out.println("222222222222222222222");

        Gson gson = new Gson();
        String jsonStatus = gson.toJson(status);
        System.out.println(jsonStatus);

        String data= jsonStatus.toString();
        data=data.replace("name","Program name");
        data=data.replace("idd","State");

        System.out.println(data);

        HttpEntity<String> newEntity = new HttpEntity<>(data, headers);


        // send PUT request to update post with `id` 10
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.PUT, newEntity, String.class);


        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response);
            return response.getBody();
        } else {
            return null;
        }
    }

    public void RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }










    /*private RestTemplate restTemplate;


    public void RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJSON() {
        String url = "http://localhost:8082/v1/status";
        return this.restTemplate.getForObject(url, String.class);
    }


    public Status updatePostWithResponse() {
        String url = "http://localhost:8082/v1/status";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a post object
        Status status = new Status("MoveToAssemblyOperation",1);

        // build the request
        HttpEntity<Status> entity = new HttpEntity<>(status, headers);

        // send PUT request to update post with `id` 10
        ResponseEntity<Status> response = this.restTemplate.exchange(url, HttpMethod.PUT, entity, Status.class, 10);

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response);
            return response.getBody();
        } else {
            return null;
        }
    }*/




    /*
    @RequestMapping(value = "/v1/status", method = RequestMethod.PUT)
    public @ResponseBody String putStatus(@RequestBody Status status){
        Status newStatus = new Status("MoveToAssemblyOperation",1);
        String newStatusJson = new Gson().toJson(newStatus);
        System.out.println(newStatusJson);
        return newStatusJson;
    }

     */

    /*
    private static Map<String, Status> statusRepo = new HashMap<>();
    static {
        Status battery = new Status();
        battery.setId("99");
        battery.setName("Battery");
        statusRepo.put(battery.getId(), battery);

        Status programName = new Status();
        programName.setId("2");
        programName.setName("Program name");
        statusRepo.put(programName.getId(), programName);

        Status state = new Status();
        state.setId("3");
        state.setName("State");
        statusRepo.put(state.getId(), state);

        Status timestamp = new Status();
        timestamp.setId("4");
        timestamp.setName("Timestamp");
        statusRepo.put(timestamp.getId(), timestamp);
    }



    @RequestMapping(value = "/v1/status")
    public ResponseEntity<Object> getStatus() {
        return new ResponseEntity<>(statusRepo.values(), HttpStatus.OK);
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "http://localhost:8082/v1/status")
    public String getStatusList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
                "http://localhost:8082/v1/status", HttpMethod.GET, entity, String.class).getBody();

    }

     */
}

