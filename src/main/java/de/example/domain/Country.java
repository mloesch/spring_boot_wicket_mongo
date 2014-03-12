package de.example.domain;

import org.springframework.data.annotation.Id;

public class Country {

    @Id
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
