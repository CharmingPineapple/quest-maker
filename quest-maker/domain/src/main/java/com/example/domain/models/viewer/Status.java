package com.example.domain.models.viewer;

public class Status {

    public String name;
    public String type;
    public String effect;
    public String description;

    public Status(String name,
                  String type,
                  String effect,
                  String description) {

        this.name = name;
        this.type = type;
        this.effect = effect;
        this.description = description;
    }


}
