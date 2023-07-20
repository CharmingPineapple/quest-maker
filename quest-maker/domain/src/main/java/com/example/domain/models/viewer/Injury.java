package com.example.domain.models.viewer;

public class Injury {

    public String name;
    public String type;
    public String effect;
    public String description;

    public Injury(String name,
                         String type,
                         String effect,
                         String description) {

        this.name = name;
        this.type = type;
        this.effect = effect;
        this.description = description;
    }


}
