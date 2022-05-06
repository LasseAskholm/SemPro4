package com.example.AGV.state;

import com.google.gson.Gson;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping(path = "/v1/status")
public class StatusController {
    private RestTemplate restTemplate;

    @GetMapping
    public String test(){
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
        Status status = new Status("MoveToAssemblyOperation",1);

        // make status object
        Gson gson = new Gson();
        String jsonStatus = gson.toJson(status);
        System.out.println(jsonStatus);
        String data= jsonStatus.toString();

        // change the names
        data=data.replace("name","Program name");
        data=data.replace("id","State");

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


}

