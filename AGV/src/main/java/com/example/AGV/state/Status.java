package com.example.AGV.state;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

public class Status {
    private String name;
    private int id;

    public Status() {
    }

    public Status(String name, int id) {
        this.name = name;
        this.id = id;
    }


    //GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}


