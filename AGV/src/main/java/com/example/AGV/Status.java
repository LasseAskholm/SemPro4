
package com.example.AGV;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;


public class Status {
    private String name;
    private int idd;

    public Status() {
    }

    public Status(String name, int id) {
        this.name = name;
        this.idd = id;
    }


    //GETTERS
    public int getId(){return idd;}
    public String getName(){
        return name;
    }


    //SETTERS
    public void setId(int id){this.idd = idd;}
    public void setName(String name){
        this.name = name;
    }



/*
    public String toString(){
        return ""
    }


 */




    /*@Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }*/
}

/*
@Autowired
   RestTemplate restTemplate;

@RequestMapping(value = "/v1/status")
public String getStatusList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(
        "http://localhost:8082/v1/status", HttpMethod.GET, entity, String.class).getBody();
        }

@RequestMapping(value = "/v1/status/{id}", method = RequestMethod.PUT)
public String updateStatus(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Status> entity = new HttpEntity<Status>(status,headers);

        return restTemplate.exchange(
        "http://localhost:8082/v1/status/"+id, HttpMethod.PUT, entity, String.class).getBody();
        }*/
